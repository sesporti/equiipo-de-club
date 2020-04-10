package competicion;

public interface Clasificable {
	
	int getGanados();
	int getEmpatados();
	int getPerdidos();
	// Esto no puede ser un default que se calcula en funcion
	// de los anteriores?
	int getPuntos();
	int getGolesFavor();
	int getGolesContra();
	// Lo de arriba lo dejaria aqui porque es propio de cada elemento
	// y puede almacenarse en el objeto, pero la posicion depende de
	// los datos del resto asi que lo sacaria de aqui. Seria un 
	// dato calculado en funcion de toda la coleccion de clasificable:
	// basicamente seria ordenar por puntos, desempatar por gol average
	// en su caso y de ahi salen las posiciones, pero no ponerte a sincronizar
	// los valores en cada uno
	int getPosicion();

}
