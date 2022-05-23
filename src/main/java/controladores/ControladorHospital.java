package controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Cliente;
import entidades.Hospital;

public class ControladorHospital {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("p81victoriav2");
	private EntityManager em;
	private Query consulta;
	
	public void borrarHospital(Hospital h) {
		this.em = entityManagerFactory.createEntityManager();
		Hospital aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(h)) {
			aux = this.em.merge(h);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public void modificarCliente(Hospital h) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(h);
		this.em.getTransaction().commit();
		this.em.close();

	}
	public void crearCliente(Hospital h) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(h);
		this.em.getTransaction().commit();
		this.em.close();
	}
	
	public Hospital findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Hospital aux = null;
		this.consulta = em.createNativeQuery("Select * from hospital where codhospi = ?", Hospital.class);
		this.consulta.setParameter(1, pk);
		try {
			aux = (Hospital) consulta.getSingleResult();
		} catch (NoResultException nre) {	
			aux = null;
		}
		this.em.close();
		return aux;

	}
	
}
