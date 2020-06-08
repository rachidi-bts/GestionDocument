package com.gestion.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Demmandeur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cne;
	private String codeApogee;
	private String nom;
	private String prenom;
	private String cin;
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateNaissance;
	private String villeNaissance;
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date anneeInscription;
	@ManyToOne
	private Filiere filiere;
	private String login;
	private String password;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getCodeApogee() {
		return codeApogee;
	}
	public void setCodeApogee(String codeApogee) {
		this.codeApogee = codeApogee;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getVilleNaissance() {
		return villeNaissance;
	}
	public void setVilleNaissance(String villeNaissance) {
		this.villeNaissance = villeNaissance;
	}
	public Date getAnneeInscription() {
		return anneeInscription;
	}
	public void setAnneeInscription(Date anneeInscription) {
		this.anneeInscription = anneeInscription;
	}

	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    	
	
	
	public Demmandeur(Long id, String cne, String codeApogee, String nom, String prenom, String cin, Date dateNaissance,
			String villeNaissance, Date anneeInscription, Filiere filiere, String login, String password) {
		super();
		this.id = id;
		this.cne = cne;
		this.codeApogee = codeApogee;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.dateNaissance = dateNaissance;
		this.villeNaissance = villeNaissance;
		this.anneeInscription = anneeInscription;
		this.filiere = filiere;
		this.login = login;
		this.password = password;
	}
	public Demmandeur() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public String toString() {
		return "Demmandeur [id=" + id + ", cne=" + cne + ", codeApogee=" + codeApogee + ", nom=" + nom + ", prenom="
				+ prenom + ", cin=" + cin + ", dateNaissance=" + dateNaissance + ", villeNaissance=" + villeNaissance
				+ ", anneeInscription=" + anneeInscription + ", filiere=" + filiere + ", login=" + login + ", password="
				+ password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Demmandeur other = (Demmandeur) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
