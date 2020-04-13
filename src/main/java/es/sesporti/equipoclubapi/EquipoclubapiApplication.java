package es.sesporti.equipoclubapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.JsonDeserializer;
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
//@EnableJpaRepositories("${es.lanyu.jpa-package}")// usando propiedad, tambien se puede usar una clase
//@EntityScan("es.lanyu.usuarios.repositorios")// o definirlo literal. ambos admiten varios valores
@Import(ConfiguracionPorJava.class)
public class EquipoclubapiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(EquipoclubapiApplication.class);
	
	public static void main(String[] args) {

		
		ConfigurableApplicationContext context = SpringApplication.run(EquipoclubapiApplication.class, args);
		
		ObjectMapper mapper = context.getBean(ObjectMapper.class);
		
		JugadorDAO jugadorDAO = context.getBean(JugadorDAO.class);
		EntrenadorDAO entrenadorDAO = context.getBean(EntrenadorDAO.class);
		EquipoDAO equipoDAO = context.getBean(EquipoDAO.class);
		AsistenciaDAO asistenciaDAO = context.getBean(AsistenciaDAO.class);
		

		
//		try {
//			List<Equipo> equipos = Arrays.asList(mapper.readValue("src/main/resources/equipos2.json", Equipo[].class));
//			equipoDAO.saveAll(equipos);
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		cargarEquipoDesdeArchivo("src/main/resources/equipos.json", mapper, equipoDAO);
		cargarJugadoresDesdeArchivo("src/main/resources/jugadores.json", mapper, jugadorDAO);
		cargarEntrenadorDesdeArchivo("src/main/resources/entrenadores.json", mapper, entrenadorDAO);
		cargarAsistenciaDesdeArchivo("src/main/resources/asistencias.json", mapper, asistenciaDAO);
		
		List<Equipo> equipos = equipoDAO.findAll();
		equipos.stream().map(Equipo::toString).forEach(log::debug);
		
		List<Jugador> jugadores = jugadorDAO.findAll();
		jugadores.stream().map(Jugador::toString).forEach(log::debug);
				
		List<Entrenador> entrenadores = entrenadorDAO.findAll();
		entrenadores.stream().map(Entrenador::toString).forEach(log::debug);
		
		List<Asistencia> asistencias = asistenciaDAO.findAll();
		asistencias.stream().map(Asistencia::toString).forEach(log::debug);
		
		
		
		context.close();
	}
	
	static void cargarJugadoresDesdeArchivo(String ruta, ObjectMapper mapper, JugadorDAO jugadorDAO) {
		
		try {
			ArrayList<Jugador> jugadores = mapper.readValue(new File(ruta),
			        mapper.getTypeFactory().constructCollectionType(ArrayList.class, Jugador.class));
			
			jugadorDAO.saveAll(jugadores);
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
		

//		
//		String linea = null;
//		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
//		try (BufferedReader buffer = new BufferedReader(
//				new InputStreamReader(new FileInputStream(ruta), "UTF-8"))) {
//			Jugador jugador;
//			while((linea = buffer.readLine()) != null) {
//				if (linea.startsWith("{") && linea.endsWith("}")) {
//					jugador = mapper.readValue(linea, Jugador.class);
//					jugadorDAO.save(jugador);
//					log.trace("Cargado {}", jugador);
//				}
//			}
//		} catch (Exception e) {
//			log.error("Error leyendo: {}", linea);
//		}
	}
	static void cargarEntrenadorDesdeArchivo(String ruta, ObjectMapper mapper, EntrenadorDAO entrenadorDAO) {
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

	static void cargarEquipoDesdeArchivo(String ruta, ObjectMapper mapper, EquipoDAO equipoDAO) {
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
	
	static void cargarAsistenciaDesdeArchivo(String ruta, ObjectMapper mapper, AsistenciaDAO asistenciaDAO) {
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
			log.error("Error leyendo: {}", linea);
		}
	}
}
