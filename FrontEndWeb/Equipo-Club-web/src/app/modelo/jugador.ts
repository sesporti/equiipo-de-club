export interface Jugador {
  nombre: string;
  edad: number;
  fechaNacimiento: string;
  poc: string;
  nif: string;
  _links: {
    self: {
      href: string;
    };
    jugador: {
      href: string;
    };
    asistencias: {
      href: string;
    };
    equipo: {
      href: string;
    };
  };
  equipo: string;
  nombreEquipo: string;
}
