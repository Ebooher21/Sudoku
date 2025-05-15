import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Main {
    // global variable
    public static Integer select;

    // changes the user selected number
    public static void setNum(int num){
        select = num;
        System.out.println("setNum was called");
    }

    // retrieves the current user selected number
    // public static int getNum(){
    //     return select;
    // }

    // makes the empty spaces of the game board
    public static void createSpace(int i, int k, JFrame frame, GridBagConstraints pin, List<JButton> space){
        pin.gridx = k;
        pin.gridy = i;
        pin.ipadx = 50;
        pin.ipady = 50;

        JButton button = new JButton(" ");
        space.add(button);
        frame.add(button,pin);
        button.addActionListener(event -> {
            System.out.printf("x: %d, y: %d\n",k,i);
            String numtext = Integer.toString(select);
            button.setText(numtext);
        });
    }

    // creates the buttons that allow the user to pick a number
    public static void createNumButton(int num, JFrame frame, GridBagConstraints n, List<Integer> nums){
        n.gridx = num;
        n.gridy = 10;
        n.ipadx = 50;
        n.ipady = 50;

        JButton button = new JButton(String.format("%d",num));
        frame.add(button,n);
        button.addActionListener(e ->{
            System.out.printf("button %d clicked\n",num);
            setNum(num);
        });
    }

    public static void main(String[] args){
        // lists
        HashMap<Integer,Integer> location = new HashMap<>(); // x,y coordinates
        List<JButton> space = new ArrayList<>(); // buttons
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
            pin.insets = new Insets(2,2,2,2);

            // add empty spaces
            for(int i = 1; i <= 9; i++){
                for(int k = 1; k <= 9; k++){
                    location.put(k,i);
                    createSpace(i,k,mainframe,pin,space);
                }
            }

            // layout constraints for number buttons
            GridBagConstraints n = new GridBagConstraints();
            n.insets = new Insets(30,5,5,5);

            // add number selection buttons
            for(int i = 1; i <= 9; i++){
                nums.add(i);
                createNumButton(i,mainframe,n,nums);
            }
        });

        // set the display
        mainframe.pack();
        mainframe.setMinimumSize(new Dimension(800,600));
        mainframe.setLocationRelativeTo(null); // centers the frame
        mainframe.setVisible(true);
    }

}