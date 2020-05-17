package com.gestion.demo.ws.provided ;


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

import com.gestion.demo.bean.EtatDemmande;
import com.gestion.demo.service.facade.EtatDemmandeService;
import com.gestion.demo.ws.converter.EtatDemmandeConverter;
import com.gestion.demo.ws.vo.EtatDemmandeVo;
@RestController
@RequestMapping("GestionDocument/EtatDemmande")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EtatDemmandeRest {

 @Autowired 
 private EtatDemmandeService etatDemmandeService;

 @Autowired 
private EtatDemmandeConverter etatDemmandeConverter ;

@PostMapping("/")
public EtatDemmandeVo save(@RequestBody EtatDemmandeVo etatDemmandeVo){
EtatDemmande etatDemmande= etatDemmandeConverter.toItem(etatDemmandeVo);
return etatDemmandeConverter.toVo(etatDemmandeService.save(etatDemmande));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
etatDemmandeService.deleteById(id);
}
@GetMapping("/")
public List<EtatDemmandeVo> findAll(){
return etatDemmandeConverter.toVo(etatDemmandeService.findAll());
}

 public EtatDemmandeConverter getEtatDemmandeConverter(){
return etatDemmandeConverter;
}
 
 public void setEtatDemmandeConverter(EtatDemmandeConverter etatDemmandeConverter){
this.etatDemmandeConverter=etatDemmandeConverter;
}

 public EtatDemmandeService getEtatDemmandeService(){
return etatDemmandeService;
}
 
 public void setEtatDemmandeService(EtatDemmandeService etatDemmandeService){
this.etatDemmandeService=etatDemmandeService;
}
 
	@GetMapping("/libelle/{libelle}")
	public EtatDemmande findByLibelle(@PathVariable String libelle) {
		return etatDemmandeService.findByLibelle(libelle);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return etatDemmandeService.deleteByLibelle(libelle);
	}


}