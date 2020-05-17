package com.gestion.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.ServiceDocument;
import com.gestion.demo.bean.TypeDocument;


@Repository
 public interface TypeDocumentDao extends JpaRepository<TypeDocument,Long> {


	 public TypeDocument findByServiceDocument(ServiceDocument serviceDocument);

	 public int deleteByServiceDocument(ServiceDocument serviceDocument);

}
