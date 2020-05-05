package com.gestion.demo.service.facade;

import java.util.Date;
import java.util.List;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.dao.DemmandeDocumentDao;


public interface DemmandeDocumentService {

	public List<DemmandeDocument> findByDemmandeurNom(String nom);
	public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee);
	public List<DemmandeDocument> findByDemmandeurCne(String cne);
	
	public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle);
	
	public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle);
	
	public DemmandeDocumentDao findByDateDemmande(Date dateDemmande);
	
	public int deleteByEtatDemmandeLibelle (String libelle);
	
	public int save(DemmandeDocument modele);


	public List<DemmandeDocument> findAll();
	
}
