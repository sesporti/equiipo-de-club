package es.sesporti.asistencia.repositorios;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.sesporti.asistencia.Jugador;

@Transactional(readOnly = true)
public class JugadorDAOImpl implements JugadorDAOCustom{

	@Autowired
	JugadorDAO jugadorDAO;
	
	@PersistenceContext
    EntityManager entityManager;
	
	
	@Override
	public List<Jugador> getJugadoresPorEdadesLicencia(int edadMinima, int edadMaxima) {
		
		LocalDate hoy = LocalDate.now();
		
		LocalDate fechaFin = LocalDate.of(hoy.getYear()-edadMinima, 12, 31);
		LocalDate fechaIni = LocalDate.of(hoy.getYear()-edadMaxima, 1, 1);
		
		List<Jugador> jugadores = jugadorDAO.findByFechaNacimientoBetween(fechaIni, fechaFin);
		
//		List<Jugador> jugadores =  jugadorDAO.findAll().stream().filter(j -> j.getEdad() == edadMinima || j.getEdad() == edadMaxima)
//				.collect(Collectors.toList());// este es menos eficiente, ya que recupera todo de la BD,s.
		
		return jugadores;
	}

	@Override
	public List<Jugador> getJugadoresPorEdad(int edadJugador) {
			
		List<Jugador> jugadores =  jugadorDAO.findAll().stream().filter(j -> j.getEdad() == edadJugador)
				.collect(Collectors.toList());
		
		return jugadores;
	}
}
