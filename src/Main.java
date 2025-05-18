import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

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
        //pin.ipadx = 50;
        //pin.ipady = 70;

        JButton button = new JButton();

        space.add(button);
        frame.add(button,pin);

        // set size
        Dimension size = new Dimension(80,80);
        button.setPreferredSize(size);
        button.setMinimumSize(size);
        button.setMaximumSize(size);
        // removes box around button text
        button.setFocusPainted(false);
        // makes button background transparent
        button.setBackground(new Color(255,0,0,0));
        // removes opaque background when the button is hovered
        button.setOpaque(false);

        button.addActionListener(event -> {
            System.out.printf("x: %d, y: %d\n",k,i);
            if(select == null){} // does nothing
            else{
                String numtext = Integer.toString(select);
                button.setText(numtext);
            }
        });
    }

    // creates the buttons that allow the user to pick a number
    public static void createNumButton(int num, JFrame frame, GridBagConstraints n, List<Integer> nums){
        n.gridx = num;
        n.gridy = 10;
        n.ipadx = 0;
        n.ipady = 0;

        JButton button = new JButton(String.format("%d",num));
        frame.add(button,n);

        // makes button background transparent
        button.setBackground(new Color(255,0,0,0));
        // removes opaque background when the button is hovered
        button.setOpaque(false);
        // removes button border
        button.setBorderPainted(false);
        // removes button text border
        button.setFocusPainted(false);

        button.addActionListener(e ->{
            System.out.printf("button %d clicked\n",num);
            setNum(num);
        });
    }

    public static void generate(){

        Random random = new Random();
        int[][][] order = new int[9][3][3];

        for(int i = 0; i <= 8; i++){ // each 3x3 grid
            List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            for(int j = 0; j <= 2; j++){ // y
                for(int k = 0; k <= 2; k++){ // x
                    // select a number 1-9 from the list nums at random
                    int ranint = random.nextInt(0,nums.size());
                    int num = nums.get(ranint);

                    if(i == 0){ // base case for grid 1
                        order[i][j][k] = num; // add to list of 2D Arrays
                        nums.remove(ranint); // remove the selected number from the list
                    }
                    else if(i == 1){ // for grid 2
                        for(int  y= 0; y <= 2; y++){
                            if (order[0][y][0] != num && order[0][y][1] != num && order[0][y][2] != num) {
                                if(order[i][y][k] == 0) {
                                    order[i][j][k] = num;
                                    nums.remove(ranint);
                                    break;
                                }
                            }
                        }
                    } else if(i == 2){ // for grid 3
                        for (int y = 0; y <= 2; y++) {
                                if(num != order[0][y][0] && num != order[0][y][1] &&
                                        num != order[0][y][2] && num != order[1][y][0] &&
                                        num != order[1][y][1] && num != order[1][y][2]){
                                        order[i][j][k] = num;
                                        nums.remove(ranint);
                                        break;
                                }
                        }
                    } else if(i==3){ // for grid 4
                        outer:
                        for(int y = 0; y <=2; y++){
                            for(int x = 0; x<=2; x++){
                                if(num != order[0][0][x] &&
                                        num != order[0][1][x] &&
                                        num != order[0][2][x]){
                                    order[i][y][x] = num;
                                    nums.remove(ranint);
                                    break outer;
                                }
                            }
                        }
                    } else if(i==4){ // for grid 5
                        outer:
                        for(int y = 0; y <= 2; y++){
                            for(int x = 0; x<= 2; x++){
                                if(num != order[3][y][0] && num != order[3][y][1] &&
                                        num != order[3][y][2] && num != order[1][0][x] &&
                                        num != order[1][1][x] && num != order[1][2][x]){
                                    order[i][y][x] = num;
                                    nums.remove(ranint);
                                    break outer;
                                }
                            }
                        }
                    } else if(i==5){ // for grid 6
                        outer:
                        for(int y = 0; y <= 2; y++){
                            for(int x = 0; x<= 2; x++){
                                if(num != order[3][y][0] && num != order[3][y][1] &&
                                        num != order[3][y][2] && num != order[4][y][0] &&
                                        num != order[4][y][1] && num != order[4][y][2] &&
                                        num != order[2][0][x] && num != order[2][1][x] &&
                                        num != order[2][2][x]){
                                    order[i][y][x] = num;
                                    nums.remove(ranint);
                                    break outer;
                                }
                            }
                        }
                    } else if(i==6){ // for grid 7
                        outer:
                        for(int y = 0; y <= 2; y++){
                            for(int x = 0; x<= 2; x++){
                                if(num != order[0][0][x] && num != order[0][1][x] &&
                                        num != order[0][2][x] && num != order[3][0][x] &&
                                        num != order[3][1][x] && num != order[3][2][x]){
                                    order[i][y][x] = num;
                                    nums.remove(ranint);
                                    break outer;
                                }
                            }
                        }
                    } else if(i==7){ // for grid 8
                        outer:
                        for(int y = 0; y <= 2; y++){
                            for(int x = 0; x<= 2; x++){
                                if(num != order[6][y][0] && num != order[6][y][1] &&
                                        num != order[6][y][2] && num != order[1][0][x] &&
                                        num != order[1][1][x] && num != order[1][2][x] &&
                                        num != order[4][0][x] && num != order[4][1][x] &&
                                        num != order[4][2][x]){
                                    order[i][y][x] = num;
                                    nums.remove(ranint);
                                    break outer;
                                }
                            }
                        }
                    } else{ // for grid 9
                        outer:
                        for(int y = 0; y <= 2; y++){
                            for(int x = 0; x<= 2; x++){
                                if(num != order[6][y][0] && num != order[6][y][1] &&
                                        num != order[6][y][2] && num != order[7][y][0] &&
                                        num != order[7][y][1] && num != order[7][y][2] &&
                                        num != order[2][0][x] && num != order[2][1][x] &&
                                        num != order[2][2][x] && num != order[5][0][x] &&
                                        num != order[5][1][x] && num != order[5][2][x]){
                                    order[i][y][x] = num;
                                    nums.remove(ranint);
                                    break outer;
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int z = 0; z <= 8; z++){
            for(int y = 0; y <= 2; y++){
                for(int x = 0; x <= 2; x++){
                    System.out.printf("%d", order[z][x][y]);
                }
                System.out.println("\n");
            }
            if(z == 2 || z == 5 || z == 8){
                System.out.println("\n");
            }else{System.out.println(" ");}
        }
    }

    public static void main(String[] args){
        generate();
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
            pin.insets = new Insets(0,0,0,0);

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
        mainframe.setMinimumSize(new Dimension(1000,900));
        mainframe.setLocationRelativeTo(null); // centers the frame
        mainframe.setVisible(true);
    }

}