package es.sesporti.asistencia;

public interface EntrenadorEquipo {

	default boolean isEntrenadorValidoParaEquipo(Entrenador entrenador, Equipo equipo) {
		boolean valido = false;
		if (equipo != null && entrenador != null && entrenador.getLicencias().contains(equipo.getLicencia())) {
			valido = true;
		}
		return valido;
		
	}
}
