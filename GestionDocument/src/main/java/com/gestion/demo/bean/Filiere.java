package com.gestion.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.gestion.demo.bean.TypeFiliere;

@Entity
public class Filiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	private String abrv;
	@ManyToOne
	private TypeFiliere typeFiliere ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getAbrv() {
		return abrv;
	}
	public void setAbrv(String abrv) {
		this.abrv = abrv;
	}
	
	public TypeFiliere getTypeFiliere() {
		return typeFiliere;
	}
	public void setTypeFiliere(TypeFiliere typeFiliere) {
		this.typeFiliere = typeFiliere;
	}
	
	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Filiere(Long id, String libelle, String abrv, TypeFiliere typeFiliere) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.abrv = abrv;
		this.typeFiliere = typeFiliere;
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
		Filiere other = (Filiere) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Filiere [id=" + id + ", libelle=" + libelle + ", abrv=" + abrv + ", typeFiliere=" + typeFiliere + "]";
	}
	
	
	
	
}
