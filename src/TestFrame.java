import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;

public class TestFrame {
    TestFrame(String[][] department,String[] columnnames) {
        JFrame frame = new JFrame("Departments");
        JTable table = new JTable(department, columnnames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(450, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
