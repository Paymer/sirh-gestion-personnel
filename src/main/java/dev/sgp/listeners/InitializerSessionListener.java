package dev.sgp.listeners;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;


public class InitializerSessionListener implements ServletContextListener {
	
	@Inject private CollaborateurService collabService;
	@Inject private DepartementService departementService;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		String image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSI42mkIUTlD-825aUK4lGWZ9fhveGbrMhQ6hFScdavOLOJeXfC";

		collabService.sauvegarderCollaborateur(new Collaborateur ("Jean", "Reno", "Paris", "111111112111111", "Comptabilité", image));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Marie", "Curie", "Paris", "111111113111111", "Informatique", image));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Jules", "Verne", "Nantes", "111111111111111", "Ressources Humaines", image));
		collabService.sauvegarderCollaborateur(new Collaborateur ("Isaac", "Newton", "Barcelona", "111111111141111", "Administratif", image));
		
	
		departementService.sauvegarderDepartement(new Departement ("Comptabilité"));
		departementService.sauvegarderDepartement(new Departement ("Ressources Humaines"));
		departementService.sauvegarderDepartement(new Departement ("Informatique"));
		departementService.sauvegarderDepartement(new Departement ("Administratif"));
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {


	}

}
