import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
			
public class Sound2 {

			    public File content;
			    
			    public Sound2(String nom)
			    throws Exception
			    {
			        this.content = new File(nom);
			    }
			    
			    public void PlaySoundC()
			    throws Exception
			    {
			        Clip clip = AudioSystem.getClip();
			        clip.open(AudioSystem.getAudioInputStream(this.content));
			        clip.loop(Clip.LOOP_CONTINUOUSLY);
			    }
			    public void PlaySound()
			    throws Exception
			    {
			        Clip clip = AudioSystem.getClip();
			        clip.open(AudioSystem.getAudioInputStream(this.content));
			        clip.start();
			    }
	
}

