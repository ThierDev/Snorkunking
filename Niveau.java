import java.awt.event.KeyEvent;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Niveau extends Grotte{

	public int index;
	public final static int X_MAX=120;
	public final static int Y_MAX=120;
	public final static double WIDTH=0.5f;
	
	public Niveau(String vNom,Integer vNbCave) {
		super(vNom, vNbCave);
	}
	
	public static void main(String[] args) {	

	    final int FPS= 1000;
	    final int NB_JOUEURS = 4;
        double deltaX=0;
        double deltaY=0;
        double deltaZ=1;
		int spawn1=0;
        
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
		
		StdDraw.setCanvasSize(720,720);
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
		
        while(true){
		
		StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");

        StdDraw.setPenColor(StdDraw.YELLOW);
        
		for (int i = 0; i < niveauxC3; i++) {
			StdDraw.rectangle(X_MAX/2,(2+4*i),58,1.5);
		}
		
        for (int i = 0; i < niveauxC2; i++) {
			StdDraw.rectangle(X_MAX/2,(6+4*niveauxC3+4*i),58,1.5);
        }
        
        for (int i = 0; i < niveauxC1; i++) {
			StdDraw.rectangle(X_MAX/2,(10+4*niveauxC3+4*niveauxC2+4*i),58,1.5);
        }
		StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.rectangle(X_MAX/2,(10+4*niveauxC3+4*niveauxC2+4*niveauxC1),58,1.5);
        
        

        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
            deltaY= deltaY+4;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
            deltaY= deltaY-4;
        }
		
        if (deltaY<=0) deltaY = 0 ;
        if (deltaY>(8+4*niveauxC3+4*niveauxC2+4*niveauxC1)) deltaY = 8+4*niveauxC3+4*niveauxC2+4*niveauxC1 ;        
        
		StdDraw.setPenColor(StdDraw.RED);
		double h1 = 10+4*niveauxC3+4*niveauxC2+4*niveauxC1;
	    while (spawn1<4 || spawn1>116) {
	    spawn1 = randomGenerator.nextInt(9); }
        StdDraw.filledCircle(spawn1,h1-deltaY,1);
        StdDraw.picture(spawn1, h1-deltaY,"plongeur.png");
        
        
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.filledRectangle(X_MAX/2,(2+4*niveauxC3),58,2);
		StdDraw.filledRectangle(X_MAX/2,(6+4*niveauxC3+4*niveauxC2),58,2);
		
        StdDraw.show(120);
        
        	}
        }
        
}