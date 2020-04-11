package com.gestion.demo.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Responsable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String login;
	private String password;
	@ManyToOne
	private Service service;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Responsable(long id, String login, String password, Service service) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.service = service;
	}
	public Responsable() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Responsable [id=" + id + ", login=" + login + ", password=" + password + ", service=" + service + "]";
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
		Responsable other = (Responsable) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
