package es.sesporti.asistencia.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RestResource;

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
	
	@RestResource(path="jugador")
	List<Asistencia> findByJugador(Jugador jugador);
	@RestResource(path="nombreJugador-contiene")	
	List<Asistencia> findByJugadorNombreContaining(String txtNombreJugador);	
	@RestResource(path="tipoAsistencia")
	List<Asistencia> findByTipoAsistencia(TipoAsistencia tipoAsistencia);
	@RestResource(path="faltasAsistencia")
	List<Asistencia> findByTipoAsistenciaNot(TipoAsistencia tipoAsistencia);
	@RestResource(path="fecha")
	List<Asistencia> findByFecha(LocalDate fecha);
	@RestResource(path="fecha-y-nombreJugador-contiene")
	List<Asistencia> findByFechaAndJugadorNombreContaining(LocalDate fecha,String txtNombreJugador);
	@RestResource(path="fecha-y-equipo")
	List<Asistencia> findByFechaAndJugadorEquipo(LocalDate fecha,Equipo equipo);
	@RestResource(path="fecha-y-tipoAsistencia")
	List<Asistencia> findByFechaAndTipoAsistencia(LocalDate fecha, TipoAsistencia tipoAsistencia);
	@RestResource(path="faltasAsistencia-y-fecha")
	List<Asistencia> findByFechaAndTipoAsistenciaNot(LocalDate fecha, TipoAsistencia tipoAsistencia);
	@RestResource(path="fecha-despues")
	List<Asistencia> findByFechaAfter(LocalDate fecha);
	@RestResource(path="fechaDespues-y-nombreJugador-contiene")
	List<Asistencia> findByFechaAfterAndJugadorNombreContaining(LocalDate fecha,String txtNombreJugador);
	@RestResource(path="fechaDespues-y-equipo")
	List<Asistencia> findByFechaAfterAndJugadorEquipo(LocalDate fecha,Equipo equipo);
	@RestResource(path="fechaDespues-y-tipoAsistencia")
	List<Asistencia> findByFechaAfterAndTipoAsistencia(LocalDate fecha, TipoAsistencia tipoAsistencia);
	@RestResource(path="faltasAsistencia-y-fecha-despues")
	List<Asistencia> findByFechaAfterAndTipoAsistenciaNot(LocalDate fecha, TipoAsistencia tipoAsistencia);
	@RestResource(path="entre-fechas")
	List<Asistencia> findByFechaBetween(LocalDate fechaInicial, LocalDate fechaFin);
	@RestResource(path="entreFechas-y-nombreJugador-contiene")
	List<Asistencia> findByFechaBetweenAndJugadorNombreContaining(LocalDate fechaInicial, LocalDate fechaFin, String txtNombreJugador);
	@RestResource(path="entreFechas-y-equipo")
	List<Asistencia> findByFechaBetweenAndJugadorEquipo(LocalDate fechaInicial, LocalDate fechaFin, Equipo equipo);
	@RestResource(path="entreFechas-y-tipoAsistencia")
	List<Asistencia> findByFechaBetweenAndTipoAsistencia(LocalDate fechaInicial, LocalDate fechaFin, TipoAsistencia tipoAsistencia);
	@RestResource(path="faltasAsistencia-entre-fechas")
	List<Asistencia> findByFechaBetweenAndTipoAsistenciaNot(LocalDate fechaInicial, LocalDate fechaFin, TipoAsistencia tipoAsistencia);
	
}
