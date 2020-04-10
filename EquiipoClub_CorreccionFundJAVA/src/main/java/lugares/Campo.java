package lugares;

import competicion.TipoEquipo;

public class Campo implements TerrenoJuego{

	private int numero;
	private TipoEquipo tipo;
	private boolean hierba;
	
	public Campo(int numero, TipoEquipo tipo, boolean hierba) {

		this.hierba = hierba;
		this.numero = numero;
		this.tipo = tipo;
		
	}

	@Override
	public int getNumero() {
		
		return numero;
	}

	@Override
	public TipoEquipo getTipo() {
		
		return tipo;
	}

	@Override
	public boolean getCesped() {
		
		return hierba;
	}

	@Override
	public String toString() {
		return String.format("Campo de %s (nº %s), con cesped = %s", getTipo(), getNumero(),
				getCesped());
	}
	
	
	

}
