import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Multiple extends JButton {
    private int enemyHealth;

    private boolean dance =true;

    Multiple(String text, ImageIcon icon,JPanel panel, JFrame frame)
    {
        super(text,icon);

        Multiple tmp = this;
this.setBounds(frame.getWidth()/2 -150,frame.getHeight()/2 -150,300,300);
        System.out.println(getLocation()+ " location now");
        this.danceBaby();
        System.out.println(getLocation() + "location after");


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
                    //dance = false;

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

    public void danceBaby() {

        final Point point = getLocation();
        final int delay = 1000;
        System.out.println("danceBaby loc"+ getLocation());
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {

                        moveButton(new Point(point.x + 100, point.y));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x, point.y - 100));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x - 100, point.y));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x , point.y + 100));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        Thread dd = new Thread(r);
        dd.start();

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
}
