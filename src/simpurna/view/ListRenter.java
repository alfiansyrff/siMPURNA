/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package simpurna.view;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import simpurna.controller.UserController;
import simpurna.model.UserModel;

/**
 *
 * @author alfia
 */
public class ListRenter extends javax.swing.JPanel {
    
    /**
     * Creates new form ListRenter
     */
    private UserController  userController = new UserController();
    
    public ListRenter() {
        initComponents();
        userController.displayUsers(this);
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        list_pegawaiPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        penghuniKosTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        kelolaPenghuniButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        list_pegawaiPanel.setBackground(new java.awt.Color(249, 251, 231, 199));
        list_pegawaiPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        penghuniKosTable.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        penghuniKosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Username", "Nama", "Alamat", "Nomor Telepon", "Kamar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        penghuniKosTable.setRowHeight(30);
        jScrollPane1.setViewportView(penghuniKosTable);

        list_pegawaiPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 790, 220));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("DAFTAR PENGHUNI");
        list_pegawaiPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 790, 50));

        kelolaPenghuniButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/change.png"))); // NOI18N
        kelolaPenghuniButton.setText("UPDATE DATA");
        kelolaPenghuniButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kelolaPenghuniButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelolaPenghuniButtonActionPerformed(evt);
            }
        });
        list_pegawaiPanel.add(kelolaPenghuniButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, -1, -1));

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/exit.png"))); // NOI18N
        deleteButton.setText("HAPUS PENGHUNI");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        list_pegawaiPanel.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        add(list_pegawaiPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 830, 380));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/home.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 60, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/background.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 900, 500));
    }// </editor-fold>//GEN-END:initComponents
    
    public void showUsers(List<UserModel> users) {
        

    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DashboardAdmin da = new DashboardAdmin();
   
        JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);

        parentWindow.getContentPane().remove(this);

        parentWindow.getContentPane().add(da);

        parentWindow.pack();

        da.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kelolaPenghuniButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelolaPenghuniButtonActionPerformed
        // TODO add your handling code here:
        RenterUpdate ru = new RenterUpdate();
   
        JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);

        parentWindow.getContentPane().remove(this);

        parentWindow.getContentPane().add(ru);

        parentWindow.pack();

        ru.setVisible(true);
    }//GEN-LAST:event_kelolaPenghuniButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        userController.deleteUser(this);
        userController.displayUsers(this);
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    public JTable getPenghuniKosTable() {
        return penghuniKosTable;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kelolaPenghuniButton;
    private javax.swing.JPanel list_pegawaiPanel;
    private javax.swing.JTable penghuniKosTable;
    // End of variables declaration//GEN-END:variables
}
