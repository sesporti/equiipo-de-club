package es.sesporti.asistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import es.sesporti.asistencia.Jugador;

@RepositoryRestResource(path="jugadores",
						//exported=false,
						itemResourceRel="jugador",
						collectionResourceRel="jugadores")
public interface JugadorDAO extends JpaRepository<Jugador, Long>{
	Jugador findByNombreContaining(String txt);
	List<Jugador> findAllByNombreContaining(String txt);
	List<Jugador> findByEquipoNombre(String nombreEquipo);
	List<Jugador> findAllByPocContaining(String poc);
}
