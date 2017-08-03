package dev.sgp.service;



import java.util.ArrayList;
import java.util.List;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;


@ApplicationScoped
public class CollaborateurService {

	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	@Inject private Event<CollabEvt> collabEvt;
	
	public List<Collaborateur> listerCollaborateurs() {
	return listeCollaborateurs;
	}
	
	
	public void sauvegarderCollaborateur(Collaborateur collab) {
	collabEvt.fire(new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
	listeCollaborateurs.add(collab);
	
	}
	
}
