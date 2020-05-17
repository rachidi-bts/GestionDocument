package com.gestion.demo.ws.vo;

public class ResponsableVo{

private String id ;
private String login ;
private String password ;
private ServiceDocumentVo serviceDocumentVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getLogin(){
    return login;
}

public void setLogin(String  login){
     this.login = login;
}

public String  getPassword(){
    return password;
}

public void setPassword(String  password){
     this.password = password;
}

public ServiceDocumentVo  getServiceDocumentVo (){
    return serviceDocumentVo ;
}

public void setServiceDocumentVo (ServiceDocumentVo  serviceDocumentVo ){
     this.serviceDocumentVo  = serviceDocumentVo ;
}




}