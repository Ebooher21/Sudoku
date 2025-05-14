import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void createSpace(int i, int k, JFrame frame, GridBagConstraints con){
        con.gridx = k;
        con.gridy = i;
        con.ipadx = 50;
        con.ipady = 50;
        frame.add(new JButton(""),con);
    }

    public static void createNumButton(int num, JFrame frame, GridBagConstraints con, List<Integer> nums){
        con.gridx = num;
        con.gridy = 10;
        con.ipadx = 50;
        con.ipady = 50;

        JButton button = new JButton(String.format("%d",num));
        button.addActionListener(e ->{
            int select = nums.get(num-1);
        });
        frame.add(button,con);
    }

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
        // add label
        con.gridx = 0;
        con.gridy = 0;
        con.ipadx = 50;
        con.ipady = 50;
        mainframe.add(intro,con);

        // add empty spaces
        for(int i = 1; i <= 9; i++){
            for(int k = 1; k <= 9; k++){
                createSpace(i,k,mainframe,con);
        }}

        List<Integer> nums = new ArrayList<>();
        // add number selection buttons
        for(int i = 1; i <= 9; i++){
            nums.add(i);
            createNumButton(i,mainframe,con,nums);
        }

        // set the display
        mainframe.pack();
        mainframe.setMinimumSize(new Dimension(800,600));
        mainframe.setLocationRelativeTo(null); // centers the frame
        mainframe.setVisible(true);
    }

}