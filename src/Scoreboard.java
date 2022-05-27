import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class Scoreboard extends AbstractListModel {


    private ArrayList<Player> topplayers;

    public Scoreboard(ArrayList<Player> topplayers){

        this.topplayers = topplayers;

        JFrame jFrame = new JFrame();
        JList<String> jList = new JList<>();
        jList.setModel(new AbstractListModel<String>() {
            @Override
            public int getSize() {
                return topplayers.size();
            }

            @Override
            public String getElementAt(int index) {
                return topplayers.get(index).toString();
            }
        });


        jFrame.add(new JScrollPane(jList));
        jFrame.setSize(300, 300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);

    }

    @Override
    public int getSize() {
        return topplayers.size();
    }

    @Override
    public String getElementAt(int index) {
        return topplayers.get(index).toString();
    }
}
