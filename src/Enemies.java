import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Enemies extends JFrame  {

//    private int enemyHealth;
    private JButton rooster;


    public Enemies()
    {
        JPanel panel = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Toolkit.getDefaultToolkit().getImage("HotlineMiamiBack.gif"), 0,0,1200, 600, this);
            }
        };

        JFrame frame = new JFrame();

//        JButton rooster = new JButton("SHOOT HP-> "+10,new ImageIcon("rooster.gif"));
//        this.rooster = rooster;
//        rooster.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                shakeButton();
//                enemyHealth++;
//
//                System.out.println("SHOT: "+enemyHealth+" times");
//
//                rooster.setText("SHOOT HP-> "+(10 - enemyHealth));
//                rooster.setBackground(Color.RED);
//
//                if( enemyHealth == 10)
//                {
//                    rooster.setEnabled(false);
//                    rooster.setText("DECEASED");
//                    rooster.setToolTipText("WELL DONE");
//                }
//            }
//        });

        ImageIcon chic =new ImageIcon("rooster.gif");


        //Image back = chic.getImage("HotlineMiamiBack.gif");
        //back = back.getScaledInstance(700,400,Image.SCALE_DEFAULT);
       // setLayout(new FlowLayout());

        //setToolTipText("PULL THE TRIGGER");


        frame.setSize(1200,600);
        for (int i = 0; i < 1; i++) {

            int x =0;
            int y= 0;


                 x = 350;
                 y = 200;

            System.out.println(x +"y =  " + y);

            Multiple enem =new Multiple("SHOOT HP-> "+10,new ImageIcon("rooster.gif"),panel,frame);
            enem.setBounds(frame.getWidth()/2 -150,frame.getHeight()/2 -150,300,300);
            panel.add(enem);


        }

      //  panel.add(new Multiple("SHOOT HP-> "+10,new ImageIcon("rooster.gif"),panel).setBounds(175,100,100,100););
       // panel.add(new Multiple("SHOOT HP-> "+10,new ImageIcon("rooster.gif"),panel).setBounds(525,300,100,100););

        //this.danceBaby();
        frame.add(panel);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setVisible(true);


    }

/*
    public void danceBaby() {

        final Point point = getLocation();
        final int delay = 1000;

        Runnable r = new Runnable() {
            @Override
            public void run() {
                while(true){
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

       // Thread t = new Thread(r);
//        t.start();
    }

    private void moveButton(final Point p) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                rooster.setLocation(p);
            }
        });

 */
    }



