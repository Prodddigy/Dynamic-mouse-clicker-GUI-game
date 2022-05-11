import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Rythm {

    AudioInputStream input;
    static Clip clip;

    public Rythm(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {

        input = AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());

        clip = AudioSystem.getClip();
        clip.open(input);
        clip.loop(Clip.LOOP_CONTINUOUSLY);



    }
}
