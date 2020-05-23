export interface Asistencia {
  fecha: string;
  tipoAsistencia: string;
  nombreJugador: string;
  equipoJugador: {
    nombre: string;
    licencia: string;
    categoria: string;
  };
  _links: {
    self: {
      href: string;
    };
    asistencia: {
      href: string;
    };
    jugador: {
      href: string;
    };
  };
  jugador: string;
}
