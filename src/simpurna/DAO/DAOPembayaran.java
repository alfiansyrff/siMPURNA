/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package simpurna.DAO;

import java.util.List;
import simpurna.model.PembayaranModel;

/**
 *
 * @author alfia
 */
public interface DAOPembayaran {
    public List<PembayaranModel>getAll();
    
    public List<PembayaranModel> getByUsername(String username);
    
    public List<PembayaranModel> getByStatus(Boolean status);
    
    public void updateStatus(Integer id_bayar);
    
    public void edit(PembayaranModel pm);
    
    public void insert(PembayaranModel pm);
}
