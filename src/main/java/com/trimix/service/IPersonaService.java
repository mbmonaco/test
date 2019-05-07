package com.trimix.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.trimix.model.Persona;
import com.trimix.model.dto.PersonaDTO;

public interface IPersonaService {
	
	public Persona load(Long id) throws ServiceException;
	
	public Persona save(Persona persona) throws ServiceException;
	
	public Persona update(Persona persona) throws ServiceException;
	
	public List<Persona> list() throws ServiceException;
	
	public List<Persona> filter(String nombre, String tipodoc) throws ServiceException;
	
	public void delete(Persona persona) throws ServiceException;
	
	public PersonaDTO loadDTO (Persona persona) throws ServiceException;
	

}
