import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Thread.sleep;

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

            Rythm.clip.start();







        }
        catch (Exception ex)
        {
            System.out.println("oops error");
        }
    }


}
