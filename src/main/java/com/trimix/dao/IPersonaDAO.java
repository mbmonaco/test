package com.trimix.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.trimix.model.Persona;

public interface IPersonaDAO {

	public Persona load(long id) throws PersistenceException;
	
	public Persona save(Persona persona) throws PersistenceException;
	
	public Persona update(Persona persona) throws PersistenceException;
	
	public List<Persona> list() throws PersistenceException;
	
	public List<Persona> filter(String nombre, String tipodoc) throws PersistenceException;
	
	public void delete(Persona persona) throws PersistenceException;
	
}
