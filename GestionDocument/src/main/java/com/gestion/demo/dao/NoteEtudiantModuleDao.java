package com.gestion.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.NoteEtudiantModule;


@Repository
public interface NoteEtudiantModuleDao extends JpaRepository<NoteEtudiantModule,Long> {


       public List<NoteEtudiantModule> findByNoteEtudiantId(Long id);
       public int deleteByNoteEtudiantId(Long id);
       
       public List<NoteEtudiantModule> findByResultatLibelle(String libelle);
       public  int deleteByResultatLibelle(String libelle);   
       
       public List<NoteEtudiantModule> findByResultatId(Long id);
       public int deleteByResultatId(Long id);
       
       public List<NoteEtudiantModule> findByModuleLibelle(String libelle);
       public int deleteByModuleLibelle(String libelle);    
       
       public List<NoteEtudiantModule> findByModuleId(Long id);
       public int deleteByModuleId(Long id);
       
       public NoteEtudiantModuleDao findByNote(Double note);
       public int deleteByNote(Double note);

}