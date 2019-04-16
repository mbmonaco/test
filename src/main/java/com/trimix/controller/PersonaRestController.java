package com.trimix.controller;

import org.hibernate.service.spi.ServiceException;
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
import com.trimix.service.IPersonaService;

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
	public ResponseEntity<Object> save(@RequestBody Persona persona) {		
		try {
			return new ResponseEntity<Object>(personaService.save(persona), HttpStatus.CREATED);
		} catch (ServiceException e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody Persona persona) {		
		try {
			return new ResponseEntity<Object>(personaService.update(persona), HttpStatus.OK);
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
