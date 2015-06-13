/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n_puzzle_by_me;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author Administrator
 */
public class N_Puzzle extends javax.swing.JFrame {
    
    int m,n;
    int [][] board;
    int [] inversionTest;
    int k;
    int xEmpty, yEmpty;
    State root = new State();
    Function funct = new Function();
    Puzzle1 puzzle = new Puzzle1();
    List<State> printList;
    int Next, Back;
    public N_Puzzle() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Inputs");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("M");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("N");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Puzzle");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Result");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("SOLVE");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("<<BACK");
        jButton2.setEnabled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setText("NEXT>>");
        jButton3.setEnabled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Manhatton Distance");
        jRadioButton1.setName("manhatton"); // NOI18N

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Pattern Database");
        jRadioButton2.setName("pattern"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField3))
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jRadioButton2)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //Solve Button
        
        Date startingTime = Calendar.getInstance().getTime();
        
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        
        m = Integer.parseInt(jTextField1.getText());
        n = Integer.parseInt(jTextField2.getText());
        board = new int[m+1][n+1];
        inversionTest = new int[(m*n)+1];
        k=1;
        String s = jTextField3.getText();
        String [] st = s.split(",");
        int count=0;
        for(int i=1; i<=m; ++i)
        {
            for(int j=1; j<=n; ++j)
            {
                board[i][j] = Integer.parseInt(st[count]);
                count++;
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
        for(int i=1; i<=m; ++i)
        {
            for(int j=1; j<=n; ++j)
            {
                jTextArea1.append(board[i][j]+" "); 
            }
            jTextArea1.append("\n");
        }
        if(buttonGroup1.getSelection().equals(jRadioButton1.getModel())){
        boolean solvable = funct.isSolvable(n, m, inversionTest, xEmpty);
        if(solvable)
        {
            jTextArea1.append("Solvable"+"\n");
            
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
            boolean result = puzzle.idaStar(root, funct);
            if(result){
                
                jTextArea1.append("Solution is Found"+"\n");
                int steps=funct.getSteps();
                jTextArea1.append("Number of Steps: "+ steps+"\n");
                printList = new ArrayList<State>(funct.getList1());
                
                int size;
                for(int i=printList.size()-1; i>=0; --i)
                {
                    State state = printList.get(i);
                    int[][] board1 = state.getBoard();
                    int m1 = state.getM();
                    int n1 = state.getN();
                    jTextArea1.append("\n");
                    for(int j=1; j<=m1; ++j)
                    {
                        for(int k=1; k<=n1; ++k)
                        {
                            jTextArea1.append(board1[j][k]+" ");
                        }
                        jTextArea1.append("\n");
                    }
                    jTextArea1.append("--------------------------------------------"+"\n");
                }
                jButton2.setEnabled(true);
                jButton3.setEnabled(true);
                Back=printList.size()-1;
                Next=printList.size()-1;
            }
            else
                jTextArea1.append("Solution Not Found\n");
        }
        else {
            jTextArea1.setText("UnSolvable"+"\n");
        }
        }
        //pattern database
        else if(buttonGroup1.getSelection().equals(jRadioButton2.getModel())){
        
        boolean solvable = funct.isSolvable(n, m, inversionTest, xEmpty);
        if(solvable)
        {
            jTextArea1.append("Solvable"+"\n");
            
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
            boolean result = puzzle.idaStarPatternDatabase(root, funct);
            if(result){
                
                jTextArea1.append("Solution is Found"+"\n");
                int steps=funct.getSteps();
                jTextArea1.append("Number of Steps: "+ steps+"\n");
                printList = new ArrayList<State>(funct.getList1());
                
                int size;
                for(int i=printList.size()-1; i>=0; --i)
                {
                    State state = printList.get(i);
                    int[][] board1 = state.getBoard();
                    int m1 = state.getM();
                    int n1 = state.getN();
                    jTextArea1.append("\n");
                    for(int j=1; j<=m1; ++j)
                    {
                        for(int k=1; k<=n1; ++k)
                        {
                            jTextArea1.append(board1[j][k]+" ");
                        }
                        jTextArea1.append("\n");
                    }
                    jTextArea1.append("--------------------------------------------"+"\n");
                }
                jButton2.setEnabled(true);
                jButton3.setEnabled(true);
                Back=printList.size()-1;
                Next=printList.size()-1;
            }
            else
                jTextArea1.append("Solution Not Found\n");
        }
        else {
            jTextArea1.setText("UnSolvable"+"\n");
        }    
        }
        
        Date now = Calendar.getInstance().getTime();
        long timeElapsed = now.getTime() - startingTime.getTime();
        jLabel6.setText("Time: "+timeElapsed);
        jLabel6.setBackground(Color.yellow);
        jPanel1.removeAll();
        jPanel1.setLayout(new GridLayout(m,n));
        JButton[][] jb = new JButton[m][n];
        for(int i=0; i<m; ++i)
        {
            for(int j=0; j<n; ++j)
            {
                jb[i][j] = new JButton();
                jb[i][j].setText(String.valueOf(board[i+1][j+1]));
                jb[i][j].setFont(new Font("SANS_SERIF", Font.BOLD, 16));
                if(board[i+1][j+1]==0)
                {
                    jb[i][j].setBackground(Color.GRAY);
                }
                else
                    jb[i][j].setBackground(Color.YELLOW);
                jPanel1.add(jb[i][j]);
            }
        }
        jPanel1.validate();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //Back Button
        if(Back>=0 && Back<printList.size())
        {
            State state = printList.get(Back);
            int[][] board1 = state.getBoard();
            int m1 = state.getM();
            int n1 = state.getN();
            jPanel1.removeAll();
            jPanel1.setLayout(new GridLayout(m1,n1));
            JButton[][] jb = new JButton[m1][n1];
            for(int i=0; i<m1; ++i)
            {
                for(int j=0; j<n1; ++j)
                {
                    jb[i][j] = new JButton();
                    jb[i][j].setText(String.valueOf(board1[i+1][j+1]));
                    jb[i][j].setFont(new Font("SANS_SERIF", Font.BOLD, 16));
                    if(board1[i+1][j+1]==0)
                    {
                        jb[i][j].setBackground(Color.GRAY);
                    }
                    else
                        jb[i][j].setBackground(Color.YELLOW);
                    jPanel1.add(jb[i][j]);
                }
            }
            jPanel1.validate();
            Next = Back;
            Back++;
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        //Next Button
        if(Next>=0 && Next<printList.size())
        {
            State state = printList.get(Next);
            int[][] board1 = state.getBoard();
            int m1 = state.getM();
            int n1 = state.getN();
            jPanel1.removeAll();
            jPanel1.setLayout(new GridLayout(m1,n1));
            JButton[][] jb = new JButton[m1][n1];
            for(int i=0; i<m1; ++i)
            {
                for(int j=0; j<n1; ++j)
                {
                    jb[i][j] = new JButton();
                    jb[i][j].setText(String.valueOf(board1[i+1][j+1]));
                    jb[i][j].setFont(new Font("SANS_SERIF", Font.BOLD, 16));
                    if(board1[i+1][j+1]==0)
                    {
                        jb[i][j].setBackground(Color.GRAY);
                    }
                    else
                        jb[i][j].setBackground(Color.YELLOW);
                    jPanel1.add(jb[i][j]);
                }
            }
            jPanel1.validate();
            Back = Next;
            Next--;
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(N_Puzzle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(N_Puzzle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(N_Puzzle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(N_Puzzle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new N_Puzzle().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
