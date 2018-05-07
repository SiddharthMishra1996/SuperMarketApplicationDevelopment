/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by;

import CoNect.Cnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Siddharth
 */
public class BuyGen extends javax.swing.JFrame {

    /**
     * Creates new form BuyGen
     */
    public BuyGen() {
        setTitle("General Store Products");
        setContentPane(new JLabel(new ImageIcon("C:\\MyJava\\access.jpg")));
        initComponents();
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        dispquery.setVisible(true);
        YesPrint.setVisible(true);
        NoPrint.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Search = new javax.swing.JLabel();
        SearchField = new javax.swing.JTextField();
        OK = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        selSize = new javax.swing.JLabel();
        EntSize = new javax.swing.JTextField();
        EntNo = new javax.swing.JTextField();
        selSize1 = new javax.swing.JLabel();
        dispquery = new javax.swing.JLabel();
        YesPrint = new javax.swing.JButton();
        NoPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Search.setText("Search");

        OK.setText("OK");
        OK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKMouseClicked(evt);
            }
        });
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "NSmall", "PSmall", "NMedium", "PMedium", "NLarge", "PLarge"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        selSize.setText("Select Size(small, medium, large)");

        selSize1.setText("Enter the quantity you want to buy");

        dispquery.setText("Do you want to print your invoice now");

        YesPrint.setText("YES");
        YesPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YesPrintActionPerformed(evt);
            }
        });

        NoPrint.setText("NO");
        NoPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(selSize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                        .addComponent(Search, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(selSize1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(EntSize, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                            .addComponent(EntNo))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(dispquery, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(YesPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NoPrint)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selSize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EntSize, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EntNo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selSize1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dispquery, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(YesPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NoPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKMouseClicked
       
       
    }//GEN-LAST:event_OKMouseClicked

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
       String nm=SearchField.getText();
        String siz = EntSize.getText();
        int num=Integer.parseInt(EntNo.getText());
        jTable1.setVisible(true);
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
        int n=model.getRowCount();
        if(n>0)
        {while((n=model.getRowCount())!=0)
            {model.removeRow(n-1);}}
        Connection con=Cnection.connect();
        try
        {
            Statement stm=con.createStatement();
            ResultSet s=stm.executeQuery("Select * from gensto where Name LIKE '%"+nm+"%';");
            while(s.next())
            {
                model.addRow(new Object[]{s.getString("Name"),s.getInt("NSmall"),s.getFloat("PSmall"),s.getInt("NMedium"),
                    s.getFloat("PMedium"),s.getInt("NLarge"),s.getFloat("PLarge")});
            }
         jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                int qty;
                float p;
                try {
                    Statement stm2=con.createStatement();
                     ResultSet s2=stm2.executeQuery("Select * from gensto where Name='"+(model.getValueAt(jTable1.getSelectedRow(),0).toString())+"'");
                     if(s2.next())
                     {
                         if(siz.equalsIgnoreCase("small"))
                         {
                             if(num>s2.getInt("NSmall"))
                              JOptionPane.showMessageDialog(null,"Sorry the quantity you requested to buy is \n not available in this size");
                             else
                             {
                               qty=s2.getInt("NSmall");
                               qty-=num;
                               p=s2.getFloat("PSmall");
                               int x1=stm2.executeUpdate("update gensto set NSmall='"+qty+"' where Name='"+(model.getValueAt(jTable1.getSelectedRow(),0).toString())+"'");
                               if(x1>0)
                               {                                
               
                                 JOptionPane.showMessageDialog(null,"Item added to your Buy Cart");
                                 try
                                {
                                   Statement stm3=con.createStatement();
                                   stm3.executeUpdate("insert into invoice (Name,Type,Size,Price,Quantity,NetPrice)values('"+(model.getValueAt(jTable1.getSelectedRow(),0).toString())+"','General Products','"+siz+"','"+p+"/-','"+num+"','"+(float)(num*p)+"')");
                                   JOptionPane.showMessageDialog(null,"You may proceed to print your invoice....");
                                 }catch(SQLException e1){}   
                               }
                             }
                         }
                         
                         else if(siz.equalsIgnoreCase("medium"))
                         {
                             if(num>s2.getInt("NMedium"))
                              JOptionPane.showMessageDialog(null,"Sorry the quantity you requested to buy is \n not available in this size");
                             else
                             {
                               qty=s2.getInt("NMedium");
                               qty-=num;
                               p=s2.getFloat("PMedium");
                               Statement stm4=con.createStatement();
                               int x1=stm4.executeUpdate("update gensto set NMedium='"+qty+"' where Name='"+(model.getValueAt(jTable1.getSelectedRow(),0).toString())+"'");
                               if(x1>0)
                               {                                
               
                                 JOptionPane.showMessageDialog(null,"Item added to your Buy Cart");
                                 try
                                {
                                   Statement stm5=con.createStatement();
                                   stm5.executeUpdate("insert into invoice (Name,Type,Size,Price,Quantity,NetPrice)values('"+(model.getValueAt(jTable1.getSelectedRow(),0).toString())+"','General Products','"+siz+"','"+Float.toString(p)+"/-','"+num+"','"+(float)(num*p)+"')");
                                   JOptionPane.showMessageDialog(null,"You may proceed to print your invoice....");
                                }catch(SQLException e2){}   
                               }
                             }
                         }
                         
                         else if(siz.equalsIgnoreCase("large"))
                         {
                             if(num>s2.getInt("NLarge"))
                              JOptionPane.showMessageDialog(null,"Sorry the quantity you requested to buy is \n not available in this size");
                             else
                             {
                               qty=s2.getInt("NLarge");
                               qty-=num;
                               p=s2.getFloat("PLarge");
                               Statement stm4=con.createStatement();
                               int x1=stm4.executeUpdate("update gensto set NLarge='"+qty+"' where Name='"+(model.getValueAt(jTable1.getSelectedRow(),0).toString())+"'");
                               if(x1>0)
                               {                                
               
                                 JOptionPane.showMessageDialog(null,"Item added to your Buy Cart");
                                 try
                                {
                                   Statement stm6=con.createStatement();
                                   stm6.executeUpdate("insert into invoice (Name,Type,Size,Price,Quantity,NetPrice)values('"+(model.getValueAt(jTable1.getSelectedRow(),0).toString())+"','General Products','"+siz+"','"+Float.toString(p)+"/-','"+num+"','"+(float)(num*p)+"')");
                                   JOptionPane.showMessageDialog(null,"You may proceed to print your invoice....");
                                }catch(SQLException e3){}   
                               }
                             }
                         }
                     }
                }catch (SQLException ex) {                 
                }
           
            }
            }); 
        }catch(Exception e){}
       
    }//GEN-LAST:event_OKActionPerformed

    private void YesPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YesPrintActionPerformed
           new Invo().setVisible(true);
           setVisible(false);
    }//GEN-LAST:event_YesPrintActionPerformed

    private void NoPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoPrintActionPerformed
         setVisible(false);
    }//GEN-LAST:event_NoPrintActionPerformed

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
            java.util.logging.Logger.getLogger(BuyGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyGen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField EntNo;
    private javax.swing.JTextField EntSize;
    private javax.swing.JButton NoPrint;
    private javax.swing.JButton OK;
    private javax.swing.JLabel Search;
    private javax.swing.JTextField SearchField;
    private javax.swing.JButton YesPrint;
    private javax.swing.JLabel dispquery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel selSize;
    private javax.swing.JLabel selSize1;
    // End of variables declaration//GEN-END:variables
}