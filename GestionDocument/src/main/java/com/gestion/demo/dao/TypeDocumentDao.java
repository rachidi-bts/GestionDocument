package com.gestion.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.TypeDocument;

@Repository
public interface TypeDocumentDao extends JpaRepository <TypeDocument,Long>{
	public TypeDocument findByLibelle (String libelle);
	public TypeDocument findByServiceDocumentLibelle (String libelle);

	public int deleteByLibelle (String libelle);
	public int deleteByServiceDocumentLibelle (String libelle);

	
}
