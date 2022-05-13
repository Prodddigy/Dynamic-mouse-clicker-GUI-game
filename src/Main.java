import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.Scanner;

public class Main {


    static String path;
    static Clip clip;


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new MainMenu());


//        SwingUtilities.invokeLater(() ->new Enemies());






        try {//Carpenter Brut.wav
            path = "Hydrogen by MOON.wav";

            Rythm song = new Rythm(path);

            song.clip.start();

            Scanner scan = new Scanner(System.in);

            while(true)
            {
                String sing = path;

                System.out.println("Now playing...");

                System.out.println("-_-_-_-_ "+ sing+ " -_-_-_-_");
                System.out.println("press q to quit music");

                String q = scan.next();

                if(q == "q")
                    clip.stop();

                    break;


            }
            scan.close();
        }
        catch (Exception ex)
        {
            System.out.println("oops error");
        }



    }


}
