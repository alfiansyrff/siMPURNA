/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package simpurna.DAO;

import java.util.List;
import simpurna.model.PengumumanModel;

/**
 *
 * @author alfia
 */
public interface DAOPengumuman {
    public List<PengumumanModel>getAll();
    
    public void add(PengumumanModel pm);
    
    public void edit(PengumumanModel pm);
    
    public void remove(Integer id);
}
