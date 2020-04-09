package es.sesporti.asistencia.rest;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Equipo;
import es.sesporti.asistencia.Jugador;
import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Asistencia.TipoAsistencia;

public class MixIns {
	
	@JsonIgnoreProperties(value = {"asistencias","equipo"})//
	@JsonPropertyOrder({ "nombre", "edad", "idequipo", "poc", "nif","equipo","asistencias" })
	public static interface Jugadores {
		@JsonProperty("id")
		abstract Long getId();
		@JsonProperty("nombre")
		abstract String getNombre();
		@JsonProperty("nif")
		abstract String getNif();
		@JsonProperty("poc")
		abstract String getPoc();
		@JsonProperty("idEquipo")
		abstract Long getIdEquipo();
		@JsonProperty("edad")
		abstract int getEdad();
		@JsonProperty("equipo")
		abstract Equipo getEquipo();
		@JsonProperty("asistencias")
		abstract List<Asistencia> getAsistencias();
	}
	
	//@JsonIgnoreProperties(value = { "equipo" })
	//@JsonPropertyOrder({ "id", "nif", "categoria", "nombre" })
	public static interface Entrenadores {
		@JsonProperty("id")
		abstract Long getId();
		@JsonProperty("nombre")
		abstract String getNombre();
		@JsonProperty("nif")
		abstract String getNif();
		@JsonProperty("categoria")
		abstract String getCategoria();
		@JsonProperty("equipo")
		abstract Equipo getEquipo();
	}
	
	//@JsonIgnoreProperties(value = { "jugadores","entrenadores" })
	@JsonPropertyOrder({ "id", "categoria", "nombre", "jugadores","entrenadores" })
	public static interface Equipos {
		@JsonProperty("id")
		abstract Long getId();
		@JsonProperty("nombre")
		abstract String getNombre();
		@JsonProperty("jugadores")
		abstract List<Jugador> getJugadores();
		@JsonProperty("entrenadores")
		abstract List<Entrenador> getEntrenadores();
		@JsonProperty("categoria")
		abstract String getCategoria();		
	}
	
	//@JsonIgnoreProperties(value = { "idJugador" })
	public static interface Asistencias {
		@JsonProperty("id")
		abstract Long getId();
		@JsonProperty("fecha")
		abstract Date getFecha();
		@JsonProperty("jugador")
		abstract Jugador getJugador();
		@JsonProperty("idJugador")
		abstract Long getIdJugador();
		@JsonProperty("tipoAsistencia")
		abstract TipoAsistencia getTipoAsistencia();
	}
    
}

