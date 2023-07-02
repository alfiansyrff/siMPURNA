/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.Impl;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import simpurna.DAO.DAOKamar;
import simpurna.config.Database;
import simpurna.model.KamarModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author alfia
 */
public class DAOImplKamar implements DAOKamar{
    
    Connection conn;
    
    @Override
    public List<KamarModel> getAll() {
        Database database = Database.getInstance();
        List<KamarModel> kamars = new ArrayList<>();
        
        try {
          conn = database.getConnection();
          String sql = "select * from kamar";
          
          Statement stmt= conn.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   KamarModel kamar = new KamarModel();
                   kamar.setNoKamar(rslt.getInt("id_kamar"));
                   kamar.setIsRented(rslt.getBoolean("is_rented"));
                   kamar.setTipeKamar(rslt.getString("tipe_kamar"));
                   kamar.setHargaSewa(rslt.getDouble("harga_sewa"));
                   kamars.add(kamar);
               }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kamars;
    }

    @Override
    public List<KamarModel> getByType(String type) {
        Database database = Database.getInstance();
        List<KamarModel> kamars = new ArrayList<>();
        
        try {
          conn = database.getConnection();
          String sql = "SELECT kamar.*, users.name FROM kamar JOIN users ON kamar.id_kamar = users.id_kamar WHERE kamar.tipe_kamar = ? AND kamar.is_rented = true";
          
          PreparedStatement stmt= conn.prepareStatement(sql);
          stmt.setString(1, type);
          ResultSet rslt = stmt.executeQuery();
          
          while(rslt.next()){
            KamarModel kamar = new KamarModel();
            kamar.setNoKamar(rslt.getInt("id_kamar"));
            kamar.setIsRented(rslt.getBoolean("is_rented"));
            kamar.setTipeKamar(rslt.getString("tipe_kamar"));
            kamar.setHargaSewa(rslt.getDouble("harga_sewa"));
            kamar.setPenyewa(rslt.getString("name"));
            kamars.add(kamar);
          }
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kamars;
    }

    @Override
    public void edit(KamarModel kamar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Integer> getKamarByStatus(boolean isRented) {
        List<Integer> kamars = new ArrayList<>();
        Database database = Database.getInstance();

        try {
            conn = database.getConnection();
            String sql = "SELECT id_kamar FROM kamar WHERE is_rented=?";
            
            PreparedStatement stmt= conn.prepareStatement(sql);
            stmt.setBoolean(1, isRented);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Integer kamar = rs.getInt("id_kamar");
                kamars.add(kamar);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kamars;
    }

}
