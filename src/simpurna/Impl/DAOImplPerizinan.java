/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.Impl;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import simpurna.DAO.DAOPerizinan;
import simpurna.config.Database;
import simpurna.model.PerizinanModel;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import simpurna.model.PerizinanModel.Status;

/**
 *
 * @author alfia
 */
public class DAOImplPerizinan implements DAOPerizinan{
    Connection conn;
    
    @Override
    public void add(PerizinanModel izin) {
        Database database = Database.getInstance();
        
        String id_user = izin.getUsername();
        LocalDateTime tglPembuatanIzin = izin.getTanggalPembuatanIzin();
        LocalDate tglPelaksanaan = izin.getTanggalPelaksanaanIzin();
        String waktuPelaksanaan = izin.getWaktuPelaksanaanIzin();
        String keterangan = izin.getKeterangan();
        Status status = izin.getStatus();
        
        try{
            conn = database.getConnection();
            String insertSql = "INSERT INTO perizinan(username, tanggal_pembuatan, tanggal_pelaksanaan, waktu_pelaksanaan, keterangan, status) values(?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStmt= conn.prepareStatement(insertSql);
            
            insertStmt.setString(1,id_user);
            insertStmt.setTimestamp(2, Timestamp.valueOf(tglPembuatanIzin));
            insertStmt.setDate(3, java.sql.Date.valueOf(tglPelaksanaan));
            insertStmt.setString(4, waktuPelaksanaan);
            insertStmt.setString(5, keterangan);
            insertStmt.setInt(6, status.getValue());
            insertStmt.executeUpdate();
                
            insertStmt.close();
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public List<PerizinanModel> getAllConfirmedPerizinan() {
        Database database = Database.getInstance();
        List<PerizinanModel> perizinans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from perizinan WHERE status IN (2,3)";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);

            while(rslt.next()){
                PerizinanModel pm = new PerizinanModel();
                pm.setId(rslt.getInt("id"));
                pm.setKeterangan(rslt.getString("keterangan"));
                pm.setTanggalPelaksanaanIzin(rslt.getDate("tanggal_pelaksanaan").toLocalDate());
                pm.setTanggalPembuatanIzin(rslt.getTimestamp("tanggal_pembuatan").toLocalDateTime());
                pm.setUsername(rslt.getString("username"));
                pm.setWaktuPelaksanaanIzin(rslt.getString("waktu_pelaksanaan"));
                int statusValue = rslt.getInt("status");
                switch (statusValue) {
                    case 1:
                        pm.setStatus(Status.PENDING);
                        break;
                    case 2:
                        pm.setStatus(Status.DISETUJUI);
                        break;
                    case 3:
                        pm.setStatus(Status.DITOLAK);
                        break;
                    default:
                        // Handle unrecognized status value
                        break;
                }
                
                perizinans.add(pm);
                
                }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perizinans;
    }

    @Override
    public List<PerizinanModel> getAllPerizinanByStatus(int status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PerizinanModel> getByStatus(Integer status) {
        Database database = Database.getInstance();
        List<PerizinanModel> perizinans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from perizinan WHERE status=?";
          
          PreparedStatement stmt= conn.prepareStatement(sql);
          stmt.setInt(1, status);
          ResultSet rslt=stmt.executeQuery();

            while(rslt.next()){
                PerizinanModel pm = new PerizinanModel();
                pm.setId(rslt.getInt("id"));
                pm.setKeterangan(rslt.getString("keterangan"));
                pm.setTanggalPelaksanaanIzin(rslt.getDate("tanggal_pelaksanaan").toLocalDate());
                pm.setTanggalPembuatanIzin(rslt.getTimestamp("tanggal_pembuatan").toLocalDateTime());
                pm.setUsername(rslt.getString("username"));
                pm.setWaktuPelaksanaanIzin(rslt.getString("waktu_pelaksanaan"));
                int statusValue = rslt.getInt("status");
                switch (statusValue) {
                    case 1:
                        pm.setStatus(Status.PENDING);
                        break;
                    case 2:
                        pm.setStatus(Status.DISETUJUI);
                        break;
                    case 3:
                        pm.setStatus(Status.DITOLAK);
                        break;
                    default:
                        // Handle unrecognized status value
                        break;
                }
                
                perizinans.add(pm);
                
                }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perizinans;
    }

    @Override
    public void updateStatus(Integer id, Integer status) {
        Database database = Database.getInstance();
        
        try {
            conn = database.getConnection();
            String sql = "UPDATE perizinan SET status = ? WHERE id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, status);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PerizinanModel> getByUsername(String username) {
    Database database = Database.getInstance();
        List<PerizinanModel> perizinans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from perizinan WHERE username=?";
          
          PreparedStatement stmt= conn.prepareStatement(sql);
          stmt.setString(1, username);
          ResultSet rslt=stmt.executeQuery();

            while(rslt.next()){
                PerizinanModel pm = new PerizinanModel();
                pm.setId(rslt.getInt("id"));
                pm.setKeterangan(rslt.getString("keterangan"));
                pm.setTanggalPelaksanaanIzin(rslt.getDate("tanggal_pelaksanaan").toLocalDate());
                pm.setTanggalPembuatanIzin(rslt.getTimestamp("tanggal_pembuatan").toLocalDateTime());
                pm.setUsername(rslt.getString("username"));
                pm.setWaktuPelaksanaanIzin(rslt.getString("waktu_pelaksanaan"));
                int statusValue = rslt.getInt("status");
                switch (statusValue) {
                    case 1:
                        pm.setStatus(Status.PENDING);
                        break;
                    case 2:
                        pm.setStatus(Status.DISETUJUI);
                        break;
                    case 3:
                        pm.setStatus(Status.DITOLAK);
                        break;
                    default:
                        // Handle unrecognized status value
                        break;
                }
                
                perizinans.add(pm);
                
                }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perizinans;
    }
}
