/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryclient;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Container;
import java.rmi.RemoteException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tarana
 */
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    private JFrame f=new JFrame();
    public ManageBooks() throws RemoteException {
        Container c=getContentPane();
        c.setBackground(Color.GRAY);
        initComponents();
        printJtable();
        
    }
    public void printJtable() throws RemoteException
    {
     Client client=new Client();
    //  int k=client.stub.AddBooks(name, category, author, publisher, edition);
              Vector v=new Vector();
              v=client.stub.TableLoadBooks();
//              System.out.println(v);
//              
//              int m=v.size();
//              System.out.println(m);
//              System.out.print(m);
              DefaultTableModel d=(DefaultTableModel)table.getModel();
              d.setRowCount(0);
              for(int i=0;i<v.size();i++)
              {
               Vector v1=new Vector();
               v1=(Vector) v.get(i);
               d.addRow(v1);
              }
     
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtcategory = new javax.swing.JTextField();
        txtauthor = new javax.swing.JTextField();
        txtpublisher = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtedition = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MANAGE BOOKS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 230, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("NAME");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("CATEGORY");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("AUTHOR");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("PUBLISHER");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setText("COUNT");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 150, -1));
        jPanel1.add(txtcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 150, -1));
        jPanel1.add(txtauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 150, -1));
        jPanel1.add(txtpublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 150, -1));
        jPanel1.add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 150, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 110, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 110, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 110, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "CATEGORY", "AUTHOR", "PUBLISHER", "EDITION", "COUNT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 31, 510, 450));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/libraryserver/library (3).jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 140, 120));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setText("EDITION");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, -1, -1));
        jPanel1.add(txtedition, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1030, 500));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton5.setText("BACK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("LOGOUT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String name,category,author,publisher,edition,qty1;
            int qty;
             Client client=new Client();
             
            name=txtname.getText();
            category=txtcategory.getText();
            author=txtauthor.getText();
            publisher=txtpublisher.getText();
             edition=txtedition.getText();
            qty1=txtqty.getText();
            
            if(!(name.equals("")||category.equals("")||author.equals("")||publisher.equals("")||edition.equals("")||qty1.equals("")))
           {    
                qty=Integer.parseInt(txtqty.getText());
            System.out.print(qty);
            int k=client.stub.AddBooks(name, category, author, publisher, edition, qty);
              Vector v=new Vector();
              v=client.stub.TableLoadBooks();
              DefaultTableModel d=(DefaultTableModel)table.getModel();
              d.setRowCount(0);
              for(int i=0;i<v.size();i++)
              {
               Vector v1=new Vector();
               v1=(Vector) v.get(i);
               d.addRow(v1);
              }
            if(k>0)
            {
                JOptionPane.showMessageDialog(this,"Record of book succesfully added!!");
                txtname.setText("");
                txtauthor.setText(" ");
                txtpublisher.setText(" ");
                txtqty.setText(" ");
                txtcategory.setText(" ");
                txtedition.setText(" ");
                txtname.requestFocus();
                
            }
            else
            {
               JOptionPane.showMessageDialog(this,"Error in addition!!"); 
            }
            
            }
            else
            {
            JOptionPane.showMessageDialog(f,"All fields are compulsory to be filled"); 
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ManageBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel d=(DefaultTableModel)table.getModel();
        int selectIndex=table.getSelectedRow();
        int id=Integer.parseInt(d.getValueAt(selectIndex,0).toString());
        txtname.setText(d.getValueAt(selectIndex,1).toString());
        txtcategory.setText(d.getValueAt(selectIndex,2).toString());
        txtauthor.setText(d.getValueAt(selectIndex,3).toString());
        txtpublisher.setText(d.getValueAt(selectIndex,4).toString());
        txtedition.setText(d.getValueAt(selectIndex,5).toString());
        txtqty.setText(d.getValueAt(selectIndex,6).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try
        {
        String name,category,author,publisher,edition;
        int qty;
        DefaultTableModel d1=(DefaultTableModel)table.getModel();
         Client client=new Client();
        int selectIndex=table.getSelectedRow();
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
       
            name=txtname.getText(); 
            category=txtcategory.getText();
            author=txtauthor.getText();
            publisher=txtpublisher.getText();
            edition=txtedition.getText();
            qty=Integer.parseInt(txtqty.getText());
            
            int k=client.stub.UpdateBookRecord(name, category, author, publisher,edition,id,qty);
             Vector v=new Vector();
              v=client.stub.TableLoadBooks();
              DefaultTableModel d=(DefaultTableModel)table.getModel();
              d.setRowCount(0);
              for(int i=0;i<v.size();i++)
              {
               Vector v1=new Vector();
               v1=(Vector) v.get(i);
               d.addRow(v1);
              }
            if(k>0)
            {
                JOptionPane.showMessageDialog(this,"Record of book has been Updated!!!");
                txtname.setText("");
                txtauthor.setText(" ");
                txtpublisher.setText(" ");
                txtqty.setText(" ");
                txtcategory.setText(" ");
                txtedition.setText(" ");
                txtname.requestFocus();
                
            }
            else
            {
               JOptionPane.showMessageDialog(this,"Error in Updation!!"); 
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ManageBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         try
        {
        String name,category,author,publisher,edition;
        DefaultTableModel d1=(DefaultTableModel)table.getModel();
         Client client=new Client();
        int selectIndex=table.getSelectedRow();
        int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
       
          
            int k=client.stub.DelelteBookRecord(id);
             Vector v=new Vector();
              v=client.stub.TableLoadBooks();
              DefaultTableModel d=(DefaultTableModel)table.getModel();
              d.setRowCount(0);
              for(int i=0;i<v.size();i++)
              {
               Vector v1=new Vector();
               v1=(Vector) v.get(i);
               d.addRow(v1);
              }
            if(k>0)
            {
                JOptionPane.showMessageDialog(this,"Record of the book has been Deleted!!!");
                txtname.setText("");
                txtauthor.setText(" ");
                txtpublisher.setText(" ");
                txtqty.setText(" ");
                txtcategory.setText(" ");
                txtedition.setText(" ");
                txtname.requestFocus();
                
            }
            else
            {
               JOptionPane.showMessageDialog(this,"Error in Deletion!!"); 
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ManageBooks.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        AdminPanel a=new AdminPanel();
        this.setVisible(false);
        a.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        LoginPage lg=new LoginPage();
        this.setVisible(false);
        lg.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageBooks().setVisible(true);
                } catch (RemoteException ex) {
                    Logger.getLogger(ManageBooks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtauthor;
    private javax.swing.JTextField txtcategory;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpublisher;
    private javax.swing.JTextField txtqty;
    // End of variables declaration//GEN-END:variables
}
