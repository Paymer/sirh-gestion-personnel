package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "collaborateur")
public class Collaborateur {


	@Id
	@Column (name = "Matricule")
	String matricule;
	@Column (name = "nom")
	String nom;
	@Column (name = "prenom")
	String prenom;
	@Column (name = "date_naissance")
	LocalDate date_naissance;
	@Column (name = "adresse")
	String adresse;
	@Column (name = "num_sec_social")
	String numSecSoc;
	@Column (name = "email")
	String emailPro;
	@Column (name = "photo")
	String photo;
	@Column (name = "date_heure_creation")
	ZonedDateTime dateHeureCreation;
	@Column (name = "actif")
	boolean actif;
	@Column (name = "intitulePoste")
	String intitulePoste;
	
	
	@OneToOne
	@JoinColumn(name="CordBanc_id")
	CordBanc coordonbanc;

	public CordBanc getCoordonbanc() {
		return coordonbanc;
	}

	public void setCoordonbanc(CordBanc coordonbanc) {
		this.coordonbanc = coordonbanc;
	}

	@ManyToOne
	@JoinColumn(name="departement_id")
	Departement departement;
	
	
	
	
	public Collaborateur() {
		
	}

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
		this.photo = "https://s-media-cache-ak0.pinimg.com/236x/b2/97/90/b29790fc676170d2ee704140d04f1bfe--mobile-web-web-development.jpg";
	}
	


	public Collaborateur (String nom, String prenom, String adresse, String numSecSocial, Departement dep, String photo, LocalDate datenaissance){
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
		this.departement = dep;
		this.date_naissance = datenaissance;
	
		
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
