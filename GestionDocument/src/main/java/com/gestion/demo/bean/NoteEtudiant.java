package com.gestion.demo.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class NoteEtudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private Double noteFinale;
	@ManyToOne
	private Resultat resultatFinal;
	@ManyToOne
    private Demmandeur demmandeur;
	@OneToMany(mappedBy = "noteEtudiant")
	private List<NoteEtudiantModule> noteEtudiantModules;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getNoteFinale() {
		return noteFinale;
	}
	public void setNoteFinale(Double noteFinale) {
		this.noteFinale = noteFinale;
	}
	public Resultat getResultatFinal() {
		return resultatFinal;
	}
	public void setResultatFinal(Resultat resultatFinal) {
		this.resultatFinal = resultatFinal;
	}
	public Demmandeur getDemmandeur() {
		return demmandeur;
	}
	public void setDemmandeur(Demmandeur demmandeur) {
		this.demmandeur = demmandeur;
	}
	public List<NoteEtudiantModule> getNoteEtudiantModules() {
		return noteEtudiantModules;
	}
	public void setNoteEtudiantModules(List<NoteEtudiantModule> noteEtudiantModules) {
		this.noteEtudiantModules = noteEtudiantModules;
	}
	public NoteEtudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoteEtudiant(Long id, Double noteFinale, Resultat resultatFinal, Demmandeur demmandeur,
			List<NoteEtudiantModule> noteEtudiantModules) {
		super();
		this.id = id;
		this.noteFinale = noteFinale;
		this.resultatFinal = resultatFinal;
		this.demmandeur = demmandeur;
		this.noteEtudiantModules = noteEtudiantModules;
	}
	@Override
	public String toString() {
		return "NoteEtudiant [id=" + id + ", noteFinale=" + noteFinale + ", resultatFinal=" + resultatFinal
				+ ", demmandeur=" + demmandeur + ", noteEtudiantModules=" + noteEtudiantModules + "]";
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
		NoteEtudiant other = (NoteEtudiant) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
