package es.sesporti.asistencia.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Asistencia.TipoAsistencia;
import es.sesporti.asistencia.Equipo;
import es.sesporti.asistencia.Jugador;

//@Repository
@RepositoryRestResource(path="asistencias",
						//exported=false,
						itemResourceRel="asistencia",
						collectionResourceRel="asistencias")
public interface AsistenciaDAO extends JpaRepository<Asistencia, Long> {
	
	List<Asistencia> findByJugador(Jugador jugador);
		
	List<Asistencia> findByJugadorNombreContaining(String txtNombreJugador);	
	
	List<Asistencia> findByTipoAsistencia(TipoAsistencia tipoAsistencia);
	
	List<Asistencia> findByTipoAsistenciaNot(TipoAsistencia tipoAsistencia);

	List<Asistencia> findByFecha(LocalDate fecha);
	
	List<Asistencia> findByFechaAndJugadorNombreContaining(LocalDate fecha,String txtNombreJugador);
	
	List<Asistencia> findByFechaAndJugadorEquipo(LocalDate fecha,Equipo equipo);
	
	List<Asistencia> findByFechaAndTipoAsistencia(LocalDate fecha, TipoAsistencia tipoAsistencia);
	
	List<Asistencia> findByFechaAndTipoAsistenciaNot(LocalDate fecha, TipoAsistencia tipoAsistencia);
	
	List<Asistencia> findByFechaAfter(LocalDate fecha);
	
	List<Asistencia> findByFechaAfterAndJugadorNombreContaining(LocalDate fecha,String txtNombreJugador);
	
	List<Asistencia> findByFechaAfterAndJugadorEquipo(LocalDate fecha,Equipo equipo);
	
	List<Asistencia> findByFechaAfterAndTipoAsistencia(LocalDate fecha, TipoAsistencia tipoAsistencia);
	
	List<Asistencia> findByFechaAfterAndTipoAsistenciaNot(LocalDate fecha, TipoAsistencia tipoAsistencia);
	
	List<Asistencia> findByFechaBetween(LocalDate fechaInicial, LocalDate fechaFin);
	
	List<Asistencia> findByFechaBetweenAndJugadorNombreContaining(LocalDate fechaInicial, LocalDate fechaFin, String txtNombreJugador);
	
	List<Asistencia> findByFechaBetweenAndJugadorEquipo(LocalDate fechaInicial, LocalDate fechaFin, Equipo equipo);
	
	List<Asistencia> findByFechaBetweenAndTipoAsistencia(LocalDate fechaInicial, LocalDate fechaFin, TipoAsistencia tipoAsistencia);
	
	List<Asistencia> findByFechaBetweenAndTipoAsistenciaNot(LocalDate fechaInicial, LocalDate fechaFin, TipoAsistencia tipoAsistencia);
	
}
