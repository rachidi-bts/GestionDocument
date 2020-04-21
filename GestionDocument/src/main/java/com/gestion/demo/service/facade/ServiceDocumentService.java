package com.gestion.demo.service.facade;

import java.util.List;
import com.gestion.demo.bean.ServiceDocument;

public interface ServiceDocumentService {
	public ServiceDocument findByLibelle (String libelle);
	public int deleteByLibelle (String libelle);
	public List<ServiceDocument> findAll();
	public int save(ServiceDocument serviceDocument);
	public int update(ServiceDocument serviceDocument);
}
