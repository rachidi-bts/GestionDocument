package com.gestion.demo.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.Module;
import com.gestion.demo.dao.ModuleDao;
import com.gestion.demo.service.facade.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

   @Autowired
   private ModuleDao moduleDao;

 @Override
 public List<Module> findAll() {
	return moduleDao.findAll();
}

@Override
public Module findByLibelle(String libelle) {
	return moduleDao.findByLibelle(libelle);
}

@Override
public Module findById(Long id) {
	return moduleDao.getOne(id);
}

@Override
public Module save(Module module) {
	 if(module.getLibelle()==null)
		  return null;
	
		Module foundedModule = findByLibelle(module.getLibelle());
      if(foundedModule!=null)
         return null;  

   Module savedModule = moduleDao.save(module);
  return savedModule;
}

@Override
public List<Module> saveAll(List<Module> modules) {
	List<Module> list = new ArrayList<Module>();
	for(Module module: modules){
	        list.add(save(module));	
	}
	return list;
}

@Override
public Module update(Module module) {
	  if(module.getLibelle()==null)
		  return null;
	
		Module foundedModule = findByLibelle(module.getLibelle());
       if(foundedModule==null)
          return null;  
 
   return  moduleDao.save(foundedModule);
 
}

@Override
public int delete(Module module) {
	 if(module.getLibelle()==null)
		  return -1;
	
		Module foundedModule = findByLibelle(module.getLibelle());
      if(foundedModule==null)
         return -1;  
  moduleDao.delete(foundedModule);
  return 1;
}

@Override
public int deleteByLibelle(String libelle) {
   return moduleDao.deleteByLibelle(libelle);
}
   
   
  
 
}