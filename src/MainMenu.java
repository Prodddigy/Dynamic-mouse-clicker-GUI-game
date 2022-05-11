import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MainMenu extends JFrame {


    MainMenu()
    {

        //JFrame frame = new JFrame("TURBO KILLER");

    //   final ImageIcon backGround = new ImageIcon("HotlineMiamiBack.gif");

       // JLabel title = new JLabel("TURBO KILLER");

      //  JButton start = new JButton("Start");

      ///  JButton highScore = new JButton("High Score");

       // JButton exit = new JButton("Exit");

        JFrame frame = new JFrame("Display an image in the background");
        final ImageIcon icon = new ImageIcon("HotlineMiamiBack.gif");


        JTextArea text = new JTextArea() {
            Image img = icon.getImage();

            // instance initializer
            {
                setOpaque(false);
            }

            public void paintComponent(Graphics graphics) {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }

            @Override
            public boolean isEditable() {
                return false;
            }
        };
        JScrollPane pane = new JScrollPane(text);
        Container content = frame.getContentPane();
        content.add(pane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(3);
        frame.setSize(447, 251);
        frame.setVisible(true);

    }
}
