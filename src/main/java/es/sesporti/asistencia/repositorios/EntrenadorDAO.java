package es.sesporti.asistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import competicion.Categoria;
import competicion.Licencia;
import es.sesporti.asistencia.Entrenador;

//@Repository
@RepositoryRestResource(path="entrenadores",
						//exported=false,
						itemResourceRel="entrenador",
						collectionResourceRel="entrenadores")
public interface EntrenadorDAO extends JpaRepository<Entrenador, Long>{
	
	List<Entrenador> findByNombreContaining (String nombre);
	List<Entrenador> findByEquiposNombre (String equipo);
	List<Entrenador> findByLicencias (Licencia licencia);
	List<Entrenador> findByEquiposId (Long idEquipo);
	List<Entrenador> findByEquiposCategoria (Categoria categoria);
	List<Entrenador> findByEquiposLicenciaAndEquiposCategoria (Licencia licencia, Categoria categoria);
}
