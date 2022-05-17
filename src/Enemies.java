import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Enemies extends JFrame  {



//    private int enemyHealth;
    private JButton rooster;




    public Enemies(Player newPlayer)
    {

            



        JPanel panel = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Toolkit.getDefaultToolkit().getImage("HotlineMiamiBack.gif"), 0,0,1200, 600, this);
            }
        };

        JFrame frame = new JFrame();



        ImageIcon chic =new ImageIcon("rooster.gif");


        Image back = chic.getImage();
        back = back.getScaledInstance(75,75,Image.SCALE_DEFAULT);
        //setLayout(new FlowLayout());

        //setToolTipText("PULL THE TRIGGER");

        ImageIcon roo = new ImageIcon(back);

        frame.setSize(1200,600);
        for (int j = 1; j < 3; j++) {

            for (int i = 1; i < 6; i++) {

             //   System.out.println(x + "y =  " + y);
            Point point = new Point (frame.getWidth() - (200 * i) - 75, frame.getHeight() - (400 / j) - 75);
            if(i%2 ==0) {

                Multiple enem = new Multiple("SHOOT HP-> " + 10, roo, panel, frame, point, 2);

                enem.setBounds(frame.getWidth() - (200 * i) - 35, frame.getHeight() - (400 / j) - 35, 70, 70);
                System.out.println(enem.getLocation()+" enemies location hello");
                panel.add(enem);
            }
            else {
                Multiple enem = new Multiple("SHOOT HP-> " + 10, roo, panel, frame, point, 1);

                enem.setBounds(frame.getWidth() - (200 * i) - 35, frame.getHeight() - (400 / j) - 35, 70, 70);
                System.out.println(enem.getLocation()+" enemies location hello");
                panel.add(enem);

            }


            }
        }


      //  panel.add(new Multiple("SHOOT HP-> "+10,new ImageIcon("rooster.gif"),panel).setBounds(175,100,100,100););
       // panel.add(new Multiple("SHOOT HP-> "+10,new ImageIcon("rooster.gif"),panel).setBounds(525,300,100,100););

        //this.danceBaby();
        frame.add(panel);
//        frame.addWindowListener(listener);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setVisible(true);
    }



    }



