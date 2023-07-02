/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package simpurna.DAO;

import java.util.List;
import simpurna.model.KontakPentingModel;

/**
 *
 * @author alfia
 */
public interface DAOKontakPenting {
    public List<KontakPentingModel>getAll();
    
    public KontakPentingModel getById(Integer id);
    
    public void add(KontakPentingModel kp);
    
    public void edit(KontakPentingModel kp);
}
