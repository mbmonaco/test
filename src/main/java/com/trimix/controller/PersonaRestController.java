package com.trimix.controller;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.service.spi.ServiceException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trimix.model.Persona;
import com.trimix.model.dto.PersonaDTO;
import com.trimix.service.IPersonaService;
import com.trimix.utils.JsonUtils;

@RestController
@RequestMapping(value = "/personas")
public class PersonaRestController {	
	
	@Autowired
	private IPersonaService personaService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<Object> list() {
		try {
			return new ResponseEntity<Object>(personaService.list(), HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
	
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ResponseEntity<Object> filter(
			@RequestParam(value = "nombre", defaultValue = "", required = true) String nombre,
			@RequestParam(value = "tipodoc", defaultValue = "Todas", required = true) String tipodoc) {
		try {
			return new ResponseEntity<Object>(personaService.filter(nombre,tipodoc), HttpStatus.OK);
		} catch (ServiceException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody String personaJson) throws JSONException, ParseException {	
		Persona persona=new Persona();
		try {
			String apellido=JsonUtils.getStringValueFromJson(personaJson, "perApellido");
			persona.setPerApellido(apellido);
			String nombre=JsonUtils.getStringValueFromJson(personaJson, "perNombre");
			persona.setPerNombre(nombre);
			String tipoDocumento=JsonUtils.getStringValueFromJson(personaJson, "perTipoDocumento");
			persona.setPerTipoDocumento(tipoDocumento);
			Long numeroDocumento=JsonUtils.getLongValueFromJson(personaJson, "perNumeroDocumento");
			persona.setPerNumeroDocumento(numeroDocumento);
			Date fechaNacimiento=JsonUtils.getDateyyyyMMddFromJson(personaJson, "perFechaNacimiento");
			persona.setPerFechaNacimiento(fechaNacimiento);		
			
			persona=personaService.save(persona);
			PersonaDTO personaDTO = personaService.loadDTO(persona);			
			return new ResponseEntity<Object>(personaDTO, HttpStatus.CREATED);
		} catch (ServiceException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody String personaJson) throws JSONException, ParseException {		
		Persona persona=new Persona();
		try {
			String apellido=JsonUtils.getStringValueFromJson(personaJson, "perApellido");
			persona.setPerApellido(apellido);
			String nombre=JsonUtils.getStringValueFromJson(personaJson, "perNombre");
			persona.setPerNombre(nombre);
			String tipoDocumento=JsonUtils.getStringValueFromJson(personaJson, "perTipoDocumento");
			persona.setPerTipoDocumento(tipoDocumento);
			Long numeroDocumento=JsonUtils.getLongValueFromJson(personaJson, "perNumeroDocumento");
			persona.setPerNumeroDocumento(numeroDocumento);
			Date fechaNacimiento=JsonUtils.getDateyyyyMMddFromJson(personaJson, "perFechaNacimiento");
			persona.setPerFechaNacimiento(fechaNacimiento);
			Long id=JsonUtils.getLongValueFromJson(personaJson, "perId");
			persona.setPerId(id);
			
			persona=personaService.update(persona);
			PersonaDTO personaDTO = personaService.loadDTO(persona);
			return new ResponseEntity<Object>(personaDTO, HttpStatus.OK);
		} catch (ServiceException e) {			
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable long id) {
		try {
			Persona p = new Persona();
			p.setPerId(id);
			personaService.delete(p);
			return ResponseEntity.ok().body(null);
		} catch (ServiceException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
		}		
	}
	
}
