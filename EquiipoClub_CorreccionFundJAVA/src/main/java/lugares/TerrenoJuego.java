package lugares;

import competicion.TipoEquipo;

public interface TerrenoJuego{

	int getNumero();
	TipoEquipo getTipo();
	// Aqui quizas un enum para saber el tipo de cesped?
	boolean getCesped();
}
