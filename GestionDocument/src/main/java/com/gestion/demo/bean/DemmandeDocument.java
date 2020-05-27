package com.gestion.demo.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DemmandeDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Demmandeur demmandeur;
	@ManyToOne
	private TypeDocument typeDocument;
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateDemmande ;
	@ManyToOne 
	private EtatDemmande etatDemmande;
	@Temporal(value = TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date dateValidation ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Demmandeur getDemmandeur() {
		return demmandeur;
	}
	public void setDemmandeur(Demmandeur demmandeur) {
		this.demmandeur = demmandeur;
	}
	
	public TypeDocument getTypeDocument() {
		return typeDocument;
	}
	public void setTypeDocument(TypeDocument typeDocument) {
		this.typeDocument = typeDocument;
	}
	
	public Date getDateDemmande() {
		return dateDemmande;
	}
	public void setDateDemmande(Date dateDemmande) {
		this.dateDemmande = dateDemmande;
	}
	
	public EtatDemmande getEtatDemmande() {
		return etatDemmande;
	}
	public void setEtatDemmande(EtatDemmande etatDemmande) {
		this.etatDemmande = etatDemmande;
	}
	
	public Date getDateValidation() {
		return dateValidation;
	}
	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}
	public DemmandeDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		public DemmandeDocument(Long id, Demmandeur demmandeur, TypeDocument typeDocument, Date dateDemmande,
			EtatDemmande etatDemmande, Date dateValidation) {
		super();
		this.id = id;
		this.demmandeur = demmandeur;
		this.typeDocument = typeDocument;
		this.dateDemmande = dateDemmande;
		this.etatDemmande = etatDemmande;
		this.dateValidation = dateValidation;
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
		DemmandeDocument other = (DemmandeDocument) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DemmandeDocument [id=" + id + ", demmandeur=" + demmandeur + ", typeDocument=" + typeDocument
				+ ", dateDemmande=" + dateDemmande + ", etatDemmande=" + etatDemmande + ", dateValidation="
				+ dateValidation + "]";
	}
	
	
}
