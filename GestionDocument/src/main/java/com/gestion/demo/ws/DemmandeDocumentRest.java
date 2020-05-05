package com.gestion.demo.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.demo.bean.DemmandeDocument;
import com.gestion.demo.dao.DemmandeDocumentDao;
import com.gestion.demo.service.facade.DemmandeDocumentService;

 @RestController
 @CrossOrigin(origins = { "http://localhost:4200" })
 @RequestMapping("GestionDocument/DemmandeDocument")
public class DemmandeDocumentRest {
	
	@Autowired
	private DemmandeDocumentService demmandeDocumentService;
	
	@GetMapping("/Demmandeur/nom/{nom}")
	public List<DemmandeDocument> findByDemmandeurNom(@PathVariable String nom) {
		return demmandeDocumentService.findByDemmandeurNom(nom);
	}


	@GetMapping("/Demmandeur/codeApogee/{codeApogee}")
	public List<DemmandeDocument> findByDemmandeurCodeApogee(@PathVariable String codeApogee) {
		return demmandeDocumentService.findByDemmandeurCodeApogee(codeApogee);
	}

	@GetMapping("/Demmandeur/cne/{cne}")
	public List<DemmandeDocument> findByDemmandeurCne(@PathVariable String cne) {
		return demmandeDocumentService.findByDemmandeurCne(cne);
	}

	@GetMapping("/TypeDocument/libelle/{libelle}")
	public List<DemmandeDocument> findByTypeDocumentLibelle(@PathVariable String libelle) {
		return demmandeDocumentService.findByTypeDocumentLibelle(libelle);
	}

	@GetMapping("/EtatDemmmande/libelle/{libelle}")
	public List<DemmandeDocument> findByEtatDemmandeLibelle(@PathVariable String libelle) {
		return demmandeDocumentService.findByEtatDemmandeLibelle(libelle);
	}

	@GetMapping("/dateDemmande/{dateDemmande}")
	public DemmandeDocumentDao findByDateDemmande(@PathVariable Date dateDemmande) {
		return demmandeDocumentService.findByDateDemmande(dateDemmande);
	}

	@DeleteMapping("/EtatDemmande/libelle/{libelle}")
	public int deleteByEtatDemmandeLibelle(@PathVariable String libelle) {
		List<DemmandeDocument> demmandeDocuments= demmandeDocumentService.findByEtatDemmandeLibelle(libelle);
		if (demmandeDocuments == null) {
			return -1;
		}else {
			for (DemmandeDocument demmandeDocument : demmandeDocuments) {
				demmandeDocumentService.delete(demmandeDocument);	
			}
			return 1;
		
		}
	}

   @PostMapping("/")
	public int save(@RequestBody DemmandeDocument demmandeDocument) {
		return demmandeDocumentService.save(demmandeDocument);
		
	}

	@GetMapping("/")
	public List<DemmandeDocument> findAll() {
		return demmandeDocumentService.findAll();
	}
	
}
