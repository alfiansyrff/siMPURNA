/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package simpurna.DAO;

import java.util.List;
import simpurna.model.UserModel;
/**
 *
 * @author alfia
 */
public interface DAOUser {
    public List<UserModel>getAll();
    
    public List<UserModel>prosesLogin(String user, String pass);
    
    public void add(UserModel user);
    
    public void edit(UserModel user);
    
    public void remove(String idUser);
}
