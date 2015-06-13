
package n_puzzle_by_me;

class State{
    private int[][] board;
    private int f,g,h,n,m;
    private int xEmpty,yEmpty;

/*    public state(int[][] board) {
        this.board = board;
    }
*/
    
    public int[][] getBoard() {
        return board;
    }

    public int getF() {
        return f;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getG() {
        return g;
    }

    public int getH() {
        return h;
    }

    public int getxEmpty() {
        return xEmpty;
    }

    public int getyEmpty() {
        return yEmpty;
    }

    public void setBoard(int[][] board1) {
        this.board = new int[board1.length][];
        for(int i=0; i<board1.length; ++i)
        {
            this.board[i] = board1[i].clone();
        }
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setG(int g) {
        this.g = g;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setxEmpty(int xEmpty) {
        this.xEmpty = xEmpty;
    }

    public void setyEmpty(int yEmpty) {
        this.yEmpty = yEmpty;
    }
    
}
