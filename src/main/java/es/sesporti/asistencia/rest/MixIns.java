package es.sesporti.asistencia.rest;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Equipo;
import es.sesporti.asistencia.Jugador;
import es.sesporti.asistencia.LocalDateDeserializer;
import es.sesporti.asistencia.LocalDateSerializer;
import es.sesporti.asistencia.Asistencia;
import es.sesporti.asistencia.Asistencia.TipoAsistencia;

public class MixIns {
	
	@JsonIgnoreProperties(value = {"idEquipo"})//"asistencias","equipo"
	@JsonPropertyOrder({ "nombre", "edad","poc", "nif","nombreEquipo","categoriaEquipo","licenciaEquipo"})//, "equipo","asistencias" 
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
		abstract long getEquipoId();		
		
		@JsonProperty("equipo")
		abstract Equipo getEquipo();
		
		@JsonProperty("nombreEquipo")
		abstract String getEquipoNombre();
		
		@JsonProperty("categoriaEquipo")
		abstract String getEquipoCategoria();
		
		@JsonProperty("licenciaEquipo")
		abstract String getEquipoLicencia();
		
		@JsonProperty("asistencias")
		abstract List<Asistencia> getAsistencias();
	}
	
	//@JsonIgnoreProperties(value = { "equipos" })
	@JsonPropertyOrder({ "id", "nombre", "nif", "licencias", "equipos" })
	public static interface Entrenadores {
		
		@JsonProperty("id")
		abstract long getId();
		@JsonProperty("nombre")
		abstract String getNombre();
		@JsonProperty("nif")
		abstract String getNif();
		@JsonProperty("licencias")
		abstract Set<String> getLicencias();
		@JsonProperty("equipos")
		abstract List<Equipo> getEquipos();
	}
	
	//@JsonIgnoreProperties(value = { "jugadores","entrenadores" })//
	@JsonPropertyOrder({ "id", "categoria","licencia", "nombre", "jugadores","entrenadores" })
	public static interface Equipos {
		
		@JsonProperty("id")
		abstract long getId();
		@JsonProperty("nombre")
		abstract String getNombre();
		@JsonProperty("categoria")
		abstract String getCategoria();
		@JsonProperty("licencia")
		abstract String getLicencia();
		@JsonProperty("jugadores")
		abstract List<Jugador> getJugadores();
		@JsonProperty("entrenadores")
		abstract List<Entrenador> getEntrenadores();
	}
	
	@JsonIgnoreProperties(value = { "idJugador"})//,"jugador"
	@JsonPropertyOrder({"id", "fecha", "tipoAsistencia", "nombreJugador"})
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
		abstract long getJugadorId();
		@JsonProperty("nombreJugador")
		abstract String getJugadorNombre();
		@JsonProperty("tipoAsistencia")
		abstract TipoAsistencia getTipoAsistencia();
	}
    
}

