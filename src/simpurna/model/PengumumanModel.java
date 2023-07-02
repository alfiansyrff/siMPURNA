/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.model;

import java.time.LocalDateTime;

/**
 *
 * @author alfia
 */
public class PengumumanModel {
    private Integer id;
    private String isi;
    private LocalDateTime tanggal;
    private String username;

    public Integer getId() {
        return id;
    }

    public String getIsi() {
        return isi;
    }

    public LocalDateTime getTanggal() {
        return tanggal;
    }

    public String getUsername() {
        return username;
    }
   
    public void setId(Integer id) {
        this.id = id;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public void setTanggal(LocalDateTime tanggal) {
        this.tanggal = tanggal;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
    
}
