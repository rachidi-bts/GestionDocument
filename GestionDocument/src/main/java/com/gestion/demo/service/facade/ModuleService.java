package com.gestion.demo.service.facade;

import java.util.List;
import com.gestion.demo.bean.Module;

public interface ModuleService {

    
	public List<Module> findAll();
	   
	public Module findByLibelle(String libelle);

	public Module findById(Long id);
    
	public Module save(Module module);

	public List<Module> saveAll(List<Module> modules);
    
	public Module update(Module module);
    
	public int delete(Module module);
    
	public int deleteByLibelle(String libelle);
    
}