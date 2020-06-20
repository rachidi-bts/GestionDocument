package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.NoteEtudiantModule;
import com.gestion.demo.dao.NoteEtudiantModuleDao;

public interface NoteEtudiantModuleService {

      
	public List<NoteEtudiantModule> findAll();
	   
	public NoteEtudiantModule findById(Long id);
	
	public List<NoteEtudiantModule> findByNoteEtudiantId(Long id);
	public int deleteByNoteEtudiantId(Long id);
			 
	public List<NoteEtudiantModule> findByResultatLibelle(String libelle);
	public int deleteByResultatLibelle(String libelle);       
			
	public List<NoteEtudiantModule> findByResultatId(Long id);
	public int deleteByResultatId(Long id);
			 
	public List<NoteEtudiantModule> findByModuleLibelle(String libelle);
	public int deleteByModuleLibelle(String libelle);       
			
	public List<NoteEtudiantModule> findByModuleId(Long id);
	public int deleteByModuleId(Long id);
			 
	public NoteEtudiantModuleDao findByNote(Double note);
    public int deleteByNote(Double note);
    
	public NoteEtudiantModule save(NoteEtudiantModule noteEtudiantModule);

	
	public List<NoteEtudiantModule> saveAll(List<NoteEtudiantModule> noteEtudiantModules);
    
     /**
     * update NoteEtudiantModule in database
     * @param noteEtudiantModule - NoteEtudiantModule to be updated
     * @return the updated NoteEtudiantModule, If the NoteEtudiantModule can't be updated return null.
     */
	public NoteEtudiantModule update(NoteEtudiantModule noteEtudiantModule);
    
	public int delete(NoteEtudiantModule noteEtudiantModule);
  
}