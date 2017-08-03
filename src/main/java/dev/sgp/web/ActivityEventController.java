package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.CollabEvt;
import dev.sgp.service.ActiviteService;


public class ActivityEventController extends HttpServlet {

	@Inject private ActiviteService event;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	List<CollabEvt> ev = event.listerActivitiesCollab();
	req.setAttribute("event", ev);
	req.getRequestDispatcher("/WEB-INF/views/collab/Event.jsp").forward(req, resp);
	
	}
}
