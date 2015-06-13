/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n_puzzle_by_me;

/**
 *
 * @author Administrator
 */
import java.io.IOException;
import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 9/18/14
 * Time: 2:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Database {

    static Queue<String> list;

    public static int getCost(String name) {

        //returns -1 in case no match is found
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        String url = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "";

        String tableName = "fifteen_puzzle_1";
        String outputColumn = "cost";
        String matchColumn = "pattern";
        int cost = -1;

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            String query = String.format("Select * from %s where %s = \"%s\"", tableName, matchColumn, name);
            rs = st.executeQuery(query);
            if (rs.next()) {
                cost = rs.getInt(outputColumn);
            }

            con.close();
            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (con != null) {
            //System.out.println("connected");
        }
        return cost;
    }

    public static boolean insertCost(String pattern, int cost) {

        boolean returnValue;
        Connection con = null;
        PreparedStatement preparedStatement = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost/test";
        String user = "root";
        String password = "";
        String tableName = "fifteen_puzzle_1";
        String outputColumn = "cost";
        String matchColumn = "pattern";

        try {
            con = DriverManager.getConnection(url, user, password);

            String query = String.format("Select * from %s where %s = \"%s\"", tableName, matchColumn, pattern);
            st = con.createStatement();
            rs = st.executeQuery(query);

            if (rs.next())
                returnValue = false;
            else {
                query = String.format("insert into %s(%s,%s) values(?,?)", tableName, matchColumn, outputColumn);
                preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, pattern);
                preparedStatement.setInt(2, cost);
                preparedStatement.execute();
                returnValue = true;
            }

            con.close();
            rs.close();
            st.close();
            if (preparedStatement != null) preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            returnValue = false;
        }
        return returnValue;
    }

    public static void insertPatterns() {
        String goalState = "0,1,2,3,4,8,12,15";
        int d = 4;
        int n[][] = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                n[i][j] = (i * d) + j + 1;
            }
        }
        int initCost = 0;

        list = new LinkedList<String>();
        list.add(goalState);
        Database.insertCost(goalState, 0);
        int count = 0;

        while (!list.isEmpty()) {
            String currentState = list.remove();
            generatePatterns(currentState);
            //count++;
            //if (count > 5) break;
        }
    }

    private static void printState(int[][] s) {
        //System.out.println("Now in state:");
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length; j++) {
                System.out.printf("%3d", s[i][j]);
                //priorityQueue.add(new Nodes(j - 1, null, puzzleState));
            }
            System.out.println();
        }
    }

    public static void generatePatterns(String currentState) {
        int d = 4;

        String parts[] = currentState.split(",");
        String temp[] = null;
        int zerPos = Integer.parseInt(parts[7]);
        int zeroRow = (zerPos) / d;
        int zeroCol = (zerPos) % d;

        int fullState[][] = new int[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                fullState[i][j] = 6;
            }
        }
        for (int i = 0; i < 7; i++) {
            int v = Integer.parseInt(parts[i]);
            int r = v / d;
            int c = v % d;
            v = i + 1;
            if (i >= d) {
                v = 4 * i - 11;
            }
            fullState[r][c] = v;
            //System.out.printf("v=%d\n",v);
        }
        fullState[zeroRow][zeroCol] = 0;
        //System.out.printf("putting 0 in row=%d,col=%d\n",zeroRow,zeroCol);
        //System.out.printf("parent-%s,cost=%d\n", currentState, Database.getCost(currentState));
        //printState(fullState);
        int demo[][] = new int[d][d];

        if (zeroRow > 0) {
            temp = Arrays.copyOf(parts, parts.length);
            temp[7] = (zerPos - d) + "";
            for (int i = 0; i < 7; i++) {
                if ((zerPos - d) == Integer.parseInt(temp[i])) {
                    //swapWith=i;
                    temp[i] = zerPos + "";
                    break;
                }
            }

           /* Database.arrayCopy(fullState, demo);
            demo[zeroRow][zeroCol] = demo[zeroRow - 1][zeroCol];
            demo[zeroRow - 1][zeroCol] = 0;

            if ((demo[zeroRow][zeroCol] - 1) / d == 0 || (demo[zeroRow][zeroCol] - 1) % d == 0) {
                int n = demo[zeroRow][zeroCol] - 1;
                temp[n / 5 + 4] = zerPos + "";
            }*/

            String newState = String.format("%s,%s,%s,%s,%s,%s,%s,%s", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);

            int cost = Database.getCost(newState);
            if (cost == -1) {
                //System.out.printf("U,%s,cost=%d\n", newState, Database.getCost(currentState) + 1);
                list.add(newState);
                //printState(fullState);
                Database.insertCost(newState,Database.getCost(currentState)+1);
            }
        }
        if (zeroRow < d - 1) {

            temp = Arrays.copyOf(parts, parts.length);
            temp[7] = (zerPos + d) + "";
            for (int i = 0; i < 7; i++) {
                if ((zerPos + d) == Integer.parseInt(temp[i])) {
                    temp[i] = zerPos + "";
                    break;
                }
            }

            /*Database.arrayCopy(fullState, demo);
            demo[zeroRow][zeroCol] = demo[zeroRow + 1][zeroCol];
            demo[zeroRow + 1][zeroCol] = 0;

            if ((demo[zeroRow][zeroCol] - 1) / d == 0 || (demo[zeroRow][zeroCol] - 1) % d == 0) {
                int n = demo[zeroRow][zeroCol] - 1;
                temp[n / 5 + 4] = zerPos + "";
            }*/
            String newState = String.format("%s,%s,%s,%s,%s,%s,%s,%s", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);

            int cost = Database.getCost(newState);
            if (cost == -1) {
                //System.out.printf("D,%s,cost=%d\n", newState, Database.getCost(currentState) + 1);
                list.add(newState);
                //printState(fullState);
                //Database.insertCost(newState,cost);
                Database.insertCost(newState,Database.getCost(currentState)+1);
            }
        }
        if (zeroCol > 0) {
            temp = Arrays.copyOf(parts, parts.length);
            temp[7] = (zerPos - 1) + "";
            for (int i = 0; i < 7; i++) {
                if ((zerPos - 1) == Integer.parseInt(temp[i])) {
                    temp[i] = zerPos + "";
                    break;
                }
            }
            /*Database.arrayCopy(fullState, demo);
            demo[zeroRow][zeroCol] = demo[zeroRow][zeroCol - 1];
            demo[zeroRow][zeroCol - 1] = 0;

            if ((demo[zeroRow][zeroCol] - 1) / d == 0 || (demo[zeroRow][zeroCol] - 1) % d == 0) {
                int n = demo[zeroRow][zeroCol] - 1;
                temp[n / 5 + 4] = zerPos + "";
            }*/
            String newState = String.format("%s,%s,%s,%s,%s,%s,%s,%s", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);

            int cost = Database.getCost(newState);
            if (cost == -1) {
                //System.out.printf("L,%s,cost=%d\n", newState, Database.getCost(currentState) + 1);
                list.add(newState);
                //printState(fullState);
                //Database.insertCost(newState,cost);
                Database.insertCost(newState,Database.getCost(currentState)+1);
            }
        }
        if (zeroCol < d - 1) {
            temp = Arrays.copyOf(parts, parts.length);
            temp[7] = (zerPos + 1) + "";
            for (int i = 0; i < 7; i++) {
                if ((zerPos + 1) == Integer.parseInt(temp[i])) {
                    temp[i] = zerPos + "";
                    break;
                }
            }/*
            Database.arrayCopy(fullState, demo);
            demo[zeroRow][zeroCol] = demo[zeroRow][zeroCol + 1];
            demo[zeroRow][zeroCol + 1] = 0;

            if ((demo[zeroRow][zeroCol] - 1) / d == 0 || (demo[zeroRow][zeroCol] - 1) % d == 0) {
                int n = demo[zeroRow][zeroCol] - 1;
                temp[n / 5 + 4] = zerPos + "";
            }*/
            String newState = String.format("%s,%s,%s,%s,%s,%s,%s,%s", temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6], temp[7]);

            int cost = Database.getCost(newState);
            if (cost == -1) {
                //System.out.printf("R,%s,cost=%d\n", newState, Database.getCost(currentState) + 1);
                list.add(newState);
                //printState(fullState);
                //Database.insertCost(newState,cost);
                Database.insertCost(newState,Database.getCost(currentState)+1);
            }
        }

    }

    private static void arrayCopy(int[][] source, int[][] dest) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length; j++) {
                dest[i][j] = source[i][j];
            }
        }
    }
    
        public static void main(String[] args) throws IOException {
            Database.insertPatterns();           
        }
}
