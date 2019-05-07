package com.trimix.model.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trimix.model.Persona;

@JsonPropertyOrder({ "perApellido", "perFechaNacimiento", "perId", "perNombre", "perNumeroDocumento",
		"perTipoDocumento" })
public class PersonaDTO {

	@JsonIgnore
	private Persona persona;

	public PersonaDTO(Persona persona) {
		this.persona = persona;
	}

	public String getPerApellido() {
		return persona.getPerApellido();
	}

	public String getPerFechaNacimiento() {
		if (persona.getPerFechaNacimiento() != null) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(persona.getPerFechaNacimiento());
		}
		return null;
	}

	public Long getPerId() {
		return persona.getPerId();
	}

	public String getPerNombre() {
		return persona.getPerNombre();
	}

	public Long getPerNumeroDocumento() {
		return persona.getPerNumeroDocumento();
	}

	public String getPerTipoDocumento() {
		return persona.getPerTipoDocumento();
	}

}
