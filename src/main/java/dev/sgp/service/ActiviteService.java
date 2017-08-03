package dev.sgp.service;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import dev.sgp.entite.CollabEvt;

@ApplicationScoped
public class ActiviteService {

	ArrayList<CollabEvt> event = new ArrayList<>();
	
	public void recevoirEvenementCollab(@Observes CollabEvt evt){
		event.add(evt);
		
	}
	
	public ArrayList<CollabEvt> listerActivitiesCollab(){
		return event;
	}
}
