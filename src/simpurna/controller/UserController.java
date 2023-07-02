/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import simpurna.DAO.DAOUser;
import simpurna.Impl.DAOImplUser;
import simpurna.model.UserModel;
import simpurna.view.AddRenter;
import simpurna.view.DashboardAdmin;
import simpurna.view.ListRenter;
import simpurna.view.RenterUpdate;

/**
 *
 * @author alfia
 */
public class UserController {
    DAOUser impl;
    private ListRenter listRenter;
    
    public UserController() {
        impl = new DAOImplUser();
    }
    
    public void displayUsers(ListRenter listRenter) {
       List<UserModel> users = impl.getAll();
       
       DefaultTableModel model = (DefaultTableModel) listRenter.getPenghuniKosTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (UserModel user : users) {
                Object[] rowData = {user.getUsername(), user.getName(), user.getAddress(), user.getTelephone(), user.getKamar()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void displayUsersInsertedThisYear(AddRenter ar) {
       List<UserModel> users = impl.getInsertedThisYear();
       
       DefaultTableModel model = (DefaultTableModel) ar.getTableAddRenter().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (UserModel user : users) {
                Object[] rowData = {user.getName(), user.getAddress(), user.getTelephone(), user.getTglMasuk(), user.getKamar()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void displayDetailedUsers(RenterUpdate ru, String username) {
       
       UserModel user = impl.getByUsername(username);

       ru.setNama(user.getName());
       ru.getAlamat().setText(user.getAddress());
       ru.getKamar().setSelectedIndex(user.getKamar());
       ru.getKontak().setText(user.getTelephone());
    }
    
    public void setUsername(RenterUpdate ru) {
        ru.getUsernameResult().removeAllItems();
        List <String> usernames = impl.getAllUsername();

         for (String uname: usernames) {
             ru.getUsernameResult().addItem(uname);
         }
    }
    
    public void insertUsers(AddRenter ar) {
        UserModel um = new UserModel();
        
        String username = ar.getUsername().getText();
        String newName = ar.getNameUser().getText();
        String newKontak = ar.getKontak().getText();
        String newAlamat = ar.getAlamat().getText();
        String newKamar = ar.getKamarKosong().getSelectedItem().toString();
        
        um.setUsername(username);
        
        um.setPass(username + "123");
        
        um.setAddress(newAlamat);
        
        um.setKamar(Integer.valueOf(newKamar));
        
        um.setRole("renter");
        
        um.setTelephone(newKontak);
        
        um.setName(newName);
        
        
        impl.add(um);
      
        JOptionPane.showMessageDialog(ar, "Penghuni Berhasil Ditambah\nUsername: " + username +"\nPassword:" + um.getPass(), "Sukses", JOptionPane.INFORMATION_MESSAGE);
        ar.getUsername().setText("");
        ar.getKontak().setText("");
        ar.getNameUser().setText("");
        ar.getAlamat().setText("");
        ar.getKamarKosong().setSelectedIndex(0);
    }
    
    public void updateUsers(RenterUpdate ru) {
        
        String username = ru.getSelectedUsername();
        UserModel user = impl.getByUsername(username);

        user.setName(ru.getNama().getText());
        user.setAddress(ru.getAlamat().getText());
        user.setTelephone(ru.getKontak().getText());
        user.setKamar(Integer.valueOf(ru.getKamar().getSelectedItem().toString()));
        impl.edit(user);
        JOptionPane.showMessageDialog(listRenter, "Data Berhasil diperbarui", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        
        ru.getUsernameResult().setSelectedIndex(0);
        ru.getNama().setText("");
        ru.getAlamat().setText("");
        ru.getKontak().setText("");
        ru.getKamar().setSelectedIndex(-1);
    }
    
    public void countJmlPenghuni(DashboardAdmin dbAdmin) {
        Integer jmlPenghuni = impl.getAll().size();
        
        dbAdmin.getJmlPenghuniLabel().setText(jmlPenghuni.toString());
    }
    
    public void deleteUser(ListRenter lr) {
        Integer selectedRow = lr.getPenghuniKosTable().getSelectedRow();
        
        if (selectedRow >= 0) {
            String username = lr.getPenghuniKosTable().getValueAt(selectedRow, 0).toString();
            
            int confirmation = JOptionPane.showConfirmDialog(lr, "Apakah Anda Yakin?", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {      
                impl.remove(username);
                JOptionPane.showMessageDialog(lr, "Berhasil Menghapus Penghuni", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
    }
}
