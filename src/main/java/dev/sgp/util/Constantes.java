package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.VisiteWebService;


public interface Constantes {

	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	VisiteWebService WEB_SERVICE = new VisiteWebService();
	DepartementService DEP_SERVICE = new DepartementService();

	
}
