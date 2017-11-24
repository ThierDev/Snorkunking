import java.io.* ;
import sun.audio.* ;

public class Sound
{
  public static void main(String[] args)
  throws Exception
  {
    // open the sound file as a Java input stream
    String gongFile = "/mnt/monster/home/eleves/v/ving10785/Téléchargements/1-welcome.wav";
    InputStream in = new FileInputStream(gongFile);

   // create an audiostream from the inputstream
    AudioStream audioStream = new AudioStream(in);

   // play the audio clip with the audioplayer class
    AudioPlayer.player.start(audioStream);
  }
}