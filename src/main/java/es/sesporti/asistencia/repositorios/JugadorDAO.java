package es.sesporti.asistencia.repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RestResource;

import competicion.Categoria;
import competicion.Licencia;
import es.sesporti.asistencia.Jugador;

//@Repository
@RepositoryRestResource(path="jugadores",
						//exported=false,
						itemResourceRel="jugador",
						collectionResourceRel="jugadores")
public interface JugadorDAO extends JpaRepository<Jugador, Long>{
	
	@RestResource(path="nombre")
	Jugador findByNombreContaining(String txt);
	@RestResource(path="nombre-contiene")
	List<Jugador> findAllByNombreContaining(String txt);
	@RestResource(path="nombre-equipo-contiene")
	List<Jugador> findAllByEquipoNombreContaining(String txt);
	@RestResource(path="categoria-equipo")
	List<Jugador> findAllByEquipoCategoria(Categoria categoria);
	@RestResource(path="licencia-equipo")
	List<Jugador> findAllByEquipoLicencia(Licencia licencia);
	@RestResource(path="poc-contiene")
	List<Jugador> findAllByPocContaining(String txt);
	@RestResource(path="nacimiento-despues-fecha")
	List<Jugador> findByFechaNacimientoAfter(@Param("fecha")LocalDate fecha);
	@RestResource(path="nacimiento-entre-fechas")
	List<Jugador> findByFechaNacimientoBetween(@Param("fechaIni")LocalDate fechaIni,
												@Param("fechaFin")LocalDate fechaFin);
// No funciona, pide que exista el campo edad en Jugador, pendiente de explicar en asignatura.
//	List<Jugador> findByEdad(int edad);

}