import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multiple extends JButton{
    private int enemyHealth;

    private int playerHp =20;

    private boolean dance =true;

    private Point point;

    private JPanel panel;





    Multiple(String text, ImageIcon icon,JPanel panel, JFrame frame, Point point, int position, boolean killed)
    {


        super(text,icon);



this.panel = panel;

        this.point = point;
        Multiple tmp = this;
    //this.setBounds(frame.getWidth()/2 -150,frame.getHeight()/2 -150,300,300);
        System.out.println(point+ " location now");
        danceBaby(point,position,panel, tmp,frame);
        System.out.println(point + "location after");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("shake "+getLocation());
                shakeButton();
                enemyHealth++;

                System.out.println("SHOT: "+enemyHealth+" times");

                setText("SHOOT HP-> "+(10 - enemyHealth));
                setBackground(Color.RED);

                if( enemyHealth == 10)
                {
                     //killed =false;
                    panel.remove(tmp);

                    panel.revalidate();

                    panel.repaint();

                    setEnabled(false);
                    setText("DECEASED");
                    setToolTipText("WELL DONE");
                }
            }
        });
    }

    public void danceBaby(Point point, int position, JPanel panel, Multiple tmp, JFrame frame) {


        final int delay = 1000;
        System.out.println("danceBaby loc"+ getLocation());
    if( position ==2) {
    Runnable r = new Runnable() {
        @Override
        public void run() {
            while (true) {

                try {

                    moveButton(new Point(point.x, point.y - 100));
                    Thread.sleep(delay);
                    moveButton(point);
                    Thread.sleep(delay);
                    moveButton(new Point(point.x, point.y + 100));
                    Thread.sleep(delay);
                    moveButton(point);
                    Thread.sleep(delay);
                    moveButton(new Point(point.x - 50, point.y ));
                    Thread.sleep(delay);
                    moveButton(point);
                    Thread.sleep(delay);
                    point.x = point.x -50;

                    if(point.x <0)
                    {
                        panel.remove(tmp);

                        playerHp--;
                        if(playerHp<=0)
                        {
                            gameOver(panel);

                            panel.add(new JLabel("Game over")).setBounds(600-200, 300-50,200,50);

                        }
                        //subtract points from player
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };
    Thread dd = new Thread(r);
    dd.start();
}
else
{
    Runnable r = new Runnable() {
        @Override
        public void run() {
            while (true) {

                try {


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

                    if(point.x <0)
                    {
                        panel.remove(tmp);
                        playerHp-=20;
                        if(playerHp<=0)
                        {
                            gameOver(panel);

                            panel.add(new JLabel("Game over")).setBounds(600-200, 300-50,200,50);
                        }
                        //subtract points from player
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    };
    Thread dd = new Thread(r);
    dd.start();
}


    }



    public void shakeButton() {
        final Point point = getLocation();
        final int delay = 10;
        System.out.println("insideshake" + getLocation());

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {

                        moveButton(new Point(point.x + 5, point.y));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x , point.y - 5));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x - 5, point.y));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x , point.y + 5));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        Thread t = new Thread(r);
        t.start();
    }


    private void moveButton(final Point p) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLocation(p);
            }
        });
    }

    public static void gameOver(JPanel panel)
    {
        panel.removeAll();
    }


}
