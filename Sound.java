import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


    public class Sound extends Main {
    	
    	public static void launchMusic() 
            throws Exception
    {
        AudioInputStream in = AudioSystem.getAudioInputStream(new File("GuileTheme.wav"));
        Clip test = AudioSystem.getClip();
        test.open(in);
        test.loop(Clip.LOOP_CONTINUOUSLY);}  
   }