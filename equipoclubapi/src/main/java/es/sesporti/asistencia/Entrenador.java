package es.sesporti.asistencia;

import javax.persistence.ManyToOne;

public class Entrenador implements Identificable, Comparable<Entrenador>{


	protected Long id;
	private String nombre, nif, categoria;

	@ManyToOne
//	@JoinColumn(name="ID_EQUIPO", referencedColumnName="ID")
	private Equipo equipo;
	
	public Entrenador() {}
	
//	public Entrenador(Long id, String nif) {
//		this(id, "", nif, "",);
//	}
	
	public Entrenador(Long id, String nombre, String nif, String categoria) {
		setId(id);
		setNombre(nombre);
		setNif(nif);
		setCategoria(categoria);
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Entrenador [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getNif()=" + getNif()
				+ ", getCategoria()=" + getCategoria() + "]";
	}

	@Override
	public int compareTo(Entrenador o) {
		if (this.getNombre().equals(o.getNombre())) {
			return this.getNif().compareTo(o.getNif());
		} else {
			return this.getNombre().compareTo(o.getNombre());
		}
	}
	
	
}
