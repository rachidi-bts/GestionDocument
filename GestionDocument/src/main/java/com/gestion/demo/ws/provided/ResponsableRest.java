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

import com.gestion.demo.bean.Responsable;
import com.gestion.demo.service.facade.ResponsableService;
import com.gestion.demo.ws.converter.ResponsableConverter;
import com.gestion.demo.ws.vo.ResponsableVo;
@RestController
@RequestMapping("GestionDocument/Responsable")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ResponsableRest {

 @Autowired 
 private ResponsableService responsableService;

 @Autowired 
private ResponsableConverter responsableConverter ;

@PostMapping("/")
public ResponsableVo save(@RequestBody ResponsableVo responsableVo){
Responsable responsable= responsableConverter.toItem(responsableVo);
return responsableConverter.toVo(responsableService.save(responsable));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
responsableService.deleteById(id);
}
@GetMapping("/")
public List<ResponsableVo> findAll(){
return responsableConverter.toVo(responsableService.findAll());
}

 public ResponsableConverter getResponsableConverter(){
return responsableConverter;
}
 
 public void setResponsableConverter(ResponsableConverter responsableConverter){
this.responsableConverter=responsableConverter;
}

 public ResponsableService getResponsableService(){
return responsableService;
}
 
 public void setResponsableService(ResponsableService responsableService){
this.responsableService=responsableService;
}

}