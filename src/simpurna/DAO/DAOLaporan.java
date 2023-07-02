/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package simpurna.DAO;

import java.util.List;
import simpurna.model.LaporanModel;

/**
 *
 * @author alfia
 */
public interface DAOLaporan {
    public void add(LaporanModel laporan);
    
    public void updateStatus(int idPelaporan);
    
    public void updateTanggapan(int idPelaporan, String tanggapan);
    
    public void hapusLaporan(int idPelaporan);
    
    public LaporanModel getLaporanById(int idPelaporan);
    
    public List<LaporanModel> getAllLaporan();
    
    public List<LaporanModel> getLaporanByStatus(boolean status);
    
    public List<LaporanModel> getLaporanByUsername(String username);

}
