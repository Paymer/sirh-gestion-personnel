package dev.sgp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class InitializerSessionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		CollaborateurService ser = Constantes.COLLAB_SERVICE;
		ser.sauvegarderCollaborateur(new Collaborateur ("Jean", "Reno", "Paris", "111111112111111"));
		ser.sauvegarderCollaborateur(new Collaborateur ("Marie", "Curie", "Paris", "111111113111111"));
		ser.sauvegarderCollaborateur(new Collaborateur ("Jules", "Verne", "Nantes", "111111111111111"));
		
		
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {


	}

}
