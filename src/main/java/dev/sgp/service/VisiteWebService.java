package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;


import dev.sgp.entite.VisiteWeb;

public class VisiteWebService {

	
	List<VisiteWeb> listeVisiteWeb = new ArrayList<>();
	public List<VisiteWeb> listerVisiteWeb() {
	return listeVisiteWeb;
	}
	
	
	public void sauvegarderVisite(VisiteWeb vis) {
	listeVisiteWeb.add(vis);}
	
}
