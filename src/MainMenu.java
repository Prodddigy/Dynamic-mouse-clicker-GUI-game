import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Objects;

public class MainMenu extends JFrame {


Player newPlayer ;
    String nick="anonymous";

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

        start.setForeground(Color.MAGENTA);
        start.setFont(new Font(Font.DIALOG, Font.ITALIC,30));

        //JLabel background = new JLabel(icon);

        JLabel insertNick = new JLabel("Please insert your nickname");
        insertNick.setFont(new Font(Font.DIALOG, Font.ITALIC,30));

        insertNick.setForeground(Color.MAGENTA);

        JTextField nickname = new JTextField();


        nickname.setFont(new Font(Font.DIALOG, Font.ITALIC,30));
        nickname.setForeground(Color.MAGENTA);


        this.nick = nickname.getText();

        nickname.setOpaque(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(Objects.equals(nickname.getText(), "your nickname") || Objects.equals(nickname.getText(), "yournickname"))
                {
                    nickname.setText("very funny");
                }

            newPlayer = new Player(nickname.getText());

            for( Player tmp : Player.TopPlayers)
            {
                System.out.println(tmp);
            }

                SwingUtilities.invokeLater(() -> {
                    try {
                        new Enemies(newPlayer);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                });

                Enemies.setPlayerHp(20);
            }
        });


        JButton scoreboard = new JButton("ScoreBoard");
        scoreboard.setForeground(Color.MAGENTA);
        scoreboard.setFont(new Font(Font.DIALOG, Font.ITALIC,30));

        scoreboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> new Scoreboard(Player.TopPlayers));
            }
        });



        frame.setSize(1200, 600);

       start.setBounds(frame.getWidth()/2-100,frame.getHeight()/2-20, 200,40);
        nickname.setBounds(frame.getWidth()/2-400,frame.getHeight()/2-20, 200,40);
        insertNick.setBounds(frame.getWidth()/2-490,frame.getHeight()/2-70, 400,40);
        scoreboard.setBounds(frame.getWidth()/2-100,frame.getHeight()/2+80, 200,40);

       // start.setOpaque(false);
        panel.add(scoreboard);
        panel.add(insertNick);
        panel.add(nickname);
        panel.add(start);

        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);




    }
}
