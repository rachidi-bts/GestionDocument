package com.gestion.demo.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EtatDemmande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String libelle;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public EtatDemmande(long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	public EtatDemmande() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EtatDemmande [id=" + id + ", libelle=" + libelle + "]";
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
		EtatDemmande other = (EtatDemmande) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
