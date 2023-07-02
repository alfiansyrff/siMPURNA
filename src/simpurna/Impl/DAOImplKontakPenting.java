/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.Impl;


import java.util.List;
import simpurna.DAO.DAOKontakPenting;
import simpurna.model.KontakPentingModel;
import java.sql.*;
import java.util.ArrayList;
import simpurna.config.Database;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfia
 */
public class DAOImplKontakPenting implements DAOKontakPenting{
    Connection conn;
    
    @Override
    public List<KontakPentingModel> getAll() {
        Database database = Database.getInstance();
        List<KontakPentingModel> kontaks = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from kontak_penting";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
          while(rslt.next()){
              KontakPentingModel kp = new KontakPentingModel();
              kp.setId(rslt.getInt("id"));
              kp.setNama(rslt.getString("nama"));
              kp.setKontak(rslt.getString("nomor"));
              kp.setKeterangan(rslt.getString("keterangan"));
              kontaks.add(kp);
          }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kontaks;
    }

    @Override
    public void edit(KontakPentingModel kp) {
      Database database = Database.getInstance();
        
        try {
            conn = database.getConnection();
            String sql = "UPDATE kontak_penting SET nama = ?, nomor = ?, keterangan = ? WHERE id = ?";
            
            Integer getSelectedId = kp.getId();
            String newNama = kp.getNama();
            String newKeterangan = kp.getKeterangan();
            String newNomor = kp.getKontak();
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            ;
            stmt.setString(1, newNama);
            stmt.setString(2, newNomor);
            stmt.setString(3, newKeterangan);
            stmt.setInt(4, getSelectedId);
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(KontakPentingModel kp) {
        Database database = Database.getInstance();
        
        String nama = kp.getNama();
        String kontak = kp.getKontak();
        String keterangan = kp.getKeterangan();
        
        try{
            conn = database.getConnection();
            String insertSql = "INSERT INTO kontak_penting(nama, nomor, keterangan) VALUES (?, ?, ?)";
            PreparedStatement insertStmt= conn.prepareStatement(insertSql);
            
            insertStmt.setString(1,nama);
            insertStmt.setString(2, kontak);
            insertStmt.setString(3,  keterangan);
    
            insertStmt.executeUpdate();
                
            insertStmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public KontakPentingModel getById(Integer id) {
        Database database = Database.getInstance();
        KontakPentingModel kpm = new KontakPentingModel();
  
        try {
          conn = database.getConnection();
          String sql = "select * from kontak_penting where id= ?";
          
          PreparedStatement stmt= conn.prepareStatement(sql);
          stmt.setInt(1, id);
          ResultSet rslt=stmt.executeQuery();
          
               while(rslt.next()){
                   kpm.setId(rslt.getInt("id"));
                   kpm.setNama(rslt.getString("nama"));
                   kpm.setKontak(rslt.getString("nomor"));
                   kpm.setKeterangan(rslt.getString("keterangan"));
               }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kpm; 
    }
    
}
