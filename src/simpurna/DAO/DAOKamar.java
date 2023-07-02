/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package simpurna.DAO;

import java.util.List;
import simpurna.model.KamarModel;

/**
 *
 * @author alfia
 */
public interface DAOKamar {
    public List<KamarModel>getAll();
    
    public List<KamarModel> getByType(String type);
    
    public List<Integer> getKamarByStatus(boolean isRented);
    
    public void edit(KamarModel kamar);

}
