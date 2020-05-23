package com.gestion.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.bean.EtatDemmande;
import com.gestion.demo.bean.TypeDocument;

@Repository
public interface DemmandeDocumentDao extends JpaRepository<DemmandeDocument, Long> {

	public DemmandeDocument findByDemmandeur(Demmandeur demmandeur);

	public DemmandeDocument findByTypeDocument(TypeDocument typeDocument);

	public DemmandeDocument findByEtatDemmande(EtatDemmande etatDemmande);

	public List<DemmandeDocument> findByDemmandeurNom(String nom);

	public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee);

	public List<DemmandeDocument> findByDemmandeurCne(String cne);
	
	public List<DemmandeDocument> findByDemmandeurCin(String cin);

	public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle);

	public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle);

	public DemmandeDocumentDao findByDateDemmande(Date dateDemmande);

	public int deleteByDemmandeur(Demmandeur demmandeur);

	public int deleteByTypeDocument(TypeDocument typeDocument);

	public int deleteByEtatDemmande(EtatDemmande etatDemmande);

}
