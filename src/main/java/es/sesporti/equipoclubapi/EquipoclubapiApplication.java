package es.sesporti.equipoclubapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Equipo;
import es.sesporti.asistencia.Jugador;
import es.sesporti.asistencia.repositorios.AsistenciaDAO;
import es.sesporti.asistencia.repositorios.EntrenadorDAO;
import es.sesporti.asistencia.repositorios.EquipoDAO;
import es.sesporti.asistencia.repositorios.JugadorDAO;

@SpringBootApplication
@ImportResource({"classpath:config/jpa-config.xml"})
@Import(ConfiguracionPorJava.class)
public class EquipoclubapiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EquipoclubapiApplication.class);
	
	public static void main(String[] args) {

		
		@SuppressWarnings("unused")
		ConfigurableApplicationContext context = SpringApplication.run(EquipoclubapiApplication.class, args);
		
//		ObjectMapper mapper = context.getBean(ObjectMapper.class);
		
//		JugadorDAO jugadorDAO = context.getBean(JugadorDAO.class);
//		EntrenadorDAO entrenadorDAO = context.getBean(EntrenadorDAO.class);
//		EquipoDAO equipoDAO = context.getBean(EquipoDAO.class);
//		AsistenciaDAO asistenciaDAO = context.getBean(AsistenciaDAO.class);
		
//		//Descomentar para carga inicial de datos en BD,s.
//		
//		cargarEquiposDesdeArchivo("src/main/resources/equipos.json", mapper, equipoDAO);		
//		cargarEntrenadoresDesdeArchivo("src/main/resources/entrenadores.json", mapper, entrenadorDAO);
//		cargarJugadoresDesdeArchivo("src/main/resources/jugadores.json", mapper, jugadorDAO);
//		cargarAsistenciasDesdeArchivo("src/main/resources/asistencias.json", mapper, asistenciaDAO);
		
//		//Entidades
//		List<Equipo> equipos = equipoDAO.findAll();
//		equipos.stream().map(Equipo::toString).forEach(log::debug);
//		
//		List<Jugador> jugadores = jugadorDAO.findAll();
//		jugadores.stream().map(Jugador::toString).forEach(log::debug);
//				
//		List<Entrenador> entrenadores = entrenadorDAO.findAll();
//		entrenadores.stream().map(Entrenador::toString).forEach(log::debug);
//		
//		List<Asistencia> asistencias = asistenciaDAO.findAll();
//		asistencias.stream().map(Asistencia::toString).forEach(log::debug);
//		
//		//Metodos personalizados con RESTful
//		List<Jugador> jugadoresPorEdadCategoria = jugadorDAO.getJugadoresPorEdadesLicencia(11,12);//ALEVINES
//		jugadoresPorEdadCategoria.stream().map(Jugador::toString).forEach(log::warn);
//		
//		List<Jugador> jugadoresPorEdad = jugadorDAO.getJugadoresPorEdad(9);//por edad, no por Categoria
//		jugadoresPorEdad.stream().map(Jugador::toString).forEach(log::warn);		
		
//		context.close();
	}
	
	static void cargarJugadoresDesdeArchivo(String ruta, ObjectMapper mapper, JugadorDAO jugadorDAO) {
		
		try {
			ArrayList<Jugador> jugadores = mapper.readValue(new File(ruta),
			        mapper.getTypeFactory().constructCollectionType(ArrayList.class, Jugador.class));
			
			jugadorDAO.saveAll(jugadores);
			log.trace("Cargados Jugadores: {}", jugadores);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void cargarEntrenadoresDesdeArchivo(String ruta, ObjectMapper mapper, EntrenadorDAO entrenadorDAO) {
		String linea = null;
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(new FileInputStream(ruta), "UTF-8"))) {
			Entrenador entrenador;
			while((linea = buffer.readLine()) != null) {
				if (linea.startsWith("{") && linea.endsWith("}")) {
					entrenador = mapper.readValue(linea, Entrenador.class);
					entrenadorDAO.save(entrenador);
					log.trace("Cargado {}", entrenador);
				}
			}
		} catch (Exception e) {
			log.error("Error leyendo: {}", linea);
		}
	}

	static void cargarEquiposDesdeArchivo(String ruta, ObjectMapper mapper, EquipoDAO equipoDAO) {
		String linea = null;
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(new FileInputStream(ruta), "UTF-8"))) {
			Equipo equipo;
			while((linea = buffer.readLine()) != null) {
				if (linea.startsWith("{") && linea.endsWith("}")) {
					equipo = mapper.readValue(linea, Equipo.class);
					equipoDAO.save(equipo);
					log.trace("Cargado {}", equipo);
				}
			}
		} catch (Exception e) {
			log.error("Error leyendo: {}", linea);
		}	
	}
	
	static void cargarAsistenciasDesdeArchivo(String ruta, ObjectMapper mapper, AsistenciaDAO asistenciaDAO) {
		String linea = null;
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		try (BufferedReader buffer = new BufferedReader(
				new InputStreamReader(new FileInputStream(ruta), "UTF-8"))) {
			Asistencia asistencia;
			while((linea = buffer.readLine()) != null) {
				if (linea.startsWith("{") && linea.endsWith("}")) {
					asistencia = mapper.readValue(linea, Asistencia.class);
					asistenciaDAO.save(asistencia);
					log.trace("Cargado {}", asistencia);
				}
			}
		} catch (Exception e) {
			log.error("Error leyendo: {}: {}", linea, e.getMessage());
		}
	}
}
