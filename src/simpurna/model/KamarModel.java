/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simpurna.model;

/**
 *
 * @author alfia
 */
public class KamarModel {
    private Integer noKamar;
    private Boolean isRented;
    private String tipeKamar;
    private Double hargaSewa;
    private String penyewa;

    public Double getHargaSewa() {
        return hargaSewa;
    }

    public Boolean getIsRented() {
        return isRented;
    }

    public Integer getNoKamar() {
        return noKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public String getPenyewa() {
        return penyewa;
    }

    public void setHargaSewa(Double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public void setIsRented(Boolean isRented) {
        this.isRented = isRented;
    }

    public void setNoKamar(Integer noKamar) {
        this.noKamar = noKamar;
    }

    public void setTipeKamar(String tipeKamar) {
        this.tipeKamar = tipeKamar;
    }

    public void setPenyewa(String penyewa) {
        this.penyewa = penyewa;
    }
   
    
}
