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
          String sql = "select * from users";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   UserModel user = new UserModel();
                   user.setUsername(rslt.getString("username"));
//                   user.setPass(rslt.getString("password"));
                   user.setName(rslt.getString("name"));
                   user.setAddress(rslt.getString("address"));
                   user.setTelephone(rslt.getString("telephone"));
                   user.setRole(rslt.getString("role"));
                   users.add(user);
               }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
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
        
        try{
            conn = database.getConnection();
            String sql="insert into users(username, password, name, address, telephone, role) values(?,?,?,?,?,?)";
            PreparedStatement stmt= conn.prepareStatement(sql);
            
                stmt.setString(1,username);
                stmt.setString(2,pass);
                stmt.setString(3, name);
                stmt.setString(4, address);
                stmt.setString(5, telephone);
                stmt.setString(6, role);
                
                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void edit(UserModel user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(String idUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
