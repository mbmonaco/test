package com.trimix.service.impl;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimix.dao.hibernate.PersonaDAO;
import com.trimix.model.Persona;
import com.trimix.model.dto.PersonaDTO;
import com.trimix.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private PersonaDAO personaDAO;

	@Override
	public List<Persona> list() {
		return personaDAO.list();
	}

	@Override
	public List<Persona> filter(String nombre, String tipodoc) {
		return personaDAO.filter(nombre, tipodoc);
	}

	@Override
	public Persona load(Long id) throws ServiceException {
		return personaDAO.load(id);
	}

	@Override
	public Persona save(Persona persona) throws ServiceException {
		return personaDAO.save(persona);
	}

	@Override
	public Persona update(Persona persona) throws ServiceException {
		return personaDAO.update(persona);
	}

	@Override
	public void delete(Persona persona) throws ServiceException {
		personaDAO.delete(persona);

	}
	
	@Override
	public PersonaDTO loadDTO(Persona persona) throws ServiceException {
		return new PersonaDTO(persona);
	}

}
