import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Test {

    public static void main (String args[]) {
        //retrieve the local screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        final int screen_Width = dim.width;
        final int screen_Height = dim.height;

        //Create a JFrame
        JFrame frame = new JFrame();

        frame.setSize(screen_Width , screen_Height);

        //set properties for the JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setLayout( null );

        frame.setVisible(true); } 
	
}
