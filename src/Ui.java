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
        GridBagConstraints menu = new GridBagConstraints();
        menu.insets = new Insets(20,10,20,10); // padding

        // widgets set up
        JLabel intro = new JLabel("Sudoku");
        JButton start = new JButton("New Game");

        // add child widgets to parent frame
        // add label
        menu.gridx = 0;
        menu.gridy = 0;
        menu.ipadx = 100;
        menu.ipady = 100;
        mainframe.add(intro,menu);

        // add start button
        menu.gridx = 0;
        menu.gridy = 1;
        menu.ipadx = 100;
        menu.ipady = 50;
        mainframe.add(start,menu);

        // event listener for start button
        start.addActionListener(event -> {
            intro.setVisible(false);
            start.setEnabled(false);
            start.setVisible(false);
            //Difficulty(mainframe);

        });

        // set the display
        mainframe.pack();
        mainframe.setMinimumSize(new Dimension(1000,900));
        mainframe.setLocationRelativeTo(null); // centers the frame
        mainframe.setVisible(true);
    }
}
