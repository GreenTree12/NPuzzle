
package n_puzzle_by_me;

import java.util.ArrayList;
import java.util.List;

class Function{
    private int steps;
    
    public List<State> list = new ArrayList<State>();
    public List<State> list1;

    public void setList1(List<State> list2) {
        this.list1 = new ArrayList<State>(list2);
    }

    public List<State> getList1() {
        return list1;
    }

    
    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
    public boolean isSolvable(int n, int m,int [] inversionTest, int xEmpty){
        int size, inversionCount=0;
        size = (n*m)-1;
        for(int i=1; i<size; ++i){
            for(int j=i+1; j<=size; ++j){
                if(inversionTest[i]>inversionTest[j])
                    inversionCount++;
            }
        }
        if(n%2 == 1){                         //n odd inver sionCount even
            if(inversionCount%2 == 0)
                return true;
            else
                return false;
        }
        else{                                  // n even
            if((m-xEmpty)%2==0 && inversionCount%2==0) // m-xEmpty even , inversionCount even
                return true;
            else if((m-xEmpty)%2==1 && inversionCount%2 == 1) //m-xEmpty odd , inversionCount odd
                return true;
            else                  // otherwise false
                return false;
        }
    }
    
    public boolean isGoal(State state){
        /*int k=1;
        int n = state.getN();
        int m = state.getM();
        int [][] board = state.getBoard();
        for(int i=1; i<=m; ++i)
        {
            for(int j=1; j<=n; ++j)
            {
                if(i==m && j==n)
                {
                    if(board[i][j] != 0)
                        return false;
                }
                else
                {
                    if(board[i][j]!=k)
                        return false;
                    k++;
                }
            }
        }*/
        int dist = manhattan(state);
        if(dist==0)
            return true;
        else
            return false;
    }
    
    public int manhattan(State state){
        
        int[][] board = state.getBoard();
        int n = state.getN();
        int m = state.getM();
        int dist=0;
        int xTemp, yTemp, xFinal, yFinal;
        for(int i=1; i<=m; ++i)
        {
            for(int j=1; j<=n; ++j)
            {
                if(board[i][j]==0)
                    continue;
                xTemp = i;    //Present X, Y Coordinates.
                yTemp = j;
                if(board[i][j]%n == 0) // FInal X, Y Coordinates.
                {
                    yFinal = n;
                    xFinal = board[i][j]/n;
                }
                else
                {
                    yFinal = board[i][j]%n;
                    xFinal = (board[i][j] / n) + 1;
                }
                dist += Math.abs(xFinal-xTemp) + Math.abs(yFinal-yTemp);
            }
        }
        return dist;
    }
    public int patternDatabase(State state){
        int [][] board = state.getBoard();
        int d = 4;
        int [][] boardNew = new int[d][d];
        int temp[] = new int[2 * d];
        int h_n = 0;
        int count = 0;
        for(int i=0; i<d; ++i)
        {
            for(int j=0; j<d; ++j)
            {
                boardNew[i][j]=board[i+1][j+1];
            }
        }
        for (int i = 0; i < d && count < 8; i++) {
            for (int j = 0; j < d && count < 8; j++) {
                if ((boardNew[i][j] - 1) / d == 0 || (boardNew[i][j] - 1) % d == 0) {
                    int index = i * d + j;
                    count++;
                    switch (boardNew[i][j]) {
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
            h_n = manhattan(state);
            return h_n;
        }
        else {
            return h_n;
        }
    }
    public State neighbour(State parentNode, int xTo, int yTo){
        State state = new State();
        int [][] board = swap(parentNode.getBoard(), parentNode.getxEmpty(), parentNode.getyEmpty(), xTo, yTo);
        state.setBoard(board);
        state.setxEmpty(xTo);
        state.setyEmpty(yTo);
        state.setM(parentNode.getM());
        state.setN(parentNode.getN());
        state.setH(manhattan(state));
        state.setG(parentNode.getG()+1);
        state.setF(state.getG()+state.getH());
        return state;
    }
    
    public State neighbourPatternDatabase(State parentNode, int xTo, int yTo){
        State state = new State();
        int [][] board = swap(parentNode.getBoard(), parentNode.getxEmpty(), parentNode.getyEmpty(), xTo, yTo);
        state.setBoard(board);
        state.setxEmpty(xTo);
        state.setyEmpty(yTo);
        state.setM(parentNode.getM());
        state.setN(parentNode.getN());
        state.setH(patternDatabase(state));
        state.setG(parentNode.getG()+1);
        state.setF(state.getG()+state.getH());
        return state;
    }
    
    public int[][] swap(int[][] parentBoard, int xFrom, int yFrom, int xTo, int yTo) {
        int first, second;
        int[][] childBoard = new int[parentBoard.length][];
        for(int i=0; i<parentBoard.length; ++i)
        {
            childBoard[i] = parentBoard[i].clone();
        }
        first =  childBoard[xFrom][yFrom];
        second = childBoard[xTo][yTo];
        childBoard[xFrom][yFrom] = second;
        childBoard[xTo][yTo] = first;
        return childBoard;
    }
    
    public void printList(){
        int size;
        while(!list.isEmpty()){
            size = list.size();
            State state = list.remove(size-1);
            int[][] board = state.getBoard();
            int m = state.getM();
            int n = state.getN();
            for(int i=1; i<=m; ++i)
            {
                for(int j=1; j<=n; ++j)
                {
                    System.out.printf(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("--------------------------------------------");
            System.out.println();
        }
    }
}