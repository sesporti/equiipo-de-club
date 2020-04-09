package es.sesporti.asistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Jugador;

@RepositoryRestResource(path="asistencias",
						//exported=false,
						itemResourceRel="asistencia",
						collectionResourceRel="asistencias")
public interface AsistenciaDAO extends JpaRepository<Asistencia, Long> {
	Asistencia findByJugadorContaining(Jugador jugador);
}
