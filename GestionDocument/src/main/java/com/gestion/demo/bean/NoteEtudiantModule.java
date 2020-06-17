package com.gestion.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class NoteEtudiantModule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Module module;
	private double note;
	private String ptsJury;
	@ManyToOne
	private Resultat resultat;
	@ManyToOne
	private NoteEtudiant noteEtudiant;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public String getPtsJury() {
		return ptsJury;
	}
	public void setPtsJury(String ptsJury) {
		this.ptsJury = ptsJury;
	}
	public Resultat getResultat() {
		return resultat;
	}
	public void setResultat(Resultat resultat) {
		this.resultat = resultat;
	}
	public NoteEtudiant getNoteEtudiant() {
		return noteEtudiant;
	}
	public void setNoteEtudiant(NoteEtudiant noteEtudiant) {
		this.noteEtudiant = noteEtudiant;
	}
	public NoteEtudiantModule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoteEtudiantModule(Long id, Module module, double note, String ptsJury, Resultat resultat,
			NoteEtudiant noteEtudiant) {
		super();
		this.id = id;
		this.module = module;
		this.note = note;
		this.ptsJury = ptsJury;
		this.resultat = resultat;
		this.noteEtudiant = noteEtudiant;
	}
	@Override
	public String toString() {
		return "NoteEtudiantModule [id=" + id + ", module=" + module + ", note=" + note + ", ptsJury=" + ptsJury
				+ ", resultat=" + resultat + ", noteEtudiant=" + noteEtudiant + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		NoteEtudiantModule other = (NoteEtudiantModule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
