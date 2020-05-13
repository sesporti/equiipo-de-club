package es.sesporti.asistencia.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Equipo;

@Component
public class EntrenadorListener {
	
	private Logger log = LoggerFactory.getLogger(EntrenadorListener.class);
		
	private static EquipoDAO equipoDAO;
	
	@Autowired
	public void init(EquipoDAO equipoDAO) {
		EntrenadorListener.equipoDAO = equipoDAO;
	}
	
	public void antesDeGuardar(Entrenador entrenador) {
		List<Equipo> equipos = entrenador.getEquipos();
		
		if (equipos != null) {
				
			for (Equipo equipo : equipos) {
				
					if (!entrenador.isEntrenadorValidoParaEquipo(entrenador, equipo)) {
						log.trace("@PrePersist => Equipo {} no es válido para Entrenador {} ({})", equipo.getNombre(),
							entrenador.getNombre(), entrenador.getLicencias());
					
						entrenador.getEquipos().remove(equipo);
						
					} else {
						log.trace("@PrePersist => Entrenador {} ({}) VALIDO para Equipo {}",
			
								entrenador.getNombre(), entrenador.getLicencias(), equipo.getNombre());
					}
			}
	
		} else {
			log.trace("@PrePersist => Entrenador {} ({}) NO tiene equipos asignados",
					entrenador.getNombre(), entrenador.getLicencias());
			
			entrenador.setEquipos(new ArrayList<Equipo>());
		}
		
	}
	
	public void despuesDeGuardar(Entrenador entrenador) {
		List<Equipo> equipos = entrenador.getEquipos();
		log.debug("@PostPersist => Equipos: ", equipos);
		log.debug("@PostPersist => idEntrenador: ", entrenador.getId());
		
		if (equipos != null && !equipos.isEmpty()) {
			log.debug("@PostPersist => El entrenador SI tiene equipos asignados");
			log.debug("@PostPersist => Equipos: ", equipos);
			log.debug("@PostPersist => idEntrenador: ", entrenador.getId());
			for (Equipo equipo : equipos) {
				
					if (!entrenador.isEntrenadorValidoParaEquipo(entrenador, equipo)) {
						log.debug("@PostPersist => Equipo {} NO es válido para Entrenador {} ({})", equipo.getNombre(),
							entrenador.getNombre(), entrenador.getLicencias());
					
						entrenador.getEquipos().remove(equipo);
						
					} else {
						log.debug("@PostPersist => Equipo {} VALIDO para Entrenador {} ({})",
			
								equipo.getNombre(),entrenador.getNombre(), entrenador.getLicencias() );
					}
			}
	
		} else {
			log.trace("@PostPersist => Entrenador {} ({}) NO tiene equipos asignados",
					entrenador.getNombre(), entrenador.getLicencias());
			
			entrenador.setEquipos(new ArrayList<Equipo>());
		}
	}
	
	//No necesario, el entrenador se agrega a los equipos por la bidireccionalidad del codigo en las clases EQUIPO Y ENTRENADOR
//		log.trace("@PostPersist Entrenador {} agregado a Equipos {}", entrenador.getNombre(), entrenador.getEquipos());
//		entrenador.getEquipos().forEach(e -> equipoDAO.getOne(e.getId()).addEntrenador(entrenador));		
	
	public void antesDeBorrar (Entrenador entrenador) {
		log.debug("@PreRemove Entrenador {} borrado de {} Equipos", entrenador.getNombre(), entrenador.getEquipos().size());
		entrenador.getEquipos().forEach(e -> equipoDAO.getOne(e.getId()).removeEntrenador(entrenador));
	}
	
	

}
