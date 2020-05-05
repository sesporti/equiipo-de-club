package es.sesporti.asistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
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
	List<Equipo> findByNombreContaining(@Param("nombre") String nombre);
	@RestResource(path="categoria")
	List<Equipo> findByCategoria (@Param("categoria") Categoria categoria);
	@RestResource(path="licencia")
	List<Equipo> findByLicencia (@Param("licencia") Licencia licencia);
	@RestResource(path="licencia-y-categoria")
	List<Equipo> findByLicenciaAndCategoria (@Param("licencia") Licencia licencia,
			@Param("categoria") Categoria categoria);
	@RestResource(path="nombre-jugador")
	Equipo findByJugadoresNombre(@Param("nombreJugador") String nombreJugador);
	@RestResource(path="nombre-entrenador")
	List<Equipo> findByEntrenadoresNombre(@Param("nombreEntrenador") String nombreEntrenador);
	@RestResource(path="nombre-entrenador-contiene")
	List<Equipo> findByEntrenadoresNombreContaining(@Param("txtEntrenador") String txtEntrenador);
	@RestResource(path="nombre-contiene-y-categoria")
	List<Equipo> findByNombreContainingAndCategoria(@Param("nombre") String nombre,
			@Param("categoria") Categoria categoria);
	@RestResource(path="nombre-jugador-contiene")
	List<Equipo> findByJugadoresNombreContaining(@Param("txtNombreJugador") String txtNombreJugador);
	
}
