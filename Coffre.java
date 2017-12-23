import java.util.Random;

public class Coffre extends Niveau {

	public static void Generation() throws Exception {	
	
    Random randomGenerator = new Random();
    
    int[] ListeTresorsC1 = new int[niveauxC1];
    int[] ListeTresorsC2 = new int[niveauxC2];
    int[] ListeTresorsC3 = new int[niveauxC3];
    
    for (int i = 0; i<niveauxC1; i++) {
        int tresorsC1 = randomGenerator.nextInt(1-3);
    	int temp = tresorsC1;
    	ListeTresorsC1[i] = temp; }
    
    for (int i = 0; i<niveauxC2; i++) {
        int tresorsC2 = randomGenerator.nextInt(5-8);
    	int temp = tresorsC2;
    	ListeTresorsC2[i] = temp; }
    
    for (int i = 0; i<niveauxC3; i++) {
        int tresorsC3 = randomGenerator.nextInt(10-12);
    	int temp = tresorsC3;
    	ListeTresorsC3[i] = temp; }
    
	}
}