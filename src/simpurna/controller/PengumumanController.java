/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import simpurna.DAO.DAOPengumuman;
import simpurna.Impl.DAOImplPengumuman;
import simpurna.model.PengumumanModel;
import simpurna.observer.Observable;
import simpurna.observer.Observer;
import simpurna.view.DashboardRenter;
import simpurna.view.PengumumanAdmin;
import simpurna.view.PengumumanRenter;

/**
 *
 * @author alfia
 */
public class PengumumanController implements Observable{
    DAOPengumuman impl;
    private List<Observer> observers;
    
    public PengumumanController() {
        impl = new DAOImplPengumuman();
        observers = new ArrayList<>();
    }
    
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
   
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.updatePengumuman();
        }
    }
    
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    
    public void displayAllPengumumanAdmin(PengumumanAdmin pa) {
       List<PengumumanModel> pengumumans= impl.getAll();
       
        DefaultTableModel model = (DefaultTableModel) pa.getPengumumanTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (PengumumanModel pm: pengumumans) {
                Object[] rowData = {pm.getId(), pm.getTanggal(), pm.getIsi(), pm.getUsername()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void insert(PengumumanAdmin pa) {
        String username = pa.getUsername();
        String isi = pa.getIsi().getText();
        LocalDateTime tanggal = LocalDateTime.now();
        
        PengumumanModel pm = new PengumumanModel();
        pm.setIsi(isi);
        pm.setTanggal(tanggal);
        pm.setUsername(username);
        
        impl.add(pm);
        JOptionPane.showMessageDialog(pa, "Berhasil Membuat Pengumuman", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        notifyObservers();
        pa.getIsi().setText("");
    }
    
    public void edit(PengumumanAdmin pa) {
        Integer selectedRow = pa.getPengumumanTable().getSelectedRow();
        
        if (selectedRow >= 0) {
            Integer id = pa.getId();
            String isi = pa.getIsi().getText();
            String username = pa.getUsername();
            LocalDateTime tanggal = LocalDateTime.now();
            
            int confirmation = JOptionPane.showConfirmDialog(pa, "Apakah Yakin Untuk Mengubah Pengumuman Ini?", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {
                PengumumanModel pm = new PengumumanModel();
                pm.setIsi(isi);
                pm.setTanggal(tanggal);
                pm.setUsername(username);
                pm.setId(id);
                
                impl.edit(pm);
                JOptionPane.showMessageDialog(pa, "Berhasil Mengubah Pengumuman", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                pa.getIsi().setText("");
            } 
        }
    }
    
    public void delete(PengumumanAdmin pa) {
        Integer selectedRow = pa.getPengumumanTable().getSelectedRow();
        
        if (selectedRow >= 0) {
            Integer id = pa.getId();
            
            int confirmation = JOptionPane.showConfirmDialog(pa, "Apakah Yakin Untuk Menghapus Pengumuman ini?", "Perhatian!", JOptionPane.YES_NO_OPTION);
            
            if (confirmation == JOptionPane.YES_OPTION) {      
                impl.remove(id);
                JOptionPane.showMessageDialog(pa, "Berhasil Menghapus Pengumuman", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                pa.getIsi().setText("");
            } 
        }
    }
    
    public void displayAllPengumumanRenter(PengumumanRenter pr) {
       List<PengumumanModel> pengumumans= impl.getAll();
       
        DefaultTableModel model = (DefaultTableModel) pr.getPengumumanTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (PengumumanModel pm: pengumumans) {
                LocalDate tanggal = pm.getTanggal().toLocalDate();
                LocalTime waktu = pm.getTanggal().toLocalTime();
                Object[] rowData = {tanggal, waktu, pm.getIsi()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void countTotalPengumuman(DashboardRenter dr) {
        Integer totalPengumuman = impl.getAll().size();
        dr.getTotalPengumuman().setText(totalPengumuman.toString());
    }  
}
