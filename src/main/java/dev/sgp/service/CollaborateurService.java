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
import dev.sgp.entite.CordBanc;
import dev.sgp.entite.TypeCollabEvt;
import dev.sgp.exception.ParamException;
import dev.sgp.util.ParameterChecker;



@Stateless
public class CollaborateurService {

	
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;

	
	@Inject private Event<CollabEvt> collabEvt;
	
	public List<Collaborateur> listerCollaborateurs() {

		TypedQuery<Collaborateur> query = em.createQuery("select p from Collaborateur p", Collaborateur.class);
			return query.getResultList();
	}
	
	public List<Collaborateur> listerCollaborateurs(boolean actif) {

		TypedQuery<Collaborateur> query = em.createQuery("select p from Collaborateur p where p.actif=:act", Collaborateur.class)
				.setParameter("act", actif);

			return query.getResultList();
	}
	
	
	
	public List<Collaborateur> listerCollaborateurs(int dep) {

		TypedQuery<Collaborateur> query = em.createQuery("select p from Collaborateur p where p.departement=:dep", Collaborateur.class)
				.setParameter("dep", dep);

			return query.getResultList();
	}
	
	
	public Collaborateur getCollaborateur (String mat){
			TypedQuery<Collaborateur> query = em.createQuery("select p from Collaborateur p where p.matricule=:mat", Collaborateur.class)
				.setParameter("mat", mat);
			return query.getSingleResult();
	}
	
	
	
	
	
	@Inject ParameterChecker parch;
	
	public void sauvegarderCollaborateur(Collaborateur collab) throws ParamException{
		
		if (!parch.checkParamEmpty(collab)){
			throw new ParamException(parch.getIncParamEmpty(collab));}
		else if (!parch.checkParamCorrect(collab)){
			throw new ParamException(parch.getIncParam(collab));}
		else{
			collabEvt.fire(new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
			em.persist(collab);}
		
	}

	
	public void modifyColl (Collaborateur coll, String mat) throws ParamException{
		
		
		if (!parch.checkParamEmpty(coll)){
			throw new ParamException(parch.getIncParamEmpty(coll));}
		else if (!parch.checkParamCorrect(coll)){
			throw new ParamException(parch.getIncParam(coll));}
		else{
		
		
		
		TypedQuery<Collaborateur> query = em.createQuery("select p from Collaborateur p where p.matricule=:mat", Collaborateur.class)
										.setParameter("mat", mat);
		Collaborateur p = query.getSingleResult();
		
		if(p != null){
			p.setMatricule(coll.getMatricule());
			p.setActif(coll.isActif());
			p.setNom(coll.getNom());
			p.setPrenom(coll.getPrenom());
			p.setEmailPro(coll.getEmailPro());
			p.setAdresse(coll.getAdresse());
			p.setDate_naissance(coll.getDate_naissance());
			p.setNumSecSoc(coll.getNumSecSoc());
			p.setPhoto(coll.getPhoto());
			p.setDepartement(coll.getDepartement());
			p.setIntitulePoste(coll.getIntitulePoste());
	

			}}
		
	}
	
	
public void modifyCordBanc (CordBanc banc, String mat){
		
	TypedQuery<Collaborateur> query = em.createQuery("select p from Collaborateur p where p.matricule=:mat", Collaborateur.class)
			.setParameter("mat", mat);
	Collaborateur p = query.getSingleResult();

	if(p != null){

		p.setCoordonbanc(p.getCoordonbanc());

}
	
}
	

			
	
	
	
}
