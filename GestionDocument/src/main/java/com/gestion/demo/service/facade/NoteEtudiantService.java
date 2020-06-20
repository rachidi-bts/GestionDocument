package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.NoteEtudiant;
import com.gestion.demo.dao.NoteEtudiantDao;

public interface NoteEtudiantService {

        
    public List<NoteEtudiant> findAll();
	
    public NoteEtudiant findById(Long id);
	
    public List<NoteEtudiant> findByResultatFinalLibelle(String libelle);
    public int deleteByResultatFinalLibelle(String libelle);       
			
    public List<NoteEtudiant> findByResultatFinalId(Long id);
    public int deleteByResultatFinalId(Long id);
			 
    public List<NoteEtudiant> findByDemmandeurLogin(String login);
    public int deleteByDemmandeurLogin(String login);  
    
    public List<NoteEtudiant> findByDemmandeurCne(String cne);      
    public int deleteByDemmandeurCne(String cne);
			
    public List<NoteEtudiant> findByDemmandeurId(Long id);
    public int deleteByDemmandeurId(Long id);
    
    public NoteEtudiantDao findByNoteFinale(Double noteFinale);
    public  int deleteByNoteFinale(Double noteFinale);
			 
    public NoteEtudiant save(NoteEtudiant noteEtudiant);

    public List<NoteEtudiant> saveAll(List<NoteEtudiant> noteEtudiants);
    
     /**
     * update NoteEtudiant in database
     * @param noteEtudiant - NoteEtudiant to be updated
     * @return the updated NoteEtudiant, If the NoteEtudiant can't be updated return null.
     */
    public NoteEtudiant update(NoteEtudiant noteEtudiant);
    
    public int delete(NoteEtudiant noteEtudiant);
    
}