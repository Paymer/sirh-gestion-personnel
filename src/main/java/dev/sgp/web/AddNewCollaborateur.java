package dev.sgp.web;

import java.io.IOException;
import java.time.ZonedDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class AddNewCollaborateur extends HttpServlet {

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/collab/AddNewCollaborateur.jsp");
		dispatcher.forward(req, resp);

		
			
		}
	
				
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nom = req.getParameter("Nom");
		String prenom = req.getParameter("Prenom");
		String dateNaissance = req.getParameter("DateNaissance");
		String adresse = req.getParameter("Adresse");
		String numSecSoc = req.getParameter("NumSecSoc");
		
		
		
		Collaborateur col = new Collaborateur(nom, prenom, dateNaissance, adresse, numSecSoc );
		
		col.setActif(true);
		col.setDateHeureCreation(ZonedDateTime.now());
		col.setEmailPro(nom+"."+prenom+"@societe.com");
		col.setMatricule(prenom.substring(0, 3));
		col.setPhoto("Github.png");
		
		Constantes.COLLAB_SERVICE.sauvegarderCollaborateur(col);
		Constantes.COLLAB_SERVICE.listerCollaborateurs();
		
		
		
		
	}

	
	
}
