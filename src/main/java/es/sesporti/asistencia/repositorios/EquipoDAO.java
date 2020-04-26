package es.sesporti.asistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import competicion.Categoria;
import competicion.Licencia;
import es.sesporti.asistencia.Equipo;

//@Repository
@RepositoryRestResource(path = "equipos",
						//exported=false,
						itemResourceRel = "equipo", collectionResourceRel = "equipos")
public interface EquipoDAO extends JpaRepository<Equipo, Long> {
	
	List<Equipo> findByNombreContaining(String nombre);
	List<Equipo> findByCategoria (Categoria categoria);
	List<Equipo> findByLicencia (Licencia licencia);
	List<Equipo> findByLicenciaAndCategoria (Licencia licencia, Categoria categoria);
	Equipo findByJugadoresNombre(String nombreJugador);
	List<Equipo> findByEntrenadoresNombre(String nombreEntrenador);
	List<Equipo> findByEntrenadoresNombreContaining(String txtEntrenador);
	List<Equipo> findByNombreContainingAndCategoria(String nombre, Categoria categoria);
	List<Equipo> findByJugadoresNombreContaining(String txtNombreJugador);
	
}
