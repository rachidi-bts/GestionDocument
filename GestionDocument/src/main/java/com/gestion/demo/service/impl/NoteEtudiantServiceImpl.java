package com.gestion.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.bean.NoteEtudiant;
import com.gestion.demo.bean.Resultat;
import com.gestion.demo.dao.NoteEtudiantDao;
import com.gestion.demo.service.facade.DemmandeurService;
import com.gestion.demo.service.facade.NoteEtudiantModuleService;
import com.gestion.demo.service.facade.NoteEtudiantService;
import com.gestion.demo.service.facade.ResultatService;
import com.gestion.demo.service.util.SearchUtil;

@Service
public class NoteEtudiantServiceImpl implements NoteEtudiantService {

   @Autowired
   private NoteEtudiantDao noteEtudiantDao;
   
   @Autowired
    private ResultatService resultatFinalService ;
   @Autowired
    private DemmandeurService demmandeurService ;
  

	@Override
	public List<NoteEtudiant> findAll(){
		return noteEtudiantDao.findAll();
	}	
	@Override
	public List<NoteEtudiant> findByResultatFinalLibelle(String libelle){
		return noteEtudiantDao.findByResultatFinalLibelle(libelle);
	}
	@Override
    public int deleteByResultatFinalLibelle(String libelle){
		return noteEtudiantDao.deleteByResultatFinalLibelle(libelle);
	}
	
     @Override
    public List<NoteEtudiant> findByResultatFinalId(Long id){
		return noteEtudiantDao.findByResultatFinalId(id);

	}
	   @Override
    public int deleteByResultatFinalId(Long id){
		return noteEtudiantDao.deleteByResultatFinalId(id);

	}
     		
	@Override
	public List<NoteEtudiant> findByDemmandeurLogin(String login){
		return noteEtudiantDao.findByDemmandeurLogin(login);
	}
	@Override
    public int deleteByDemmandeurLogin(String login){
		return noteEtudiantDao.deleteByDemmandeurLogin(login);
	}
	
     @Override
    public List<NoteEtudiant> findByDemmandeurId(Long id){
		return noteEtudiantDao.findByDemmandeurId(id);

	}
	   @Override
    public int deleteByDemmandeurId(Long id){
		return noteEtudiantDao.deleteByDemmandeurId(id);

	}
     		

	@Override
	public NoteEtudiant findById(Long id){
		return noteEtudiantDao.getOne(id);
	}

	@Override	
	public NoteEtudiant save (NoteEtudiant noteEtudiant){
		 if(noteEtudiant.getId()==null)
			  return null;
		  NoteEtudiant foundedNoteEtudiant = findById(noteEtudiant.getId()); 
		       if(foundedNoteEtudiant!=null)
	          return null;	  
	    
	          if(noteEtudiant.getResultatFinal()!=null){
				    Resultat resultat = resultatFinalService.findByLibelle(noteEtudiant.getResultatFinal().getLibelle());
				  if(resultat == null)
				  noteEtudiant.setResultatFinal(resultatFinalService.save(noteEtudiant.getResultatFinal()));
				  else
				  noteEtudiant.setResultatFinal(resultat);
			  }
	    
	          if(noteEtudiant.getDemmandeur()!=null){
				    Demmandeur demmandeur = demmandeurService.findByCne(noteEtudiant.getDemmandeur().getCne());
				  if(demmandeur == null)
				  noteEtudiant.setDemmandeur(demmandeurService.save(noteEtudiant.getDemmandeur()));
				  else
				  noteEtudiant.setDemmandeur(demmandeur);
			  }

	    NoteEtudiant savedNoteEtudiant = noteEtudiantDao.save(noteEtudiant);
	   return savedNoteEtudiant;
	}

    @Override
    public List<NoteEtudiant> saveAll(List<NoteEtudiant> noteEtudiants){
		List<NoteEtudiant> list = new ArrayList<NoteEtudiant>();
		for(NoteEtudiant noteEtudiant: noteEtudiants){
		        list.add(save(noteEtudiant));	
		}
		return list;
	}


   @Override
   public NoteEtudiant update(NoteEtudiant noteEtudiant){
     
		 if(noteEtudiant.getId()==null)
			  return null;
		  NoteEtudiant foundedNoteEtudiant = findById(noteEtudiant.getId()); 
		       if(foundedNoteEtudiant==null)
	          return null;	  
	 
	   return  noteEtudiantDao.save(foundedNoteEtudiant);
     
     }
    
	@Override
	public int delete(NoteEtudiant noteEtudiant){

		 if(noteEtudiant.getId()==null)
			  return -1;
		  NoteEtudiant foundedNoteEtudiant = findById(noteEtudiant.getId()); 
		       if(foundedNoteEtudiant==null)
	          return -1;	  
	   noteEtudiantDao.delete(foundedNoteEtudiant);
	   return 1;
	}
	@Override
	public List<NoteEtudiant> findByDemmandeurCne(String cne) {
		return noteEtudiantDao.findByDemmandeurCne(cne);
	}
	@Override
	public int deleteByDemmandeurCne(String cne) {
		return noteEtudiantDao.deleteByDemmandeurCne(cne);
	}
	@Override
	public NoteEtudiantDao findByNoteFinale(Double noteFinale) {
		return noteEtudiantDao.findByNoteFinale(noteFinale);
	}
	@Override
	public int deleteByNoteFinale(Double noteFinale) {
		return noteEtudiantDao.deleteByNoteFinale(noteFinale);
	}
	
	
  
 
}