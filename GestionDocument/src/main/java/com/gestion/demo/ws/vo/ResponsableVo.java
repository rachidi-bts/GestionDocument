package com.gestion.demo.ws.vo;

public class ResponsableVo{

private String id ;
private String login ;
private String password ;
private TypeFiliereVo typeFilliereVo ;



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

public TypeFiliereVo  getTypeFilliereVo (){
    return typeFilliereVo ;
}

public void setTypeFilliereVo (TypeFiliereVo  typeFilliereVo ){
     this.typeFilliereVo  = typeFilliereVo ;
}




}