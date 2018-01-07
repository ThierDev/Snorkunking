import java.util.Random;

public class Coffre{

    //public int NiveauType;
    public int Tresor;


    public Coffre(int NiveauType){
    
        //this.NiveauType = NiveauType;
        Random randomGenerator = new Random();

        if (NiveauType == 1){this.Tresor = 1+ randomGenerator.nextInt(3-1);}
        else if(NiveauType == 2){this.Tresor = 5 +randomGenerator.nextInt(8-5); }
        else if(NiveauType==3){this.Tresor = 10 + randomGenerator.nextInt(12-10);}
    }

    
		
	
}
