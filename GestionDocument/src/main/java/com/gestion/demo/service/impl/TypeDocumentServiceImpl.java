package com.gestion.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.TypeDocument;
import com.gestion.demo.dao.TypeDocumentDao;
import com.gestion.demo.service.facade.TypeDocumentService;

@Service
public class TypeDocumentServiceImpl implements TypeDocumentService {
	@Autowired
	private  TypeDocumentDao typeDocumentDao;

	@Override
	public TypeDocument findByLibelle(String libelle) {
		return typeDocumentDao.findByLibelle(libelle);
	}
	@Transactional
	@Override
	public int deleteByLibelle(String libelle) {
		return typeDocumentDao.deleteByLibelle(libelle);
	}
	@Override
	public TypeDocument findByServiceDocumentLibelle(String libelle) {
		return typeDocumentDao.findByServiceDocumentLibelle(libelle);
	}
	@Transactional
	@Override
	public int deleteByServiceDocumentLibelle(String libelle) {
		return typeDocumentDao.deleteByServiceDocumentLibelle(libelle);
	}

	@Override
	public List<TypeDocument> findAll() {
		return typeDocumentDao.findAll();
	}

	@Override
	public int save(TypeDocument typeDocument) {
		TypeDocument foundedTypeDocument = findByLibelle(typeDocument.getLibelle());

		if (foundedTypeDocument != null) {
			return -1;
		} else {
			typeDocumentDao.save(typeDocument);
			return 1;
		}
	}

	@Override
	public int update(TypeDocument typeDocument) {
		return 0;
	}
	

}
