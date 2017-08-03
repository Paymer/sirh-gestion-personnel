package dev.sgp.service;



import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.Departement;


@Stateless
public class DepartementService {

	
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	

	
	
	public List<Departement> listerDepartement() {
	
		// JPQL = pas table mais classe !!!!!
		 			TypedQuery<Departement> query = em.createQuery("select p from Departement p", Departement.class);
		 			return query.getResultList();

	}
	


	public void sauvegarderDepartement(Departement dep) {
		
		em.persist(dep);		
		
	}
	
}
