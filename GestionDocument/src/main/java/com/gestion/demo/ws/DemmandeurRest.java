package com.gestion.demo.ws;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.gestion.demo.bean.Demmandeur;
import com.gestion.demo.dao.DemmandeurDao;
import com.gestion.demo.service.facade.DemmandeurService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("GestionDocument/Demmandeur")
public class DemmandeurRest {

	@Autowired
	public DemmandeurService demmandeurService;
	
	@GetMapping("/cne/{cne}")
	public Demmandeur findByCne(@PathVariable String cne) {
		return demmandeurService.findByCne(cne);
	}

	@GetMapping("/codeApogee/{codeApogee}")
	public Demmandeur findByCodeApogee(@PathVariable String codeApogee) {
		return demmandeurService.findByCodeApogee(codeApogee);
	}

	@GetMapping("/nom/{nom}")
	public Demmandeur findByNom(@PathVariable String nom) {
		return demmandeurService.findByNom(nom);
	}

	@GetMapping("/cin/{cin}")
	public Demmandeur findByCin(@PathVariable String cin) {
		return demmandeurService.findByCin(cin);
	}

	@DeleteMapping("/cne/{cne}")
	public int deleteByCne(@PathVariable String cne) {
	return	demmandeurService.deleteByCne(cne);
		
	}

	@PostMapping("/")
	public int save(@RequestBody Demmandeur demmandeur) {
		return demmandeurService.save(demmandeur);
			
	}

	@GetMapping("/")
	public List<Demmandeur> findAll() {
		return demmandeurService.findAll();
	}
	
}
