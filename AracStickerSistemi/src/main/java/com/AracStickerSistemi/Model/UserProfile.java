package com.AracStickerSistemi.Model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserProfile {

    private boolean isHasUser;
    private String urlcodeid;
    private int kullanici_id;
    @NotEmpty(message = "Bu alan boş bırakılmamalı")
    private String id;
    @NotEmpty(message = "Bu alan boş bırakılmamalı")
    private String password;
    @NotEmpty(message = "Bu alan boş bırakılmamalı")
    private String ad;
    @NotEmpty(message = "Bu alan boş bırakılmamalı")
    private String soyAdi;
    private String stickerTur;
    @NotEmpty(message = "Bu alan boş bırakılmamalı")
    @Size (min = 11 , max = 11 , message = "Telefon numarası 11 haneli olmalıdır")
    private String cepTel;
    private String görev;
    private String kampus;
    private String kampusbirim;

    public String getKampusbirim() {
        return kampusbirim;
    }

    public void setKampusbirim(String kampusbirim) {
        this.kampusbirim = kampusbirim;
    }

    public boolean isHasUser() {
        return isHasUser;
    }

    public void setHasUser(boolean hasUser) {
        isHasUser = hasUser;
    }

    public String getUrlcodeid() {
        return urlcodeid;
    }

    public void setUrlcodeid(String urlcodeid) {
        this.urlcodeid = urlcodeid;
    }

    public UserProfile() {
        this.isHasUser = true;
        this.password = "#";
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getGörev() {
        return görev;
    }

    public void setGörev(String görev) {
        this.görev = görev;
    }

    public String getKampus() {
        return kampus;
    }

    public void setKampus(String kampus) {
        this.kampus = kampus;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAdi() {
        return soyAdi;
    }

    public void setSoyAdi(String soyAdi) {
        this.soyAdi = soyAdi;
    }

    public String getStickerTur() {
        return stickerTur;
    }

    public void setStickerTur(String stickerTur) {
        this.stickerTur = stickerTur;
    }

    public String getCepTel() {
        return cepTel;
    }

    public void setCepTel(String cepTel) {
        this.cepTel = cepTel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
