package com.gestion.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.demo.bean.EtatDemmande;

import com.gestion.demo.dao.EtatDemmandeDao;
import com.gestion.demo.service.facade.EtatDemmandeService;

@Service
public class EtatDemmandeServiceImpl implements EtatDemmandeService{

	@Autowired
	public EtatDemmandeDao etatDemmendeDao;
	
	@Override
	public EtatDemmande findByLibelle(String libelle) {
		return etatDemmendeDao.findByLibelle(libelle);
	}

	@Override
	public int deleteByLibelle(String libelle) {
		return etatDemmendeDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(EtatDemmande etatDemmande) {
		EtatDemmande foundedEtatDemmande = findByLibelle(etatDemmande.getLibelle());

		if (foundedEtatDemmande != null) {
			return -1;
		} else {
			etatDemmendeDao.save(etatDemmande);
			return 1;
		}
	}

	@Override
	public List<EtatDemmande> findAll() {
		return null;
	}

}
