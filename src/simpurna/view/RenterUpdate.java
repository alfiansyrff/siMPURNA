/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package simpurna.view;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import simpurna.controller.UserController;

/**
 *
 * @author alfia
 */
public class RenterUpdate extends javax.swing.JPanel {

    /**
     * Creates new form RenterUpdate
     */
    private UserController  userController = new UserController();
    private String selectedUsername;
    
    public RenterUpdate() {
       initComponents();
       userController.setUsername(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_beri_makanPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        namaTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        kamarComboBox = new javax.swing.JComboBox<>();
        kontakTextField = new javax.swing.JTextField();
        alamatTextField = new javax.swing.JTextField();
        usernameComboBox = new javax.swing.JComboBox<>();
        homeButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        form_beri_makanPanel.setBackground(new java.awt.Color(249, 251, 231, 199));
        form_beri_makanPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel6.setText("Nama");
        form_beri_makanPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel8.setText("Username");
        form_beri_makanPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel9.setText(" Kontak");
        form_beri_makanPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        namaTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        form_beri_makanPanel.add(namaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel10.setText("Kamar");
        form_beri_makanPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel11.setText("Alamat");
        form_beri_makanPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        updateButton.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        form_beri_makanPanel.add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Update Penghuni");
        form_beri_makanPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 28));

        kamarComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        kamarComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));
        kamarComboBox.setMinimumSize(new java.awt.Dimension(112, 27));
        kamarComboBox.setPreferredSize(new java.awt.Dimension(112, 27));
        kamarComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kamarComboBoxActionPerformed(evt);
            }
        });
        form_beri_makanPanel.add(kamarComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 250, -1));

        kontakTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        form_beri_makanPanel.add(kontakTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 250, -1));

        alamatTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        form_beri_makanPanel.add(alamatTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 250, -1));

        usernameComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        usernameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "alfian", "yahya" }));
        usernameComboBox.setMinimumSize(new java.awt.Dimension(112, 27));
        usernameComboBox.setPreferredSize(new java.awt.Dimension(112, 27));
        usernameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameComboBoxActionPerformed(evt);
            }
        });
        form_beri_makanPanel.add(usernameComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 250, -1));

        add(form_beri_makanPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 306, 410));

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/home.png"))); // NOI18N
        homeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });
        add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 60, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simpurna/asset/background.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        userController.updateUsers(this);
       
    }//GEN-LAST:event_updateButtonActionPerformed

    private void kamarComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kamarComboBoxActionPerformed
        // TODO add your handling code here:

      
    }//GEN-LAST:event_kamarComboBoxActionPerformed

    private void usernameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameComboBoxActionPerformed
        // TODO add your handling code here:
        Object selectedItem = usernameComboBox.getSelectedItem();
        if (selectedItem != null) {           
            String selectedUname = usernameComboBox.getSelectedItem().toString();
            selectedUsername = selectedUname;
            userController.displayDetailedUsers(this, selectedUsername);
        }
    }//GEN-LAST:event_usernameComboBoxActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        DashboardAdmin da = new DashboardAdmin();
   
        JFrame parentWindow = (JFrame) SwingUtilities.getWindowAncestor(this);

        parentWindow.getContentPane().remove(this);

        parentWindow.getContentPane().add(da);

        parentWindow.pack();

        da.setVisible(true);
    }//GEN-LAST:event_homeButtonActionPerformed
    
    public JComboBox getUsernameResult() {
        return usernameComboBox;
    }
    
    public String getSelectedUsername() {
        return selectedUsername;
    }
    
    public JTextField getAlamat() {
        return alamatTextField;
    }    
    
    public JTextField getKontak() {
        return kontakTextField;
    }
    
    public JTextField getNama() {
        return namaTextField;
    }
    
    public JComboBox getKamar() {
        return kamarComboBox;
    }
    
    public void setNama(String nama) {
        namaTextField.setText(nama);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamatTextField;
    private javax.swing.JPanel form_beri_makanPanel;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> kamarComboBox;
    private javax.swing.JTextField kontakTextField;
    private javax.swing.JTextField namaTextField;
    private javax.swing.JButton updateButton;
    private javax.swing.JComboBox<String> usernameComboBox;
    // End of variables declaration//GEN-END:variables
}
