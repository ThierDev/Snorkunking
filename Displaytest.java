import edu.princeton.cs.introcs.StdDraw;

public class Displaytest{
	public final static int X_MAX=12;
	public final static int Y_MAX=12;
	public final static float WIDTH=0.5f;

	public static void main(String[]args){
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
		for(int y=Y_MAX;y>=0;--y){
				for(int x=0;x<=X_MAX;++x){

StdDraw.clear(StdDraw.BLUE);

StdDraw.setPenColor(StdDraw.RED);

StdDraw.filledCircle(x,y,WIDTH);

StdDraw.show(500);

}
}

}
}