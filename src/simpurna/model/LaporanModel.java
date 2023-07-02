/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.model;

/**
 *
 * @author alfia
 */

import java.time.LocalDateTime;

public class LaporanModel {
    private int idPelaporan;
    private LocalDateTime tanggalPelaporan;
    private String usernamePelapor;
    private String isiLaporan;
    private String tanggapanAdmin;
    private boolean status;

    // Getters and setters
    public int getIdPelaporan() {
        return idPelaporan;
    }

    public void setIdPelaporan(int idPelaporan) {
        this.idPelaporan = idPelaporan;
    }

    public LocalDateTime getTanggalPelaporan() {
        return tanggalPelaporan;
    }

    public void setTanggalPelaporan(LocalDateTime tanggalPelaporan) {
        this.tanggalPelaporan = tanggalPelaporan;
    }

    public String getUsernamePelapor() {
        return usernamePelapor;
    }

    public void setUsernamePelapor(String usernamePelapor) {
        this.usernamePelapor = usernamePelapor;
    }

    public String getIsiLaporan() {
        return isiLaporan;
    }

    public void setIsiLaporan(String isiLaporan) {
        this.isiLaporan = isiLaporan;
    }

    public String getTanggapanAdmin() {
        return tanggapanAdmin;
    }

    public void setTanggapanAdmin(String tanggapanAdmin) {
        this.tanggapanAdmin = tanggapanAdmin;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
