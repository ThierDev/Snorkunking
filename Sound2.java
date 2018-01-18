import java.io.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

			
public class Sound2 {

			    public File content;
			    public Clip klip;
			    
			    public Sound2(String nom)
			    throws Exception
			    {
			        this.content = new File(nom);
			        this.klip = AudioSystem.getClip();
			    }
			    
			    public void LoadSound()
			    throws Exception 
			    {
			    	klip.open(AudioSystem.getAudioInputStream(this.content));
			    }
			    
			    public void PlaySoundC()
			    throws Exception
			    {
			    	klip.open(AudioSystem.getAudioInputStream(this.content));
			        klip.loop(Clip.LOOP_CONTINUOUSLY);
			    }
			    
			    public void Stop()
			    throws Exception
			    {
			        klip.close();
			    }
			    
			    public void PlaySound()
			    throws Exception
			    {
			        klip.open(AudioSystem.getAudioInputStream(this.content));
			        klip.start();
			    }
}

