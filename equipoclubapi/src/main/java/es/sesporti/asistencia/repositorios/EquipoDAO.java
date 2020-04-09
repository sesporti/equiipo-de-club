package es.sesporti.asistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Equipo;

@RepositoryRestResource(path = "equipos",
//exported=false,
		itemResourceRel = "equipo", collectionResourceRel = "equipos")
public interface EquipoDAO extends JpaRepository<Equipo, Long> {
	Equipo findByNombreContaining(String txt);
}
