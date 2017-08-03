package dev.sgp.listeners;



import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;


public class InitializerSessionListener implements ServletContextListener {
	
	@EJB private CollaborateurService collabService;
	@EJB private DepartementService departementService;
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		
		
		
		departementService.sauvegarderDepartement(new Departement ("Comptabilité"));
		departementService.sauvegarderDepartement(new Departement ("Ressources Humaines"));
		departementService.sauvegarderDepartement(new Departement ("Informatique"));
		departementService.sauvegarderDepartement(new Departement ("Administratif"));
		
		
		TypedQuery<Departement> query = em.createQuery("select p from Departement p", Departement.class);
										
			List<Departement> dep =query.getResultList();
		
		String image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSI42mkIUTlD-825aUK4lGWZ9fhveGbrMhQ6hFScdavOLOJeXfC";

		collabService.sauvegarderCollaborateur(new Collaborateur ("Jean", "Reno", "Paris", "111111112111111", dep.get(0), image));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Marie", "Curie", "Paris", "111111113111111", dep.get(1), image));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Jules", "Verne", "Nantes", "111111111111111", dep.get(2), image));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Isaac", "Newton", "Barcelona", "111111111141111", dep.get(3), image));
		
	

	}

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {


	}

}
