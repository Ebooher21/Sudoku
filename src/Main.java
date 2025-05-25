import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

public class Main {
    // global variable
    public static Integer select;

    public static void difficulty(JFrame frame){
        JLabel message = new JLabel("Choose a Difficulty");
        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");

        frame.add(message);
        frame.add(easy);
        frame.add(medium);
        frame.add(hard);

        easy.addActionListener(e -> {

        });

        medium.addActionListener(e -> {

        });

        hard.addActionListener(e -> {

        });

    }

    public static int[][][] solution(){

        Random random = new Random();
        int[][][] order = new int[9][3][3];

        for(int i = 0; i <= 9; i++){ // each 3x3 grid
            List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
            for(int j = 0; j <= 2; j++){ // y
                for(int k = 0; k <= 2; k++){ // x

                    if(i == 0){ // base case for grid 1

                        // select a number 1-9 from the list nums at random
                        int ranint = random.nextInt(0,nums.size());
                        int num = nums.get(ranint);

                        order[i][j][k] = num; // add to list of 2D Arrays
                        nums.remove(ranint); // remove the selected number from the list

                    }else if(i==1){
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);
                            if(n == 8){
                                if(num == order[0][j][0] || num == order[0][j][1] ||
                                        num == order[0][j][2]){
                                    for(int b = 2; b >= 0; b--){
                                        if(order[i][j-1][b] != order[0][j][0] &&
                                                order[i][j-1][b] != order[0][j][1] &&
                                                order[i][j-1][b] != order[0][j][2])
                                        {
                                            if(num != order[0][j-1][0] &&
                                                    num != order[0][j-1][1] &&
                                                    num != order[0][j-1][2])
                                            {
                                                order[i][j][k] = order[i][j-1][b];
                                                order[i][j-1][b] = num;
                                                break outer;
                                            }
                                        }
                                    }
                                }
                            }
                            if(num != order[0][j][0] &&
                                    num != order[0][j][1] &&
                                    num != order[0][j][2])
                            {
                                if(order[i][j][k] == 0){
                                    order[i][j][k] = num;
                                    nums.remove(ranint);
                                    break;
                                }
                            }
                        }
                    } else if(i == 2){
                        boolean check = false;
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);
                            if(check){
                                n -= 1;
                                check = false;
                            }
                            if(num == order[0][j][0] || num == order[0][j][1] ||
                                    num == order[0][j][2] || num == order[1][j][0] ||
                                    num == order[1][j][1] || num == order[1][j][2])
                            {
                                if(j == 0){
                                    check = true;
                                    continue;
                                }
                                for(int b = 2; b >= 0; b--){
                                    if(order[i][j-1][b] != 0 && order[i][j-1][b] != order[0][j][0] &&
                                            order[i][j-1][b] != order[0][j][1] &&
                                            order[i][j-1][b] != order[0][j][2] &&
                                            order[i][j-1][b] != order[1][j][0] &&
                                            order[i][j-1][b] != order[1][j][1] &&
                                            order[i][j-1][b] != order[1][j][2])
                                    {
                                        if(order[i][j][k] == 0 && num != order[0][j-1][0] && num != order[0][j-1][1] &&
                                                num != order[0][j-1][2] && num != order[1][j-1][0] &&
                                                num != order[1][j-1][1] && num != order[1][j-1][2])
                                        {
                                            order[i][j][k] = order[i][j-1][b];
                                            order[i][j-1][b] = num;
                                            nums.remove(ranint);
                                            break outer;
                                        }
                                    }
                                }
                            }
                            if(num != order[0][j][0] && num != order[0][j][1] &&
                                    num != order[0][j][2] && num != order[1][j][0] &&
                                    num != order[1][j][1] && num != order[1][j][2])
                            {
                                if(order[i][j][k] == 0){
                                    order[i][j][k] = num;
                                    nums.remove(ranint);
                                    break;
                                }
                            }
                        }
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0){
                                        order[i][b][t] = nums.getLast();
                                    }
                                }
                            }
                        }
                    } else if(i==3){
                        boolean check = false;
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);
                            if(check){
                                n -= 1;
                                check = false;
                            }
                            if(num == order[0][0][k] || num == order[0][1][k] ||
                                    num == order[0][2][k])
                            {
                                if(k == 0){
                                    check = true;
                                    continue;
                                }
                                for(int b = 2; b >= 0; b--){
                                    if(order[i][b][k-1] != 0 && order[i][b][k-1] != order[0][0][k] && order[i][b][k-1] != order[0][1][k] &&
                                            order[i][b][k-1] != order[0][2][k])
                                    {
                                        if(num != order[0][0][k-1] && num != order[0][1][k-1] &&
                                                num != order[0][2][k-1])
                                        {
                                            order[i][j][k] = order[i][b][k-1];
                                            order[i][b][k-1] = num;
                                            nums.remove(ranint);
                                            break outer;
                                        }
                                    }
                                }
                            }
                            if(num != order[0][0][k] && num != order[0][1][k] &&
                                    num != order[0][2][k])
                            {
                                if(order[i][j][k] == 0){
                                    order[i][j][k] = num;
                                    nums.remove(ranint);
                                    break;
                                }
                            }
                        }

                    }else if(i==4){
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);

                            if(num == order[1][0][k] || num == order[1][1][k] ||
                                    num == order[1][2][k] || num == order[3][j][0] ||
                                    num == order[3][j][1] || num == order[3][j][2])
                            {
                                for(int b = 2; b >= 0; b--){
                                    for(int t=2; t>=0; t--){
                                        if(order[i][b][t] != 0 && order[i][b][t] != order[1][0][k] && order[i][b][t] != order[1][1][k] &&
                                                order[i][b][t] != order[1][2][k] && order[i][b][t] != order[3][j][0] &&
                                                order[i][b][t] != order[3][j][1] && order[i][b][t] != order[3][j][2])
                                        {
                                            if(order[i][j][k] == 0 && num != order[1][0][t] && num != order[1][1][t] &&
                                                    num != order[1][2][t] && num != order[3][b][0] &&
                                                    num != order[3][b][1] && num != order[3][b][2])
                                            {
                                                order[i][j][k] = order[i][b][t];
                                                order[i][b][t] = num;
                                                nums.remove(ranint);
                                                break outer;
                                            }

                                        }
                                    }
                                }
                            }
                            if(order[i][j][k] == 0 && num != order[1][0][k] && num != order[1][1][k] &&
                                    num != order[1][2][k] && num != order[3][j][0] &&
                                    num != order[3][j][1] && num != order[3][j][2]){
                                order[i][j][k] = num;
                                nums.remove(ranint);
                                break;
                            }

                        }
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0){
                                        order[i][b][t] = nums.getLast();
                                    }
                                }
                            }
                        }
                    }else if(i==5){
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);

                            if(num == order[3][j][0] || num == order[3][j][1] ||
                                    num == order[3][j][2] || num == order[4][j][0] ||
                                    num == order[4][j][1] || num == order[4][j][2] ||
                                    num == order[2][0][k] || num == order[2][1][k] ||
                                    num == order[2][2][k])
                            {
                                for(int b = 2; b >= 0; b--){
                                    for(int t = 2; t >= 0;t--){
                                        if(order[i][b][t] != 0 && order[i][b][t] != order[3][j][0] && order[i][b][t] != order[3][j][1] &&
                                                order[i][b][t] != order[3][j][2] && order[i][b][t] != order[4][j][0] &&
                                                order[i][b][t] != order[4][j][1] && order[i][b][t] != order[4][j][2] &&
                                                order[i][b][t] != order[2][0][k] && order[i][b][t] != order[2][1][k] &&
                                                order[i][b][t] != order[2][2][k]){
                                            if(num != order[3][b][0] && num != order[3][b][1] &&
                                                    num != order[3][b][2] && num != order[4][b][0] &&
                                                    num != order[4][b][1] && num != order[4][b][2] &&
                                                    num != order[2][0][t] && num != order[2][1][t] &&
                                                    num != order[2][2][t]){
                                                order[i][j][k] = order[i][b][t];
                                                order[i][b][t] = num;
                                                nums.remove(ranint);
                                                break outer;
                                            }
                                        }
                                    }

                                }
                            }
                            if(order[i][j][k] == 0 && num != order[3][j][0] &&
                                    num != order[3][j][1] && num != order[3][j][2] &&
                                    num != order[4][j][0] && num != order[4][j][1] &&
                                    num != order[4][j][2] && num != order[2][0][k] &&
                                    num != order[2][1][k] && num != order[2][2][k])
                            {
                                order[i][j][k] = num;
                                nums.remove(ranint);
                                break;

                            }
                        }
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0){
                                        order[i][b][t] = nums.getLast();
                                    }
                                }
                            }
                        }
                    }else if(i==6){
                        boolean check = false;
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);
                            if(check){
                                n -= 1;
                                check = false;
                            }
                            if(num == order[0][0][k] || num == order[0][1][k] ||
                                    num == order[0][2][k] || num == order[3][0][k] ||
                                    num == order[3][1][k] || num == order[3][2][k])
                            {
                                if(k == 0){
                                    check = true;
                                    continue;
                                }
                                for(int b = 2; b >= 0; b--){
                                    if(order[i][b][k-1] != 0 && order[i][b][k-1] != order[0][0][k] &&
                                            order[i][b][k-1] != order[0][1][k] &&
                                            order[i][b][k-1] != order[0][2][k] &&
                                            order[i][b][k-1] != order[3][0][k] &&
                                            order[i][b][k-1] != order[3][1][k] &&
                                            order[i][b][k-1] != order[3][2][k])
                                    {
                                        if(order[i][j][k] == 0 && num != order[0][0][k-1] && num != order[0][1][k-1] &&
                                                num != order[0][2][k-1] && num != order[3][0][k-1] &&
                                                num != order[3][1][k-1] && num != order[3][2][k-1])
                                        {
                                            order[i][j][k] = order[i][b][k-1];
                                            order[i][b][k-1] = num;
                                            nums.remove(ranint);
                                            break outer;
                                        }
                                    }
                                }
                            }
                            if(num != order[0][0][k] && num != order[0][1][k] &&
                                    num != order[0][2][k] && num != order[3][0][k] &&
                                    num != order[3][1][k] && num != order[3][2][k])
                            {
                                if(order[i][j][k] == 0){
                                    order[i][j][k] = num;
                                    nums.remove(ranint);
                                    break;
                                }
                            }
                        }
                    }else if(i==7){
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);

                            if(num == order[1][0][k] || num == order[1][1][k] ||
                                    num == order[1][2][k] || num == order[4][0][k] ||
                                    num == order[4][1][k] || num == order[4][2][k] ||
                                    num == order[6][j][0] || num == order[6][j][1] ||
                                    num == order[6][j][2])
                            {
                                for(int b = 2; b >= 0; b--){
                                    for(int t=2; t>=0; t--){
                                        if(order[i][b][t] != 0 && order[i][b][t] != order[1][0][k] && order[i][b][t] != order[1][1][k] &&
                                                order[i][b][t] != order[1][2][k] && order[i][b][t] != order[4][0][k] && order[i][b][t] != order[4][1][k] &&
                                                order[i][b][t] != order[4][2][k] && order[i][b][t] != order[6][j][0] &&
                                                order[i][b][t] != order[6][j][1] && order[i][b][t] != order[6][j][2])
                                        {
                                            if(order[i][j][k] == 0 && num != order[1][0][t] && num != order[1][1][t] &&
                                                    num != order[1][2][t] && num != order[4][0][t] && num != order[4][1][t] &&
                                                    num != order[4][2][t] && num != order[6][b][0] &&
                                                    num != order[6][b][1] && num != order[6][b][2])
                                            {
                                                order[i][j][k] = order[i][b][t];
                                                order[i][b][t] = num;
                                                nums.remove(ranint);
                                                break outer;
                                            }

                                        }
                                    }
                                }
                            }
                            if(order[i][j][k] == 0 && num != order[1][0][k] && num != order[1][1][k] &&
                                    num != order[1][2][k] && num != order[4][0][k] && num != order[4][1][k] &&
                                    num != order[4][2][k] && num != order[6][j][0] &&
                                    num != order[6][j][1] && num != order[6][j][2]){
                                order[i][j][k] = num;
                                nums.remove(ranint);
                                break;
                            }
                        }
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0){
                                        order[i][b][t] = nums.getLast();
                                        nums.removeLast();
                                    }
                                }
                            }
                        }
                    }else if(i==8){
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);

                            if(num == order[6][j][0] || num == order[6][j][1] ||
                                    num == order[6][j][2] || num == order[7][j][0] ||
                                    num == order[7][j][1] || num == order[7][j][2] ||
                                    num == order[2][0][k] || num == order[2][1][k] ||
                                    num == order[2][2][k] || num == order[5][0][k] ||
                                    num == order[5][1][k] || num == order[5][2][k])
                            {
                                for(int b = 2; b >= 0; b--){
                                    for(int t = 2; t >= 0;t--){
                                        if(order[i][b][t] != 0 && order[i][b][t] != order[6][j][0] &&
                                                order[i][b][t] != order[6][j][1] && order[i][b][t] != order[6][j][2] &&
                                                order[i][b][t] != order[7][j][0] && order[i][b][t] != order[7][j][1] &&
                                                order[i][b][t] != order[7][j][2] && order[i][b][t] != order[2][0][k] &&
                                                order[i][b][t] != order[2][1][k] && order[i][b][t] != order[2][2][k] &&
                                                order[i][b][t] != order[5][0][k] && order[i][b][t] != order[5][1][k] &&
                                                order[i][b][t] != order[5][2][k]){
                                            if(num != order[6][b][0] && num != order[6][b][1] &&
                                                    num != order[6][b][2] && num != order[7][b][0] &&
                                                    num != order[7][b][1] && num != order[7][b][2] &&
                                                    num != order[2][0][t] && num != order[2][1][t] &&
                                                    num != order[2][2][t] && num != order[5][0][t] &&
                                                    num != order[5][1][t] && num != order[5][2][t]){
                                                order[i][j][k] = order[i][b][t];
                                                order[i][b][t] = num;
                                                nums.remove(ranint);
                                                break outer;
                                            }
                                        }
                                    }
                                }
                            }
                            if(order[i][j][k] == 0 && num != order[6][j][0] &&
                                    num != order[6][j][1] && num != order[6][j][2] &&
                                    num != order[7][j][0] && num != order[7][j][1] &&
                                    num != order[7][j][2] && num != order[2][0][k] &&
                                    num != order[2][1][k] && num != order[2][2][k] &&
                                    num != order[5][0][k] && num != order[5][1][k] &&
                                    num != order[5][2][k])
                            {
                                order[i][j][k] = num;
                                nums.remove(ranint);
                                break;

                            }
                        }
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0){
                                        order[i][b][t] = nums.getFirst();
                                        nums.removeFirst();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return order;
    }

    // changes the user selected number
    public static void setNum(int num){
        select = num;
        System.out.println("setNum was called");
    }

    // makes the empty spaces of the game board
    public static void createSpace(int i, int k, JFrame frame, GridBagConstraints pin, List<JButton> space){
        pin.gridx = k;
        pin.gridy = i;

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

    public static void main(String[] args){
        // lists
        HashMap<Integer,Integer> location = new HashMap<>(); // x,y coordinates
        List<JButton> space = new ArrayList<>(); // buttons
        List<Integer> nums = new ArrayList<>(); // numbers choices
        Random random = new Random();

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

            int[][][] board = solution();
            List<Integer> amount = new ArrayList<>(Arrays.asList(3,4,5));
            // populate board
            for(int z = 0; z <= 8; z++){
                for(int y = 0; y <= 2; y++){
                    for(int x = 0; x <= 2; x++){
                        int num = board[z][y][x];
                        int pick = random.nextInt(0,amount.size());

                    }
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