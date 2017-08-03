package dev.sgp.web;


import java.io.IOException;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;

import dev.sgp.service.CollaborateurService;


public class AddNewCollaborateur extends HttpServlet {

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/collab/AddNewCollaborateur.jsp");
		dispatcher.forward(req, resp);

		
			
		}
	
	
	@EJB private CollaborateurService collabService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nom = req.getParameter("Nom");
		String prenom = req.getParameter("Prenom");
		LocalDate dateNaissance = LocalDate.parse(req.getParameter("DateNaissance"));
		String adresse = req.getParameter("Adresse");
		String numSecSoc = req.getParameter("NumSecSoc");
		
		
		
		Collaborateur col = new Collaborateur(nom, prenom, dateNaissance, adresse, numSecSoc );
		
		
		
		
		
		
		collabService.sauvegarderCollaborateur(col);
		
		
	
		resp.sendRedirect("/sgp/collaborateurs/lister");
		
		           
		
		
		
		
	}

	
	
}
