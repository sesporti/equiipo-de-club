package es.sesporti.asistencia.rest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import competicion.Categoria;
import competicion.Licencia;
import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Equipo;
import es.sesporti.asistencia.Jugador;
import es.sesporti.asistencia.LocalDateDeserializer;
import es.sesporti.asistencia.LocalDateSerializer;
import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Asistencia.TipoAsistencia;

public class MixIns {
	
	@JsonIgnoreProperties(value = {"licenciaEquipo","idEquipo","nombreEquipo","categoriaEquipo"})//,"asistencias","equipo"
	@JsonPropertyOrder({ "id", "nombre", "edad","fechaNacimiento","poc", "nif"})// ,"equipo","asistencias" 
	public static interface Jugadores {
		
		@JsonProperty("id")
		abstract long getId();
		
		@JsonProperty("nombre")
		abstract String getNombre();
		
		@JsonProperty("nif")
		abstract String getNif();
		
		@JsonProperty("poc")
		abstract String getPoc();
		
		@JsonProperty("fechaNacimiento")
		@JsonDeserialize(using = LocalDateDeserializer.class)
	    @JsonSerialize(using = LocalDateSerializer.class)
		abstract LocalDate getFechaNacimiento();
		
		@JsonProperty("edad")
		abstract int getEdad();
		
		@JsonProperty("idEquipo")
		abstract long getIdEquipo();		
		
		@JsonProperty("equipo")
		abstract Equipo getEquipo();
		
		@JsonProperty("nombreEquipo")
		abstract String getNombreEquipo();
		
		@JsonProperty("categoriaEquipo")
		abstract String getCategoriaEquipo();
		
		@JsonProperty("licenciaEquipo")
		abstract String getLicenciaEquipo();
		
		@JsonProperty("asistencias")
		abstract List<Asistencia> getAsistencias();
	}
	
	@JsonIgnoreProperties(value = { "nombreEquipos","idEquipos","categoriaEquipos","licenciaEquipos" })
	@JsonPropertyOrder({ "id", "nombre", "nif", "licencias", "equipos" })
	public static interface Entrenadores {
		
		@JsonProperty("id")
		abstract long getId();
		@JsonProperty("nombre")
		abstract String getNombre();
		@JsonProperty("nif")
		abstract String getNif();
		@JsonProperty("licencias")
		abstract Collection<Licencia> getLicencias();
		@JsonProperty("equipos")
		abstract List<Equipo> getEquipos();
	}
	
	@JsonIgnoreProperties(value = { "nombreJugadores", "nombreEntrenadores" })//,"jugadores","entrenadores"
	@JsonPropertyOrder({ "id","nombre","licencia","categoria","entrenadores","jugadores" })
	public static interface Equipos {
		
		@JsonProperty("id")
		abstract long getId();
		@JsonProperty("nombre")
		abstract String getNombre();
		@JsonProperty("categoria")
		abstract Categoria getCategoria();
		@JsonProperty("licencia")
		abstract Licencia getLicencia();
		@JsonProperty("jugadores")
		abstract List<Jugador> getJugadores();
		@JsonProperty("entrenadores")
		abstract List<Entrenador> getEntrenadores();
	}
	
	@JsonIgnoreProperties(value = { "idJugador","entrenadoresJugador"})//,"jugador"
	@JsonPropertyOrder({"id", "fecha", "tipoAsistencia", "nombreJugador","equipoJugador"})
	public static interface Asistencias {
		
		@JsonProperty("id")
		abstract long getId();

		@JsonProperty("fecha")
		@JsonDeserialize(using = LocalDateDeserializer.class)
	    @JsonSerialize(using = LocalDateSerializer.class)
		abstract LocalDate getFecha();

		@JsonProperty("jugador")
		abstract Jugador getJugador();
		@JsonProperty("idJugador")
		abstract long getIdJugador();
		@JsonProperty("nombreJugador")
		abstract String getNombreJugador();
		@JsonProperty("tipoAsistencia")
		abstract TipoAsistencia getTipoAsistencia();
		@JsonProperty("equipoJugador")
		abstract Equipo getEquipoJugador();
		@JsonProperty("entrenadoresJugador")
		abstract List<Entrenador> getEntrenadoresJugador();
	}
    
}

