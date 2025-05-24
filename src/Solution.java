import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution {
    public Solution(){
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
    }
}
