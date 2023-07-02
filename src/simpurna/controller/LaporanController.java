/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import simpurna.DAO.DAOLaporan;
import simpurna.Impl.DAOImplLaporan;
import simpurna.config.Database;
import simpurna.model.LaporanModel;
import simpurna.model.Session;
import simpurna.view.DashboardAdmin;
import simpurna.view.DashboardRenter;
import simpurna.view.LaporanAdmin;
import simpurna.view.LaporanRenter;

/**
 *
 * @author alfia
 */
public class LaporanController {
    DAOLaporan impl;
    
    public LaporanController() {
        impl = new DAOImplLaporan();
    }
    
    public void displayLaporanUser(LaporanRenter lr) {
       String username = lr.getUsername().getText();
       List<LaporanModel> laporans = impl.getLaporanByUsername(username);
       
       DefaultTableModel model = (DefaultTableModel) lr.getLaporanUser().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (LaporanModel lm: laporans) {
                String status = lm.isStatus() ? "Selesai" : "Belum Selesai";
                Object[] rowData = {lm.getIdPelaporan(), lm.getTanggalPelaporan(), lm.getIsiLaporan(), lm.getTanggapanAdmin(), status};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void displayLaporanAll(LaporanAdmin la) {
       List<LaporanModel> laporans = impl.getAllLaporan();
       
       DefaultTableModel model = (DefaultTableModel) la.getLaporanAdminTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (LaporanModel lm: laporans) {
                String status = lm.isStatus() ? "Selesai" : "Belum Selesai";
                Object[] rowData = {lm.getIdPelaporan(), lm.getUsernamePelapor(), lm.getTanggalPelaporan(), lm.getIsiLaporan(), lm.getTanggapanAdmin(), status};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void insertLaporan(LaporanRenter lr) {
        
       String username = lr.getUsername().getText();
       LocalDateTime tgl = LocalDateTime.now();
       String isiLaporan = lr.getIsiLaporan().getText();
       String tanggapan = "";
       Boolean status = false;
       
       LaporanModel lm = new LaporanModel();
       
       lm.setUsernamePelapor(username);
       lm.setIsiLaporan(isiLaporan);
       lm.setStatus(status);
       lm.setTanggalPelaporan(tgl);
       lm.setTanggapanAdmin(tanggapan);
       
       impl.add(lm);
       JOptionPane.showMessageDialog(lr, "Berhasil Membuat Laporan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
       
       lr.getIsiLaporan().setText("");
    }
    
    public void updateStatus(LaporanRenter lr) {
        Integer selectedRow = lr.getLaporanUser().getSelectedRow();
        
        if (selectedRow >= 0) {
            Integer id = (Integer) lr.getLaporanUser().getValueAt(selectedRow, 0);
            
            int confirmation = JOptionPane.showConfirmDialog(lr, "Konfirmasi Status Pelaporan id: " + id +  " Menjadi Selesai ?", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {
                impl.updateStatus(id);
                JOptionPane.showMessageDialog(lr, "Status Pelaporan Berhasil Diubah", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
    }
    
    public void updateTanggapan(LaporanAdmin la) {
        Integer selectedRow = la.getLaporanAdminTable().getSelectedRow();
        
        if (selectedRow >= 0) {
            Integer id = Integer.parseInt(la.getId().getText());
            String tanggapan = la.getTanggapan().getText();
            
            int confirmation = JOptionPane.showConfirmDialog(la, "Tambah Tanggapan Pelaporan id: " + id +  "?", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {
                impl.updateTanggapan(id, tanggapan);
                JOptionPane.showMessageDialog(la, "Berhasil Menambahkan Tanggapan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                la.getTanggapan().setText("");
                la.getId().setText("");
                la.getIsi().setText("");
            } 
        }
    }
    
    public void countTotalPelaporan(DashboardRenter dr) {
        Session session = Session.getInstance();
        String username = session.getUsername();
        Integer totalPelaporan = impl.getLaporanByUsername(username).size();
        dr.getTotalPelaporan().setText(totalPelaporan.toString());
    }  
    
    public void countTotalPelaporanAdmin(DashboardAdmin da) {
        Integer totalPelaporan = impl.getAllLaporan().size();
        da.getPelaporanMasuk().setText(totalPelaporan.toString());
    }  
}
