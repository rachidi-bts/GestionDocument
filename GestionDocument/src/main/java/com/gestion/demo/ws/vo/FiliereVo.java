package com.gestion.demo.ws.vo;

public class FiliereVo{

private String id ;
private String libelle ;
private String abrv;
private TypeFiliereVo typeFiliereVo ;


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

public String getAbrv() {
	return abrv;
}

public void setAbrv(String abrv) {
	this.abrv = abrv;
}

public TypeFiliereVo getTypeFiliereVo(){
    return this.typeFiliereVo;
}
 
public void setTypeFiliereVo(TypeFiliereVo typeFiliereVo){
    this.typeFiliereVo = typeFiliereVo;
}



}