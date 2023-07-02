/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import simpurna.DAO.DAOUser;
import simpurna.Impl.DAOImplUser;
import simpurna.model.UserModel;
import simpurna.view.DashboardAdmin;
import simpurna.view.Login;
import java.util.logging.Level;
import java.util.logging.Logger;
import simpurna.DAO.DAOAdmin;
import simpurna.Impl.DAOImplAdmin;
import simpurna.model.AdminModel;
import simpurna.model.Session;
import simpurna.view.DashboardRenter;

/**
 *
 * @author alfia
 */
public class LoginController {
    
    Login login;
    DAOUser implUser;
    DAOAdmin implAdmin;
    List<UserModel> users;
    List<AdminModel> admins;
    
    public LoginController(Login login) {
        this.login = login;
        implUser = new DAOImplUser();
        implAdmin = new DAOImplAdmin();
    }
    
    public void cekLogin(Login loginData) {
        if(!loginData.getUsername().getText().trim().isEmpty() && !loginData.getPass().toString().isEmpty()) {
            String username = loginData.getUsername().getText();
            String pwUser = get_SHA_512_SecurePassword(loginData.getPass().getText(),"puriarjuna");
            String pwAdmin = get_SHA_512_SecurePassword(loginData.getPass().getText(),"admin");
            
            
            users = implUser.prosesLogin(username, pwUser);
            admins = implAdmin.prosesLogin(username, pwAdmin);
            
            if (!admins.isEmpty()) {
                Session session = Session.getInstance();
                session.setUsername(username);
                session.setRole("admin");
                JOptionPane.showMessageDialog(loginData, "Berhasil Login!\nHalo Admin!", "Login berhasil", JOptionPane.INFORMATION_MESSAGE);
                DashboardAdmin dbAdmin= new DashboardAdmin();
                dbAdmin.setVisible(true);
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(dbAdmin);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } else if(!users.isEmpty()) {
                Session session = Session.getInstance();
                session.setUsername(username);
                session.setRole("renter");
                JOptionPane.showMessageDialog(loginData, "Berhasil Login!\nSelamat datang kembali!", "Login berhasil", JOptionPane.INFORMATION_MESSAGE);   
                DashboardRenter dbRenter= new DashboardRenter();
                dbRenter.setVisible(true);
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(dbRenter);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);  
            } else {
               JOptionPane.showMessageDialog(loginData, "Username atau Password salah!","Login Gagal",JOptionPane.ERROR_MESSAGE); 
            }
            
//            if(users.size() == 1) {
//                
//                Session session = Session.getInstance();
//                session.setUsername(username);
//               
//                JOptionPane.showMessageDialog(loginData, "Berhasil Login!\nSelamat datang kembali!", "Login berhasil", JOptionPane.INFORMATION_MESSAGE);
//                DashboardRenter dbRenter= new DashboardRenter();
//                dbRenter.setVisible(true);
//                JFrame frame = new JFrame();
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.getContentPane().add(dbRenter);
//                frame.pack();
//                frame.setLocationRelativeTo(null);
//                frame.setVisible(true);
//            } else {
//                JOptionPane.showMessageDialog(loginData, "Username atau Password salah!","Login Gagal",JOptionPane.ERROR_MESSAGE);
//            }
            
        } else {
            JOptionPane.showMessageDialog(loginData, "Username atau Password tidak boleh kosong!","Login Gagal",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
             MessageDigest md = MessageDigest.getInstance("SHA-512");
            try {
                md.update(salt.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
             byte[] bytes = null;
            try {
                bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
             StringBuilder sb = new StringBuilder();
             for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
             }
             generatedPassword = sb.toString();
            } 
           catch (NoSuchAlgorithmException e){
            e.printStackTrace();
           }
        return generatedPassword;
    }
}
