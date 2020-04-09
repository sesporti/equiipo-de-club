package es.sesporti.equipoclubapi;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Equipo;
import es.sesporti.asistencia.Jugador;
import es.sesporti.asistencia.rest.MixIns;

@Configuration
@PropertySource({ "classpath:config/rest.properties", "classpath:config/jackson.properties" })
public class ConfiguracionPorJava {
	
	@Bean
	public ObjectMapper getObjectMapper() {

		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(Jugador.class, MixIns.Jugadores.class);
		mapper.addMixIn(Entrenador.class, MixIns.Entrenadores.class);
		mapper.addMixIn(Equipo.class, MixIns.Equipos.class);
		mapper.addMixIn(Asistencia.class, MixIns.Asistencias.class);
//		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//		mapper.setVisibility(PropertyAccessor.GETTER, Visibility.PROTECTED_AND_PUBLIC);
//		mapper.setSerializationInclusion(Include.ALWAYS);
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	    mapper.setDateFormat(df);
		
		
		return mapper;
	}
	
}