package com.gestion.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.ServiceDocument;


@Repository
 public interface ServiceDocumentDao extends JpaRepository<ServiceDocument,Long> {




}
