import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MultipleSaws extends JButton {


    private int enemyHealth;

    private boolean metal;


    private boolean killed =false;
    private int hp;

    Thread dd;



MultipleSaws(ImageIcon icon, JPanel panel, JFrame frame,Point point, int position, Player newplayer )
{
    super(icon);
    MultipleSaws tmp = this;

    danceBaby_but_diagonally(position,point,panel,tmp,frame);

    addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        if(Enemies.isMetal()) {

            screamPlease();
            newplayer.setScore(10000);

            Enemies.updatePts();
            //killed =false;
            panel.remove(tmp);

            panel.revalidate();

            panel.repaint();

            tmp.killed = true;
            setEnabled(false);
        }
        }
    });

}

    public void screamPlease()
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("will.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex)
        {
            ex.printStackTrace( );
        }
    }

    public void danceBaby_but_diagonally(int position,Point point, JPanel panel, MultipleSaws tmp, JFrame frame) {
        final int delay = 7;
        // System.out.println("danceBaby loc"+ getLocation());
        if( position ==2) {
            Runnable r = new Runnable() {
                @Override
                public void run() {

                    System.out.println("sawblade");
                    System.out.println(point);
                        //Point tmp1 = null;
                       // Point tmp2= null;
                        try {
                            for (int i = 1; i <= 680; i++) {

                               setLocation(point.x-i,point.y-i);
                                Thread.sleep(delay);
                               // tmp1.x = point.x ;
                                // tmp2.y = point.y ;

                                if (killed) {
                                    break;
                                }



                                if(i == 580)
                                    System.out.println("last point" +point);
                            }

                            for (int i = 1; i <= 580; i++) {



                                moveButton(new Point((point.x-680) - i, (point.y-580) + i));
                                Thread.sleep(delay);

                                if (killed) {
                                    break;
                                }

                                if ((point.x-680)-i < 0) {
                                    System.out.println("is removed");
                                    panel.remove(tmp);
                                    Enemies.getPlayerHp(10);

                                    Enemies.updateHp();

                                    System.out.println("done by saw"+Enemies.getPlayerHp(0));

                                    if (Enemies.getPlayerHp(0) <= 0) {
                                        Multiple.gameOver(panel);
                                        panel.add(new JButton("Game over")).setBounds(600 - 200, 300 - 50, 200, 50);

                                    }
                                    break;
                                }
                            }
                            System.out.println("AFTERpoint value"+ point);

                        }catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

            };
            dd = new Thread(r);
            dd.start();
        }
        else
        {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 1; i <= 580; i++) {

                            setLocation(point.x-i,point.y+i);
                            Thread.sleep(delay);
                            // tmp1.x = point.x ;
                            // tmp2.y = point.y ;

                            if (killed) {
                                break;
                            }

                            if(i == 580)
                                System.out.println("last point" +point);
                        }

                        for (int i = 1; i <= 580; i++) {



                            moveButton(new Point((point.x-680) - i, (point.y+580) - i));
                            Thread.sleep(delay);

                            if (killed) {
                                break;
                            }

                            if ((point.x-680)-i < 0) {
                                System.out.println("is removed");
                                panel.remove(tmp);
                                Enemies.getPlayerHp(10);

                                Enemies.updateHp();

                                System.out.println("done by saw"+Enemies.getPlayerHp(0));

                                if (Enemies.getPlayerHp(0) <= 0) {
                                    Multiple.gameOver(panel);
                                    panel.add(new JButton("Game over")).setBounds(600 - 200, 300 - 50, 200, 50);

                                }
                                break;
                            }
                        }
                        System.out.println("AFTERpoint value"+ point);

                    }catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }
            };
            dd = new Thread(r);
            dd.start();
        }
    }
    private void moveButton( Point p) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLocation(p);
            }
        });
    }

}
