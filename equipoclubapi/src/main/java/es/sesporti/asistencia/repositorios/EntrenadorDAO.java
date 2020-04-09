package es.sesporti.asistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import es.sesporti.asistencia.Entrenador;

@RepositoryRestResource(path="entrenadores",
						//exported=false,
						itemResourceRel="entrenador",
						collectionResourceRel="entrenadores")
public interface EntrenadorDAO extends JpaRepository<Entrenador, Long>{
	Entrenador findByNombreContaining(String txt);
}
