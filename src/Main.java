import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static boolean stopMusic =true;

    static  String path;

    static Clip clip;



    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new MainMenu());


//        SwingUtilities.invokeLater(() ->new Enemies());

    }

    public static void music()
    {
        try {//Carpenter Brut.wav
            path = "Hydrogen by MOON.wav";

            Rythm song = new Rythm(path);

            song.clip.start();

            while(stopMusic)
            {
                String sing = path;

                System.out.println("Now playing...");

                System.out.println("-_-_-_-_ "+sing+ " -_-_-_-_");



                break;
            }

        }
        catch (Exception ex)
        {
            System.out.println("oops error");
        }
    }


}
