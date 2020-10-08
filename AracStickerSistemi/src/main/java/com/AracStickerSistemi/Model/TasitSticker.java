package com.AracStickerSistemi.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TasitSticker {

    private String aracTuru;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String stickerNo;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String aracSahibininAdiSoyad;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String ruhsatSahibininAdiSoyad;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    @Size (min = 7 , max = 8 , message = "Plaka 7 veya 8 haneli olmalıdır")
    private String plaka;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String aracMarka;
    private String verilisTarihi;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String aracRengi;
    private int sticker_id;

    public TasitSticker () {
        stickerNo = "null";
    }

    public int getSticker_id() {
        return sticker_id;
    }

    public void setSticker_id(int sticker_id) {
        this.sticker_id = sticker_id;
    }

    public String getAracTuru() {
        return aracTuru;
    }

    public void setAracTuru(String aracTuru) {
        this.aracTuru = aracTuru;
    }

    public String getStickerNo() {
        return stickerNo;
    }

    public void setStickerNo(String stickerNo) {
        this.stickerNo = stickerNo;
    }

    public String getAracSahibininAdiSoyad() {
        return aracSahibininAdiSoyad;
    }

    public void setAracSahibininAdiSoyad(String aracSahibininAdiSoyad) {
        this.aracSahibininAdiSoyad = aracSahibininAdiSoyad;
    }

    public String getRuhsatSahibininAdiSoyad() {
        return ruhsatSahibininAdiSoyad;
    }

    public void setRuhsatSahibininAdiSoyad(String ruhsatSahibininAdiSoyad) {
        this.ruhsatSahibininAdiSoyad = ruhsatSahibininAdiSoyad;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getAracMarka() {
        return aracMarka;
    }

    public void setAracMarka(String aracMarka) {
        this.aracMarka = aracMarka;
    }

    public String getVerilisTarihi() {
        return verilisTarihi;
    }

    public void setVerilisTarihi(String verilisTarihi) {
        this.verilisTarihi = verilisTarihi;
    }

    public String getAracRengi() {
        return aracRengi;
    }

    public void setAracRengi(String aracRengi) {
        this.aracRengi = aracRengi;
    }
}
