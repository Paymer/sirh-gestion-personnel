package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class Collaborateur {

	String matricule;
	String nom;
	String prenom;
	LocalDate date_naissance;
	String adresse;
	String numSecSoc;
	String emailPro;
	String photo;
	ZonedDateTime dateHeureCreation;
	boolean actif;
	String intitulePoste;
	Departement departement;
	
	
	
	
	public Collaborateur (String nom, String prenom, LocalDate dateNaissance, String adresse, String numSecSocial){
		ResourceBundle applicationBundle = ResourceBundle.getBundle("application");
		this.adresse=adresse;
		this.nom=nom;
		this.date_naissance = dateNaissance;
		this.prenom=prenom;
		this.numSecSoc=numSecSocial;
		this.matricule = prenom.substring(0, 3);
		this.dateHeureCreation = ZonedDateTime.now();
		this.emailPro = nom+"."+prenom+"@"+applicationBundle.getString("suffixe");
		this.actif = true;
		this.photo = "Github.png";
	}
	
	public Collaborateur (String nom, String prenom, String adresse, String numSecSocial){
		ResourceBundle applicationBundle = ResourceBundle.getBundle("application");
		this.adresse=adresse;
		this.nom=nom;
		this.prenom=prenom;
		this.numSecSoc=numSecSocial;
		this.actif = true;
		this.dateHeureCreation = ZonedDateTime.now();
		this.emailPro = nom+"."+prenom+"@"+applicationBundle.getString("suffixe");
		this.matricule = prenom.substring(0, 3);
		this.photo = "Github.png";
		
	}
	


	public Collaborateur (String nom, String prenom, String adresse, String numSecSocial, String dep, String photo){
		ResourceBundle applicationBundle = ResourceBundle.getBundle("application");
		this.adresse=adresse;
		this.nom=nom;
		this.prenom=prenom;
		this.numSecSoc=numSecSocial;
		this.actif = true;
		this.dateHeureCreation = ZonedDateTime.now();
		this.emailPro = nom+"."+prenom+"@"+applicationBundle.getString("suffixe");
		this.matricule = prenom.substring(0, 3);
		this.photo = photo;
		this.departement = new Departement(dep);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(LocalDate date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumSecSoc() {
		return numSecSoc;
	}
	public void setNumSecSoc(String numSecSoc) {
		this.numSecSoc = numSecSoc;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	
	public String getIntitulePoste() {
		return intitulePoste;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
}
