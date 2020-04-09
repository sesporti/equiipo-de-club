package es.sesporti.asistencia;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Asistencia implements Identificable, Comparable<Asistencia> {

	protected Long id;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "DEFAULT_LOCALE")
	private Date fecha;
	
	@ManyToOne
	private Jugador jugador;
	
	private TipoAsistencia tipoAsistencia;
	
	public Asistencia() {}
	
	public Asistencia (Long id, TipoAsistencia tipo, Jugador jugador) {
		setId(id);
		setFecha(new Date());
		setJugador(jugador);
		setTipoAsistencia(tipo);
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date localDate) {
		this.fecha = localDate;
	}
	
	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
        if (!jugador.getAsistencias().contains(this)) { // warning this may cause performance issues if you have a large data set since this operation is O(n)
            jugador.getAsistencias().add(this);
        }
	}
	
	public Long getIdJugador() {
		return getJugador().getId();
	}

	public TipoAsistencia getTipoAsistencia() {
		return tipoAsistencia;
	}

	public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Asistencia [getId()=" + getId() + ", getFecha()=" + getFecha() + ", getJugador()=" + getJugador()
				+ ", getTipoAsistencia()=" + getTipoAsistencia() + "]";
	}

	@Override
	public int compareTo(Asistencia o) {
		
		return this.getFecha().compareTo(o.getFecha());
	}

	public static enum TipoAsistencia{
		SI,
		LESION,
		ENFERMEDAD,
		ESTUDIOS,
		INDEFINIDO
	}

}
