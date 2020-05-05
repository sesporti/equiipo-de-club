package es.sesporti.asistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToMany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import competicion.Categoria;
import competicion.Licencia;

public class Entrenador implements Nombrable, EntrenadorEquipo, Comparable<Entrenador>{

	private long id;
	private String nombre, nif;
	
	@ElementCollection(targetClass=Licencia.class)
	private Collection<Licencia> licencias;
	@ManyToMany(targetEntity=Equipo.class)
	private List<Equipo> equipos;
	
	//ACCESORS: GETTERS Y SETTERS
	@Override
	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
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

	public Collection<Licencia> getLicencias() {
		return licencias;
	}

	public void setLicencias(List<Licencia> licencias) {
		this.licencias = licencias;
	}
	
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		for (Equipo equipo : equipos) {
			addEquipo(equipo);
		}
	}
	
	public List<String> getNombreEquipos(){
		List<String> nombres = new ArrayList<>();
		for (Equipo equipo : getEquipos()) {
			nombres.add(equipo.getNombre());
		}
		return nombres;
	}
	
	public List<Long> getIdEquipos(){
		List<Long> idList = new ArrayList<>();
		for (Equipo equipo : getEquipos()) {
			idList.add(equipo.getId());
		}
		return idList;
	}
	
	public List<Categoria> getCategoriaEquipos(){
		List<Categoria> categorias = new ArrayList<>();
		for (Equipo equipo : getEquipos()) {
			if (this.getLicencias().contains(equipo.getLicencia())) {
				categorias.add(equipo.getCategoria());
			}			
		}
		return categorias;
	}
	
	public List<Licencia> getLicenciaEquipos(){
		List<Licencia> licencias = new ArrayList<>();
		for (Equipo equipo : getEquipos()) {
			licencias.add(equipo.getLicencia());			
		}
		return licencias;
	}

	//CONSTRUCTORS
	public Entrenador() {}
	
	public Entrenador(long id, String nif) {
		this(id, "PENDIENTE DEFINICION", nif);
	}
	
	public Entrenador(long id, String nombre, String nif) {
		setId(id);
		setNombre(nombre);
		setNif(nif);
		equipos = new ArrayList<Equipo>();
		licencias = new ArrayList<Licencia>();
	}
	
	//METHODS
	public void addLicencia(Licencia licencia) {
		if (! getLicencias().contains(licencia)) {
			getLicencias().add(licencia);
		}		
	}
	
	public void removeLicencia(Licencia licencia) {
		getLicencias().remove(licencia);
	}
	
	/**
	 * Agrega un equipo al entrenador siempre y cuando el entrenador tenga la licencia para poder entrenar a dicho equipo.
	 * Así mismo, si el entrenador cumple esta condición y no esta incluido como entrendor del equipo se le incluye.
	 * @param equipo (tiene una licencia que debe poseer el entrenador para poder ser agregado)
	 */
	public void addEquipo(Equipo equipo) {
		Logger log = LoggerFactory.getLogger(Entrenador.class);
		try {
			if (isEntrenadorValidoParaEquipo(this, equipo)) {
				getEquipos().add(equipo);
				if (!equipo.getEntrenadores().contains(this)) {
					equipo.getEntrenadores().add(this);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			log.debug("El equipo {} NO puede ser entrenado por el entrenador {},"
					+ " distinto tipo de Licencia", equipo.getNombre(), getNombre());
		}
		
		
	}
	
	/**
	 * Elimina el equipo al entrenador si esta en la lista y actualiza en el equipo pasado como parámetro eliminando al entrenador.
	 * @param equipo
	 */
	public void removeEquipo(Equipo equipo) {
		getEquipos().remove(equipo);
		equipo.getEntrenadores().remove(this);
	}	
	
	@Override
	public String toString() {
		return String.format("Entrenador (%s): Nombre: %s, NIF: %s, Licencias: %s.",
							getId(), getNombre(), getNif(), getLicencias());
	}

	@Override
	public int compareTo(Entrenador o) {
		if (Nombrable.getComparadorPorNombre().compare(this, o) == 0) {
			return this.getNif().compareTo(o.getNif());
		} else {
			return Nombrable.getComparadorPorNombre().compare(this, o);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrenador other = (Entrenador) obj;
		if (id != other.id)
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}

}
