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
                                                nums.remove(ranint);
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
                        int oldnum = 0;
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);
                            if(num == oldnum){
                                n-=1;
                                continue;
                            }
                            if(num == order[0][0][k] || num == order[0][1][k] ||
                                    num == order[0][2][k])
                            {
                                if(k == 0){
                                    n-=1;
                                    oldnum = num;
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
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0){
                                        if(order[i][b][t] != order[0][0][t] && order[i][b][t] != order[0][1][t] &&
                                                order[i][b][t] != order[0][2][t] && order[i][b][t] != order[3][0][t] &&
                                                order[i][b][t] != order[3][1][t] && order[i][b][t] != order[3][2][t]){
                                            order[i][b][t] = nums.getLast();
                                            nums.removeLast();
                                        }else{
                                            for(int l = 0; l <= 0; l++) {
                                                for (int m = 0; m <= 0; m++) {
                                                    if(order[i][l][m] != order[0][0][t] && order[i][l][m] != order[0][1][t] &&
                                                            order[i][l][m] != order[0][2][t] && order[i][l][m] != order[3][0][t] &&
                                                            order[i][l][m] != order[3][1][t] && order[i][l][m] != order[3][2][t]){
                                                        if(order[i][b][t] != order[0][0][m] && order[i][b][t] != order[0][1][m] &&
                                                                order[i][b][t] != order[0][2][m] && order[i][b][t] != order[3][0][m] &&
                                                                order[i][b][t] != order[3][1][m] && order[i][b][t] != order[3][2][m]){
                                                            order[i][l][m] = order[i][b][t];
                                                            order[i][b][t] = nums.getLast();
                                                            nums.removeLast();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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
                                        if(order[i][b][t] != order[1][0][t] && order[i][b][t] != order[1][1][t] &&
                                                order[i][b][t] != order[1][2][t] && order[i][b][t] != order[3][b][0] &&
                                                order[i][b][t] != order[3][b][1] && order[i][b][t] != order[3][b][2]){
                                            order[i][b][t] = nums.getLast();
                                            nums.removeLast();
                                        }else {
                                            for (int l = 0; l <= 0; l++) {
                                                for (int m = 0; m <= 0; m++) {
                                                    if (order[i][l][m] != order[1][0][t] && order[i][l][m] != order[1][1][t] &&
                                                            order[i][l][m] != order[1][2][t] && order[i][l][m] != order[3][l][0] &&
                                                            order[i][l][m] != order[3][l][1] && order[i][l][m] != order[3][l][2]) {
                                                        if (order[i][b][t] != order[1][0][m] && order[i][b][t] != order[1][1][m] &&
                                                                order[i][b][t] != order[1][2][m] && order[i][b][t] != order[3][l][0] &&
                                                                order[i][b][t] != order[3][l][1] && order[i][b][t] != order[3][l][2]) {
                                                            order[i][l][m] = order[i][b][t];
                                                            order[i][b][t] = nums.getLast();
                                                            nums.removeLast();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else if(i==5){
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);

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
                        }
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0) {
                                        if (order[i][b][t] != order[2][0][t] && order[i][b][t] != order[2][1][t] &&
                                                order[i][b][t] != order[2][2][t] && order[i][b][t] != order[3][b][0] &&
                                                order[i][b][t] != order[3][b][1] && order[i][b][t] != order[3][b][2] &&
                                                order[i][b][t] != order[4][b][0] && order[i][b][t] != order[4][b][1] &&
                                                order[i][b][t] != order[4][b][2]) {
                                            order[i][b][t] = nums.getLast();
                                            nums.removeLast();
                                        } else {
                                            for (int l = 0; l <= 0; l++) {
                                                for (int m = 0; m <= 0; m++) {
                                                    if (order[i][l][m] != order[2][0][t] && order[i][b][t] != order[2][1][t] &&
                                                            order[i][b][t] != order[2][2][t] && order[i][b][t] != order[3][b][0] &&
                                                            order[i][b][t] != order[3][b][1] && order[i][b][t] != order[3][b][2] &&
                                                            order[i][b][t] != order[4][b][0] && order[i][b][t] != order[4][b][1] &&
                                                            order[i][b][t] != order[4][b][2]) {
                                                        if (order[i][b][t] != order[2][0][m] && order[i][b][t] != order[2][1][m] &&
                                                                order[i][b][t] != order[2][2][m] && order[i][b][t] != order[3][l][0] &&
                                                                order[i][b][t] != order[3][l][1] && order[i][b][t] != order[3][l][2] &&
                                                                order[i][b][t] != order[4][l][0] && order[i][b][t] != order[4][l][1] &&
                                                                order[i][b][t] != order[4][l][2]) {
                                                            order[i][l][m] = order[i][b][t];
                                                            order[i][b][t] = nums.getLast();
                                                            nums.removeLast();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else if(i==6){
                        int oldnum = 0;
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);
                            if(oldnum == num){
                                n -= 1;
                                continue;
                            }
                            if(num == order[0][0][k] || num == order[0][1][k] ||
                                    num == order[0][2][k] || num == order[3][0][k] ||
                                    num == order[3][1][k] || num == order[3][2][k])
                            {
                                if(k == 0){
                                    n-=1;
                                    oldnum = num;
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
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0){
                                        if(order[i][b][t] != order[0][0][t] && order[i][b][t] != order[0][1][t] &&
                                                order[i][b][t] != order[0][2][t] && order[i][b][t] != order[3][0][t] &&
                                                order[i][b][t] != order[3][1][t] && order[i][b][t] != order[3][2][t]){
                                            order[i][b][t] = nums.getLast();
                                            nums.removeLast();
                                        }else{
                                            for(int l = 0; l <= 0; l++) {
                                                for (int m = 0; m <= 0; m++) {
                                                    if(order[i][l][m] != order[0][0][t] && order[i][l][m] != order[0][1][t] &&
                                                            order[i][l][m] != order[0][2][t] && order[i][l][m] != order[3][0][t] &&
                                                            order[i][l][m] != order[3][1][t] && order[i][l][m] != order[3][2][t]){
                                                        if(order[i][b][t] != order[0][0][m] && order[i][b][t] != order[0][1][m] &&
                                                                order[i][b][t] != order[0][2][m] && order[i][b][t] != order[3][0][m] &&
                                                                order[i][b][t] != order[3][1][m] && order[i][b][t] != order[3][2][m]){
                                                            order[i][l][m] = order[i][b][t];
                                                            order[i][b][t] = nums.getLast();
                                                            nums.removeLast();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else if(i==7){
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);

                            if(order[i][j][k] == 0 && num != order[1][0][k] && num != order[1][1][k] &&
                                    num != order[1][2][k] && num != order[4][0][k] && num != order[4][1][k] &&
                                    num != order[4][2][k] && num != order[6][j][0] &&
                                    num != order[6][j][1] && num != order[6][j][2]){
                                order[i][j][k] = num;
                                nums.remove(ranint);
                                break;
                            }

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
                        }
                        if(j==2 && k==2 && !nums.isEmpty()){
                            for(int b = 2; b >= 0; b--){
                                for(int t = 2; t >= 0;t--){
                                    if(order[i][b][t] == 0){
                                        if(order[i][b][t] != order[1][0][t] && order[i][b][t] != order[1][1][t] &&
                                                order[i][b][t] != order[1][2][t] && order[i][b][t] != order[4][0][t] && order[i][b][t] != order[4][1][t] &&
                                                order[i][b][t] != order[4][2][t] && order[i][b][t] != order[6][b][0] &&
                                                order[i][b][t] != order[6][b][1] && order[i][b][t] != order[6][b][2]){
                                            order[i][b][t] = nums.getLast();
                                            nums.removeLast();
                                        }else{
                                            for(int l = 0; l <= 0; l++) {
                                                for (int m = 0; m <= 0; m++) {
                                                    if(order[i][l][m] != order[1][0][t] && order[i][l][m] != order[1][1][t] &&
                                                            order[i][l][m] != order[1][2][t] && order[i][l][m] != order[4][0][t] && order[i][l][m] != order[4][1][t] &&
                                                            order[i][l][m] != order[4][2][t] && order[i][l][m] != order[6][b][0] &&
                                                            order[i][l][m] != order[6][b][1] && order[i][l][m] != order[6][b][2]){
                                                        if(order[i][b][t] != order[1][0][m] && order[i][b][t] != order[1][1][m] &&
                                                                order[i][b][t] != order[1][2][m] && order[i][b][t] != order[4][0][m] && order[i][b][t] != order[4][1][m] &&
                                                                order[i][b][t] != order[4][2][m] && order[i][b][t] != order[6][l][0] &&
                                                                order[i][b][t] != order[6][l][1] && order[i][b][t] != order[6][l][2]){
                                                            order[i][l][m] = order[i][b][t];
                                                            order[i][b][t] = nums.getLast();
                                                            nums.removeLast();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else if(i==8){
                        outer:
                        for(int n = 0; n <= 8; n++){
                            int ranint = random.nextInt(0,nums.size());
                            int num = nums.get(ranint);

                            if(j==2 && k==2 && !nums.isEmpty()){
                                for(int b = 2; b >= 0; b--){
                                    for(int t = 2; t >= 0;t--){
                                        if(order[i][b][t] == 0){
                                            if(order[i][b][t] != order[2][0][t] && order[i][b][t] != order[2][1][t] &&
                                                    order[i][b][t] != order[2][2][t] && order[i][b][t] != order[5][0][t] &&
                                                    order[i][b][t] != order[5][1][t] && order[i][b][t] != order[5][2][t] &&
                                                    order[i][b][t] != order[6][b][0] && order[i][b][t] != order[6][b][1] &&
                                                    order[i][b][t] != order[6][b][2] && order[i][b][t] != order[7][b][0] &&
                                                    order[i][b][t] != order[7][b][1] && order[i][b][t] != order[7][b][2]){
                                                order[i][b][t] = nums.getFirst();
                                                nums.removeFirst();
                                                if(nums.isEmpty()){
                                                    break outer;
                                                }
                                            }else{
                                                for(int l = 0; l <= 2; l++) {
                                                    for (int m = 0; m <= 2; m++) {
                                                        if(order[i][b][t] != order[i][l][m] && order[i][l][m] != order[2][0][t] && order[i][l][m] != order[2][1][t] &&
                                                                order[i][l][m] != order[2][2][t] && order[i][l][m] != order[5][0][t] &&
                                                                order[i][l][m] != order[5][1][t] && order[i][l][m] != order[5][2][t] &&
                                                                order[i][l][m] != order[6][b][0] && order[i][l][m] != order[6][b][1] &&
                                                                order[i][l][m] != order[6][b][2] && order[i][l][m] != order[7][b][0] &&
                                                                order[i][l][m] != order[7][b][1] && order[i][l][m] != order[7][b][2]){
                                                            if(order[i][b][t] != order[2][0][m] && order[i][b][t] != order[2][1][m] &&
                                                                    order[i][b][t] != order[2][2][m] && order[i][b][t] != order[5][0][m] &&
                                                                    order[i][b][t] != order[5][1][m] && order[i][b][t] != order[5][2][m] &&
                                                                    order[i][b][t] != order[6][l][0] && order[i][b][t] != order[6][l][1] &&
                                                                    order[i][b][t] != order[6][l][2] && order[i][b][t] != order[7][l][0] &&
                                                                    order[i][b][t] != order[7][l][1] && order[i][b][t] != order[7][l][2]){
                                                                order[i][l][m] = order[i][b][t];
                                                                order[i][b][t] = nums.getFirst();
                                                                nums.removeFirst();
                                                                if(nums.isEmpty()){
                                                                    break outer;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
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
                            else if(num == order[6][j][0] || num == order[6][j][1] ||
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
                        }
                    }
                }
            }
        }
        //final grid check
            for(int y = 0; y <= 2; y++){
              for(int x = 0; x <= 2; x++){
                if(order[8][y][x] == order[6][y][0] || order[8][y][x] == order[6][y][1] ||
                        order[8][y][x] == order[6][y][2] || order[8][y][x] == order[7][y][0] ||
                        order[8][y][x] == order[7][y][1] || order[8][y][x] == order[7][y][2] ||
                        order[8][y][x] == order[2][0][x] || order[8][y][x] == order[2][1][x] ||
                        order[8][y][x] == order[2][2][x] || order[8][y][x] == order[5][0][x] ||
                        order[8][y][x] == order[5][1][x] || order[8][y][x] == order[5][2][x]){
                        outer:
                        for(int i = 2; i >= 0; i--){
                          for(int j = 2; j >= 0; j--){
                             if(order[8][i][j] != order[8][y][x] && order[8][i][j] != order[6][y][0] &&
                                     order[8][i][j] != order[6][y][1] && order[8][i][j] != order[6][y][2] &&
                                     order[8][i][j] != order[7][y][0] && order[8][i][j] != order[7][y][1] &&
                                     order[8][i][j] != order[7][y][2] && order[8][i][j] != order[2][0][x] &&
                                     order[8][i][j] != order[2][1][x] && order[8][i][j] != order[2][2][x] &&
                                     order[8][i][j] != order[5][0][x] && order[8][i][j] != order[5][1][x] &&
                                     order[8][i][j] != order[5][2][x] && order[8][y][x] != order[6][i][0] &&
                                     order[8][y][x] != order[6][i][1] && order[8][y][x] != order[6][i][2] &&
                                     order[8][y][x] != order[7][i][0] && order[8][y][x] != order[7][i][1] &&
                                     order[8][y][x] != order[7][i][2] && order[8][y][x] != order[2][0][j] &&
                                     order[8][y][x] != order[2][1][j] && order[8][y][x] != order[2][2][j] &&
                                     order[8][y][x] != order[5][0][j] && order[8][y][x] != order[5][1][j] &&
                                     order[8][y][x] != order[5][2][j]) {
                                 int swapnum = order[8][i][j];
                                 order[8][i][j] = order[8][y][x];
                                 order[8][y][x] = swapnum;
                                 break outer;
                             }
                                //if (order[8][i][j] == order[6][y][0] || order[8][i][j] == order[6][y][1] ||
                                        //order[8][i][j] == order[6][y][2] || order[8][i][j] == order[7][y][0] || order[8][i][j] == order[7][y][1] ||
                                          //  order[8][i][j] == order[7][y][2] || order[8][i][j] == order[2][0][x] ||
                                            //order[8][i][j] == order[2][1][x] || order[8][i][j] == order[2][2][x] ||
                                           // order[8][i][j] == order[5][0][x] || order[8][i][j] == order[5][1][x] ||
                                           // order[8][i][j] == order[5][2][x]
                                    //) {
                                      //  if(order[8][i][j] != order[1][0][j] && order[8][i][j] != order[1][1][j] &&
                                        //        order[8][i][j] != order[1][2][j] && order[8][i][j] != order[4][0][j] &&
                                          //      order[8][i][j] != order[4][1][j] && order[8][i][j] != order[4][2][j] &&
                                            //    order[8][i][j] != order[6][i][0] && order[8][i][j] != order[6][i][1] &&
                                              //  order[8][i][j] != order[6][i][2] && order[7][i][j] != order[2][0][j] &&
                                                //order[7][i][j] != order[5][0][j] && order[7][i][j] != order[5][1][j] &&
                                                //order[7][i][j] != order[5][2][j] && order[7][i][j] != order[6][][]
                                        //){

                                        //}
                                    //}else if(order[8][y][x] == order[6][i][0] ||
                                      //      order[8][y][x] == order[6][i][1] || order[8][y][x] == order[6][i][2] ||
                                        //    order[8][y][x] == order[7][i][0] || order[8][y][x] == order[7][i][1] ||
                                          //  order[8][y][x] == order[7][i][2] || order[8][y][x] == order[2][0][j] ||
                                            //order[8][y][x] == order[2][1][j] || order[8][y][x] == order[2][2][j] ||
                                            //order[8][y][x] == order[5][0][j] || order[8][y][x] == order[5][1][j] ||
                                            //order[8][y][x] == order[5][2][j]){

                                    //}else{
                                      //  break outer;
                                    //}
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

    public static void generate(){

    }

    public static int convert_x(int x){
        if(x == 1 || x == 4 || x == 7){
            x = 0;
        }else if(x == 2 || x == 5 || x == 8){
            x = 1;
        }else{
            x = 2;
        }
        return x;
    }

    public static int convert_y(int y){
        if(y == 1 || y == 4 || y == 7){
            y = 0;
        }else if(y == 2 || y == 5 || y == 8){
            y = 1;
        }else{
            y = 2;
        }
        return y;
    }

    public static int findz(int x, int y){
        int z = 0;
        if(x <= 2 ){
            if(y <= 2){
                z = 0;
            }else if(y >= 3 && y <= 5){
                z = 3;
            }else if(y >= 6 && y <= 8){
                z = 6;
            }
        }else if(x >= 3 && x <= 5){
            if(y <= 2){
                z = 1;
            }else if(y >= 3 && y <= 5){
                z = 4;
            }else if(y >= 6 && y <= 8){
                z = 7;
            }
        }else if(x >= 6 && x <= 8){
            if(y <= 2){
                z = 2;
            }else if(y >= 3 && y <= 5){
                z = 5;
            }else if(y >= 6 && y <= 8){
                z = 8;
            }
        }
        return z;
    }

    // makes the empty spaces of the game board
    public static void createSpace(int x, int y, JFrame frame, GridBagConstraints pin, List<JButton> space, List<Integer> zaxis, int[][][] solution){
        pin.gridx = x;
        pin.gridy = y;

        int z = findz(x-1,y-1);
        int x2 = convert_x(x);
        int y2 = convert_y(y);

        JButton button = new JButton();

        zaxis.add(z);
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
        // adjust border width
        button.setBorder(SpaceBorder(z,y2,x2));

        // test: add numbers to board
        button.setText(String.valueOf(solution[z][y2][x2]));

        button.addActionListener(event -> {
            System.out.printf("x: %d, y: %d, z: %d\n",x,y,z+1);
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
        HashMap<Integer,Integer> location = new HashMap<>();// x,y coordinates
        List<JButton> space = new ArrayList<>(); // buttons
        List<Integer> zaxis = new ArrayList<>(); //grid positions
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

            int[][][] board = solution();
            List<Integer> amount = new ArrayList<>(Arrays.asList(4,5));

            // add empty spaces
            for(int y = 1; y <= 9; y++){
                for(int x = 1; x <= 9; x++){
                    location.put(x,y);
                    createSpace(x,y,mainframe,pin,space,zaxis,board);
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