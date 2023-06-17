/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simpurna;

import java.sql.SQLException;
import simpurna.DAO.DAOUser;
import simpurna.Impl.DAOImplUser;
import simpurna.config.Database;
import simpurna.model.UserModel;

/**
 *
 * @author alfia
 */
public class SiMPURNA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserModel user = new UserModel();
        user.setUsername("alfian");
        user.setPass(user.getUsername() + "123");
        user.setName("Muhammad Alfian");
        user.setRole("client");
        user.setTelephone("081335541289");
        user.setAddress("Tuban Jawa Timue");
        
        DAOUser impl = new DAOImplUser();
        impl.add(user);
    }
    
}
