package dev.sgp.service;




import java.util.List;

import javax.ejb.Stateless;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Cotisation;
import dev.sgp.entite.CordBanc;
import dev.sgp.entite.TypeCollabEvt;
import dev.sgp.exception.ParamException;
import dev.sgp.util.ParameterChecker;



@Stateless
public class CollaborateurService {

	
	@PersistenceContext(unitName="sgp-pu") private EntityManager em;

	
	@Inject private Event<CollabEvt> collabEvt;
	
	public List<Cotisation> listerCollaborateurs() {

		TypedQuery<Cotisation> query = em.createQuery("select p from Collaborateur p", Cotisation.class);
			return query.getResultList();
	}
	
	public List<Cotisation> listerCollaborateurs(boolean actif) {

		TypedQuery<Cotisation> query = em.createQuery("select p from Collaborateur p where p.actif=:act", Cotisation.class)
				.setParameter("act", actif);

			return query.getResultList();
	}
	
	
	
	public List<Cotisation> listerCollaborateurs(int dep) {

		TypedQuery<Cotisation> query = em.createQuery("select p from Collaborateur p where p.departement=:dep", Cotisation.class)
				.setParameter("dep", dep);

			return query.getResultList();
	}
	
	
	public Cotisation getCollaborateur (String mat){
			TypedQuery<Cotisation> query = em.createQuery("select p from Collaborateur p where p.matricule=:mat", Cotisation.class)
				.setParameter("mat", mat);
			return query.getSingleResult();
	}
	
	
	
	
	
	@Inject ParameterChecker parch;
	
	public void sauvegarderCollaborateur(Cotisation collab) throws ParamException{
		
		if (!parch.checkParamEmpty(collab)){
			throw new ParamException(parch.getIncParamEmpty(collab));}
		else if (!parch.checkParamCorrect(collab)){
			throw new ParamException(parch.getIncParam(collab));}
		else{
			collabEvt.fire(new CollabEvt(collab.getDateHeureCreation(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
			em.persist(collab);}
		
	}

	
	public void modifyColl (Cotisation coll, String mat) throws ParamException{
		
		
		if (!parch.checkParamEmpty(coll)){
			throw new ParamException(parch.getIncParamEmpty(coll));}
		else if (!parch.checkParamCorrect(coll)){
			throw new ParamException(parch.getIncParam(coll));}
		else{
		
		
		
		TypedQuery<Cotisation> query = em.createQuery("select p from Collaborateur p where p.matricule=:mat", Cotisation.class)
										.setParameter("mat", mat);
		Cotisation p = query.getSingleResult();
		
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
		
	TypedQuery<Cotisation> query = em.createQuery("select p from Collaborateur p where p.matricule=:mat", Cotisation.class)
			.setParameter("mat", mat);
	Cotisation p = query.getSingleResult();

	if(p != null){

		p.setCoordonbanc(p.getCoordonbanc());

}
	
}
	

			
	
	
	
}
