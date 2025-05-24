import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ui extends JFrame{

    public JFrame getMainFrame(JFrame frame){
        return frame;
    }

    public Ui(){
        // lists
        HashMap<Integer,Integer> location = new HashMap<>(); // x,y coordinates
        java.util.List<JButton> space = new ArrayList<>(); // buttons
        List<Integer> nums = new ArrayList<>(); // numbers choices

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

            // layout constraints for empty spaces
            GridBagConstraints pin = new GridBagConstraints();
            pin.insets = new Insets(0,0,0,0);

            // layout constraints for number buttons
            GridBagConstraints n = new GridBagConstraints();
            n.insets = new Insets(30,5,5,5);

        });

        // set the display
        mainframe.pack();
        mainframe.setMinimumSize(new Dimension(1000,900));
        mainframe.setLocationRelativeTo(null); // centers the frame
        mainframe.setVisible(true);
    }
}
