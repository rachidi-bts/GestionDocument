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

import com.gestion.demo.bean.TypeDocument;
import com.gestion.demo.service.facade.TypeDocumentService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("GestionDocument/TypeDocument")
public class TypeDocumentRest {
	@Autowired
	private TypeDocumentService typeDocumentService;

	@GetMapping("/libelle/{libelle}")
	public TypeDocument findByLibelle(@PathVariable String libelle) {
		return typeDocumentService.findByLibelle(libelle);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return typeDocumentService.deleteByLibelle(libelle);
	}
	@GetMapping("/serviceDocument/libelle/{libelle}")
	public TypeDocument findByServiceDocumentLibelle(@PathVariable String libelle) {
		return typeDocumentService.findByServiceDocumentLibelle(libelle);
	}
	@DeleteMapping("/serviceDocument/libelle/{libelle}")
	public int deleteByServiceDocumentLibelle(@PathVariable String libelle) {
		return typeDocumentService.deleteByServiceDocumentLibelle(libelle);
	}

	@GetMapping("/")
	public List<TypeDocument> findAll() {
		return typeDocumentService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody TypeDocument typeDocument) {
		return typeDocumentService.save(typeDocument);
	}

	@PutMapping("/")
	public int update(@RequestBody TypeDocument typeDocument) {
		return typeDocumentService.update(typeDocument);
	}

}
