package competicion;

public interface Competicionable extends Licenciable,Agrupable
								,Categorizable,TipoEquipoInterface {

	String getTemporada();
	// Evita las clases de las interfaces. Si no ya estas
	// ligando la interface a una implementacion concreta
	Competicion getCompeticion();
	Calendario getCalendario();
}
