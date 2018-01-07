import edu.princeton.cs.introcs.StdDraw;

public class NiveauC extends Main{
    public String ColorArg;
    public int position;
    public int totalNiveau;
    public double NiveauHeight;

    public NiveauC(int typeNiveau,int position,int totalNiveau){ 
        if (typeNiveau==1){
            this.ColorArg = "Blue";
        }
        else if(typeNiveau==2){
            this.ColorArg = "Yellow";  
        }
        else if (typeNiveau==3){
            this.ColorArg = "Red";
        }
        this.position = position;
        this.totalNiveau=totalNiveau;
        this.NiveauHeight = 250/totalNiveau;
        
    }
    public double positionYCenterNiveau(){

        return (NiveauHeight + position*NiveauHeight);
    }
    public void drawNiveau(){
        setPenColors(ColorArg);
        double Y=positionYCenterNiveau();
        StdDraw.rectangle(X_MAX/2,Y*SH,X_MAX/2-0.075*X_MAX,NiveauHeight*SH);
    }
    public void setPenColors(String argString){
        if(argString.equals("Red")){StdDraw.setPenColor(StdDraw.RED);}
        else if(argString.equals("Blue")){StdDraw.setPenColor(StdDraw.BLUE);}
        else if(argString.equals("Yellow")){StdDraw.setPenColor(StdDraw.YELLOW);}
        else if(argString.equals("Green")){StdDraw.setPenColor(StdDraw.GREEN);}
        else {StdDraw.setPenColor();}
    }
}