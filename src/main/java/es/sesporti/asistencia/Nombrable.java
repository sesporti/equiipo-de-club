package es.sesporti.asistencia;

import java.util.Comparator;

public interface Nombrable extends Identificable{

	public String getNombre();
	
	static Comparator<Nombrable> getComparadorPorNombre() {
		return new Comparator<Nombrable>() {
			@Override
			public int compare(Nombrable o1, Nombrable o2) {
				if(o1 == null) return -1;
				if(o2 == null) return 1;
				return o1.getNombre().compareTo(o2.getNombre());
			}
		};
	}
}
