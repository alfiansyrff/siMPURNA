/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.controller;

import java.text.NumberFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import simpurna.DAO.DAOKamar;
import simpurna.Impl.DAOImplKamar;
import simpurna.model.KamarModel;
import simpurna.view.AddRenter;
import simpurna.view.CekKamar;

/**
 *
 * @author alfia
 */
public class KamarController {
    DAOKamar impl;

    public KamarController() {
        this.impl = new DAOImplKamar();
    }
    
    public void displayKamarEksklusif(CekKamar ck) {
       List<KamarModel> kamars = impl.getByType("Eksklusif");
       
       DefaultTableModel model = (DefaultTableModel) ck.getEksklusifTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (KamarModel kamar : kamars) {
                String status = kamar.getIsRented() ? "Terisi" : "Tersedia";
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String hargaSewa = formatter.format(kamar.getHargaSewa());
                Object[] rowData = {kamar.getNoKamar(), status, kamar.getPenyewa(), hargaSewa};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void displayKamarReguler(CekKamar ck) {
       List<KamarModel> kamars = impl.getByType("Reguler");
       
       DefaultTableModel model = (DefaultTableModel) ck.getRegulerTable().getModel();
        while(model.getRowCount()>0){
           model.removeRow(0);
        }   
        try {   
            for (KamarModel kamar : kamars) {
                String status = kamar.getIsRented() ? "Terisi" : "Tersedia";
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                String hargaSewa = formatter.format(kamar.getHargaSewa());
                Object[] rowData = {kamar.getNoKamar(), status, kamar.getPenyewa(), hargaSewa};
                model.addRow(rowData);
            }
          
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void countJmlPenghuniEks(CekKamar ck) {
        Integer jmlEks = 4- impl.getByType("Eksklusif").size();
        ck.getKapasitasEks().setText(jmlEks.toString());
    }
    
    public void countJmlPenghuniReg(CekKamar ck) {
        Integer jmlReg = 6 - impl.getByType("Reguler").size();
        ck.getKapasitasReg().setText(jmlReg.toString());
    }
    
    public void setKamarKosong(AddRenter ar){
        ar.getKamarKosong().removeAllItems();
        
        List<Integer> kamars = impl.getKamarByStatus(false);
        
        for (Integer kamar: kamars) {
            ar.getKamarKosong().addItem(kamar.toString());
        }
        
    }
    
}
