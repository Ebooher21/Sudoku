import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args){
        // creating the main frame
        JFrame mainframe = new JFrame("Sudoku");

        // exit when the frame is closed
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // layout manager
        mainframe.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.insets = new Insets(5,5,5,5); // padding

        // widgets set up
        JLabel intro = new JLabel("Sudoku");
        intro.setSize(200,100);

        // add child widgets to parent frame
        con.gridx = 0;
        con.gridy = 0;
        mainframe.add(intro,con);

        //GridBagConstraints box = new GridBagConstraints();
        //box.insets = new Insets(5,5,5,5);
        for(int i = 1; i <= 9; i++){
            for(int k = 1; k <= 9; k++){
                con.gridx = k;
                con.gridy = i;
                JButton space = new JButton("");
                space.setSize(50,50);
                mainframe.add(space,con);

        }}

        // set the display
        mainframe.pack();
        mainframe.setMinimumSize(new Dimension(800,600));
        mainframe.setLocationRelativeTo(null); // centers the frame
        mainframe.setVisible(true);
    }
}