package com.gestion.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.TypeFiliere;
import com.gestion.demo.bean.TypeDocument;


@Repository
 public interface TypeDocumentDao extends JpaRepository<TypeDocument,Long> {


	 public TypeDocument findByTypeFilliere(TypeFiliere typeFilliere);

	 public int deleteByTypeFilliere(TypeFiliere typeFilliere);

}
