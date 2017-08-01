package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

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
	
	
	
	public Collaborateur (String nom, String prenom, String dateNaissance, String adresse, String numSecSocial){
		this.adresse=adresse;
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
		this.numSecSoc=numSecSocial;
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
	
}
