/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.model;

import java.time.LocalDateTime;
import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author alfia
 */
public class PerizinanModel {
    private int id;
    private String username;
    private LocalDateTime tanggalPembuatanIzin;
    private LocalDate tanggalPelaksanaanIzin;
    private String waktuPelaksanaanIzin;
    private String keterangan;
    private Status status;
    
    public enum Status {
        PENDING(1),
        DISETUJUI(2),
        DITOLAK(3);

        private final int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public int getId() {
        return id;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getTanggalPelaksanaanIzin() {
        return tanggalPelaksanaanIzin;
    }

    public LocalDateTime getTanggalPembuatanIzin() {
        return tanggalPembuatanIzin;
    }
   
    public String getUsername() {
        return username;
    }

    public String getWaktuPelaksanaanIzin() {
        return waktuPelaksanaanIzin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTanggalPelaksanaanIzin(LocalDate tanggalPelaksanaanIzin) {
        this.tanggalPelaksanaanIzin = tanggalPelaksanaanIzin;
    }

    public void setTanggalPembuatanIzin(LocalDateTime tanggalPembuatanIzin) {
        this.tanggalPembuatanIzin = tanggalPembuatanIzin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWaktuPelaksanaanIzin(String waktuPelaksanaanIzin) {
        this.waktuPelaksanaanIzin = waktuPelaksanaanIzin;
    }

    
}
