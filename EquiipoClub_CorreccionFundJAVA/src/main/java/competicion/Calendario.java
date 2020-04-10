package competicion;

import java.util.HashMap;
import java.util.Map;

public class Calendario {
	
	// Aqui simplemente una Collection<Jorneable>
	private Map<Jorneable, Integer> jornadas;
	
	public Calendario() {
		
			
		jornadas = new HashMap<Jorneable, Integer>();
	}

	public Map<Jorneable, Integer> getJornadas() {
		return jornadas;
	}
	
	// Veo que pones aqui el numero pero lo veo algo de Jornada no 
	// que tenga que estar en un calendario
	public void agregarJornada(Jorneable jornada, int numeroJornada) {
		getJornadas().put(jornada, numeroJornada);
	}

	@Override
	// No pongas saltos de linea en un toString. Es mejor que ocupe poco
	// y queda en una sola linea porque puede estar metido en un sitio muy pequeno
	public String toString() {
		return String.format("Calendario:\ngetJornadas()=%s]", getJornadas());
	}
	
	
}
