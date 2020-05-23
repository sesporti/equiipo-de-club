export interface Equipo {
  nombre: string;
  licencia: string;
  categoria: string;
  _links: {
    self: {
      href: string;
    };
    equipo: {
      href: string;
    };
    jugadores: {
      href: string;
    };
    entrenadores: {
      href: string;
    };
  };
  jugadores: [];
  entrenadores: [];
}
