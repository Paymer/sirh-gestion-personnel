package dev.sgp.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.CordBanc;
import dev.sgp.exception.ParamException;
import dev.sgp.service.CollaborateurService;


@Path("/collaborateurs")
public class CollaborateurRessource {

@Inject CollaborateurService colSer;
	

	
/**
 * /api/collaborateurs?departementId=12
 * /api/collaborateurs
 * @return
 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> listAll(@QueryParam("departementId") Integer departementId){
		
		if (departementId==null){
			return colSer.listerCollaborateurs();
		} else{
			return colSer.listerCollaborateurs(departementId);
		}
		
	}


	// /clients/12 vs /clients?id=12
	@Path("/{Matricule}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collaborateur listOne (@PathParam("Matricule") String mat){
		
		return colSer.getCollaborateur(mat);
		
	}
	@Path("/{Matricule}")
	@PUT
	@Consumes (MediaType.APPLICATION_JSON)
	public void modifyOne (@PathParam("Matricule") String mat, Collaborateur coll){
		
		try {
			colSer.modifyColl(coll, mat);
		} catch (ParamException e) {
			
		}
		}
	
	
		
		@Path("/{Matricule}/banque")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public CordBanc list (@PathParam("Matricule") String mat){
			
			return (colSer.getCollaborateur(mat)).getCoordonbanc();
			
			
		}
		
		
		@Path("/{Matricule}/banque")
		@PUT
		@Consumes (MediaType.APPLICATION_JSON)
		public void modify (@PathParam("Matricule") String mat, CordBanc banc){
			colSer.modifyCordBanc(banc, mat);
			
			}
		

}
