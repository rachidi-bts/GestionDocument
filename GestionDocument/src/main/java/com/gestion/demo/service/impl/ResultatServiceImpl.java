package com.gestion.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.Resultat;
import com.gestion.demo.dao.ResultatDao;
import com.gestion.demo.service.facade.ResultatService;
import com.gestion.demo.service.util.SearchUtil;


@Service
public class ResultatServiceImpl implements ResultatService {

   @Autowired
   private ResultatDao resultatDao;
   

	@Override
	public List<Resultat> findAll(){
		return resultatDao.findAll();
	}	
	@Override
	public Resultat findByLibelle(String libelle){
		return resultatDao.findByLibelle(libelle);
	}

		@Override
	public int deleteByLibelle(String  libelle) {
		return resultatDao.deleteByLibelle(libelle);	 
	}

	@Override
	public Resultat findById(Long id){
		return resultatDao.getOne(id);
	}

	@Override	
	public Resultat save (Resultat resultat){
	        if(resultat.getLibelle()==null)
			  return null;
		
			Resultat foundedResultat = findByLibelle(resultat.getLibelle());
	       if(foundedResultat!=null)
	          return null;  

	    Resultat savedResultat = resultatDao.save(resultat);
	   return savedResultat;
	}

    @Override
    public List<Resultat> saveAll(List<Resultat> resultats){
		List<Resultat> list = new ArrayList<Resultat>();
		for(Resultat resultat: resultats){
		        list.add(save(resultat));	
		}
		return list;
	}


   @Override
   public Resultat update(Resultat resultat){
     
	        if(resultat.getLibelle()==null)
			  return null;
		
			Resultat foundedResultat = findByLibelle(resultat.getLibelle());
	       if(foundedResultat==null)
	          return null;  
	 
	   return  resultatDao.save(foundedResultat);
     
     }
    
	@Override
	public int delete(Resultat resultat){

	        if(resultat.getLibelle()==null)
			  return -1;
		
			Resultat foundedResultat = findByLibelle(resultat.getLibelle());
	       if(foundedResultat==null)
	          return -1;  
	   resultatDao.delete(foundedResultat);
	   return 1;
	}
	
	
  
 
}