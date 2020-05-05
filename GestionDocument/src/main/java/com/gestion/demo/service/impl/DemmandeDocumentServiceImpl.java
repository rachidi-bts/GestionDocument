package com.gestion.demo.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.dao.DemmandeDocumentDao;
import com.gestion.demo.service.facade.DemmandeDocumentService;

@Service
public class DemmandeDocumentServiceImpl implements DemmandeDocumentService{
	
	private DemmandeDocumentDao demmandeDocumentDao;

	@Override
	public List<DemmandeDocument> findByDemmandeurNom(String nom) {
		return demmandeDocumentDao.findByDemmandeurNom(nom);
	}


	@Override
	public List<DemmandeDocument> findByDemmandeurCodeApogee(String codeApogee) {
		return demmandeDocumentDao.findByDemmandeurCodeApogee(codeApogee);
	}

	@Override
	public List<DemmandeDocument> findByDemmandeurCne(String cne) {
		return demmandeDocumentDao.findByDemmandeurCne(cne);
	}

	@Override
	public List<DemmandeDocument> findByTypeDocumentLibelle(String libelle) {
		return demmandeDocumentDao.findByTypeDocumentLibelle(libelle);
	}

	@Override
	public List<DemmandeDocument> findByEtatDemmandeLibelle(String libelle) {
		return demmandeDocumentDao.findByEtatDemmandeLibelle(libelle);
	}

	@Override
	public DemmandeDocumentDao findByDateDemmande(Date dateDemmande) {
		return demmandeDocumentDao.findByDateDemmande(dateDemmande);
	}

	@Override
	@Transactional
	public int deleteByEtatDemmandeLibelle(String libelle) {
		List<DemmandeDocument> demmandeDocuments= demmandeDocumentDao.findByEtatDemmandeLibelle(libelle);
		if (demmandeDocuments == null) {
			return -1;
		}else {
			for (DemmandeDocument demmandeDocument : demmandeDocuments) {
				demmandeDocumentDao.delete(demmandeDocument);	
			}
			return 1;
			
		}
	}

	@Override
	public int save(DemmandeDocument demmandeDocument) {
		List<DemmandeDocument> foundedDemmandeDocument = findByDemmandeurCne(demmandeDocument.getDemmandeur().getCne());

		if (foundedDemmandeDocument!= null) {
			return -1;
		} else {  
			demmandeDocumentDao.save(demmandeDocument);
			return 1; }
		
	}

	@Override
	public List<DemmandeDocument> findAll() {
		return demmandeDocumentDao.findAll();
	}


}
