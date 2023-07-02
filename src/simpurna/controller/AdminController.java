/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import simpurna.DAO.DAOAdmin;
import simpurna.Impl.DAOImplAdmin;
import simpurna.model.AdminModel;
import simpurna.view.ListAdmin;

/**
 *
 * @author alfia
 */
public class AdminController {
    DAOAdmin impl;
    
    public AdminController() {
        impl = new DAOImplAdmin();
    }
    
    public void displayAllAdmin(ListAdmin la) {
       List<AdminModel> admins = impl.getAll();
       
       DefaultTableModel model = (DefaultTableModel) la.getListAdminTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (AdminModel admin : admins) {
                Object[] rowData = {admin.getUsername(), admin.getName(), admin.getKontak()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertAdmin(ListAdmin la) {
        AdminModel am = new AdminModel();
        
        String username = la.getUsername().getText();
        String newName = la.getNama().getText();
        String newKontak = la.getKontak().getText();
        
        am.setUsername(username);
        am.setPassword(username + "123");
        am.setKontak(newKontak);
        am.setName(newName);
        
        impl.add(am);
      
        JOptionPane.showMessageDialog(la, "Admin Berhasil Ditambah\nUsername: " + username +"\nPassword:" + am.getPassword(), "Sukses", JOptionPane.INFORMATION_MESSAGE);
        la.getUsername().setText("");
        la.getKontak().setText("");
        la.getNama().setText("");
    }
    
    public void editAdmin(ListAdmin la) {
        int choice = JOptionPane.showConfirmDialog(la, "Harap tidak mengubah username! Ingin melanjutkan?", "Perhatian", JOptionPane.YES_NO_OPTION);
        
        if (choice == JOptionPane.YES_OPTION) {
            String name = la.getNama().getText();
            String kontak = la.getKontak().getText();
            String username = la.getUsername().getText();

            AdminModel am = new AdminModel();
            am.setName(name);
            am.setKontak(kontak);
            am.setUsername(username);

            impl.edit(am);
            JOptionPane.showMessageDialog(la, "Berhasil Mengupdate Admin!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            la.getUsername().setText("");
            la.getKontak().setText("");
            la.getNama().setText("");
        }
    }
    
    public void deleteAdmin(ListAdmin la) {
        Integer selectedRow = la.getListAdminTable().getSelectedRow();
        
        if (selectedRow >= 0) {
            String username = la.getUsername().getText();
            
            int confirmation = JOptionPane.showConfirmDialog(la, "Apakah Yakin Untuk Menghapus Admin ini?", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {      
                impl.remove(username);
                JOptionPane.showMessageDialog(la, "Berhasil Menghapus Admin", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                la.getUsername().setText("");
                la.getKontak().setText("");
                la.getNama().setText("");
            } 
        }
    }
}
