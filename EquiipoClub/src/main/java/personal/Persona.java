package personal;

import java.util.ArrayList;
import java.util.List;

public class Persona {
	private String nombre, sexo, dni;
	private int edad;
	private List<String> telefonos, emails;
	private List<Domicilio> domicilios;
	
	public Persona (String nombre, String sexo, String dni, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.dni = dni;
		telefonos = new ArrayList<>();
		emails = new ArrayList<>();
		domicilios = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public String getDni() {
		return dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public List<String> getTelefonos() {
		return telefonos;
	}

	public List<String> getEmails() {
		return emails;
	}

	public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public String toString() {
		return getNombre() + "("+ getDni() + "), edad = " + getEdad() + " (" + getSexo() + "), teléfonos: " + getTelefonos() + ", e-mail: " + 
				getEmails() + ", domicilios: " + getDomicilios();
		
	}
}
