import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class NiveauC extends Main{
    public String ColorArg;
    public int position;
    public int totalNiveau;
    public double NiveauHeight;
    //public Coffre coffreN;
    public List<Coffre> coffreList = new ArrayList<Coffre>(); // cette liste ne contient que 1 élément, mis a part pour le dernier niveau
    public int typeNiveau;
    Random randomGenerator = new Random();
    
    // permet de savoir si le joueur est «dans» le niveau. 
    public boolean[] presenceJoueur1 = {false};
    public boolean[] presenceJoueur2 = {false};
    

    
    
    public NiveauC(int typeNiveau,int position,int totalNiveau){ 
        if (typeNiveau==0){
            this.ColorArg = "Princeton Orange";
            this.presenceJoueur1[0]=true;
            this.presenceJoueur2[0]=true;
            
        }
        else if (typeNiveau==1){
            this.ColorArg = "Green";
            this.totalNiveau=totalNiveau;
            
        }
        else if(typeNiveau==2){
            this.ColorArg = "Yellow";
           
        }
        else if (typeNiveau==3){
            this.ColorArg = "Red";
            
        }
        this.position = position;
        this.typeNiveau = typeNiveau;
        this.totalNiveau=totalNiveau;
        
        
        
     // 
      	int xCoffre = 70 + randomGenerator.nextInt(502-1); // position en x du coffre , généré aléatoirement
      	
      	/*
      	 * Creation d'une liste de coffre, pour tous les niveaux sauf le dernier cette liste ne contient qu'un élément de type coffre.
      	 * l'object coffreliste est propre à chaque niveau, chaque niveau contient «son» coffre. 
      	 */
      	coffreList.add(new Coffre(typeNiveau,xCoffre)); 
      	
        
        }
        
    
    public double positionYCenterNiveau(){ // renvoie la position du niveau.
    	
    	NiveauHeight = 280/totalNiveau; // permet de moduler la taille des niveau en fonction du nombre de niveau. 
        return (NiveauHeight/4 +((totalNiveau-position)*NiveauHeight));
        
    }
    public void drawNiveau(){
    	// realise l'impression des niveaux , des joueurs et des coffres qui sont aussi «dans» le niveau
    	
        setPenColors(ColorArg);
        double Y=positionYCenterNiveau();
        drawJoueur();
        drawCoffre();
        NiveauHeight = 280/totalNiveau;
        StdDraw.rectangle(X_MAX/2,Y*SH,0.4*X_MAX,NiveauHeight/2*SH);
        
    }
    
    public void drawJoueur() {
    	double Y=positionYCenterNiveau();
    	
    	
    	
    	if (presenceJoueur2[0]==true) {
    		
    		StdDraw.picture(0.25*X_MAX,Y*SH ,"bob.png", NiveauHeight*SW, NiveauHeight*SH);
    	}
    	if (presenceJoueur1[0]==true) {
    		
    		StdDraw.picture(X_MAX-0.25*X_MAX,Y*SH,"patrick.png", NiveauHeight*SW, NiveauHeight*SH);}
 
    	
    }
    public void drawCoffre() {
    	
    	
    	NiveauHeight = 280/totalNiveau;
    	double Y=positionYCenterNiveau();
    	// on distingue systématiquement le dernier niveau qui peut contenir plusieurs coffres
    	
    	for (int i=0;i<coffreList.size();i++) {
    			coffreList.get(i).showCoffre((Y)*SH,NiveauHeight*SW,NiveauHeight*SH);
    		}
    	}
    
    public void setPenColors(String argString){
        if(argString.equals("Princeton Orange")){StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);}
        else if(argString.equals("Red")){StdDraw.setPenColor(StdDraw.RED);}
        else if(argString.equals("Blue")){StdDraw.setPenColor(StdDraw.BLUE);}
        else if(argString.equals("Yellow")){StdDraw.setPenColor(StdDraw.YELLOW);}
        else if(argString.equals("Green")){StdDraw.setPenColor(StdDraw.GREEN);}
        else {StdDraw.setPenColor();}
    }
    
    public int getTresor(int status){
    	
    	// recupère la valeur des tresors à chaque niveaux si l'on est au dernier niveau, on recupère tout les trésors
        	int tempTresor = 0;
    		for (int i=0;i<coffreList.size();i++) {
    			if (coffreList.get(i).status == status) {tempTresor += coffreList.get(i).getTresor();}	
    		}
    		return tempTresor;
    }
    public void changeStatus(int status) {
    	
    	// change le status des coffres 0 si personne, 1 si le J1 a prit le coffre, 2 si j2 a prit le coffre
    	
    	for (int i=0;i<coffreList.size();i++) {
			coffreList.get(i).takeCoffre(status); 	
		}
    }
    
    public boolean checkPresenceCoffre() {
    	
    	// recupère la valeur du booléen présence de la classe coffre.
    	
    	return coffreList.get(0).presence;
    }
    
	

	
}