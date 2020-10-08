package com.AracStickerSistemi.Model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OgrenciSticker extends TasitSticker {

    //Ogrenci Bilgileri

    @NotEmpty(message = "Bu alan boş bırakılamaz")
    @Size(min = 11 , max = 11 , message = "TC numarası 11 haneli olmalıdır")
    private String ogrenciTcNo;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String ogrenciAdSoyad;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String ogrenciNo;
    private String fakulteYO;
    private String bolum;
    @Range(min = 1 , max = 4 ,message = "Sınıf 1 ile 4 arasında olmalıdır")
    private int sinif;
    private int serialno;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String ogrenciEposta;
    @NotEmpty( message = "Bu alan boş bırakılamaz")
    @Size(min = 11 , max = 11 ,  message = "Telefon numarası min 11 max 11 haneli olmalıdır")
    private String ogrTel;

    public OgrenciSticker () {
        super();
        this.ogrenciTcNo = "00000000000";
        this.ogrenciAdSoyad = "null";
        this.setAracTuru("null");
    }

    public int getSerialno() {
        return serialno;
    }

    public void setSerialno(int serialno) {
        this.serialno = serialno;
    }

    public String getOgrenciTcNo() {
        return ogrenciTcNo;
    }

    public void setOgrenciTcNo(String ogrenciTcNo) {
        this.ogrenciTcNo = ogrenciTcNo;
    }

    public String getOgrenciAdSoyad() {
        return ogrenciAdSoyad;
    }

    public void setOgrenciAdSoyad(String ogrenciAdSoyad) {
        this.ogrenciAdSoyad = ogrenciAdSoyad;
    }

    public String getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(String ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public String getFakulteYO() {
        return fakulteYO;
    }

    public void setFakulteYO(String fakulteYO) {
        this.fakulteYO = fakulteYO;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getSinif() {
        return sinif;
    }

    public void setSinif(int sinif) {
        this.sinif = sinif;
    }

    public String getOgrenciEposta() {
        return ogrenciEposta;
    }

    public void setOgrenciEposta(String ogrenciEposta) {
        this.ogrenciEposta = ogrenciEposta;
    }

    public String getOgrTel() {
        return ogrTel;
    }

    public void setOgrTel(String ogrTel) {
        this.ogrTel = ogrTel;
    }
}
