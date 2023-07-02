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
public class PembayaranModel {
    private Integer id_pembayaran;
    private String id_user;
    private Integer id_kamar;
    private Double totalBayar;
    private LocalDateTime tgl;
    private String metode;
    private Boolean status;

    public Integer getId_kamar() {
        return id_kamar;
    }

    public Integer getId_pembayaran() {
        return id_pembayaran;
    }

    public String getId_user() {
        return id_user;
    }

    public String getMetode() {
        return metode;
    }

    public Boolean getStatus() {
        return status;
    }

    public LocalDateTime getTgl() {
        return tgl;
    }

    public Double getTotalBayar() {
        return totalBayar;
    }

    public void setId_kamar(Integer id_kamar) {
        this.id_kamar = id_kamar;
    }

    public void setId_pembayaran(Integer id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public void setMetode(String metode) {
        this.metode = metode;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setTgl(LocalDateTime tgl) {
        this.tgl = tgl;
    }

    public void setTotalBayar(Double totalBayar) {
        this.totalBayar = totalBayar;
    }
    
}
