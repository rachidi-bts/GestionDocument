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

import com.gestion.demo.bean.TypeDocument;
import com.gestion.demo.service.facade.TypeDocumentService;
import com.gestion.demo.ws.converter.TypeDocumentConverter;
import com.gestion.demo.ws.vo.TypeDocumentVo;
@RestController
@RequestMapping("/is/TypeDocument")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TypeDocumentRest {

 @Autowired 
 private TypeDocumentService typeDocumentService;

 @Autowired 
private TypeDocumentConverter typeDocumentConverter ;

@PostMapping("/")
public TypeDocumentVo save(@RequestBody TypeDocumentVo typeDocumentVo){
TypeDocument typeDocument= typeDocumentConverter.toItem(typeDocumentVo);
return typeDocumentConverter.toVo(typeDocumentService.save(typeDocument));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
typeDocumentService.deleteById(id);
}
@GetMapping("/")
public List<TypeDocumentVo> findAll(){
return typeDocumentConverter.toVo(typeDocumentService.findAll());
}

 public TypeDocumentConverter getTypeDocumentConverter(){
return typeDocumentConverter;
}
 
 public void setTypeDocumentConverter(TypeDocumentConverter typeDocumentConverter){
this.typeDocumentConverter=typeDocumentConverter;
}

 public TypeDocumentService getTypeDocumentService(){
return typeDocumentService;
}
 
 public void setTypeDocumentService(TypeDocumentService typeDocumentService){
this.typeDocumentService=typeDocumentService;
}

}