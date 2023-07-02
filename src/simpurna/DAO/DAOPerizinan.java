/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package simpurna.DAO;

import java.util.List;
import simpurna.model.PerizinanModel;

/**
 *
 * @author alfia
 */
public interface DAOPerizinan {
    public void add(PerizinanModel pm);
    
    public List<PerizinanModel> getAllConfirmedPerizinan();
    
    public List<PerizinanModel> getByStatus(Integer status);
    
    public List<PerizinanModel> getByUsername(String username);
    
    public List<PerizinanModel> getAllPerizinanByStatus(int status);
    
    public void updateStatus(Integer id, Integer status);
}
