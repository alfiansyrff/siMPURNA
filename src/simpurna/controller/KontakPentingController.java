/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import simpurna.DAO.DAOKontakPenting;
import simpurna.Impl.DAOImplKontakPenting;
import simpurna.model.KontakPentingModel;
import simpurna.view.KontakPenting;
import simpurna.view.KontakPentingAdmin;

/**
 *
 * @author alfia
 */
public class KontakPentingController {
    DAOKontakPenting impl;

    public KontakPentingController() {
        this.impl = new DAOImplKontakPenting();
    }
    
    public void displayAllInRenter(KontakPenting kpv) {
        List<KontakPentingModel> kontaks = impl.getAll();
       
       DefaultTableModel model = (DefaultTableModel) kpv.getKontakPentingTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (KontakPentingModel kp: kontaks) {
                Object[] rowData = {kp.getNama(), kp.getKontak(), kp.getKeterangan()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void displayAllInAdmin(KontakPentingAdmin kpav) {
        List<KontakPentingModel> kontaks = impl.getAll();
       
       DefaultTableModel model = (DefaultTableModel) kpav.getTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (KontakPentingModel kp: kontaks) {
                Object[] rowData = {kp.getId(), kp.getNama(), kp.getKontak(), kp.getKeterangan()};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertKontakPenting(KontakPentingAdmin kpa) {
        
       KontakPentingModel kpm = new KontakPentingModel();
       String getName = kpa.getNama().getText();
       String getKontak = kpa.getKontak().getText();
       String getKtrgn = kpa.getKeterangan().getText();
       
       kpm.setNama(getName);
       kpm.setKontak(getKontak);
       kpm.setKeterangan(getKtrgn);
       
       impl.add(kpm);
       JOptionPane.showMessageDialog(kpa, "Data Kontak Penting Berhasil Ditambah", "Sukses", JOptionPane.INFORMATION_MESSAGE);
       
       kpa.getNama().setText("");
       kpa.getKeterangan().setText("");
       kpa.getKontak().setText("");
    }
    
    public void updateKontakPenting(KontakPentingAdmin kpa) {
        Integer id = kpa.getSelectedId();
        String name = kpa.getNama().getText();
        String kontak = kpa.getKontak().getText();
        String keterangan = kpa.getKeterangan().getText();
        
        KontakPentingModel kp = new KontakPentingModel();
        kp.setId(id);
        kp.setNama(name);
        kp.setKeterangan(keterangan);
        kp.setKontak(kontak);
        
        impl.edit(kp);
        JOptionPane.showMessageDialog(kpa, "Kontak id " + id + " Berhasil diupdate!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
       
    }
    
    
}
