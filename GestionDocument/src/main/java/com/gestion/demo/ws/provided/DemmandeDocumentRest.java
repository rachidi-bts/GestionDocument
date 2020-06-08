package com.gestion.demo.ws.provided ;


import java.io.FileNotFoundException;
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
import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.dao.DemmandeDocumentDao;
import com.gestion.demo.service.facade.DemmandeDocumentService;
import com.gestion.demo.ws.converter.DemmandeDocumentConverter;
import com.gestion.demo.ws.vo.DemmandeDocumentVo;
import com.itextpdf.text.DocumentException;
@RestController
@RequestMapping("GestionDocument/DemmandeDocument")
@CrossOrigin(origins = {"http://localhost:4200"})
public class DemmandeDocumentRest {

 @Autowired 
 private DemmandeDocumentService demmandeDocumentService;

 @Autowired 
private DemmandeDocumentConverter demmandeDocumentConverter ;

@PostMapping("/")
public DemmandeDocumentVo save(@RequestBody DemmandeDocumentVo demmandeDocumentVo){
DemmandeDocument demmandeDocument= demmandeDocumentConverter.toItem(demmandeDocumentVo);
return demmandeDocumentConverter.toVo(demmandeDocumentService.save(demmandeDocument));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
demmandeDocumentService.deleteById(id);
}
@GetMapping("/")
public List<DemmandeDocumentVo> findAll(){
	demmandeDocumentConverter.init();
return demmandeDocumentConverter.toVo(demmandeDocumentService.findAll());
}

 public DemmandeDocumentConverter getDemmandeDocumentConverter(){
return demmandeDocumentConverter;
}
 
 public void setDemmandeDocumentConverter(DemmandeDocumentConverter demmandeDocumentConverter){
this.demmandeDocumentConverter=demmandeDocumentConverter;
}

 public DemmandeDocumentService getDemmandeDocumentService(){
return demmandeDocumentService;
}
 
 public void setDemmandeDocumentService(DemmandeDocumentService demmandeDocumentService){
this.demmandeDocumentService=demmandeDocumentService;
}
 
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
	 
	@GetMapping("/Demmandeur/cin/{cin}")
	public List<DemmandeDocument> findByDemmandeurCin(@PathVariable String cin) {
		return demmandeDocumentService.findByDemmandeurCin(cin);
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

	@GetMapping("/infoDemmandeurPdf/cin/{cin}")
	public int infoDemmandeurPdf(@PathVariable String cin) throws DocumentException, FileNotFoundException{
		return demmandeDocumentService.infoDemmandeurPdf(cin);
	}
}