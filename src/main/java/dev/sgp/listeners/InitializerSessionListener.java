package dev.sgp.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartmentService;
import dev.sgp.util.Constantes;

public class InitializerSessionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		CollaborateurService ser = Constantes.COLLAB_SERVICE;
		ser.sauvegarderCollaborateur(new Collaborateur ("Jean", "Reno", "Paris", "111111112111111", "Comptabilité", "https://git-for-windows.github.io/img/gwindows_logo.png"));
		ser.sauvegarderCollaborateur(new Collaborateur ("Marie", "Curie", "Paris", "111111113111111", "Informatique", "https://git-for-windows.github.io/img/gwindows_logo.png"));
		ser.sauvegarderCollaborateur(new Collaborateur ("Jules", "Verne", "Nantes", "111111111111111", "Ressources Humaines", "https://git-for-windows.github.io/img/gwindows_logo.png"));
		ser.sauvegarderCollaborateur(new Collaborateur ("Isaac", "Newton", "Barcelona", "111111111141111", "Administratif", "https://git-for-windows.github.io/img/gwindows_logo.png"));
		
		DepartmentService deps = Constantes.DEP_SERVICE;
		deps.sauvegarderDepartement(new Departement ("Comptabilité"));
		deps.sauvegarderDepartement(new Departement ("Ressources Humaines"));
		deps.sauvegarderDepartement(new Departement ("Informatique"));
		deps.sauvegarderDepartement(new Departement ("Administratif"));
	}

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {


	}

}
