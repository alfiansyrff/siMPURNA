/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.model;

/**
 *
 * @author alfia
 */
public class Session {
    private static Session instance;
    private String username;
    private String role;

    private Session() {

    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void setUsername(String userId) {
        this.username = userId;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
    

    public void clearSession() {
        username= null;
        role = null;
    }
}
