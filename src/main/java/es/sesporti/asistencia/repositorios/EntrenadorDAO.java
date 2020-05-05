package es.sesporti.asistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RestResource;

import competicion.Categoria;
import competicion.Licencia;
import es.sesporti.asistencia.Entrenador;

//@Repository
@RepositoryRestResource(path="entrenadores",
						//exported=false,
						itemResourceRel="entrenador",
						collectionResourceRel="entrenadores")
public interface EntrenadorDAO extends JpaRepository<Entrenador, Long>{
	
	@RestResource(path="nombre-contiene")
	List<Entrenador> findByNombreContaining (@Param("nombre") String nombre);
	@RestResource(path="nombre-equipo")
	List<Entrenador> findByEquiposNombre (@Param("equipo") String equipo);
	@RestResource(path="licencia")
	List<Entrenador> findByLicencias (@Param("licencia") Licencia licencia);
	@RestResource(path="idEquipo")
	List<Entrenador> findByEquiposId (@Param("idEquipo") Long idEquipo);
	@RestResource(path="categoria-equipo")
	List<Entrenador> findByEquiposCategoria (@Param("categoria") Categoria categoria);
	@RestResource(path="licenciaEquipo-categoriaEquipo")
	List<Entrenador> findByEquiposLicenciaAndEquiposCategoria (@Param("licencia") Licencia licencia,
			@Param("categoria") Categoria categoria);
}
