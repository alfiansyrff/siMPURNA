/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.Impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import simpurna.DAO.DAOUser;
import simpurna.config.Database;
import simpurna.model.UserModel;

/**
 *
 * @author alfia
 */
public class DAOImplUser implements DAOUser{
    Connection conn;


    @Override
    public List<UserModel> getAll() {
        Database database = Database.getInstance();
        List<UserModel> users = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from users where role='renter'";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   UserModel user = new UserModel();
                   user.setUsername(rslt.getString("username"));
                   user.setName(rslt.getString("name"));
                   user.setAddress(rslt.getString("address"));
                   user.setTelephone(rslt.getString("telephone"));
                   user.setRole(rslt.getString("role"));
                   user.setKamar(rslt.getInt("id_kamar"));
                   users.add(user);
               }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    @Override
    public UserModel getByUsername(String username) {
        Database database = Database.getInstance();
        UserModel user = new UserModel();
  
        try {
          conn = database.getConnection();
          String sql = "select * from users where role='renter' AND username= ?";
          
          PreparedStatement stmt= conn.prepareStatement(sql);
          stmt.setString(1, username);
          ResultSet rslt=stmt.executeQuery();
          
               while(rslt.next()){
                   user.setUsername(rslt.getString("username"));
                   user.setName(rslt.getString("name"));
                   user.setAddress(rslt.getString("address"));
                   user.setTelephone(rslt.getString("telephone"));
                   user.setRole(rslt.getString("role"));
                   user.setKamar(rslt.getInt("id_kamar"));
               }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user; 
    }
    
    @Override
    public List<UserModel> prosesLogin(String user, String pass) {
        Database database = Database.getInstance();
        List<UserModel> users = new ArrayList<>();
         
        try {
         conn = database.getConnection();
         String sql = "select * from users where username='"+user+"' AND password='"+pass+"'";

         Statement stmt = conn.createStatement();
         ResultSet rslt = stmt.executeQuery(sql);

              while(rslt.next()){
                  UserModel um = new UserModel();
                  um.setUsername(rslt.getString("username"));
                  um.setPass(rslt.getString("password"));
                  users.add(um);
              }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return users;
    }

    @Override
    public void add(UserModel user) {
        Database database = Database.getInstance();
        
        String username = user.getUsername();
        String pass = get_SHA_512_SecurePassword(user.getPass(),"puriarjuna");
        String name = user.getName();
        String address = user.getAddress();
        String telephone = user.getTelephone();
        String role = user.getRole();
        Integer id_kamar = user.getKamar();
        
        try{
            conn = database.getConnection();
            String insertSql = "insert into users(username, password, name, address, telephone, role, id_kamar) values(?,?,?,?,?,?,?)";
            PreparedStatement insertStmt= conn.prepareStatement(insertSql);
            
            insertStmt.setString(1,username);
            insertStmt.setString(2,pass);
            insertStmt.setString(3, name);
            insertStmt.setString(4, address);
            insertStmt.setString(5, telephone);
            insertStmt.setString(6, role);
            insertStmt.setInt(7, id_kamar);
            insertStmt.executeUpdate();
                
            insertStmt.close();

            String updateSql = "UPDATE kamar SET is_rented = TRUE WHERE id_kamar = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);

            updateStmt.setInt(1, id_kamar);

            updateStmt.executeUpdate();
            updateStmt.close();
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void edit(UserModel user) {
        Database database = Database.getInstance();
        
        String username = user.getUsername();
        
        try {
            conn = database.getConnection();
            
            String selectPreviousKamarSql = "SELECT id_kamar FROM users WHERE username = ?";
            PreparedStatement selectPreviousKamarStmt = conn.prepareStatement(selectPreviousKamarSql);
            selectPreviousKamarStmt.setString(1, username);
            ResultSet previousKamarResult = selectPreviousKamarStmt.executeQuery();

            int previousKamarId = 0;

            if (previousKamarResult.next()) {
                previousKamarId = previousKamarResult.getInt("id_kamar");
            }

            selectPreviousKamarStmt.close();
    
    
            String updateUsersql = "UPDATE users SET name = ?, address = ?,  telephone = ?, id_kamar = ? WHERE username = ?";
            PreparedStatement updateUserstmt = conn.prepareStatement(updateUsersql);
            
            updateUserstmt.setString(1,user.getName());
            updateUserstmt.setString(2,user.getAddress());
            updateUserstmt.setString(3, user.getTelephone());
            updateUserstmt.setInt(4, user.getKamar());
            updateUserstmt.setString(5, username);

            updateUserstmt.executeUpdate();

            updateUserstmt.close();
           
            if (previousKamarId != 0) {
                // Update previous kamar in kamar table
                String updatePreviousKamarSql = "UPDATE kamar SET is_rented = FALSE WHERE id_kamar = ?";
                PreparedStatement updatePreviousKamarStmt = conn.prepareStatement(updatePreviousKamarSql);

                updatePreviousKamarStmt.setInt(1, previousKamarId);

                updatePreviousKamarStmt.executeUpdate();
                updatePreviousKamarStmt.close();
            }
            
            // Update new kamar in kamar table
            String updateNewKamarSql = "UPDATE kamar SET is_rented = TRUE WHERE id_kamar = ?";
            PreparedStatement updateNewKamarStmt = conn.prepareStatement(updateNewKamarSql);

            updateNewKamarStmt.setInt(1, user.getKamar());

            updateNewKamarStmt.executeUpdate();
            updateNewKamarStmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(String idUser) {
        Database database = Database.getInstance();
        
        
        try {
            conn = database.getConnection();
            
            String selectPreviousKamarSql = "SELECT id_kamar FROM users WHERE username = ?";
            PreparedStatement selectPreviousKamarStmt = conn.prepareStatement(selectPreviousKamarSql);
            selectPreviousKamarStmt.setString(1, idUser);
            ResultSet previousKamarResult = selectPreviousKamarStmt.executeQuery();

            int previousKamarId = 0;

            if (previousKamarResult.next()) {
                previousKamarId = previousKamarResult.getInt("id_kamar");
            }

            selectPreviousKamarStmt.close();
    
    
            String deleteUsersql = "DELETE FROM users WHERE username = ?";
            PreparedStatement deleteStmt = conn.prepareStatement(deleteUsersql);
            
            deleteStmt.setString(1,idUser);
 
            deleteStmt.executeUpdate();

            deleteStmt.close();
           
            if (previousKamarId != 0) {
                // Update previous kamar in kamar table
                    String updatePreviousKamarSql = "UPDATE kamar SET is_rented = FALSE WHERE id_kamar = ?";
                PreparedStatement updatePreviousKamarStmt = conn.prepareStatement(updatePreviousKamarSql);

                updatePreviousKamarStmt.setInt(1, previousKamarId);

                updatePreviousKamarStmt.executeUpdate();
                updatePreviousKamarStmt.close();
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public List<String> getAllUsername() {
        List<String> usernames = new ArrayList<>();
        Database database = Database.getInstance();

        try {
            conn = database.getConnection();
            String sql = "SELECT username FROM users WHERE role='renter'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String username = rs.getString("username");
                usernames.add(username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usernames;
    }

    @Override
    public List<UserModel> getInsertedThisYear() {
        Database database = Database.getInstance();
        List<UserModel> users = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "SELECT * FROM users WHERE YEAR(tglMasuk) = YEAR(CURRENT_DATE);";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   UserModel user = new UserModel();
                   user.setUsername(rslt.getString("username"));
                   user.setName(rslt.getString("name"));
                   user.setAddress(rslt.getString("address"));
                   user.setTelephone(rslt.getString("telephone"));
                   user.setRole(rslt.getString("role"));
                   user.setKamar(rslt.getInt("id_kamar"));
                   user.setTglMasuk(rslt.getTimestamp("tglMasuk").toLocalDateTime());
                   users.add(user);
               }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }


}
