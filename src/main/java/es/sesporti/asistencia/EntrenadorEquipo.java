package es.sesporti.asistencia;

public interface EntrenadorEquipo {

	default boolean isEntrenadorValidoParaEquipo(Entrenador entrenador, Equipo equipo) {
		
		return entrenador.getLicencias().contains(equipo.getLicencia());
	}
}
