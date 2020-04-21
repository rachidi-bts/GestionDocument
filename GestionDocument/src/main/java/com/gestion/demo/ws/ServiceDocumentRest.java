package com.gestion.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.demo.bean.ServiceDocument;
import com.gestion.demo.service.facade.ServiceDocumentService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("GestionDocument/ServiceDocument")
public class ServiceDocumentRest {
	@Autowired
	private ServiceDocumentService serviceDocumentService;

	@GetMapping("/libelle/{libelle}")
	public ServiceDocument findByLibelle(@PathVariable String libelle) {
		return serviceDocumentService.findByLibelle(libelle);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return serviceDocumentService.deleteByLibelle(libelle);
	}

	@GetMapping("/")
	public List<ServiceDocument> findAll() {
		return serviceDocumentService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody ServiceDocument serviceDocument) {
		return serviceDocumentService.save(serviceDocument);
	}

	@PutMapping("/")
	public int update(@RequestBody ServiceDocument serviceDocument) {
		return serviceDocumentService.update(serviceDocument);
	}

}
