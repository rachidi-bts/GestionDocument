package com.gestion.demo.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.Module;
import com.gestion.demo.bean.NoteEtudiant;
import com.gestion.demo.bean.NoteEtudiantModule;
import com.gestion.demo.bean.Resultat;
import com.gestion.demo.dao.NoteEtudiantModuleDao;
import com.gestion.demo.service.facade.ModuleService;
import com.gestion.demo.service.facade.NoteEtudiantModuleService;
import com.gestion.demo.service.facade.NoteEtudiantService;
import com.gestion.demo.service.facade.ResultatService;
import com.gestion.demo.service.util.SearchUtil;

@Service
public class NoteEtudiantModuleServiceImpl implements NoteEtudiantModuleService {

   @Autowired
   private NoteEtudiantModuleDao noteEtudiantModuleDao;
   
   @Autowired
    private NoteEtudiantService noteEtudiantService ;
   @Autowired
    private ResultatService resultatService ;
   @Autowired
    private ModuleService moduleService ;
@Override
public List<NoteEtudiantModule> findAll() {
	return noteEtudiantModuleDao.findAll();
}
@Override
public NoteEtudiantModule findById(Long id) {
	return noteEtudiantModuleDao.getOne(id);
}
@Override
public List<NoteEtudiantModule> findByNoteEtudiantId(Long id) {
	return noteEtudiantModuleDao.findByNoteEtudiantId(id);
}
@Override
public int deleteByNoteEtudiantId(Long id) {
	return noteEtudiantModuleDao.deleteByNoteEtudiantId(id);
}
@Override
public List<NoteEtudiantModule> findByResultatLibelle(String libelle) {
	return noteEtudiantModuleDao.findByResultatLibelle(libelle);
}
@Override
public int deleteByResultatLibelle(String libelle) {
	return noteEtudiantModuleDao.deleteByResultatLibelle(libelle);
}
@Override
public List<NoteEtudiantModule> findByResultatId(Long id) {
	return noteEtudiantModuleDao.findByResultatId(id);
}
@Override
public int deleteByResultatId(Long id) {
	return noteEtudiantModuleDao.deleteByResultatId(id);
}
@Override
public List<NoteEtudiantModule> findByModuleLibelle(String libelle) {
	return noteEtudiantModuleDao.findByModuleLibelle(libelle);
}
@Override
public int deleteByModuleLibelle(String libelle) {
	return noteEtudiantModuleDao.deleteByModuleLibelle(libelle);
}
@Override
public List<NoteEtudiantModule> findByModuleId(Long id) {
	return noteEtudiantModuleDao.findByModuleId(id);
}
@Override
public int deleteByModuleId(Long id) {
	return noteEtudiantModuleDao.deleteByModuleId(id);
}
@Override
public NoteEtudiantModuleDao findByNote(Double note) {
	return noteEtudiantModuleDao.findByNote(note);
}
@Override
public int deleteByNote(Double note) {
	return noteEtudiantModuleDao.deleteByNote(note);
}
@Override
public NoteEtudiantModule save(NoteEtudiantModule noteEtudiantModule) {
	if(noteEtudiantModule.getId()==null)
		  return null;
	  NoteEtudiantModule foundedNoteEtudiantModule = findById(noteEtudiantModule.getId()); 
	       if(foundedNoteEtudiantModule!=null)
        return null;	  
  
        if(noteEtudiantModule.getNoteEtudiant()!=null){
			   NoteEtudiant noteEtudiant = noteEtudiantService.findById(noteEtudiantModule.getNoteEtudiant().getId());
			  if(noteEtudiant == null)
			  noteEtudiantModule.setNoteEtudiant(noteEtudiantService.save(noteEtudiantModule.getNoteEtudiant()));
			  else
			  noteEtudiantModule.setNoteEtudiant(noteEtudiant);
		  }
  
        if(noteEtudiantModule.getResultat()!=null){
			    Resultat resultat = resultatService.findByLibelle(noteEtudiantModule.getResultat().getLibelle());
			  if(resultat == null)
			  noteEtudiantModule.setResultat(resultatService.save(noteEtudiantModule.getResultat()));
			  else
			  noteEtudiantModule.setResultat(resultat);
		  }
  
        if(noteEtudiantModule.getModule()!=null){
			    Module module = moduleService.findByLibelle(noteEtudiantModule.getModule().getLibelle());
			  if(module == null)
			  noteEtudiantModule.setModule(moduleService.save(noteEtudiantModule.getModule()));
			  else
			  noteEtudiantModule.setModule(module);;
		  }

  NoteEtudiantModule savedNoteEtudiantModule = noteEtudiantModuleDao.save(noteEtudiantModule);
 return savedNoteEtudiantModule;
}
@Override
public List<NoteEtudiantModule> saveAll(List<NoteEtudiantModule> noteEtudiantModules) {
	List<NoteEtudiantModule> list = new ArrayList<NoteEtudiantModule>();
	for(NoteEtudiantModule noteEtudiantModule: noteEtudiantModules){
	        list.add(save(noteEtudiantModule));	
	}
	return list;
}
@Override
public NoteEtudiantModule update(NoteEtudiantModule noteEtudiantModule) {
	if(noteEtudiantModule.getId()==null)
		  return null;
	  NoteEtudiantModule foundedNoteEtudiantModule = findById(noteEtudiantModule.getId()); 
	       if(foundedNoteEtudiantModule==null)
        return null;	  

 return  noteEtudiantModuleDao.save(foundedNoteEtudiantModule);
}
@Override
public int delete(NoteEtudiantModule noteEtudiantModule) {
	 if(noteEtudiantModule.getId()==null)
		  return -1;
	  NoteEtudiantModule foundedNoteEtudiantModule = findById(noteEtudiantModule.getId()); 
	       if(foundedNoteEtudiantModule==null)
         return -1;	  
  noteEtudiantModuleDao.delete(foundedNoteEtudiantModule);
  return 1;
}
 


	
 
}