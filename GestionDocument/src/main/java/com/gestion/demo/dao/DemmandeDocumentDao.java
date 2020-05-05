package com.gestion.demo.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.DemmandeDocument;

@Repository
public interface DemmandeDocumentDao extends JpaRepository<DemmandeDocument, Long> {

	public List<DemmandeDocument> findByDemmandeurNom(String nom);
	public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee);
	public List<DemmandeDocument> findByDemmandeurCne(String cne);
	
	public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle);
	
	public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle);
	
	public DemmandeDocumentDao findByDateDemmande(Date dateDemmande);
	
	public int deleteByEtatDemmandeLibelle (String libelle);
   

	
}
