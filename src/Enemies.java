import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enemies extends JFrame implements Runnable {

    private int enemyHealth;
    private JButton rooster;


    public Enemies()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton rooster = new JButton("SHOOT HP-> "+10,new ImageIcon("rooster.gif"));
        this.rooster = rooster;
        rooster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                shakeButton();
                enemyHealth++;

                System.out.println("SHOT: "+enemyHealth+" times");

                rooster.setText("SHOOT HP-> "+(10 - enemyHealth));
                rooster.setBackground(Color.RED);

                if( enemyHealth == 10)
                {
                    rooster.setEnabled(false);
                    rooster.setText("DECEASED");
                    rooster.setToolTipText("WELL DONE");
                }
            }
        });


        setLayout(new FlowLayout());

        rooster.setToolTipText("PULL THE TRIGGER");


        add(rooster);

        setSize(700,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);


    }


    public void danceBaby() {

        final Point point = rooster.getLocation();
        final int delay = 1000;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {

                        moveButton(new Point(point.x + 10, point.y));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x , point.y - 10));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x - 10, point.y));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                        moveButton(new Point(point.x , point.y + 10));
                        Thread.sleep(delay);
                        moveButton(point);
                        Thread.sleep(delay);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
    }

    @Override
    public void run() {

        danceBaby();
        rooster.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                shakeButton();
            }
        });
    }

    public void shakeButton() {
        final Point point = rooster.getLocation();
        final int delay = 10;

        
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
                rooster.setLocation(p);
            }
        });
    }
}
