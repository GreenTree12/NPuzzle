package n_puzzle_by_me;
/**
 * @author Administrator
 * @author Administrator
 * @author Administrator
 * @author Sabiha Afroz
 * @author 0905114
 * @author Administrator
 * @author Administrator
 * @author Administrator
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;


public class Puzzle {
    
    static int n,m;
    static int xEmpty, yEmpty;
    static State root = new State();
    static Function funct = new Function();
    static int Found = -200;
    static int NotFound = -400;
    
    public static boolean idaStar(State root){
        
        int bound = root.getH();
        int t;
        while(true)
        {
            int[][] board = root.getBoard();
            System.out.println("--------------------------ROOT-------------------------");
            for(int i=1; i<=m; ++i)
            {
                for(int j=1; j<=n; ++j)
                {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println(root.getH());
            System.out.println("--------------------------ROOT-------------------------");
            funct.list.clear();
            t = search(root, 0, bound);
            if(t==Found)
            {
                System.out.println("Found");
                System.out.println("Number Of Steps: "+funct.getSteps());
                funct.setList1(funct.list);
                funct.printList();
                return true;
            }
            else if(t==2147483000)
            {
                System.out.println("Not Found");
                return false;
            }
            bound = t;
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static int search(State node, int g, int bound){
        int [][] dimension = {{1, 0} , { -1, 0} , { 0, 1} , { 0, -1}};
        int f = g + node.getH();
        
        if(f>bound)
        {
            //int size = funct.list.size();
            //funct.list.remove(size-1);
            return f;
        }
        if(funct.isGoal(node))
        {
            funct.setSteps(g);
            return Found;
        }
        int min = 2147483000;
        int t;
        for(int i=0; i<4; ++i)
        {
            int xTemp, yTemp;
            State childNode;
            xTemp = node.getxEmpty()+dimension[i][0];
            yTemp = node.getyEmpty()+dimension[i][1];
            if(xTemp>0 && xTemp<=node.getM() && yTemp>0 && yTemp<=node.getN())
            {
                childNode = funct.neighbour(node, xTemp, yTemp); 
                t = search(childNode, g+1, bound);
                if(t == Found) {
                    funct.list.add(childNode);
                    return Found;
                }
                if(t<min)
                    min = t;
            }
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        m = in.nextInt();
        n = in.nextInt();
        int [][] board = new int[m+1][n+1];
        int [] inversionTest = new int[(m*n)+1];
        int k=1;
        for(int i=1; i<=m; ++i)
        {
            for(int j=1; j<=n; ++j)
            {
                board[i][j] = in.nextInt();
                if(board[i][j]==0)
                {
                    xEmpty=i;
                    yEmpty=j;
                }
                else
                {
                    inversionTest[k]=board[i][j];
                    k++;
                }
            }
        }
        System.out.printf("Select Heuristics\n1.Manhatton Distance\n2.Pattern Database\n");
        int choice = in.nextInt();
        if(choice == 2  && m==4 && n==4){    //Pattern Database
            boolean solvable = funct.isSolvable(n, m, inversionTest, xEmpty);
            if(solvable)
            {
                System.out.println("Solvable");
            
                //root state setting;
            
                root.setBoard(board);
                root.setM(m);
                root.setN(n);
                int h=funct.patternDatabase(root);
                root.setH(h);
                root.setG(0);
                root.setF(root.getG()+root.getH());
                root.setxEmpty(xEmpty);
                root.setyEmpty(yEmpty);
            
                funct.setSteps(0);
                idaStarPatternDatabase(root);
            }
            else
                System.out.println("Unsolvable");
        }
        else{         //Manhatton Distance
            boolean solvable = funct.isSolvable(n, m, inversionTest, xEmpty);
            if(solvable)
            {
                System.out.println("Solvable");
            
                //root state setting;
            
                root.setBoard(board);
                root.setM(m);
                root.setN(n);
                int h=funct.manhattan(root);
                root.setH(h);
                root.setG(0);
                root.setF(root.getG()+root.getH());
                root.setxEmpty(xEmpty);
                root.setyEmpty(yEmpty);
            
                funct.setSteps(0);
                idaStar(root);
            }
            else
                System.out.println("Unsolvable");
        }
    }
    
    public static boolean idaStarPatternDatabase(State root){
        
        int bound = root.getH();
        int t;
        while(true)
        {
            int[][] board = root.getBoard();
            System.out.println("--------------------------ROOT-------------------------");
            for(int i=1; i<=m; ++i)
            {
                for(int j=1; j<=n; ++j)
                {
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println(root.getH());
            System.out.println("--------------------------ROOT-------------------------");
            funct.list.clear();
            t = searchPatternDatabase(root, 0, bound);
            if(t==Found)
            {
                System.out.println("Found");
                System.out.println("Number Of Steps: "+funct.getSteps());
                funct.setList1(funct.list);
                funct.printList();
                return true;
            }
            else if(t==2147483000)
            {
                System.out.println("Not Found");
                return false;
            }
            bound = t;
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static int searchPatternDatabase(State node, int g, int bound){
        int [][] dimension = {{1, 0} , { -1, 0} , { 0, 1} , { 0, -1}};
        int f = g + node.getH();
        
        if(f>bound)
        {
            //int size = funct.list.size();
            //funct.list.remove(size-1);
            return f;
        }
        if(funct.isGoal(node))
        {
            funct.setSteps(g);
            return Found;
        }
        int min = 2147483000;
        int t;
        for(int i=0; i<4; ++i)
        {
            int xTemp, yTemp;
            State childNode;
            xTemp = node.getxEmpty()+dimension[i][0];
            yTemp = node.getyEmpty()+dimension[i][1];
            if(xTemp>0 && xTemp<=node.getM() && yTemp>0 && yTemp<=node.getN())
            {
                childNode = funct.neighbourPatternDatabase(node, xTemp, yTemp); 
                t = searchPatternDatabase(childNode, g+1, bound);
                if(t == Found) {
                    funct.list.add(childNode);
                    return Found;
                }
                if(t<min)
                    min = t;
            }
        }
        return min;
    }
}

