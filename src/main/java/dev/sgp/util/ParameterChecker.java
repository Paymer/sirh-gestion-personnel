package dev.sgp.util;

import dev.sgp.entite.Collaborateur;

public class ParameterChecker {

	
	
	public boolean checkParamEmpty (Collaborateur coll){
		 Boolean corr = true;
		
		if ( !(coll.getNom()).matches("^[a-zA-Z]$") || !(coll.getPrenom()).matches("^[a-zA-Z]$") || !(coll.getAdresse()).matches("^[a-zA-Z0-9._%+-]$")  || !(coll.getNumSecSoc()).matches("^[0-9]{15}$")){
			corr=false;
		}
	
		
		return corr;
	}
	
	public boolean checkParamCorrect (Collaborateur coll){
		 Boolean corr = true;
		
		if ((coll.getNom()).isEmpty() || (coll.getPrenom()).isEmpty() || (coll.getAdresse()).isEmpty() || (coll.getNumSecSoc()).isEmpty() || (coll.getDate_naissance())==null){
			corr=false;}
		
		return corr;
	}
	
	public String getIncParamEmpty (Collaborateur coll){
		String param = "";
		
		if ((coll.getNom()).isEmpty()){
			param = param + " Nom ";
		}
		else if ((coll.getPrenom()).isEmpty()){
			param = param + " Prenom ";
		}
		else if ((coll.getAdresse()).isEmpty()){
			param = param + " Adress ";
		}
		else if ((coll.getNumSecSoc()).isEmpty()){
			param = param + " NumeroSecuriteSociale ";
		}
		else if ((coll.getDate_naissance())==null){
			param = param + " DateNaissance ";
		}
		
		return param;
	}
	
	public String getIncParam (Collaborateur coll){
		String param = "";
		
		if ( !(coll.getNom()).matches("^[a-zA-Z]$")){
			param = param + " Nom ";
		}
		else if (!(coll.getPrenom()).matches("^[a-zA-Z]$")){
			param = param + " Prenom ";
		}
		else if (!(coll.getAdresse()).matches("^[a-zA-Z0-9._%+-]$")){
			param = param + " Adress ";
		}
		else if (!(coll.getNumSecSoc()).matches("^[0-9]{15}$")){
			param = param + " NumeroSecuriteSociale ";
		}
		
		
		return param;
	}
	
	
}
