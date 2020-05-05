package es.sesporti.asistencia.rest;

import java.util.List;

import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.sesporti.asistencia.Jugador;
import es.sesporti.asistencia.repositorios.JugadorDAO;

@RepositoryRestController
@RequestMapping(path = "/jugadores/search")
public class JugadorController {

	private JugadorDAO jugadorDAO;
	
	public JugadorController(JugadorDAO jugadorDAO) {
		this.jugadorDAO = jugadorDAO;
	}
	
	@GetMapping("/por-edades-en-categoria")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getJugadoresPorEdadesCategoria (@RequestParam int edadMinima,
			@RequestParam int edadMaxima, PersistentEntityResourceAssembler assembler){
		
		List<Jugador> jugadores = jugadorDAO.getJugadoresPorEdadesCategoria(edadMinima, edadMaxima);
		
		return assembler.toCollectionModel(jugadores);
	}
	
	@GetMapping("/por-edad")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getJugadoresPorEdad (@RequestParam int edadJugador,
			PersistentEntityResourceAssembler assembler){
		
		List<Jugador> jugadores = jugadorDAO.getJugadoresPorEdad(edadJugador);
		
		return assembler.toCollectionModel(jugadores);
	}
}
