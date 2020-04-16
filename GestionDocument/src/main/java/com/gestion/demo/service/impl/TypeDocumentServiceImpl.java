package com.gestion.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.ServiceDocument;
import com.gestion.demo.dao.ServiceDocumentDao;
import com.gestion.demo.service.facade.ServiceDocumentService;

@Service
public class TypeDocumentServiceImpl implements ServiceDocumentService {
	@Autowired
	private ServiceDocumentDao serviceDocumentDao;

	@Override
	public ServiceDocument findByLibelle(String libelle) {
		return serviceDocumentDao.findByLibelle(libelle);
	}
	@Transactional
	@Override
	public int deleteByLibelle(String libelle) {
		return serviceDocumentDao.deleteByLibelle(libelle);
	}

	@Override
	public List<ServiceDocument> findAll() {
		return serviceDocumentDao.findAll();
	}

	@Override
	public int save(ServiceDocument serviceDocument) {
		ServiceDocument foundedServiceDocument = findByLibelle(serviceDocument.getLibelle());

		if (foundedServiceDocument != null) {
			return -1;
		} else {
			serviceDocumentDao.save(serviceDocument);
			return 1;
		}
	}

	@Override
	public int update(ServiceDocument serviceDocument) {
		return 0;
	}

}
