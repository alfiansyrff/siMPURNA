/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package simpurna.view;

import java.awt.TextArea;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import simpurna.controller.KontakPentingController;

/**
 *
 * @author alfia
 */
public class KontakPentingAdmin extends javax.swing.JPanel {

    /**
     * Creates new form KontakPentingAdmin
     */
    KontakPentingController kpc = new KontakPentingController();
    public Integer id;
    
    public KontakPentingAdmin() {
        initComponents();
        kpc.displayAllInAdmin(this);
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
        tambahButton = new javax.swing.JButton();
        labelIdHewan1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        kontakTextField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        keteranganTextArea = new javax.swing.JTextArea();
        panelHewanSiapJual = new javax.swing.JPanel();
        judulHewanSiapJual = new javax.swing.JLabel();
        jScrollHewanSiapJual = new javax.swing.JScrollPane();
        kontakPentingTable = new javax.swing.JTable();
        homeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFormJual.setBackground(new java.awt.Color(249, 251, 231, 199));
        panelFormJual.setPreferredSize(new java.awt.Dimension(277, 134));

        judulPenjualanHewan.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        judulPenjualanHewan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulPenjualanHewan.setText("FORM KONTAK PENTING");

        labelIdHewan.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        labelIdHewan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelIdHewan.setText("No. Telepon");

        labelCaraPenjualan.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        labelCaraPenjualan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCaraPenjualan.setText("Keterangan");

        tambahButton.setBackground(new java.awt.Color(204, 204, 204));
        tambahButton.setText("TAMBAH");
        tambahButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        labelIdHewan1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        labelIdHewan1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelIdHewan1.setText("Nama");

        nameTextField.setMinimumSize(new java.awt.Dimension(64, 26));

        kontakTextField.setMinimumSize(new java.awt.Dimension(64, 26));

        updateButton.setText("UPDATE");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        keteranganTextArea.setColumns(20);
        keteranganTextArea.setRows(5);
        keteranganTextArea.setLineWrap(true);
        keteranganTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(keteranganTextArea);

        javax.swing.GroupLayout panelFormJualLayout = new javax.swing.GroupLayout(panelFormJual);
        panelFormJual.setLayout(panelFormJualLayout);
        panelFormJualLayout.setHorizontalGroup(
            panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormJualLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulPenjualanHewan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelFormJualLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormJualLayout.createSequentialGroup()
                        .addComponent(labelCaraPenjualan, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormJualLayout.createSequentialGroup()
                        .addGroup(panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                            .addComponent(kontakTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelFormJualLayout.createSequentialGroup()
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tambahButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelFormJualLayout.createSequentialGroup()
                                .addGroup(panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelIdHewan1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelIdHewan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))))
        );
        panelFormJualLayout.setVerticalGroup(
            panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormJualLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(judulPenjualanHewan)
                .addGap(18, 18, 18)
                .addComponent(labelIdHewan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelIdHewan)
                .addGap(4, 4, 4)
                .addComponent(kontakTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCaraPenjualan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(panelFormJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahButton)
                    .addComponent(updateButton))
                .addGap(26, 26, 26))
        );

        add(panelFormJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 290, 390));

        panelHewanSiapJual.setBackground(new java.awt.Color(249, 251, 231, 199));
        panelHewanSiapJual.setPreferredSize(new java.awt.Dimension(277, 134));

        judulHewanSiapJual.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        judulHewanSiapJual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulHewanSiapJual.setText("DAFTAR KONTAK PENTING");

        kontakPentingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Kontak", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kontakPentingTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kontakPentingTable.setRowHeight(30);
        kontakPentingTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kontakPentingTableMouseClicked(evt);
            }
        });
        jScrollHewanSiapJual.setViewportView(kontakPentingTable);

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
                .addComponent(jScrollHewanSiapJual, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        panelHewanSiapJualLayout.setVerticalGroup(
            panelHewanSiapJualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHewanSiapJualLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(judulHewanSiapJual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollHewanSiapJual, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        add(panelHewanSiapJual, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 520, 390));

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/home.png"))); // NOI18N
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

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        //         TODO add your handling code here:
        kpc.insertKontakPenting(this);
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void kontakPentingTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kontakPentingTableMouseClicked
        // TODO add your handling code here:
        int row = kontakPentingTable.getSelectedRow();
        String name = kontakPentingTable.getValueAt(row, 1).toString();
        String kontak = kontakPentingTable.getValueAt(row, 2).toString();
        String keterangan = kontakPentingTable.getValueAt(row, 3).toString();
        nameTextField.setText(name);
        kontakTextField.setText(kontak);
        keteranganTextArea.setText(keterangan);
        this.id = (Integer) kontakPentingTable.getValueAt(row, 0);
    }//GEN-LAST:event_kontakPentingTableMouseClicked

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        kpc.updateKontakPenting(this);
    }//GEN-LAST:event_updateButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        DashboardAdmin da = new DashboardAdmin();
   
        JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);

        parentWindow.getContentPane().remove(this);

        parentWindow.getContentPane().add(da);

        parentWindow.pack();

        da.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed
    
    public JTextField getNama() {
        return nameTextField;
    }
    
    public JTextField getKontak() {
       return kontakTextField;
    }   
    
    public JTextArea getKeterangan() {
       return keteranganTextArea;
    }
    
    public JTable getTable() {
        return kontakPentingTable;
    }
    
    public Integer getSelectedId() {
        return this.id;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollHewanSiapJual;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judulHewanSiapJual;
    private javax.swing.JLabel judulPenjualanHewan;
    private javax.swing.JTextArea keteranganTextArea;
    private javax.swing.JTable kontakPentingTable;
    private javax.swing.JTextField kontakTextField;
    private javax.swing.JLabel labelCaraPenjualan;
    private javax.swing.JLabel labelIdHewan;
    private javax.swing.JLabel labelIdHewan1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel panelFormJual;
    private javax.swing.JPanel panelHewanSiapJual;
    private javax.swing.JButton tambahButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
