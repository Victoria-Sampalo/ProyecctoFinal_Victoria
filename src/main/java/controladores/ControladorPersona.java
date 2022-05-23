package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


import entidades.Persona;



public class ControladorPersona {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("p81victoriav2");
	private EntityManager em;
	private Query consulta;
	
	
	public void borrarPersona(Persona p) {
		this.em = entityManagerFactory.createEntityManager();
		Persona aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(p)) {
			aux = this.em.merge(p);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void modificarPersona(Persona p) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(p);
		this.em.getTransaction().commit();
		this.em.close();

	}
	public void crearPersona(Persona p) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(p);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Persona findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Persona aux = null;
		this.consulta = em.createNativeQuery("Select * from persona where idpersona = ?", Persona.class);
		this.consulta.setParameter(1, pk);
		try {
			aux = (Persona) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}
		this.em.close();
		return aux;

	}
	public Persona findByNif(String dni) {
		this.em = entityManagerFactory.createEntityManager();
		Persona aux = null;
		this.consulta = em.createNativeQuery("Select * from persona where dni = ?", Persona.class);
		this.consulta.setParameter(1, dni);
		try {
			aux = (Persona) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}
		this.em.close();
		return aux;

	}
	public List<Persona> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Cliente.findAll");
		List<Persona> lista = (List<Persona>) consulta.getResultList();
		this.em.close();
		return lista;
	}

	
	

}
