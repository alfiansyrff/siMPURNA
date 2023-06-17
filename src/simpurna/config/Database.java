/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.config;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alfia
 */
public class Database implements Serializable{
    public static Database instance;
    
    private final String DB_TYPE = "mysql";
    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "simpurna";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    
    private Database(){       
    }
    
    public static synchronized Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:"+DB_TYPE+"://"+DB_HOST+":"+DB_PORT+"/"+DB_NAME,DB_USER,DB_PASS);
    }
    
    public void printConnection() {
      try {
          Connection conn = getConnection();
          System.out.println(DB_NAME + "Connected!");
      } catch (SQLException e) {
          System.out.println("Failed to establish a database connection: " + e.getMessage());
          // Handle or log the exception as needed
    }

    }   
}