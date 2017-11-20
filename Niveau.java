import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Niveau extends Grotte{

	public int index;
	public final static int X_MAX=40;
	public final static int Y_MAX=40;
	public final static double WIDTH=0.5f;
	
	public Niveau(String vNom,Integer vNbCave) {
		super(vNom, vNbCave);
	}

	public static void main(String[] args) {
	    Random randomGenerator = new Random();
	    int niveauxC1 = 0;
	    int niveauxC2 = 0;
	    int niveauxC3 = 0;
	    while (niveauxC1<9 || niveauxC1>12) {
	    niveauxC1 = randomGenerator.nextInt(12); }
	    while (niveauxC2<6 || niveauxC2>9) {
	    niveauxC2 = randomGenerator.nextInt(9); }
	    while (niveauxC3<3 || niveauxC3>6) {
	    niveauxC3 = randomGenerator.nextInt(6); }
		System.out.println(niveauxC1);
		System.out.println(niveauxC2);
		System.out.println(niveauxC3);
		
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
		
		StdDraw.clear(StdDraw.BLUE);
		StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
		
		StdDraw.filledRectangle(X_MAX/2,niveauxC3+niveauxC2+3+(niveauxC1/2),18,niveauxC1/2);
		StdDraw.filledRectangle(X_MAX/2,niveauxC3+2+(niveauxC2/2),18,niveauxC1/2);
		StdDraw.filledRectangle(X_MAX/2,2,18,niveauxC3/2);

		

		}
}	