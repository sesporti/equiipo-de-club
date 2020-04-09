package competicion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Clasificacion {
	
	private Collection<Equipo> equipos;
	private Map<Equipo, Integer> partidosGanados;
	private Map<Equipo, Integer> partidosEmpatados;
	private Map<Equipo, Integer> partidosPerdidos;
	private Map<Equipo, Integer> golesFavor;
	private Map<Equipo, Integer> golesContra;

	public Clasificacion() {
	
		equipos = new ArrayList<Equipo>();
		partidosGanados = new HashMap<Equipo, Integer>();
		partidosEmpatados = new HashMap<Equipo, Integer>();
		partidosPerdidos = new HashMap<Equipo, Integer>();
		golesFavor = new HashMap<Equipo, Integer>();
		golesContra = new HashMap<Equipo, Integer>();
	}

	public Collection<Equipo> getEquipos() {
		return equipos;
	}

	public Map<Equipo, Integer> getPartidosGanados() {
		return partidosGanados;
	}

	public Map<Equipo, Integer> getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public Map<Equipo, Integer> getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public Map<Equipo, Integer> getGolesFavor() {
		return golesFavor;
	}

	public Map<Equipo, Integer> getGolesContra() {
		return golesContra;
	}
	
	
}
