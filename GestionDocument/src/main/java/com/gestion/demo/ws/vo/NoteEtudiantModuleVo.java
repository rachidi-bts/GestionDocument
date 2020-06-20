package  com.gestion.demo.ws.vo;


public class NoteEtudiantModuleVo {

     private String ptsJury ;
   
     private String note ;
   
     private String id ;
   

	private NoteEtudiantVo noteEtudiantVo ;
	private ResultatVo resultatVo ;
	private ModuleVo moduleVo ;


     private String noteMax ;
     private String noteMin ;

 public NoteEtudiantModuleVo(){
       super();
     }


     public String getPtsJury(){
          return this.ptsJury;
     }
      public void setPtsJury(String ptsJury){
          this.ptsJury = ptsJury;
     }


     public String getNote(){
          return this.note;
     }
      public void setNote(String note){
          this.note = note;
     }


     public String getId(){
          return this.id;
     }
      public void setId(String id){
          this.id = id;
     }



      public String getNoteMax(){
          return this.noteMax;
     }
     
      public String getNoteMin(){
          return this.noteMin;
     }

     public void setNoteMax(String noteMax){
          this.noteMax = noteMax;
     }

     public void setNoteMin(String noteMin){
          this.noteMin = noteMin;
     }
     
     
     

      public NoteEtudiantVo getNoteEtudiantVo(){
          return this.noteEtudiantVo;
     }
       
     public void setNoteEtudiantVo(NoteEtudiantVo noteEtudiantVo){
          this.noteEtudiantVo = noteEtudiantVo;
     }
   
      public ResultatVo getResultatVo(){
          return this.resultatVo;
     }
       
     public void setResultatVo(ResultatVo resultatVo){
          this.resultatVo = resultatVo;
     }
   
      public ModuleVo getModuleVo(){
          return this.moduleVo;
     }
       
     public void setModuleVo(ModuleVo moduleVo){
          this.moduleVo = moduleVo;
     }
   




}