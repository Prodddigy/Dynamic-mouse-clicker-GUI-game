import javax.swing.*;
import java.awt.*;

public class MultipleSaws extends JButton {


private int enemyHealth;

private boolean metal;



    private boolean killed =true;
    private int hp;

    Thread dd;



MultipleSaws(ImageIcon icon, JPanel panel, JFrame frame,Point point, int position, Player player )
{
    super(icon);
    MultipleSaws tmp = this;

    danceBaby_but_diagonally(position,point,panel,tmp,frame);

}

    public void danceBaby_but_diagonally(int position,Point point, JPanel panel, MultipleSaws tmp, JFrame frame) {
        final int delay = 10;
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
                            for (int i = 1; i <= 580; i++) {

                               setLocation(point.x-i,point.y-i);
                                Thread.sleep(delay);
                               // tmp1.x = point.x ;
                                // tmp2.y = point.y ;

                                if (killed == false) {
                                    break;
                                }



                                if(i == 580)
                                    System.out.println("last point" +point);
                            }

                            //System.out.println("point value"+ point);
                          //  tmp.moveButton(new Point(600, 0));

                           // setLocation(580,0);
                            for (int i = 1; i <= 580; i++) {



                                moveButton(new Point((point.x-680) - i, (point.y-580) + i));
                                Thread.sleep(delay);
                                // point.x = point.x -i;
                                //  point.y = point.y -i;
                              //  System.out.println("point value"+ point);


                                if (killed == false) {
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
                    while (killed) {
                       /* try {
                            moveButton(new Point(point.x, point.y + 100));
                            Thread.sleep(delay);
                            moveButton(point);
                            Thread.sleep(delay);
                            moveButton(new Point(point.x, point.y - 100));
                            Thread.sleep(delay);
                            moveButton(point);
                            Thread.sleep(delay);
                            moveButton(new Point(point.x - 50, point.y ));
                            Thread.sleep(delay);
                            moveButton(point);
                            Thread.sleep(delay);

                            point.x = point.x -50;

                            if(killed == false)
                                break;

                            if(point.x <0)
                            {
                                panel.remove(tmp);

                                Enemies.getPlayerHp(1);

                                Enemies.updateHp();
                                //playerHp--;

                                System.out.println(Enemies.getPlayerHp(0));
                                if(Enemies.getPlayerHp(0)<=0)
                                {
                                    Multiple.gameOver(panel);

                                    panel.add(new JLabel("Game over")).setBounds(600-200, 300-50,200,50);
                                }
                                break;
                                //subtract points from player
                            }
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                        */
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
