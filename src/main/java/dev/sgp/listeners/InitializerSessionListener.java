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
		
		

		collabService.sauvegarderCollaborateur(new Collaborateur ("Jean", "Reno", "Paris", "111111112111111", dep.get(0), "https://d3gxp3iknbs7bs.cloudfront.net/media/618/f66b289109b0b2d7a784c12a15ade56e657ddaaa.jpeg"));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Marie", "Curie", "Paris", "111111113111111", dep.get(1), "https://pbs.twimg.com/profile_images/593061696039706627/uzIQ4lJF.png"));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Jules", "Verne", "Nantes", "111111111111111", dep.get(2), "https://s-media-cache-ak0.pinimg.com/236x/67/44/bf/6744bfe66e1edee2e91b873ba9c159cd--the-bear-bears.jpg"));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Isaac", "Newton", "Barcelona", "111111111141111", dep.get(3), "https://i0.wp.com/govfresh.com/wp-content/uploads/2013/09/governmentbureaucat.png?fit=400%2C400&ssl=1"));
		collabService.sauvegarderCollaborateur(new Collaborateur ("George", "Clooney", "New York", "111111111145111", dep.get(3), "https://cpmech.com/presentations/images/Octocat.png"));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Jason", "Statham", "London", "111111112111111", dep.get(0), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCyoZdsdYzFR3Mh0aVNT7tWVo8P_6E2LUIgTM0GD_8gpwYqq7SdA"));

	}

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {


	}

}
