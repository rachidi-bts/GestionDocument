package com.gestion.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.NoteEtudiant;

import java.util.List;



@Repository
public interface NoteEtudiantDao extends JpaRepository<NoteEtudiant,Long> {


      public List<NoteEtudiant> findByResultatFinalLibelle(String libelle);
      public  int deleteByResultatFinalLibelle(String libelle);    
      
      public List<NoteEtudiant> findByResultatFinalId(Long id);
      public  int deleteByResultatFinalId(Long id);
      
      public List<NoteEtudiant> findByDemmandeurLogin(String login);      
      public int deleteByDemmandeurLogin(String login);  
      
      public List<NoteEtudiant> findByDemmandeurCne(String cne);      
      public int deleteByDemmandeurCne(String cne);  
      
      public List<NoteEtudiant> findByDemmandeurId(Long id);      
      public  int deleteByDemmandeurId(Long id);
      
      public NoteEtudiantDao findByNoteFinale(Double noteFinale);
      public  int deleteByNoteFinale(Double noteFinale);
}