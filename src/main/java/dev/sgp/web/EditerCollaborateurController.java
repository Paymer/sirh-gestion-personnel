package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		// récupère la valeur d'un paramètre dont le nom est avecPhoto
		String matricule = req.getParameter("matricule");
		if (matricule == null){
			resp.setStatus(400);
			resp.getWriter().write("Un matricule est attendu");
					
		}
		else {
			resp.setStatus(200);
			resp.getWriter().write("Matricule: " + matricule);
		}
				
				
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		String titre = req.getParameter("titre");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		
		if (matricule == null || titre == null || nom == null || prenom == null){
			resp.setStatus(400);
			resp.getWriter().write("Les parametres suivants son incorrects:" );	
			if (matricule == null){resp.getWriter().write(" matricule " );}
			else if (titre == null){resp.getWriter().write(" titre " );}
			else if (nom == null){resp.getWriter().write(" nom " );}
			else {resp.getWriter().write(" prenom " );}
		}
		
		
		else {
			resp.setStatus(200);
			resp.getWriter().write("Creation d'un collaborateur avec les informations suivantes: matricule=" + matricule+" ,titre="+titre+",nom="+nom+",pernom="+prenom);
		}
		
	}
	





}


