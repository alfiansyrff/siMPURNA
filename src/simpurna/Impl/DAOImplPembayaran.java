/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.Impl;

import java.util.List;
import simpurna.DAO.DAOPembayaran;
import simpurna.config.Database;
import simpurna.model.PembayaranModel;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alfia
 */
public class DAOImplPembayaran implements DAOPembayaran{
    Connection conn;
    
    @Override
    public List<PembayaranModel> getAll() {
        Database database = Database.getInstance();
        List<PembayaranModel> pembayarans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from pembayaran";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);

            while(rslt.next()){
                PembayaranModel pm = new PembayaranModel();
                pm.setId_pembayaran(rslt.getInt("id_pembayaran"));
                pm.setId_user(rslt.getString("id_user"));
                pm.setId_kamar(rslt.getInt("id_kamar"));
                pm.setTotalBayar(rslt.getDouble("total_pembayaran"));
                pm.setMetode(rslt.getString("metode_bayar"));
                pm.setTgl(rslt.getTimestamp("tanggal").toLocalDateTime());
                pm.setStatus(rslt.getBoolean("status"));
                pembayarans.add(pm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pembayarans;
    }

    @Override
    public List<PembayaranModel> getByUsername(String username) {
        Database database = Database.getInstance();
        List<PembayaranModel> pembayarans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from pembayaran WHERE id_user=?";
          
          PreparedStatement stmt= conn.prepareStatement(sql);
          stmt.setString(1, username);
          ResultSet rslt=stmt.executeQuery();

            while(rslt.next()){
                PembayaranModel pm = new PembayaranModel();
                pm.setId_pembayaran(rslt.getInt("id_pembayaran"));
                pm.setId_user(rslt.getString("id_user"));
                pm.setId_kamar(rslt.getInt("id_kamar"));
                pm.setTotalBayar(rslt.getDouble("total_pembayaran"));
                pm.setMetode(rslt.getString("metode_bayar"));
                pm.setTgl(rslt.getTimestamp("tanggal").toLocalDateTime());
                pm.setStatus(rslt.getBoolean("status"));
                pembayarans.add(pm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pembayarans;
    }

    @Override
    public void edit(PembayaranModel pm) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(PembayaranModel pm) {
        Database database = Database.getInstance();
        
        String id_user = pm.getId_user();
        Integer id_bayar = pm.getId_pembayaran();
        Integer id_kamar = pm.getId_kamar();
        String metode = pm.getMetode();
        Double totalBayar = pm.getTotalBayar();
        Boolean status = pm.getStatus();
        LocalDateTime tgl = pm.getTgl();
        
        try{
            conn = database.getConnection();
            String insertSql = "insert into pembayaran(id_user, id_kamar, total_pembayaran, tanggal, metode_bayar, status) values(?,?,?,?,?,?)";
            PreparedStatement insertStmt= conn.prepareStatement(insertSql);
            
            insertStmt.setString(1,id_user);
            insertStmt.setInt(2, id_kamar);
            insertStmt.setDouble(3, totalBayar);
            insertStmt.setTimestamp(4, Timestamp.valueOf(tgl));
            insertStmt.setString(5, metode);
            insertStmt.setBoolean(6, status);
            insertStmt.executeUpdate();
                
            insertStmt.close();
            
        }catch(Exception err){
            err.printStackTrace();
        }
    }

    @Override
    public List<PembayaranModel> getByStatus(Boolean status) {
        Database database = Database.getInstance();
        List<PembayaranModel> pembayarans = new ArrayList<>();
        try {
          conn = database.getConnection();
          String sql = "select * from pembayaran WHERE status=?";
          
          PreparedStatement stmt= conn.prepareStatement(sql);
          stmt.setBoolean(1, status);
          ResultSet rslt=stmt.executeQuery();

            while(rslt.next()){
                PembayaranModel pm = new PembayaranModel();
                pm.setId_pembayaran(rslt.getInt("id_pembayaran"));
                pm.setId_user(rslt.getString("id_user"));
                pm.setId_kamar(rslt.getInt("id_kamar"));
                pm.setTotalBayar(rslt.getDouble("total_pembayaran"));
                pm.setMetode(rslt.getString("metode_bayar"));
                pm.setTgl(rslt.getTimestamp("tanggal").toLocalDateTime());
                pm.setStatus(rslt.getBoolean("status"));
                pembayarans.add(pm);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pembayarans;
    }

    @Override
    public void updateStatus(Integer id_bayar) {
        Database database = Database.getInstance();
        
        try {
            conn = database.getConnection();
            String sql = "UPDATE pembayaran SET status = true WHERE id_pembayaran = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id_bayar);
            stmt.executeUpdate();
            
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
