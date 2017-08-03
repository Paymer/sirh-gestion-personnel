package dev.sgp.service;




import java.util.List;

import javax.ejb.Stateless;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;



@Stateless
public class CollaborateurService {

	
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;

	
	@Inject private Event<CollabEvt> collabEvt;
	
	public List<Collaborateur> listerCollaborateurs() {

		TypedQuery<Collaborateur> query = em.createQuery("select p from Collaborateur p", Collaborateur.class);
			return query.getResultList();
	}
	
	
	public void sauvegarderCollaborateur(Collaborateur collab) {
	collabEvt.fire(new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
	em.persist(collab);

	}
	
}
