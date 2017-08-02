package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Statistique;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

public class WebServiceController extends HttpServlet {

	
	// récupération du service
	private VisiteWebService webService = Constantes.WEB_SERVICE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {

	// utilisation du service
	List<VisiteWeb> visits = webService.listerVisiteWeb();
	
	
	ArrayList<Statistique> st =new ArrayList<>();
	ArrayList<String> paths =new ArrayList<>();
	
	
	for (VisiteWeb vi : visits) {   
		if (!paths.contains(vi.getChemin())){
		paths.add(vi.getChemin());
		}
        }
	
	
	for (String p : paths) {   
		
		LongSummaryStatistics stats = visits.stream().filter( visite -> visite.getChemin().equals(p)).collect(Collectors.summarizingLong(VisiteWeb::getTempsExecution));
		Statistique es = new Statistique ();
		es.setChemin(p);
		es.setMax(stats.getMax());
		es.setMin(stats.getMin());
		es.setMoyenne(stats.getAverage());
		es.setNomVisites((int)stats.getCount());
		
		st.add(es);
		
        }
	
	
	req.setAttribute("statis", st);
	req.setAttribute("listeVisits", visits);
	
	
	
	req.getRequestDispatcher("/WEB-INF/views/collab/Statistiques.jsp").forward(req, resp);
	
		}
	
	
	

			
		
		
	
}
