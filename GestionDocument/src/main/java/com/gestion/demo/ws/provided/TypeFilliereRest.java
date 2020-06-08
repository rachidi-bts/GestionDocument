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

import com.gestion.demo.bean.TypeFiliere;
import com.gestion.demo.service.facade.TypeFiliereService;
import com.gestion.demo.ws.converter.TypeFiliereConverter;
import com.gestion.demo.ws.vo.TypeFiliereVo;
@RestController
@RequestMapping("/GestionDocument/TypeFiliere")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TypeFilliereRest {

 @Autowired 
 private TypeFiliereService typeFiliereService;

 @Autowired 
private TypeFiliereConverter typeFiliereConverter ;

@PostMapping("/")
public TypeFiliereVo save(@RequestBody TypeFiliereVo typeFiliereVo){
TypeFiliere typeFiliere= typeFiliereConverter.toItem(typeFiliereVo);
return typeFiliereConverter.toVo(typeFiliereService.save(typeFiliere));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
typeFiliereService.deleteById(id);
}
@GetMapping("/")
public List<TypeFiliereVo> findAll(){
return typeFiliereConverter.toVo(typeFiliereService.findAll());
}

 public TypeFiliereConverter getTypeFiliereConverter(){
return typeFiliereConverter;
}
 
 public void setTypeFiliereConverter(TypeFiliereConverter typeFiliereConverter){
this.typeFiliereConverter=typeFiliereConverter;
}

 public TypeFiliereService getTypeFiliereService(){
return typeFiliereService;
}
 
 public void setTypeFiliereService(TypeFiliereService typeFiliereService){
this.typeFiliereService=typeFiliereService;
}

}