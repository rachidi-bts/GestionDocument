package com.gestion.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle ;
	@OneToMany(mappedBy = "serviceDocument")
	private ServiceDocument serviceDocument;
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
	
	public ServiceDocument getServiceDocument() {
		return serviceDocument;
	}
	public void setServiceDocument(ServiceDocument serviceDocument) {
		this.serviceDocument = serviceDocument;
	}

	public TypeDocument(Long id, String libelle, ServiceDocument serviceDocument) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.serviceDocument = serviceDocument;
	}
	public TypeDocument() {
		super();
		// TODO Auto-generated constructor stub
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
		TypeDocument other = (TypeDocument) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
