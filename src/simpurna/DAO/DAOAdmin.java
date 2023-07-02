/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package simpurna.DAO;

import java.util.List;
import simpurna.model.AdminModel;

/**
 *
 * @author alfia
 */
public interface DAOAdmin {
    public List<AdminModel>prosesLogin(String user, String pass);
    
    public void add(AdminModel am);
    
    public void edit(AdminModel am);
    
    public void remove(String username);
    
    public List<AdminModel> getAll();
}
