package competicion;

public interface Competicionable extends Licenciable,Agrupable
								,Categorizable,TipoEquipoInterface {

	String getTemporada();
	Competicion getCompeticion();
	Calendario getCalendario();
}
