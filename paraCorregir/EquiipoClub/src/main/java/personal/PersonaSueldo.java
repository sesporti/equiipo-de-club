package personal;

public abstract class PersonaSueldo extends Persona {
	
	private double sueldo;

	public PersonaSueldo(String nombre, String sexo, String dni, int edad, double sueldo) {
		super(nombre, sexo, dni, edad);
		this.sueldo = sueldo;
	}
	
	
	public double getSueldo() {
		return sueldo;
	}
	
	protected void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}


	public abstract double calcularSueldo();
	public abstract void agregarSueldo(double sueldo);
	public abstract void eliminarSueldo(double sueldo);

	@Override
	public String toString() {
		return super.toString() + "\nSUELDO = " + calcularSueldo() + " €";
	}
	
	

}
