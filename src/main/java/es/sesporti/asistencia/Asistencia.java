package es.sesporti.asistencia;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ManyToOne;
//import com.fasterxml.jackson.annotation.JsonFormat;

public class Asistencia implements Identificable, Comparable<Asistencia> {

	public static enum TipoAsistencia{
		SI,
		LESION,
		ENFERMEDAD,
		ESTUDIOS,
		INDEFINIDO
	}
	
	protected long id;
	
	private LocalDate fecha;
	
	@ManyToOne(targetEntity=Jugador.class)
	private Jugador jugador;	
	private TipoAsistencia tipoAsistencia = TipoAsistencia.SI;
	
	//ACCESORS: GETTERS & SETTERS
	@Override
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate localDate) {
		this.fecha = localDate;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
//        if (!jugador.getAsistencias().contains(this)) { // Da problemas al deserializar asistencias.json, ademas se advierte que esto puede causar problemas de rendimiento si tiene un conjunto de datos grande ya que esta operación es O (n)
//            jugador.getAsistencias().add(this);
//        }
	}
	
	public TipoAsistencia getTipoAsistencia() {
		return tipoAsistencia;
	}

	public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}
	
	public long getIdJugador() {
		return getJugador().getId();
	}
	
	public String getNombreJugador() {
		return getJugador().getNombre();
	}
	
	public Equipo getEquipoJugador() {
		return getJugador().getEquipo();
	}
	
	public List<Entrenador> getEntrenadoresJugador(){
		return getJugador().getEquipo().getEntrenadores();
	}

	//CONSTRUCTORS
	public Asistencia() {}
	
	public Asistencia (long id, Jugador jugador) {
		this(id, jugador, TipoAsistencia.SI);
	}
	
	public Asistencia (long id, Jugador jugador, TipoAsistencia tipo) {
		setId(id);
		setFecha(LocalDate.now());
		setJugador(jugador);
		setTipoAsistencia(tipo);
	}
	
	//METODOS
	
	@Override
	public String toString() {
		return String.format("Asistencia (%s) => Fecha: %s, Tipo Asistencia = %s, Jugador: %s",
				getId(), getFecha(), getTipoAsistencia(), getNombreJugador());
	}

	@Override
	public int compareTo(Asistencia o) {
		if (this.getFecha().equals(o.getFecha())) {
			return this.getTipoAsistencia().compareTo(o.getTipoAsistencia());
		}
		return this.getFecha().compareTo(o.getFecha());
	}



}
