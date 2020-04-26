package es.sesporti.asistencia.repositorios;

//import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.stereotype.Repository;

import competicion.Categoria;
import competicion.Licencia;
import es.sesporti.asistencia.Jugador;

//@Repository
@RepositoryRestResource(path="jugadores",
						//exported=false,
						itemResourceRel="jugador",
						collectionResourceRel="jugadores")
public interface JugadorDAO extends JpaRepository<Jugador, Long>{
	
	Jugador findByNombreContaining(String txt);
	List<Jugador> findAllByNombreContaining(String txt);
	List<Jugador> findAllByEquipoNombreContaining(String txt);
	List<Jugador> findAllByEquipoCategoria(Categoria categoria);
	List<Jugador> findAllByEquipoLicencia(Licencia licencia);
	List<Jugador> findAllByPocContaining(String txt);
}
	
	//Estas queries me dan error no realiza el parseo de String a LocalDate!!!!!!!!!!!!!
//	List<Jugador> findAllByFechaNacimiento(@Param("fecha")LocalDate fecha);
//	List<Jugador> findAllByFechaNacimientoBetween(@Param("fechaIni")LocalDate fechaIni,
//												@Param("fechaFin")LocalDate fechaFin);
//	List<Jugador> findAllByEdad(int edad);

