package com.gestion.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestion.demo.bean.EtatDemmande;
import com.gestion.demo.service.facade.EtatDemmandeService;

  @RestController
  @CrossOrigin(origins = { "http://localhost:4200" })
  @RequestMapping("GestionDocument/EtatDemmande")
  public class EtatDemmandeRest {

	@Autowired
	public EtatDemmandeService etatDemmandeService;
	
	@GetMapping("/libelle/{libelle}")
	public EtatDemmande findByLibelle(@PathVariable String libelle) {
		return etatDemmandeService.findByLibelle(libelle);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return etatDemmandeService.deleteByLibelle(libelle);
	}

	@PostMapping("/")
	public int save(@RequestBody EtatDemmande etatDemmande) {
		return	etatDemmandeService.save(etatDemmande);
	
	}

	@GetMapping("/")
	public List<EtatDemmande> findAll() {
		return null;
	}

}
