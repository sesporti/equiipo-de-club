package personal;

public class Domicilio {

	// Hay campos calculado: Localidad sera un tipo y conocera provincia,
	// pais y codigoPostal
	private String calle, letra, codigoPostal, provincia, localidad, pais;
	private int numero, piso;
	
	public Domicilio (String calle, int numero, int piso, String letra, String codigoPostal,
			String provincia, String localidad, String pais) {
		this.calle = calle;
		this.codigoPostal = codigoPostal;
		this.letra = letra;
		this.numero = numero;
		this.piso = piso;
		this.localidad = localidad;
		this.pais = pais;
		this.provincia = provincia;
	}

	public String getCalle() {
		return calle;
	}

	public String getLetra() {
		return letra;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getPais() {
		return pais;
	}

	public int getNumero() {
		return numero;
	}

	public int getPiso() {
		return piso;
	}

	@Override
	public String toString() {
		return "Domicilio: Calle " + getCalle() + ", nº " + getNumero() + ", piso " + getPiso() +
				 getLetra() + " ("
				+ getCodigoPostal() + "), Provincia de " + getProvincia() + " (" + getLocalidad()
				+ "), " + getPais();
	}
	
	
}
