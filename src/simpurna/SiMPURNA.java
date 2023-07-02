/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simpurna;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import simpurna.DAO.DAOAdmin;
import simpurna.DAO.DAOUser;
import simpurna.Impl.DAOImplAdmin;
import simpurna.Impl.DAOImplUser;
import simpurna.config.Database;
import simpurna.model.AdminModel;
import simpurna.model.PerizinanModel;
import simpurna.model.UserModel;
import java.sql.*;
import simpurna.DAO.DAOPerizinan;
import simpurna.Impl.DAOImplPerizinan;

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
//        UserModel user = new UserModel();
//        user.setUsername("mustofa");
//        user.setPass(user.getUsername() + "123");
//        user.setName("Mustofa Kamal");
//        user.setRole("admin");
//        user.setTelephone("081335541289");
//        user.setAddress("Jatinegara Jakarta Timur");
//        user.setKamar(1);
//        
//        DAOUser impl = new DAOImplUser();
//        impl.add(user);
//        System.out.println("Hello World!");

//           AdminModel adm = new AdminModel();
//           adm.setUsername("mustofa");
//           adm.setPassword("kangmus123");
//           adm.setName("Mustofa Kamal");
//           adm.setKontak("08881234732");
//           
//           DAOAdmin impl = new DAOImplAdmin();
//           impl.add(adm);
//           
//            PerizinanModel pm = new PerizinanModel();
//            pm.setUsername("alfian");
//            pm.setTanggalPembuatanIzin(LocalDateTime.now());
//            pm.setTanggalPelaksanaanIzin(LocalDate.now());
//            pm.setWaktuPelaksanaanIzin(Time.valueOf(LocalTime.now()));
//            pm.setKeterangan("Rapat Bekisar");
//            pm.setStatus(PerizinanModel.Status.PENDING);
//            
//            DAOPerizinan impl = new DAOImplPerizinan();
//            impl.add(pm);
    }
    
}
