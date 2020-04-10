package lugares;


import java.util.Collection;
import java.util.HashSet;

public class Club implements Ubicacion{
	
	private String cif, nombre;
	private Collection<Campo> campos;
	private double longitud, latitud;
	
	public Club(String nombre) {
		cif = "";
		this.nombre = nombre;
		campos = new HashSet<>();		
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Collection<Campo> getCampos() {
		return campos;
	}

	@Override
	public double getLongitud() {
		
		return longitud;
	}
	
	public void setLongitud(double longitud) {
			this.longitud = longitud;
	}
	
	@Override
	public double getLatitud() {
		
		return latitud;
	}
	
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public boolean agregarCampo(Campo campo) {
		return getCampos().add(campo);
	}
	
	public boolean eliminarCampo(Campo campo) {
		return getCampos().remove(campo);
	}
	
	public boolean agregarCampos(Collection<Campo> campos) {
		return getCampos().addAll(campos);
	}
	
	public String ubicacion() {
		return getLatitud() + "-" + getLongitud();
	}

	@Override
	public String toString() {
		return String.format("%s (Cif: %s), Datos ubicacion(): %s, Lista de Campos = [ %s ]", getNombre(),
				getCif(), ubicacion(), getCampos());
	}
	
	
}
