/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.Impl;

import java.util.List;
import simpurna.DAO.DAOPengumuman;
import simpurna.model.PengumumanModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import simpurna.config.Database;

/**
 *
 * @author alfia
 */
public class DAOImplPengumuman implements DAOPengumuman{
    Connection conn;
    
    @Override
    public List<PengumumanModel> getAll() {
        Database database = Database.getInstance();
        List<PengumumanModel> pengumumans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "SELECT * FROM pengumuman";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);

            while(rslt.next()){
                PengumumanModel pm = new PengumumanModel();
                pm.setId(rslt.getInt("id"));
                pm.setUsername(rslt.getString("username"));
                pm.setTanggal(rslt.getTimestamp("tanggal").toLocalDateTime());
                pm.setIsi(rslt.getString("isi"));
                pengumumans.add(pm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pengumumans;
    }

    @Override
    public void add(PengumumanModel pm) {
        Database database = Database.getInstance();
        
        String username = pm.getUsername();
        String isi = pm.getIsi();
        LocalDateTime tanggal = pm.getTanggal();
        
        try{
            conn = database.getConnection();
            String insertSql = "INSERT INTO pengumuman(tanggal, isi, username) values(?,?,?)";
            PreparedStatement insertStmt= conn.prepareStatement(insertSql);
            
            insertStmt.setTimestamp(1, Timestamp.valueOf(tanggal));    
            insertStmt.setString(2, isi);
            insertStmt.setString(3,username);
            
            insertStmt.executeUpdate();
            insertStmt.close();
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void edit(PengumumanModel pm) {
        Database database = Database.getInstance();
        Integer id = pm.getId();
        String username = pm.getUsername();
        String isi = pm.getIsi();
        LocalDateTime tanggal = pm.getTanggal();
       
        try {
            conn = database.getConnection();
            String sql = "UPDATE pengumuman SET username = ?, isi = ?, tanggal = ? WHERE id = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, isi);
            stmt.setTimestamp(3,Timestamp.valueOf(tanggal));
            stmt.setInt(4, id);
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id) {
        Database database = Database.getInstance();

        try {
            conn = database.getConnection();
            String sql = "DELETE FROM pengumuman WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    
}
