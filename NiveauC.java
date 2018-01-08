import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class NiveauC extends Main{
    public String ColorArg;
    public int position;
    public int totalNiveau;
    public double NiveauHeight;
    public Coffre coffreN;
    Random randomGenerator = new Random();
    
    public NiveauC(int typeNiveau,int position,int totalNiveau){ 
        if (typeNiveau==0){
            this.ColorArg = "Princeton Orange";
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
        coffreN = new Coffre(typeNiveau);
        
        }
        
    
    public double positionYCenterNiveau(){

        return (2*NiveauHeight +((totalNiveau-position)*NiveauHeight));
    }
    public void drawNiveau(){
    	int X_Coffre = 64 + randomGenerator.nextInt(508-1);
        setPenColors(ColorArg);
        double Y=positionYCenterNiveau();
        StdDraw.rectangle(X_MAX/2,Y*SH,0.4*X_MAX,NiveauHeight*SH);
        coffreN.showCoffre(X_Coffre,(Y-NiveauHeight/2)*SH,10*SW,NiveauHeight*SH);
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