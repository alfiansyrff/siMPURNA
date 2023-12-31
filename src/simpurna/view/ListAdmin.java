/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package simpurna.view;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import simpurna.controller.AdminController;

/**
 *
 * @author alfia
 */
public class ListAdmin extends javax.swing.JPanel {

    /**
     * Creates new form ListAdmin
     */
    AdminController adminController = new AdminController();
    public ListAdmin() {
        initComponents();
        adminController.displayAllAdmin(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFormJual = new javax.swing.JPanel();
        judulPenjualanHewan = new javax.swing.JLabel();
        labelIdHewan = new javax.swing.JLabel();
        labelCaraPenjualan = new javax.swing.JLabel();
        kontakTextField = new javax.swing.JTextField();
        labelIdHewan1 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        nameTextField1 = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        panelHewanSiapJual = new javax.swing.JPanel();
        judulHewanSiapJual = new javax.swing.JLabel();
        jScrollHewanSiapJual = new javax.swing.JScrollPane();
        listAdminTable = new javax.swing.JTable();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFormJual.setBackground(new java.awt.Color(249, 251, 231, 199));
        panelFormJual.setPreferredSize(new java.awt.Dimension(277, 134));

        judulPenjualanHewan.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        judulPenjualanHewan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulPenjualanHewan.setText("FORM KELOLA ADMIN");

        labelIdHewan.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        labelIdHewan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelIdHewan.setText("Nama");

        labelCaraPenjualan.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        labelCaraPenjualan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCaraPenjualan.setText("Kontak");

        kontakTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kontakTextFieldActionPerformed(evt);
            }
        });

        labelIdHewan1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        labelIdHewan1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelIdHewan1.setText("Username");

        usernameTextField.setMinimumSize(new java.awt.Dimension(64, 26));

        nameTextField1.setMinimumSize(new java.awt.Dimension(64, 26));

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/add.png"))); // NOI18N
        addButton.setText("TAMBAH");
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormJualLayout = new javax.swing.GroupLayout(panelFormJual);
        panelFormJual.setLayout(panelFormJualLayout);
        panelFormJualLayout.setHorizontalGroup(
            panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormJualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulPenjualanHewan, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormJualLayout.createSequentialGroup()
                .addGroup(panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormJualLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addGroup(panelFormJualLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kontakTextField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormJualLayout.createSequentialGroup()
                                .addGroup(panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelCaraPenjualan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelIdHewan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelIdHewan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18))
        );
        panelFormJualLayout.setVerticalGroup(
            panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormJualLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(judulPenjualanHewan)
                .addGap(18, 18, 18)
                .addComponent(labelIdHewan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelIdHewan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(labelCaraPenjualan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kontakTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        add(panelFormJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 290, 390));

        panelHewanSiapJual.setBackground(new java.awt.Color(249, 251, 231, 199));
        panelHewanSiapJual.setPreferredSize(new java.awt.Dimension(277, 134));

        judulHewanSiapJual.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        judulHewanSiapJual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulHewanSiapJual.setText("LIST ADMIN");

        listAdminTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Username", "Nama", "Kontak"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listAdminTable.setRowHeight(30);
        listAdminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAdminTableMouseClicked(evt);
            }
        });
        jScrollHewanSiapJual.setViewportView(listAdminTable);

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/edit.png"))); // NOI18N
        updateButton.setText("UPDATE");
        updateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/delete.png"))); // NOI18N
        deleteButton.setText("HAPUS");
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHewanSiapJualLayout = new javax.swing.GroupLayout(panelHewanSiapJual);
        panelHewanSiapJual.setLayout(panelHewanSiapJualLayout);
        panelHewanSiapJualLayout.setHorizontalGroup(
            panelHewanSiapJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHewanSiapJualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulHewanSiapJual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHewanSiapJualLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelHewanSiapJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelHewanSiapJualLayout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton))
                    .addComponent(jScrollHewanSiapJual, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        panelHewanSiapJualLayout.setVerticalGroup(
            panelHewanSiapJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHewanSiapJualLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(judulHewanSiapJual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollHewanSiapJual, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(panelHewanSiapJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton))
                .addGap(36, 36, 36))
        );

        add(panelHewanSiapJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 520, 390));

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/home.png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 60, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void kontakTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kontakTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kontakTextFieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here
        adminController.editAdmin(this);
        adminController.displayAllAdmin(this);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        adminController.insertAdmin(this);
        adminController.displayAllAdmin(this);
    }//GEN-LAST:event_addButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        adminController.deleteAdmin(this);
        adminController.displayAllAdmin(this);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void listAdminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAdminTableMouseClicked
        // TODO add your handling code here:
        int row = listAdminTable.getSelectedRow();
        String username = listAdminTable.getValueAt(row, 0).toString();
        String name = listAdminTable.getValueAt(row, 1).toString();
        String kontak = listAdminTable.getValueAt(row, 2).toString();
        usernameTextField.setText(username);
        kontakTextField.setText(kontak);
        nameTextField1.setText(name);
    }//GEN-LAST:event_listAdminTableMouseClicked

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        DashboardAdmin da = new DashboardAdmin();
   
        JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);

        parentWindow.getContentPane().remove(this);

        parentWindow.getContentPane().add(da);

        parentWindow.pack();

        da.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed
    
    public JTable getListAdminTable() {
        return listAdminTable;
    }
    
    public JTextField getUsername() {
        return usernameTextField;
    }
    
    public JTextField getNama() {
        return nameTextField1;
    }
    
    public JTextField getKontak() {
        return kontakTextField;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollHewanSiapJual;
    private javax.swing.JLabel judulHewanSiapJual;
    private javax.swing.JLabel judulPenjualanHewan;
    private javax.swing.JTextField kontakTextField;
    private javax.swing.JLabel labelCaraPenjualan;
    private javax.swing.JLabel labelIdHewan;
    private javax.swing.JLabel labelIdHewan1;
    private javax.swing.JTable listAdminTable;
    private javax.swing.JTextField nameTextField1;
    private javax.swing.JPanel panelFormJual;
    private javax.swing.JPanel panelHewanSiapJual;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
