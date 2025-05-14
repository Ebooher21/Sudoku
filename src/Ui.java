import javax.swing.*;
import java.awt.*;

public class Ui extends JFrame{

    public JFrame getMainFrame(JFrame frame){
        return frame;
    }

    public Ui(){
        // creating the main frame
        JFrame mainframe = new JFrame("Sudoku");

        // exit when the frame is closed
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // layout manager
        mainframe.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();

        // padding
        con.insets = new Insets(5,5,5,5);

        // start menu set up
        JLabel intro = new JLabel("Sudoku");

        JButton start = new JButton("New Game");

        // add child widgets to parent frame
        // add title label
        con.gridx = 0;
        con.gridy = 0;
        con.ipadx = 50;
        con.ipady = 50;
        mainframe.add(intro,con);

        // add start button
        con.gridx = 0;
        con.gridy = 1;
        con.ipadx = 50;
        con.ipady = 100;
        mainframe.add(start,con);

        // event listener for start button
        start.addActionListener(e -> {
            intro.setVisible(false);
            start.setEnabled(false);
            start.setVisible(false);

        });

        // set the display
        mainframe.pack();
        mainframe.setMinimumSize(new Dimension(800,600));
        mainframe.setLocationRelativeTo(null); // centers the frame
        mainframe.setVisible(true);
    }
}
