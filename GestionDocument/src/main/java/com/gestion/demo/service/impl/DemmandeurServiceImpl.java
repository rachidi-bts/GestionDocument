package com.gestion.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.dao.DemmandeurDao;
import com.gestion.demo.service.facade.DemmandeurService;



@Service
public class DemmandeurServiceImpl implements DemmandeurService{

	@Autowired
	public DemmandeurDao demmandeurDao;
	
	@Override
	public Demmandeur findByCne(String cne) {
		return demmandeurDao.findByCne(cne);
	}

	@Override
	public Demmandeur findByCodeApogee(String codeApogee) {
		return demmandeurDao.findByCodeApogee(codeApogee);
	}

	@Override
	public Demmandeur findByNom(String nom) {
		return demmandeurDao.findByNom(nom);
	}

	@Override
	public Demmandeur findByCin(String cin) {
		return demmandeurDao.findByCin(cin);
	}

	@Override
	public int deleteByCne(String cne) {
		Demmandeur demmandeur= demmandeurDao.findByCne(cne);
		if (demmandeur == null) {
			return -1;
		}else {
			demmandeurDao.delete(demmandeur);
			return 1;
		}
	}

	@Override
	public int save(Demmandeur demmandeur) {
		Demmandeur foundedDemmandeur = findByCne(demmandeur.getCne());

		if (foundedDemmandeur != null) {
			return -1;
		} else {
			DemmandeurDao.save(demmandeur);
			return 1;
		}
	}

	@Override
	public List<Demmandeur> findAll() {
		return demmandeurDao.findAll();
	}
	
	
	
}