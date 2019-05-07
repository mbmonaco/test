package com.trimix.dao.hibernate;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trimix.dao.IPersonaDAO;
import com.trimix.model.Persona;

@Repository
public class PersonaDAO implements IPersonaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Persona load(long id) throws PersistenceException {
		Persona p = null;
		Session session = this.sessionFactory.openSession();
		try {
			Query query = session.createQuery("FROM Persona WHERE p.perId=:id").setParameter("id", id);
			p = (Persona) query.uniqueResult();
		} catch (Exception e) {

			throw new PersistenceException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return p;
	}

	@Override
	public Persona save(Persona persona) throws PersistenceException {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(persona);
			session.getTransaction().commit();
		} catch (Exception e) {

			throw new PersistenceException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return persona;
	}

	@Override
	public Persona update(Persona persona) throws PersistenceException {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(persona);
			session.getTransaction().commit();
		} catch (Exception e) {

			throw new PersistenceException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return persona;
	}

	@Override
	public List<Persona> list() throws PersistenceException {
		List<Persona> list = null;
		Session session = this.sessionFactory.openSession();
		try {
			list = session.createQuery("FROM Persona").list();
		} catch (Exception e) {
			// LOG.error(e.getMessage(), e);
			throw new PersistenceException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Persona> filter(String nombre, String tipodoc) throws PersistenceException {
		List<Persona> list = null;
		Session session = this.sessionFactory.openSession();
		try {
			String query = " FROM Persona p WHERE lower(p.perNombre) LIKE '%" + nombre.toLowerCase() + "%'";
			if (!tipodoc.equals("Todas")) {
				query = query + " AND p.perTipoDocumento LIKE '" + tipodoc + "'";
			}
			list = session.createQuery(query).list();
		} catch (Exception e) {

			throw new PersistenceException(e.getMessage(), e);
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void delete(Persona persona) throws PersistenceException {
		Session session = this.sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(persona);
			session.getTransaction().commit();
		} catch (Exception e) {
			// LOG.error(e.getMessage(), e);
			throw new PersistenceException(e.getMessage(), e);
		} finally {
			session.close();
		}

	}

}
