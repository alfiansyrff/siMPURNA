/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.Impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import simpurna.DAO.DAOAdmin;
import simpurna.config.Database;
import simpurna.model.AdminModel;
import java.sql.*;
import simpurna.view.ListAdmin;

/**
 *
 * @author alfia
 */
public class DAOImplAdmin implements DAOAdmin{
    Connection conn;
    
    @Override
    public List<AdminModel> prosesLogin(String user, String pass) {
        Database database = Database.getInstance();
        List<AdminModel> admins = new ArrayList<>();
         
        try {
         conn = database.getConnection();
         String sql = "select * from admin where username='"+user+"' AND password='"+pass+"'";

         Statement stmt = conn.createStatement();
         ResultSet rslt = stmt.executeQuery(sql);

              while(rslt.next()){
                  AdminModel am = new AdminModel();
                  am.setUsername(rslt.getString("username"));
                  am.setPassword(rslt.getString("password"));
                  admins.add(am);
              }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return admins;
    }

    @Override
    public void add(AdminModel am) {
        Database database = Database.getInstance();
        
        String username = am.getUsername();
        String name = am.getName();
        String password = get_SHA_512_SecurePassword(am.getPassword(),"admin");
        String kontak = am.getKontak();
        
        try{
            conn = database.getConnection();
            String insertSql = "insert into admin(username, password, name, kontak) values(?,?,?,?)";
            PreparedStatement insertStmt= conn.prepareStatement(insertSql);
            
            insertStmt.setString(1,username);
            insertStmt.setString(2, password);
            insertStmt.setString(3, name);
            insertStmt.setString(4, kontak);
            insertStmt.executeUpdate();
                
            insertStmt.close();
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }
    
    @Override
    public void edit(AdminModel am) {
        Database database = Database.getInstance();
       
        try {
            conn = database.getConnection();
            String sql = "UPDATE admin SET name= ?, kontak = ? WHERE username = ?";
            
            String username = am.getUsername();
            String newNama = am.getName();
            String newNomor = am.getKontak();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ;
            stmt.setString(1, newNama);
            stmt.setString(2, newNomor);
            stmt.setString(3, username);
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(String username) {
        Database database = Database.getInstance();

        try {
            conn = database.getConnection();
            String sql = "DELETE FROM admin WHERE username = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public List<AdminModel> getAll() {
        Database database = Database.getInstance();
        List<AdminModel> admins = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from admin";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   AdminModel admin = new AdminModel();
                   admin.setUsername(rslt.getString("username"));
                   admin.setKontak(rslt.getString("kontak"));
                   admin.setName(rslt.getString("name"));
                   admins.add(admin);
               }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admins;
    }

    
    public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
             MessageDigest md = MessageDigest.getInstance("SHA-512");
            try {
                md.update(salt.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
            }
             byte[] bytes = null;
            try {
                bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
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
