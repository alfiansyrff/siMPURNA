/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.model;

/**
 *
 * @author alfia
 */
public class KontakPentingModel {
   private Integer id;
   private String nama;
   private String kontak;
   private String keterangan;

    public Integer getId() {
        return id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getKontak() {
        return kontak;
    }

    public String getNama() {
        return nama;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
   
   
}
