
package n_puzzle_by_me;

import java.util.ArrayList;
import java.util.List;

public class DatabaseTest {
 
    public static void main(String[] args){
        int [][] state = {{1, 2, 3, 0} , {5, 7, 6, 4} , {9, 8,12 , 10} , {13, 11, 15, 14}};
        int d = 4;
        int temp[] = new int[2 * d];
        int h_n = 0;
        int count = 0;
        for (int i = 0; i < d && count < 8; i++) {
            for (int j = 0; j < d && count < 8; j++) {
                if ((state[i][j] - 1) / d == 0 || (state[i][j] - 1) % d == 0) {
                    int index = i * d + j;
                    count++;
                    switch (state[i][j]) {
                        case 1:
                            temp[0] = index;
                            break;
                        case 2:
                            temp[1] = index;
                            break;
                        case 3:
                            temp[2] = index;
                            break;
                        case 4:
                            temp[3] = index;
                            break;
                        case 5:
                            temp[4] = index;
                            break;
                        case 9:
                            temp[5] = index;
                            break;
                        case 13:
                            temp[6] = index;
                            break;
                        case 0:
                            temp[7] = index;
                            break;
                    }
                }
            }
        }
        String newState = String.format("%d,%d,%d,%d,%d,%d,%d,%d", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);
        h_n = Database.getCost(newState);

        //since all patterns are not still in the databse,
        //we use manhattan for those absent patterns
        if (h_n == -1) {
            System.out.printf("absent %d\n",h_n);
        }
        else {
            System.out.printf("present %d\n",h_n);
        }

    }
}
