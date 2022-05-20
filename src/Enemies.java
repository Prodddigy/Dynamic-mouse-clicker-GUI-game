import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Currency;
import java.util.Scanner;

public class Enemies extends JFrame implements WindowListener {

    private
    boolean killed = true;

//    private int enemyHealth;
    private JButton rooster;

    Thread music = new Thread(() -> {
        Main.music();

    });

    public Enemies(Player newPlayer)
    {

        music.start();

        JPanel panel = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Toolkit.getDefaultToolkit().getImage("HotlineMiamiBack.gif"), 0,0,1200, 600, this);
            }
        };

        JFrame frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println("works ?");
                Rythm.clip.stop();
            }
        });



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

                Multiple enem = new Multiple("SHOOT HP-> " + 10, roo, panel, frame, point, 2,killed);

                enem.setBounds(frame.getWidth() - (200 * i) - 35, frame.getHeight() - (400 / j) - 35, 70, 70);
                System.out.println(enem.getLocation()+" enemies location hello");
                panel.add(enem);
            }
            else {
                Multiple enem = new Multiple("SHOOT HP-> " + 10, roo, panel, frame, point, 1,killed);

                enem.setBounds(frame.getWidth() - (200 * i) - 35, frame.getHeight() - (400 / j) - 35, 70, 70);
                System.out.println(enem.getLocation()+" enemies location hello");
                panel.add(enem);

            }


            }
        }


      //  panel.add(new Multiple("SHOOT HP-> "+10,new ImageIcon("rooster.gif"),panel).setBounds(175,100,100,100););
       // panel.add(new Multiple("SHOOT HP-> "+10,new ImageIcon("rooster.gif"),panel).setBounds(525,300,100,100););




        ImageIcon axeImIc =new ImageIcon("axe.png");


        Image axeIm = axeImIc.getImage();
      final Image  axeImage = axeIm.getScaledInstance(200,200,Image.SCALE_DEFAULT);
axeIm = axeImage.getScaledInstance(50,50, Image.SCALE_DEFAULT);
        axeImIc =new ImageIcon(axeIm);
        JButton axe = new JButton(axeImIc);



        ImageIcon batImIc =new ImageIcon("bat.png");


        Image batIm = batImIc.getImage();
      final Image  batImage = batIm.getScaledInstance(200,200,Image.SCALE_DEFAULT);
        batIm = batImage.getScaledInstance(50,50, Image.SCALE_DEFAULT);
        batImIc =new ImageIcon(batIm);
        JButton bat = new JButton(batImIc);

        ImageIcon swordImIc =new ImageIcon("sword.png");


        Image swordIm = swordImIc.getImage();
       final Image swordImage = swordIm.getScaledInstance(70,70,Image.SCALE_DEFAULT);
        swordIm = swordImage.getScaledInstance(50,50, Image.SCALE_DEFAULT);


        swordImIc =new ImageIcon(swordIm);
        JButton sword = new JButton(swordImIc);

        panel.add(bat);
        panel.add(axe);
        panel.add(sword);
        panel.revalidate();
        panel.repaint();

        bat.setBounds(1150-50,150,50,50);
        axe.setBounds(1150-50,200, 50,50);
        sword.setBounds(1150-50,250, 50,50);

        bat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Toolkit toolkit = Toolkit.getDefaultToolkit();

                Cursor a = toolkit.createCustomCursor(batImage, new Point(0,0),"bat");
                frame.setCursor(a);
            }
        });

        axe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Toolkit toolkit = Toolkit.getDefaultToolkit();

                Cursor a = toolkit.createCustomCursor(axeImage, new Point(0,0),"bat");
                frame.setCursor(a);

            }
        });
        sword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Toolkit toolkit = Toolkit.getDefaultToolkit();



                Cursor a = toolkit.createCustomCursor(swordImage, new Point(0,0),"bat");


                frame.setCursor(a);

            }
        });

        //this.danceBaby();
        frame.add(panel);
//        frame.addWindowListener(listener);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setVisible(true);
    }


    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("works ?");
        Main.clip.stop();

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}



