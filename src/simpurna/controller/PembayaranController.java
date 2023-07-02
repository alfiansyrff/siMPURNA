/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import simpurna.DAO.DAOPembayaran;
import simpurna.DAO.DAOUser;
import simpurna.Impl.DAOImplPembayaran;
import simpurna.Impl.DAOImplUser;
import simpurna.model.PembayaranModel;
import simpurna.model.Session;
import simpurna.model.UserModel;
import simpurna.view.DashboardAdmin;
import simpurna.view.DashboardRenter;
import simpurna.view.Pembayaran;
import simpurna.view.PembayaranAdmin;

/**
 *
 * @author alfia
 */
public class PembayaranController {
    DAOPembayaran impl;
    
    public PembayaranController() {
        this.impl = new DAOImplPembayaran();
    }
    
    public void displayTablePembayaran(Pembayaran pembayaran) {
        Session session = Session.getInstance();
        String username = session.getUsername();
        
        List<PembayaranModel> pembayarans = impl.getByUsername(username);
       
        DefaultTableModel model = (DefaultTableModel) pembayaran.getRincianTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (PembayaranModel pm: pembayarans) {
                String status = pm.getStatus() ? "Sukses" : "Pengecekan";
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String totalBayar = formatter.format(pm.getTotalBayar());
                Object[] rowData = {pm.getId_pembayaran(), pm.getMetode(), pm.getTgl(), totalBayar, status};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
   
    public void addPembayaran(Pembayaran pembayaran) {
        PembayaranModel pm = new PembayaranModel();
        
        String username = pembayaran.getUsername().getText();
        String selectedMetode = pembayaran.getMetode().getSelectedItem().toString();
        String[] parts = selectedMetode.split("\\(");
        String metode = parts[0].trim();
        Double totalBayar = Double.valueOf(pembayaran.getTotalBayar().getText());
        Instant instant = pembayaran.getTglBayar().getDate().toInstant();
        LocalDateTime tglBayar = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        
        DAOUser implUser = new DAOImplUser();
        UserModel um = implUser.getByUsername(username);
        
        pm.setId_user(username);
        pm.setMetode(metode);
        pm.setTgl(tglBayar);
        pm.setTotalBayar(totalBayar);
        pm.setStatus(false);
        pm.setId_kamar(um.getKamar());
      
        impl.insert(pm);
        JOptionPane.showMessageDialog(pembayaran, "Data Pembayaran Berhasil Ditambah", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        pembayaran.getMetode().setSelectedIndex(0);
        pembayaran.getTotalBayar().setText("");
        pembayaran.getTglBayar().setDate(null);
        displayTablePembayaran(pembayaran);
    } 
    
    public void displayTableNeedConfirmAdmin(PembayaranAdmin pembayaranAdmin) {
   
        List<PembayaranModel> pembayarans = impl.getByStatus(false);
       
        DefaultTableModel model = (DefaultTableModel) pembayaranAdmin.getNeedConfirmTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (PembayaranModel pm: pembayarans) {
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String totalBayar = formatter.format(pm.getTotalBayar());
                Object[] rowData = {pm.getId_pembayaran(), pm.getId_user(), pm.getMetode(), pm.getTgl(), totalBayar};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void displayTableSuccessAdmin(PembayaranAdmin pembayaranAdmin) {
   
        List<PembayaranModel> pembayarans = impl.getByStatus(true);
       
        DefaultTableModel model = (DefaultTableModel) pembayaranAdmin.getSuccessTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (PembayaranModel pm: pembayarans) {
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String totalBayar = formatter.format(pm.getTotalBayar());
                Object[] rowData = {pm.getId_pembayaran(), pm.getId_user(), pm.getMetode(), pm.getTgl(), totalBayar};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setTotalPembayaranSukses(PembayaranAdmin pa) {
        double totalBayar = 0.0;
        List<PembayaranModel> pembayarans = impl.getByStatus(true);
                
        for (PembayaranModel pm : pembayarans) {
            totalBayar += pm.getTotalBayar();
        }
        
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String totalBayarFormatted = formatter.format(totalBayar);
        
        pa.getTotalTextField().setText(totalBayarFormatted);
    }
    
    public void confirmPembayaran(PembayaranAdmin pa) {
        Integer selectedRow = pa.getNeedConfirmTable().getSelectedRow();
        
        if (selectedRow >= 0) {
            Integer idPembayaran = (Integer) pa.getNeedConfirmTable().getValueAt(selectedRow, 0);
            
            int confirmation = JOptionPane.showConfirmDialog(pa, "Konfirmasi Pembayaran dengan id " + idPembayaran + "?", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {
                impl.updateStatus(idPembayaran);
                JOptionPane.showMessageDialog(pa, "Konfirmasi Berhasil", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
        
    }
    
    public void countPembayaranNeedConfirm(DashboardAdmin dbAdmin) {
        Integer pembayaranBaru = impl.getByStatus(false).size();
        
        dbAdmin.getPembayaranBaruLabel().setText(pembayaranBaru.toString());
    }
    
    public void countSuccessfulPayments(DashboardRenter dr) {
        Session session = Session.getInstance();
        String username = session.getUsername();
        
        List<PembayaranModel> pembayarans = impl.getByUsername(username);
        
        int count = 0;
        for (PembayaranModel pm : pembayarans) {
            if (pm.getStatus()) {
                count++;
            }
        }
        String countInString = String.valueOf(count);
        dr.getTotalPembayaranSuccess().setText(countInString);
    }

}
