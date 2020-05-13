package es.sesporti.asistencia.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Jugador;

@Component
public class AsistenciaListener {
	private Logger log = LoggerFactory.getLogger(AsistenciaListener.class);
	
	private static AsistenciaDAO asistenciaDAO;
	
	private static JugadorDAO jugadorDAO;
	
	@Autowired
	public void init(AsistenciaDAO asistenciaDAO, JugadorDAO jugadorDAO) {
		AsistenciaListener.asistenciaDAO = asistenciaDAO;
		AsistenciaListener.jugadorDAO = jugadorDAO;
	}
	
	public void antesDeGuardar(Asistencia asistencia) {
		LocalDate fechaAsistencia = asistencia.getFecha();
		Jugador jugadorAsistencia = asistencia.getJugador();
		List<Asistencia> asistencias = asistenciaDAO.findAll().stream().filter(a -> a.getJugador() == jugadorAsistencia)
				.collect(Collectors.toList());
		int contadorFechas = 1;
		for (Asistencia a : asistencias) {
			if (a.getFecha().equals(fechaAsistencia)) {
				contadorFechas++;					
			}
		}
		if (contadorFechas > 1) {
			log.debug("@Post-Persist => El jugador {} no puede tener más de una asistencia en la misma fecha ({}), se borrará la última.",
						jugadorAsistencia.getNombre(), fechaAsistencia);
				asistenciaDAO.delete(asistencia);
		}
				
	}
	
	public void despuesDeGuardar(Asistencia asistencia) {
		LocalDate fechaAsistencia = asistencia.getFecha();
		System.out.println("fecha asistencia = "+ fechaAsistencia);
		Jugador jugadorAsistencia = asistencia.getJugador();
		System.out.println("jugador: "+ jugadorAsistencia.getNombre());
		
		List<Asistencia> asistencias = asistenciaDAO.findByFecha(fechaAsistencia);//.findAll();
		int contadorFechas = 1;
		for (Asistencia a : asistencias) {
			if (a.getFecha().equals(fechaAsistencia) && a.getJugador().equals(jugadorAsistencia)) {
				contadorFechas++;					
			}
		}
		if (contadorFechas > 1) {
			log.debug("@Post-Persist => El jugador {} no puede tener más de una asistencia en la misma fecha ({}), se borrará la última.",
						jugadorAsistencia.getNombre(), fechaAsistencia);
				asistenciaDAO.delete(asistencia);
		}
		
		// Esta sentencia no es necesaria, se agrega al jugador por la bidireccionalidad del codigo en las clases ASISTENCIA Y JUGADOR.
//		jugadorDAO.getOne(asistencia.getIdJugador()).addAsistencia(asistencia);
	}
	
	public void antesDeBorrar(Asistencia asistencia) {
		log.debug("@PreRemove Asistencia {} borrada del Jugador {}", asistencia.getId(), asistencia.getJugador().getNombre());
		jugadorDAO.getOne(asistencia.getIdJugador()).removeAsistencia(asistencia);
	}
}
