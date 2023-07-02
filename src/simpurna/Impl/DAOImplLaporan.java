/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.Impl;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import simpurna.DAO.DAOLaporan;
import simpurna.config.Database;
import simpurna.model.LaporanModel;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfia
 */
public class DAOImplLaporan implements DAOLaporan{
    Connection conn;
    
    @Override
    public void add(LaporanModel laporan) {
        Database database = Database.getInstance();
        
        Integer idLaporan = laporan.getIdPelaporan();
        LocalDateTime tgl = laporan.getTanggalPelaporan();
        String pelapor = laporan.getUsernamePelapor();
        String isiLaporan = laporan.getIsiLaporan();
        String tanggapan = laporan.getTanggapanAdmin();
        Boolean status = laporan.isStatus();
        
        try{
            conn = database.getConnection();
            String insertSql = "INSERT INTO laporan(tanggal_pelaporan, username_pelapor, isi_laporan, tanggapan_admin, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertStmt= conn.prepareStatement(insertSql);
            
            insertStmt.setTimestamp(1, Timestamp.valueOf(tgl));    
            insertStmt.setString(2, pelapor);
            insertStmt.setString(3,isiLaporan);
            insertStmt.setString(4, tanggapan);
            insertStmt.setBoolean(5, status);
            
            insertStmt.executeUpdate();
            insertStmt.close();
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public void updateStatus(int idPelaporan) {
        Database database = Database.getInstance();
       
        try {
            conn = database.getConnection();
            String sql = "UPDATE laporan SET status = ? WHERE id_pelaporan = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setInt(2, idPelaporan);
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void updateTanggapan(int idPelaporan, String tanggapan) {
       Database database = Database.getInstance();
       
        try {
            conn = database.getConnection();
            String sql = "UPDATE laporan SET tanggapan_admin = ? WHERE id_pelaporan = ?";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, tanggapan);
            stmt.setInt(2, idPelaporan);
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void hapusLaporan(int idPelaporan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LaporanModel getLaporanById(int idPelaporan) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LaporanModel> getAllLaporan() {
        Database database = Database.getInstance();
        List<LaporanModel> laporans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from laporan";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);

            while(rslt.next()){
                LaporanModel lm = new LaporanModel();
                lm.setIdPelaporan(rslt.getInt("id_pelaporan"));
                lm.setTanggalPelaporan(rslt.getTimestamp("tanggal_pelaporan").toLocalDateTime());
                lm.setUsernamePelapor(rslt.getString("username_pelapor"));
                lm.setIsiLaporan(rslt.getString("isi_laporan"));
                lm.setTanggapanAdmin(rslt.getString("tanggapan_admin"));
                lm.setStatus(rslt.getBoolean("status"));

                laporans.add(lm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laporans;
    }

    @Override
    public List<LaporanModel> getLaporanByStatus(boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LaporanModel> getLaporanByUsername(String username) {
        Database database = Database.getInstance();
        List<LaporanModel> laporans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from laporan WHERE username_pelapor=?";
          
          PreparedStatement stmt= conn.prepareStatement(sql);
          stmt.setString(1, username);
          ResultSet rslt=stmt.executeQuery();

            while(rslt.next()){
                LaporanModel lm = new LaporanModel();
                lm.setIdPelaporan(rslt.getInt("id_pelaporan"));
                lm.setTanggalPelaporan(rslt.getTimestamp("tanggal_pelaporan").toLocalDateTime());
                lm.setUsernamePelapor(rslt.getString("username_pelapor"));
                lm.setIsiLaporan(rslt.getString("isi_laporan"));
                lm.setTanggapanAdmin(rslt.getString("tanggapan_admin"));
                lm.setStatus(rslt.getBoolean("status"));

                laporans.add(lm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return laporans;
    }
    

    
}
