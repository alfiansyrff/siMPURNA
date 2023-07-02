/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import simpurna.DAO.DAOPerizinan;
import simpurna.Impl.DAOImplPerizinan;
import simpurna.model.PerizinanModel;
import simpurna.model.PerizinanModel.Status;
import simpurna.model.Session;
import simpurna.view.DashboardAdmin;
import simpurna.view.DashboardRenter;
import simpurna.view.PerizinanAdmin;
import simpurna.view.PerizinanRenter;

/**
 *
 * @author alfia
 */
public class PerizinanController {
    DAOPerizinan impl;
    
    public PerizinanController() {
        impl = new DAOImplPerizinan();
    }
    
    public void displayAllConfirmedPerizinan(PerizinanAdmin pa){
       List<PerizinanModel> perizinans = impl.getAllConfirmedPerizinan();
       
        DefaultTableModel model = (DefaultTableModel) pa.getPerizinanDiConfirm().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (PerizinanModel pm: perizinans) {
                Object[] rowData = {pm.getId(), pm.getUsername(), pm.getKeterangan(), pm.getStatus()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
    public void displayPerizinanMasukAdmin(PerizinanAdmin pa) {
        List<PerizinanModel> perizinans = impl.getByStatus(1);
       
        DefaultTableModel model = (DefaultTableModel) pa.getPerizinanMasuk().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (PerizinanModel pm: perizinans) {
                Object[] rowData = {pm.getId(), pm.getUsername(), pm.getTanggalPelaksanaanIzin(), pm.getKeterangan()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setujuiPerizinan(PerizinanAdmin pa) {
        Integer selectedRow = pa.getPerizinanMasuk().getSelectedRow();
        
        if (selectedRow >= 0) {
            Integer id = (Integer) pa.getPerizinanMasuk().getValueAt(selectedRow, 0);
            
            int confirmation = JOptionPane.showConfirmDialog(pa, "Setujui perizinan ini? ", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {
                impl.updateStatus(id, 2);
                JOptionPane.showMessageDialog(pa, "Perizinan Disetujui", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
    }
    
    public void tolakPerizinan(PerizinanAdmin pa) {
        Integer selectedRow = pa.getPerizinanMasuk().getSelectedRow();
        
        if (selectedRow >= 0) {
            Integer id = (Integer) pa.getPerizinanMasuk().getValueAt(selectedRow, 0);
            
            int confirmation = JOptionPane.showConfirmDialog(pa, "Tolak perizinan ini? ", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {
                impl.updateStatus(id, 3);
                JOptionPane.showMessageDialog(pa, "Perizinan Ditolak", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } 
        }
    }
    
    public void displayByUsername(PerizinanRenter pr) {
        String username = pr.getUsername();

        List<PerizinanModel> perizinans = impl.getByUsername(username);
        
        DefaultTableModel model = (DefaultTableModel) pr.getPerizinanTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (PerizinanModel pm: perizinans) {
                Object[] rowData = {pm.getId(), pm.getTanggalPembuatanIzin(), pm.getTanggalPelaksanaanIzin(), pm.getWaktuPelaksanaanIzin(), pm.getStatus()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void insertPerizinan(PerizinanRenter pr) {
        String username = pr.getUsername();
        String keterangan = pr.getKeterangan().getText();
        String waktu = (String) pr.getWaktu().getValue();
        LocalDate tglPelaksanaan = pr.getTglPelaksanaan().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        
        PerizinanModel pm = new PerizinanModel();
        pm.setKeterangan(keterangan);
        pm.setUsername(username);
        pm.setTanggalPelaksanaanIzin(tglPelaksanaan);
        pm.setTanggalPembuatanIzin(LocalDateTime.now());
        pm.setWaktuPelaksanaanIzin(waktu);
        pm.setStatus(Status.PENDING);
        
        impl.add(pm);
        JOptionPane.showMessageDialog(pr, "Berhasil Mengajukan Perizinan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        pr.getKeterangan().setText("");
        pr.getTglPelaksanaan().setCalendar(null);
        
    }
    
    public void countPerizinanMasuk(DashboardAdmin da) {
        Integer total = impl.getByStatus(1).size();
        
        da.getPerizinanMasuk().setText(total.toString());
        
    }
    
    public void countByUsername(DashboardRenter dr){
        Session session = Session.getInstance();
        String username = session.getUsername();
        
        Integer total = impl.getByUsername(username).size();
        dr.getPengajuanPerizinan().setText(total.toString());
    }
    
}
