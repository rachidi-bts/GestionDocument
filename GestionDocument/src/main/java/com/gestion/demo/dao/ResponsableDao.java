package com.gestion.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.demo.bean.Responsable;
import com.gestion.demo.bean.ServiceDocument;


@Repository
 public interface ResponsableDao extends JpaRepository<Responsable,Long> {


	 public Responsable findByServiceDocument(ServiceDocument serviceDocument);

	 public int deleteByServiceDocument(ServiceDocument serviceDocument);

}
