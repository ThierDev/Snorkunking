import edu.princeton.cs.introcs.StdDraw;
import java.util.Random;

public class Coffre {

    //public int NiveauType;
    public int Tresor;
    public int xCoffre;
    boolean presence = true;
    int status = 0; // 0 si le coffre n'est prit par aucun joueur, 1 j1 , 2j2 

    public Coffre(int NiveauType, int xCoffre){
    
        //this.NiveauType = NiveauType;
        Random randomGenerator = new Random();
        this.presence =true;
        if(NiveauType==0) {this.presence = false;}
        if (NiveauType == 1){this.Tresor = 1+ randomGenerator.nextInt(3-1);}
        else if(NiveauType == 2){this.Tresor = 5 +randomGenerator.nextInt(8-5); }
        else if(NiveauType==3){this.Tresor = 10 + randomGenerator.nextInt(12-10);}
    	this.xCoffre = xCoffre;
    }

    public void showCoffre(double b, double c, double d){
    	if (presence == true ){
       StdDraw.picture(xCoffre,b, "coffre.png",c ,d); 
    	} 
    }
    
    
    
    public int getTresor(){
        return Tresor;
    }
    
    public void takeCoffre(int status) {
    	
    	if (presence = true){
    		
    		this.status = status;
    		this.presence = false;
    		
    	}
    }
		
	
}
