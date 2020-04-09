package competicion;

import java.util.HashMap;
import java.util.Map;

public class Calendario {
	
	private Map<Jorneable, Integer> jornadas;
	
	public Calendario() {
		
			
		jornadas = new HashMap<Jorneable, Integer>();
	}

	public Map<Jorneable, Integer> getJornadas() {
		return jornadas;
	}
	
	public void agregarJornada(Jorneable jornada, int numeroJornada) {
		getJornadas().put(jornada, numeroJornada);
	}

	@Override
	public String toString() {
		return String.format("Calendario:\ngetJornadas()=%s]", getJornadas());
	}
	
	
}
