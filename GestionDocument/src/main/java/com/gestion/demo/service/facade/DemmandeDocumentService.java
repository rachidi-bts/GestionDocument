package com.gestion.demo.service.facade;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.dao.DemmandeDocumentDao;
import com.itextpdf.text.DocumentException;

public interface DemmandeDocumentService {

	public int save(DemmandeDocument demmandedocument);

	public List<DemmandeDocument> findAll();

	public DemmandeDocument findById(Long id);

	public int delete(DemmandeDocument demmandedocument);

	public void deleteById(Long id);

	public void clone(DemmandeDocument demmandedocument, DemmandeDocument demmandedocumentClone);

	public DemmandeDocument clone(DemmandeDocument demmandedocument);

	public List<DemmandeDocument> clone(List<DemmandeDocument> demmandedocuments);

	public List<DemmandeDocument> findByCriteria(Long idMin, Long idMax, Date dateDemmandeMin, Date dateDemmandeMax,
			Date dateValidationMin, Date dateValidationMax);

	public List<DemmandeDocument> findByDemmandeurNom(String nom);

	public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee);

	public List<DemmandeDocument> findByDemmandeurCne(String cne);
	
	public List<DemmandeDocument> findByDemmandeurCin(String cin);

	public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle);

	public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle);

	public DemmandeDocumentDao findByDateDemmande(Date dateDemmande);
	
	public int infoDemmandeurPdf(String cin, String libelle) throws DocumentException, FileNotFoundException;
}
