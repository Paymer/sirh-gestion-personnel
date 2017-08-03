package dev.sgp.web;

import java.io.IOException;
 
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;



public class ListerCollaborateursController extends HttpServlet {

	
	// récupération du service
	
	@Inject private CollaborateurService collabService;
	@Inject private DepartementService departementService;
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {

	/** utilisation du service */
	List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
	req.setAttribute("listeCollabs", collaborateurs);

		//req.setAttribute("listeCollaborateurs", collabService.listerParNometDepartement());
		//req.setAttribute("listeDepartements", departementService.listerDepartements());
		
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);

	
	}
	

	}

