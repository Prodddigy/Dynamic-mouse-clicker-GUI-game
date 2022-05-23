import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Enemies extends JFrame implements WindowListener {

  //  private
   // boolean killed = true;

    private static int playerHp =20;

    private static int playerPts = 0;

    private Thread waitForEnemy;

    JPanel panel;

    private boolean metal =false;

    private static Player player;

//    private int enemyHealth;
    private JButton rooster;

    private static JLabel scoreLabel;

    private static JLabel health;





    Thread music = new Thread(() -> {
        Main.music();

    });

    ArrayList<Multiple>enemies = new ArrayList<>();

    ArrayList<MultipleSaws>enemiesSaw = new ArrayList<>();

    public Enemies(Player newPlayer) throws InterruptedException {

        this.player = newPlayer;

        music.start();

         panel = new JPanel(null){
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

                panel.removeAll();

                for(Multiple tmp : enemies)
                {
                    tmp.setKilled(false);


                }

                System.out.println("works ?");
                Rythm.clip.stop();
            }
        });

        ImageIcon score =new ImageIcon("score.png");

        Image points = score.getImage();
        points = points.getScaledInstance(200,100,Image.SCALE_DEFAULT);

        score = new ImageIcon(points);

        JLabel scoreboard = new JLabel(score);

        scoreLabel = new JLabel( playerPts +"pts");

        scoreLabel.setFont(new Font(Font.DIALOG, Font.ITALIC,30));

        scoreLabel.setForeground(Color.MAGENTA);





        ImageIcon hp =new ImageIcon("hp.png");

        Image life = hp.getImage();
        life = life.getScaledInstance(75,75,Image.SCALE_DEFAULT);

         hp = new ImageIcon(life);

        JLabel healthPic = new JLabel(hp);

        health = new JLabel("HP" + playerHp+"/20");

        health.setFont(new Font(Font.DIALOG, Font.ITALIC,30));

        health.setForeground(Color.MAGENTA);


        ImageIcon chic =new ImageIcon("rooster.gif");


        Image back = chic.getImage();
        back = back.getScaledInstance(75,75,Image.SCALE_DEFAULT);

        ImageIcon roo = new ImageIcon(back);

        frame.setSize(1200,600);

        for (int j = 1; j < 3; j++) {

            for (int i = 1; i < 6; i++) {

             //   System.out.println(x + "y =  " + y);
            Point point = new Point (frame.getWidth() - (200 * i) - 75, frame.getHeight() - (400 / j) - 75);
            if(i%2 ==0) {

                Multiple enem = new Multiple("SHOOT HP-> " + 10, roo, panel, frame, point, 2, player);
                enemies.add(enem);
                enem.setBounds(frame.getWidth() - (200 * i) - 35, frame.getHeight() - (400 / j) - 35, 70, 70);
                System.out.println(enem.getLocation()+" enemies location hello");
                panel.add(enem);
            }
            else
            {
                Multiple enem = new Multiple("SHOOT HP-> " + 10, roo, panel, frame, point, 1,player);
                enemies.add(enem);
                enem.setBounds(frame.getWidth() - (200 * i) - 35, frame.getHeight() - (400 / j) - 35, 70, 70);
                System.out.println(enem.getLocation()+" enemies location hello");
                panel.add(enem);

            }


            }
        }

        ImageIcon sawImgIc =new ImageIcon("sawblade.png");


        Image sawImg = sawImgIc.getImage();
        sawImg = sawImg.getScaledInstance(40,40,Image.SCALE_DEFAULT);

        sawImgIc = new ImageIcon(sawImg);

       // JButton saw = new JButton(sawImgIc);


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
       final Image swordImage = swordIm.getScaledInstance(500,500,Image.SCALE_DEFAULT);
        swordIm = swordImage.getScaledInstance(50,50, Image.SCALE_DEFAULT);


        swordImIc =new ImageIcon(swordIm);
        JButton sword = new JButton(swordImIc);

        panel.add(health);
        panel.add(healthPic);

        panel.add(scoreLabel);
        panel.add(scoreboard);


        panel.add(bat);
        panel.add(axe);
        panel.add(sword);
        panel.revalidate();
        panel.repaint();

        healthPic.setBounds(1150-100,70,200,70);
        health.setBounds(1150-100,70,200,70);

        scoreboard.setBounds(600-200,550-100,200,100);
        scoreLabel.setBounds(650-200,570-100,200,100);


        //health.setOpaque(true);

        bat.setBounds(1150-50,150,50,50);
        axe.setBounds(1150-50,200, 50,50);
        sword.setBounds(1150-50,250, 50,50);


        bat.setOpaque(true);

        axe.setOpaque(true);
        sword.setOpaque(true);

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        Cursor a = toolkit.createCustomCursor(batImage, new Point(0,0),"bat");
        frame.setCursor(a);

        bat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metal = false;
                Toolkit toolkit = Toolkit.getDefaultToolkit();

                Cursor a = toolkit.createCustomCursor(batImage, new Point(0,0),"bat");
                frame.setCursor(a);
            }
        });

        axe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metal = false;
                Toolkit toolkit = Toolkit.getDefaultToolkit();

                Cursor a = toolkit.createCustomCursor(axeImage, new Point(0,0),"bat");
                frame.setCursor(a);

            }
        });
        sword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metal = true;
                Toolkit toolkit = Toolkit.getDefaultToolkit();



                Cursor a = toolkit.createCustomCursor(swordImage, new Point(0,0),"bat");


                frame.setCursor(a);

            }
        });

/*
for (int j = 1; j < 3; j++) {

            for (int i = 1; i < 6; i++) {

             //   System.out.println(x + "y =  " + y);
            Point point = new Point (frame.getWidth() - (200 * i) - 75, frame.getHeight() - (400 / j) - 75);
            if(i%2 ==0) {

                Multiple enem = new Multiple("SHOOT HP-> " + 10, roo, panel, frame, point, 2, player);
                enemies.add(enem);
                enem.setBounds(frame.getWidth() - (200 * i) - 35, frame.getHeight() - (400 / j) - 35, 70, 70);
                System.out.println(enem.getLocation()+" enemies location hello");
                panel.add(enem);
            }
            else
            {
                Multiple enem = new Multiple("SHOOT HP-> " + 10, roo, panel, frame, point, 1,player);
                enemies.add(enem);
                enem.setBounds(frame.getWidth() - (200 * i) - 35, frame.getHeight() - (400 / j) - 35, 70, 70);
                System.out.println(enem.getLocation()+" enemies location hello");
                panel.add(enem);

            }


            }
        }
 */

        ImageIcon finalSawImgIc = sawImgIc;
        waitForEnemy = new Thread(() -> {
            try {//45997
                Thread.sleep(1000);
                for (int i = 1; i <=6 ; i++) {



                    if(i%2==0)
                    {
                        Point point = new Point (1200-20, 0);
                        int position =1;
                        MultipleSaws enemSaw = new MultipleSaws(finalSawImgIc,panel,frame,point,position,player);
                        enemiesSaw.add(enemSaw);
                        enemSaw.setBounds(0-20,1200-20,40,40);
                        panel.add(enemSaw);
                        //saw.setLocation(0, 1200);
                        System.out.println("created");

                    }

                    if(i%2!=0)
                    {
                        Point point = new Point (1180, 580);
                        int position =2;
                        MultipleSaws enemSaw = new MultipleSaws(finalSawImgIc,panel,frame,point,position,player);
                        enemiesSaw.add(enemSaw);
                        enemSaw.setBounds(600-20,1200-20,40,40);
                        panel.add(enemSaw);
                        //saw.setLocation(0, 1200);
                        System.out.println("created");

                    }

                        sleep(500);
                }


                System.out.println("next enemy pls");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        waitForEnemy.start();

        //this.danceBaby();
        frame.add(panel);
//        frame.addWindowListener(listener);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setVisible(true);

//next enemy






    }



    @Override
    public void windowOpened(WindowEvent e) {


    }

    @Override
    public void windowClosing(WindowEvent e) {


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

    public static void setPlayerHp(int playerHp) {
        Enemies.playerHp = playerHp;
    }

    public static int getPlayerHp(int dmg) {
       playerHp = playerHp-dmg;
        return playerHp;
    }

    public static void updateHp()
    {
        System.out.println("Update hp"+ playerHp);
        health.setText("HP" + playerHp+"/20");
    }

    public static void updatePts()
    {
        System.out.println("Update score"+ player.getScore());
        scoreLabel.setText( player.getScore()+"pts");
    }

}



