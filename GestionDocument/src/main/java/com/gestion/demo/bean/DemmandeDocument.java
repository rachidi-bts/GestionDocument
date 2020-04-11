package com.gestion.demo.bean;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DemmandeDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date dateDemmande ;
	private Date dateValidation ;
	@OneToOne
	private EtatDemmande etatDemmande;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateDemmande() {
		return dateDemmande;
	}
	public void setDateDemmande(Date dateDemmande) {
		this.dateDemmande = dateDemmande;
	}
	public Date getDateValidation() {
		return dateValidation;
	}
	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}
	public EtatDemmande getEtatDemmande() {
		return etatDemmande;
	}
	public void setEtatDemmande(EtatDemmande etatDemmande) {
		this.etatDemmande = etatDemmande;
	}
	public DemmandeDocument(long id, Date dateDemmande, Date dateValidation, EtatDemmande etatDemmande) {
		super();
		this.id = id;
		this.dateDemmande = dateDemmande;
		this.dateValidation = dateValidation;
		this.etatDemmande = etatDemmande;
	}
	public DemmandeDocument() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DemmandeDocument [id=" + id + ", dateDemmande=" + dateDemmande + ", dateValidation=" + dateValidation
				+ ", etatDemmande=" + etatDemmande + "]";
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
	
}
