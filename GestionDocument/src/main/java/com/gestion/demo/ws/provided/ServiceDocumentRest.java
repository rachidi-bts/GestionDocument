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

import com.gestion.demo.bean.ServiceDocument;
import com.gestion.demo.service.facade.ServiceDocumentService;
import com.gestion.demo.ws.converter.ServiceDocumentConverter;
import com.gestion.demo.ws.vo.ServiceDocumentVo;
@RestController
@RequestMapping("/is/ServiceDocument")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ServiceDocumentRest {

 @Autowired 
 private ServiceDocumentService serviceDocumentService;

 @Autowired 
private ServiceDocumentConverter serviceDocumentConverter ;

@PostMapping("/")
public ServiceDocumentVo save(@RequestBody ServiceDocumentVo serviceDocumentVo){
ServiceDocument serviceDocument= serviceDocumentConverter.toItem(serviceDocumentVo);
return serviceDocumentConverter.toVo(serviceDocumentService.save(serviceDocument));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
serviceDocumentService.deleteById(id);
}
@GetMapping("/")
public List<ServiceDocumentVo> findAll(){
return serviceDocumentConverter.toVo(serviceDocumentService.findAll());
}

 public ServiceDocumentConverter getServiceDocumentConverter(){
return serviceDocumentConverter;
}
 
 public void setServiceDocumentConverter(ServiceDocumentConverter serviceDocumentConverter){
this.serviceDocumentConverter=serviceDocumentConverter;
}

 public ServiceDocumentService getServiceDocumentService(){
return serviceDocumentService;
}
 
 public void setServiceDocumentService(ServiceDocumentService serviceDocumentService){
this.serviceDocumentService=serviceDocumentService;
}

}