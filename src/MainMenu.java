import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MainMenu extends JFrame {


Player newPlayer ;


    MainMenu()
    {

        JFrame frame = new JFrame("Display an image in the background");
       ImageIcon icon = new ImageIcon("HotlineMiamiBack.gif");

        //JFrame frame = new JFrame("TURBO KILLER");

    //   final ImageIcon backGround = new ImageIcon("HotlineMiamiBack.gif");

       // JLabel back = new JLabel();

       // JLabel title = new JLabel("TURBO KILLER");

        JButton start = new JButton("Start");
        JPanel panel = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Toolkit.getDefaultToolkit().getImage("HotlineMiamiBack.gif"), 0,0,1200, 600, this);
            }
        };

        //JLabel background = new JLabel(icon);



        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            newPlayer = new Player("Tim");

            for( Player tmp : Player.TopPlayers)
            {
                System.out.println(tmp);
            }

                SwingUtilities.invokeLater(() ->new Enemies(newPlayer));

                Enemies.setPlayerHp(20);
            }
        });

        frame.setSize(1200, 600);

       start.setBounds(frame.getWidth()/2-100,frame.getHeight()/2-20, 200,40);

        panel.add(start);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);




    }
}
