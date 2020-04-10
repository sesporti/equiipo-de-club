package competicion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import lugares.Club;
import personal.Entrenador;
import personal.Jugador;

public class Equipo implements Equipable, Clasificable{
	
	private Competicionable competicion;
	private final Club club;
	private int identificador;
	private Collection<Jugador> jugadores;
	private Collection<Entrenador> entrenadores;
	
	public Equipo(Competicionable competicion, Club club, int identificador) {
		this.competicion = competicion;
		this.club = club;
		this.identificador = identificador;
		jugadores = new ArrayList<>();
		entrenadores = new ArrayList<>(4);		
		
	}
	
	public Club getClub() {
		return club;
	}
	



	@Override
	public String getTemporada() {

		return getCompeticion().getTemporada();
	}

	@Override
	public Licencia getLicencia() {

		return getCompeticion().getLicencia();
	}

	@Override
	public int getGrupo() {

		return getCompeticion().getGrupo();
	}

	@Override
	public Categoria getCategoria() {

		return getCompeticion().getCategoria();
	}

	@Override
	public TipoEquipo getTipoEquipo() {

		return getCompeticion().getTipoEquipo();
	}

	@Override
	public int getGanados() {

		return getCompeticion().getClasificacion().getPartidosGanados().get(this);
	}

	@Override
	public int getEmpatados() {

		return getCompeticion().getClasificacion().getPartidosEmpatados().get(this);
	}

	@Override
	public int getPerdidos() {

		return getCompeticion().getClasificacion().getPartidosPerdidos().get(this);
	}

	@Override
	public int getPuntos() {
		
		return getGanados() * 3 + getEmpatados() * 1;
	}

	@Override
	public int getGolesFavor() {

		return getCompeticion().getClasificacion().getGolesFavor().get(this);
	}

	@Override
	public int getGolesContra() {

		return getCompeticion().getClasificacion().getGolesContra().get(this);
	}

	@Override
	// Te das cuenta que esto es lo que digo que va en Clasificacion no?
	public int getPosicion() {
		
		Comparator<Equipo> comparador = new Comparator<Equipo>() {

			@Override
			public int compare(Equipo o1, Equipo o2) {
				if (o1.getPuntos() == o2.getPuntos() ) {
					
					return -((o1.getGolesFavor()-o1.getGolesContra())-(o2.getGolesFavor()-o2.getGolesContra()));
					
				} else {
					
					return -(o1.getPuntos()-o2.getPuntos());
				}
			}
		};
		// Usa siempre la interface
		ArrayList<Equipo> equipos = (ArrayList<Equipo>) getCompeticion().getClasificacion().getEquipos();
		
		equipos.sort(comparador);
		
		int posicion = 0;
		if (equipos.contains(this)) {
			posicion = equipos.indexOf(this) + 1;
		}
		
		return posicion;
	}

	@Override
	public int getIdentificador() {

		return identificador;
	}

	@Override
	public Collection<Entrenador> getEntrenadores() {

		return entrenadores;
	}

	@Override
	public Collection<Jugador> getJugadores() {

		return jugadores;
	}

	// Todo lo de abajo no haria falta si lo pusieras default en la interface
	@Override
	public boolean tieneEntrenador() {

		return !getEntrenadores().isEmpty();
	}

	@Override
	public boolean tieneJugadores() {

		return !getJugadores().isEmpty();
	}

	@Override
	public void agregarEntrenador(Entrenador entrenador) {
		getEntrenadores().add(entrenador);
		
	}

	@Override
	public void eliminarEntrenador(Entrenador entrenador) {
		getEntrenadores().remove(entrenador);
		
	}

	@Override
	public void agregarJugador(Jugador jugador) {
		getJugadores().add(jugador);
		
	}

	@Override
	public void eliminarJugador(Jugador jugador) {
		getJugadores().remove(jugador);
		
	}

	@Override
	public void agregarJugadores(Collection<Jugador> jugadores) {
		getJugadores().addAll(jugadores);
		
	}
	// Hasta aqui y son 40 lineas que te ahorras en todas las implementaciones

	@Override
	public Competicion getCompeticion() {
		// Este casteo te pasa por meter la clase
		// en la interface sin que haga falta. Para eso 
		// pon este tipo en el campo
		return (Competicion) competicion;
	}

	@Override
	public Calendario getCalendario() {

		return getCompeticion().getCalendario();
	}

	// Pues eso, no pongas saltos de linea en los toString
	public String datosEquipo() {
		
		return String.format("Temporada: %s\nEquipo: %s %s, Grupo-%s"
				,getTemporada(),getClub().getNombre(),getCategoria(),getLicencia(),getGrupo());
	}

	// Estas cosas se dejan para las clases de presentacion. Basta con getJugadores()
	public String listarJugadores() {
		String listado="Jugadores:\n";
		
		for (Jugador jugador : getJugadores()) {
			listado += jugador.getNumeroJugador() + ". " + jugador.getNombre() + "\n";
		}
		
		return listado;
	}

	// Lo mismo de arriba
	public String listarEntrenadores() {
		
		String listado ="Entrenadores:\n";
		
		for (Entrenador entrenador : entrenadores) {
			
			listado += entrenador.getNombre() + "\n";
		}
		
		return listado;
	}

	// Lo mismo
	public void informeEquipo() {
		System.out.printf("INFORME DEL EQUIPO\n%s\n%s\n%s"
				,datosEquipo(),listarEntrenadores(),listarJugadores());
	}
	
	
}
