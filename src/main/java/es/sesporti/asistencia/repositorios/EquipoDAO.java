package es.sesporti.asistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import competicion.Categorizable;
import es.sesporti.asistencia.Equipo;

//@RepositoryRestResource(path = "equipos",
//						//exported=false,
//						itemResourceRel = "equipo", collectionResourceRel = "equipos")
@Repository
public interface EquipoDAO extends JpaRepository<Equipo, Long> {
	
//	Equipo findByNombreContaining(String txt);
//	Equipo findByJugadorNombre(String nombreJugador);
//	Equipo findByNombreAndCategoria(String nombre, Categorizable categorizable);
//	List<Equipo> findAllByJugadorNombreContaining(String txt);
//	List<Equipo> findAllByCategoria (Categorizable categoria);
//	List<Equipo> findAllByNombre (String nombre);
//	List<Equipo> findAllByEntrenadorNombreContaining(String txt);
//	List<Equipo> findAllByEntrenadorNombre(String nombreEntrenador);
}
