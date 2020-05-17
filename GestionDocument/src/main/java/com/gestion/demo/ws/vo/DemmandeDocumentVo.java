package com.gestion.demo.ws.vo;

public class DemmandeDocumentVo{

private String id ;
private String dateDemmande;
private String dateDemmandeMin ;
private String dateDemmandeMax ;
private String dateValidation;
private String dateValidationMin ;
private String dateValidationMax ;
private DemmandeurVo demmandeurVo ;
private TypeDocumentVo typeDocumentVo ;
private EtatDemmandeVo etatDemmandeVo ;



public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getDateDemmande(){
    return dateDemmande;
}

public void setDateDemmande(String  dateDemmande){
     this.dateDemmande = dateDemmande;
}

public String  getDateDemmandeMin(){
    return dateDemmandeMin;
}

public void setDateDemmandeMin(String  dateDemmandeMin){
     this.dateDemmandeMin = dateDemmandeMin;
}

public String  getDateDemmandeMax(){
    return dateDemmandeMax;
}

public void setDateDemmandeMax(String  dateDemmandeMax){
     this.dateDemmandeMax = dateDemmandeMax;
}

public String  getDateValidation(){
    return dateValidation;
}

public void setDateValidation(String  dateValidation){
     this.dateValidation = dateValidation;
}

public String  getDateValidationMin(){
    return dateValidationMin;
}

public void setDateValidationMin(String  dateValidationMin){
     this.dateValidationMin = dateValidationMin;
}

public String  getDateValidationMax(){
    return dateValidationMax;
}

public void setDateValidationMax(String  dateValidationMax){
     this.dateValidationMax = dateValidationMax;
}

public DemmandeurVo  getDemmandeurVo (){
    return demmandeurVo ;
}

public void setDemmandeurVo (DemmandeurVo  demmandeurVo ){
     this.demmandeurVo  = demmandeurVo ;
}

public TypeDocumentVo  getTypeDocumentVo (){
    return typeDocumentVo ;
}

public void setTypeDocumentVo (TypeDocumentVo  typeDocumentVo ){
     this.typeDocumentVo  = typeDocumentVo ;
}

public EtatDemmandeVo  getEtatDemmandeVo (){
    return etatDemmandeVo ;
}

public void setEtatDemmandeVo (EtatDemmandeVo  etatDemmandeVo ){
     this.etatDemmandeVo  = etatDemmandeVo ;
}




}