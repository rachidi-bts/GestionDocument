package com.gestion.demo.service.facade;

import java.util.List;

import com.gestion.demo.bean.TypeDocument;

public interface TypeDocumentService {
	public TypeDocument findByLibelle (String libelle);
	public TypeDocument findByServiceDocumentLibelle (String libelle);

	public int deleteByLibelle (String libelle);
	public int deleteByServiceDocumentLibelle (String libelle);
	
	public List<TypeDocument> findAll();
	public int save(TypeDocument typeDocument);
	public int update(TypeDocument typeDocument);
}
