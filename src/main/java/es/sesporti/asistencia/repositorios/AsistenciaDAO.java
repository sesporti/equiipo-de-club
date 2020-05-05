package es.sesporti.asistencia.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
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
	List<Asistencia> findByJugador(@Param("jugador") Jugador jugador);
	@RestResource(path="nombreJugador-contiene")	
	List<Asistencia> findByJugadorNombreContaining(@Param("txtNombreJugador") String txtNombreJugador);	
	@RestResource(path="tipoAsistencia")
	List<Asistencia> findByTipoAsistencia(@Param("tipoAsistencia") TipoAsistencia tipoAsistencia);
	@RestResource(path="faltasAsistencia")
	List<Asistencia> findByTipoAsistenciaNot(@Param("tipoAsistencia") TipoAsistencia tipoAsistencia);
	@RestResource(path="fecha")
	List<Asistencia> findByFecha(@Param("fecha") LocalDate fecha);
	@RestResource(path="fecha-y-nombreJugador-contiene")
	List<Asistencia> findByFechaAndJugadorNombreContaining(@Param("fecha") LocalDate fecha,
			@Param("txtNombreJugador") String txtNombreJugador);
	@RestResource(path="fecha-y-equipo")
	List<Asistencia> findByFechaAndJugadorEquipo(@Param("fecha") LocalDate fecha, @Param("equipo") Equipo equipo);
	@RestResource(path="fecha-y-tipoAsistencia")
	List<Asistencia> findByFechaAndTipoAsistencia(@Param("fecha") LocalDate fecha, @Param("tipoAsistencia") TipoAsistencia tipoAsistencia);
	@RestResource(path="faltasAsistencia-y-fecha")
	List<Asistencia> findByFechaAndTipoAsistenciaNot(@Param("fecha") LocalDate fecha, @Param("tipoAsistencia") TipoAsistencia tipoAsistencia);
	@RestResource(path="fecha-despues")
	List<Asistencia> findByFechaAfter(@Param("fecha") LocalDate fecha);
	@RestResource(path="fechaDespues-y-nombreJugador-contiene")
	List<Asistencia> findByFechaAfterAndJugadorNombreContaining(@Param("fecha") LocalDate fecha, @Param("txtNombreJugador") String txtNombreJugador);
	@RestResource(path="fechaDespues-y-equipo")
	List<Asistencia> findByFechaAfterAndJugadorEquipo(@Param("fecha") LocalDate fecha, @Param("equipo") Equipo equipo);
	@RestResource(path="fechaDespues-y-tipoAsistencia")
	List<Asistencia> findByFechaAfterAndTipoAsistencia(@Param("fecha") LocalDate fecha, @Param("tipoAsistencia") TipoAsistencia tipoAsistencia);
	@RestResource(path="faltasAsistencia-y-fecha-despues")
	List<Asistencia> findByFechaAfterAndTipoAsistenciaNot(@Param("fecha") LocalDate fecha, @Param("tipoAsistencia") TipoAsistencia tipoAsistencia);
	@RestResource(path="entre-fechas")
	List<Asistencia> findByFechaBetween(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFin") LocalDate fechaFin);
	@RestResource(path="entreFechas-y-nombreJugador-contiene")
	List<Asistencia> findByFechaBetweenAndJugadorNombreContaining(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFin") LocalDate fechaFin,
			@Param("txtNombreJugador") String txtNombreJugador);
	@RestResource(path="entreFechas-y-equipo")
	List<Asistencia> findByFechaBetweenAndJugadorEquipo(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFin") LocalDate fechaFin,
			@Param("equipo") Equipo equipo);
	@RestResource(path="entreFechas-y-tipoAsistencia")
	List<Asistencia> findByFechaBetweenAndTipoAsistencia(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFin") LocalDate fechaFin,
			@Param("tipoAsistencia") TipoAsistencia tipoAsistencia);
	@RestResource(path="faltasAsistencia-entre-fechas")
	List<Asistencia> findByFechaBetweenAndTipoAsistenciaNot(@Param("fechaInicial") LocalDate fechaInicial, @Param("fechaFin") LocalDate fechaFin,
			@Param("tipoAsistencia") TipoAsistencia tipoAsistencia);
	
}
