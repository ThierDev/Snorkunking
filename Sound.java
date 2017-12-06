import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Scanner;

    public class Sound extends Main {
    	
    	public static void launchMusic() 
            throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int m = 0;
        AudioInputStream in = AudioSystem.getAudioInputStream(new File("GuileTheme.wav"));
        AudioInputStream in2 = AudioSystem.getAudioInputStream(new File("GuileTheme.wav"));
        Clip test = AudioSystem.getClip();
        Clip test2 = AudioSystem.getClip();
        test.open(in);
        test.loop(Clip.LOOP_CONTINUOUSLY);
    }  
   }