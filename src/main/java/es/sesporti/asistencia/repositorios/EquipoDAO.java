package es.sesporti.asistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RestResource;

import competicion.Categoria;
import competicion.Licencia;
import es.sesporti.asistencia.Equipo;

//@Repository
@RepositoryRestResource(path = "equipos",
						//exported=false,
						itemResourceRel = "equipo", collectionResourceRel = "equipos")
public interface EquipoDAO extends JpaRepository<Equipo, Long> {

	@RestResource(path="nombre-contiene")
	List<Equipo> findByNombreContaining(String nombre);
	@RestResource(path="categoria")
	List<Equipo> findByCategoria (Categoria categoria);
	@RestResource(path="licencia")
	List<Equipo> findByLicencia (Licencia licencia);
	@RestResource(path="licencia-y-categoria")
	List<Equipo> findByLicenciaAndCategoria (Licencia licencia, Categoria categoria);
	@RestResource(path="nombre-jugador")
	Equipo findByJugadoresNombre(String nombreJugador);
	@RestResource(path="nombre-entrenador")
	List<Equipo> findByEntrenadoresNombre(String nombreEntrenador);
	@RestResource(path="nombre-entrenador-contiene")
	List<Equipo> findByEntrenadoresNombreContaining(String txtEntrenador);
	@RestResource(path="nombre-contiene-y-categoria")
	List<Equipo> findByNombreContainingAndCategoria(String nombre, Categoria categoria);
	@RestResource(path="nombre-jugador-contiene")
	List<Equipo> findByJugadoresNombreContaining(String txtNombreJugador);
	
}
