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
    public List<Coffre> coffreList = new ArrayList<Coffre>(); // cette liste ne contient que 1 element hors dernier niveau
    public int typeNiveau;
    Random randomGenerator = new Random();
    public boolean[] presenceJoueur1 = {false};
    public boolean[] presenceJoueur2 = {false};
    
    private String debugPos = "";
    
// par convention presenceJoueur[0] = true si bob;  false si patrick/ presenceJoeur[1]=true or false dépendant si le joueur est effectivement présent
    
    
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
        this.NiveauHeight = 290/totalNiveau;
        this.debugPos = Integer.toString(position);
        
     // 
      	int xCoffre = 70 + randomGenerator.nextInt(502-1); 
      	coffreList.add(new Coffre(typeNiveau,xCoffre));
        
        }
        
    
    public double positionYCenterNiveau(){
    	
        return (NiveauHeight +((totalNiveau-position)*NiveauHeight));
        
    }
    public void drawNiveau(){
    	
        setPenColors(ColorArg);
        double Y=positionYCenterNiveau();
        drawJoueur();
        drawCoffre();
        
        StdDraw.rectangle(X_MAX/2,Y*SH,0.4*X_MAX,NiveauHeight/2*SH);
        
    }
    
    public void drawJoueur() {
    	double Y=positionYCenterNiveau();
    	
    	
    	if (presenceJoueur2[0]==true) {
    		
    		StdDraw.picture(0.25*X_MAX,Y*SH ,"bob.png", 12*SW, 12*SH);
    	}
    	if (presenceJoueur1[0]==true) {
    		
    		StdDraw.picture(X_MAX-0.25*X_MAX,Y*SH,"patrick.png", 12*SW, 12*SH);}
    	
		statusDisplay(); //Pour le debug
		statusNbDisplay();
		nbCoffreDisplay(); //debug
		levelIndexDisplay(); //debug
    	
    }
    public void drawCoffre() {
    	double Y=positionYCenterNiveau();
    	// on distingue systématiquement le dernier niveau qui peut contenir plusieurs coffres
    	
    	for (int i=0;i<coffreList.size();i++) {
    			coffreList.get(i).showCoffre((Y)*SH,11*SW,NiveauHeight*SH);
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
        	int tempTresor = 0;
    		for (int i=0;i<coffreList.size();i++) {
    			if (coffreList.get(i).status == status) {tempTresor += coffreList.get(i).getTresor();}	
    		}
    		return tempTresor;
    }
    public void changeStatus(int status) {
    	
    	for (int i=0;i<coffreList.size();i++) {
			coffreList.get(i).takeCoffre(status); 	
		}
    }
    
    public boolean checkPresenceCoffre() {
    	
    	return coffreList.get(0).presence;
    }
    
	public void statusDisplay() {
		double Y=positionYCenterNiveau();
    	for (int i=0;i<coffreList.size();i++) {
			StdDraw.text(0.11*X_MAX, (Y)*SH, "" + coffreList.get(i).presence); 	
		}
	}
	
	public void statusNbDisplay() {
		double Y=positionYCenterNiveau();
    	for (int i=0;i<coffreList.size();i++) {
			StdDraw.text(0.88*X_MAX, (Y)*SH, "" + coffreList.get(i).status); 	
		}
	}
	
	public void nbCoffreDisplay() {
		double Y=positionYCenterNiveau();
    	for (int i=0;i<coffreList.size();i++) {
			StdDraw.text(0.85*X_MAX, (Y)*SH, "" + coffreList.size()); 	
		}
	}
	
	public void levelIndexDisplay() {
		double Y=positionYCenterNiveau();

    	for (int i=0;i<coffreList.size();i++) {
			StdDraw.text(0.14*X_MAX, (Y)*SH, "" + debugPos); 	
		}
	}
	
}