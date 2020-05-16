package com.gestion.demo.ws.vo;

public class TypeDocumentVo{

private String id ;
private String libelle ;
private ServiceDocumentVo serviceDocumentVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getLibelle(){
    return libelle;
}

public void setLibelle(String  libelle){
     this.libelle = libelle;
}

public ServiceDocumentVo  getServiceDocumentVo (){
    return serviceDocumentVo ;
}

public void setServiceDocumentVo (ServiceDocumentVo  serviceDocumentVo ){
     this.serviceDocumentVo  = serviceDocumentVo ;
}




}