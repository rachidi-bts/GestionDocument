package com.gestion.demo.ws.provided;

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

import com.gestion.demo.bean.Responsable;
import com.gestion.demo.service.facade.ResponsableService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("GestionDocument/Responsable")
public class ResponsableRest {
	@Autowired
	private ResponsableService responsableService;

	@GetMapping("/login/{login}")
	public Responsable findByLogin(@PathVariable String login) {
		return responsableService.findByLogin(login);
	}

	@DeleteMapping("/login/{login}")
	public int deleteByLogin(@PathVariable String login) {
		return responsableService.deleteByLogin(login);
	}

	@GetMapping("/")
	public List<Responsable> findAll() {
		return responsableService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Responsable responsable) {
		return responsableService.save(responsable);
	}

	@PutMapping("/")
	public int update(@RequestBody Responsable responsable) {
		return responsableService.update(responsable);
	}

}
