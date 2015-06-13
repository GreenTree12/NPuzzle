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


class Puzzle1 {
    
    static int Found = -200;
    static int NotFound = -400;
    
    public static boolean idaStar(State root, Function funct){
        
        int bound = root.getH();
        int t;
        while(true)
        {
            int[][] board = root.getBoard();
            funct.list.clear();
            t = search(root, 0, bound, funct);
            if(t==Found)
            {
                funct.setList1(funct.list);
                return true;
            }
            else if(t==2147483000)
            {
                return false;
            }
            bound = t;
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static int search(State node, int g, int bound, Function funct){
        int [][] dimension = {{1, 0} , { -1, 0} , { 0, 1} , { 0, -1}};
        int f = g + node.getH();
        
        if(f>bound)
        {
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
                t = search(childNode, g+1, bound, funct);
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
    
    
    public static boolean idaStarPatternDatabase(State root, Function funct){
        
        int bound = root.getH();
        int t;
        while(true)
        {
            int[][] board = root.getBoard();
            funct.list.clear();
            t = searchPatternDatabase(root, 0, bound, funct);
            if(t==Found)
            {
                funct.setList1(funct.list);
                return true;
            }
            else if(t==2147483000)
            {
                return false;
            }
            bound = t;
        }
    }
    
    @SuppressWarnings("empty-statement")
    public static int searchPatternDatabase(State node, int g, int bound, Function funct){
        int [][] dimension = {{1, 0} , { -1, 0} , { 0, 1} , { 0, -1}};
        int f = g + node.getH();
        
        if(f>bound)
        {
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
                t = searchPatternDatabase(childNode, g+1, bound, funct);
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

