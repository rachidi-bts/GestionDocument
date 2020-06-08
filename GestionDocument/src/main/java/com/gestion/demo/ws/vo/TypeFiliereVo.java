package com.gestion.demo.ws.vo;

import java.util.ArrayList;
import java.util.List;


public class TypeFiliereVo{

private String id ;
private String libelle ;
private FiliereVo filiereVo ;



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

public FiliereVo  getFiliereVo (){
    return filiereVo ;
}

public void setFilliereVo (FiliereVo  fillieretVo ){
     this.filiereVo  = fillieretVo ;
}




}