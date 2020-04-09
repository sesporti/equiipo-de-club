package es.sesporti.asistencia.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Asistencia.TipoAsistencia;
import es.sesporti.asistencia.Jugador;

@RepositoryRestResource(path="asistencias",
						//exported=false,
						itemResourceRel="asistencia",
						collectionResourceRel="asistencias")
public interface AsistenciaDAO extends JpaRepository<Asistencia, Long> {
	Asistencia findByJugadorContaining(Jugador jugador);//no me funciona en Postman?????
//	Asistencia findByJugadorNombreContaining(String nombreJugador);//da problemas, quitar, cuando hay varias asistencias que contengan txt no devuelve resultado en Postman.
	List<Asistencia> findAllByJugadorNombreContaining(String nombreJugador);
	List<Asistencia> findByFecha(Date fecha);
	List<Asistencia> findAllByFechaBetween(Date fecha1, Date fecha2);
	List<Asistencia> findAllByFechaBetweenAndJugadorNombreContaining(Date fecha1, Date fecha2, String nombreJugador);
	List<Asistencia> findAllByTipoAsistencia(TipoAsistencia tipoAsistencia);
	List<Asistencia> findAllByFechaAndTipoAsistencia(Date fecha, TipoAsistencia tipoAsistencia);
}
