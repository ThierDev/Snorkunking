import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class NiveauC extends Main{
    public String ColorArg;
    public int position;
    public int totalNiveau;
    public double NiveauHeight;
    public Coffre coffreN;
    Random randomGenerator = new Random();
    public boolean[] presenceJoueur1 = {false};
    public boolean[] presenceJoueur2 = {false};
    
// par convention presenceJoueur[0] = true si bob;  false si patrick/ presenceJoeur[1]=true or false dépendant si le joueur est effectivement présent
    
    
    public NiveauC(int typeNiveau,int position,int totalNiveau){ 
        if (typeNiveau==0){
            this.ColorArg = "Princeton Orange";
            presenceJoueur1[0]=true;
            presenceJoueur2[0]=true;
        }
        if (typeNiveau==1){
            this.ColorArg = "Green";
        }
        else if(typeNiveau==2){
            this.ColorArg = "Yellow";  
        }
        else if (typeNiveau==3){
            this.ColorArg = "Red";
        }
        this.position = position;
        this.totalNiveau=totalNiveau;
        this.NiveauHeight = 280/totalNiveau;
    	int xCoffre = 70 + randomGenerator.nextInt(504-1);
        coffreN = new Coffre(typeNiveau, xCoffre);
        
        }
        
    
    public double positionYCenterNiveau(){

        return (2*NiveauHeight +((totalNiveau-position)*NiveauHeight));
    }
    public void drawNiveau(){
        setPenColors(ColorArg);
        double Y=positionYCenterNiveau();
        StdDraw.rectangle(X_MAX/2,Y*SH,0.4*X_MAX,NiveauHeight*SH);
        coffreN.showCoffre(coffreN.xCoffre,(Y-NiveauHeight/2)*SH,11*SW,NiveauHeight*SH);
        drawJoueur();
    }
    
    public void drawJoueur() {
    	double Y=positionYCenterNiveau() + NiveauHeight/2;
    	
    	if (presenceJoueur2[0]==true) {
    		StdDraw.picture(0.25*X_MAX,Y*SH ,"bob.png", 12*SW, 12*SH);
    	}
    	else if (presenceJoueur1[0]==true) {
    	StdDraw.picture(X_MAX-0.25*X_MAX,Y*SH,"patrick.png", 12*SW, 12*SH);}
    	
    }
    
    public void setPenColors(String argString){
        if(argString.equals("Princeton Orange")){StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);}
        else if(argString.equals("Red")){StdDraw.setPenColor(StdDraw.RED);}
        else if(argString.equals("Blue")){StdDraw.setPenColor(StdDraw.BLUE);}
        else if(argString.equals("Yellow")){StdDraw.setPenColor(StdDraw.YELLOW);}
        else if(argString.equals("Green")){StdDraw.setPenColor(StdDraw.GREEN);}
        else {StdDraw.setPenColor();}
    }
    
    public int getTresor(){
        return coffreN.getTresor();
    }
}