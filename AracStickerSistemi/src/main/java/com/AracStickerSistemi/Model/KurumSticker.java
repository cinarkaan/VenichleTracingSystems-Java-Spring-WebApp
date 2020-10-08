package com.AracStickerSistemi.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class KurumSticker extends TasitSticker {

    //Kurum Personel Bilgileri

    @NotEmpty(message = "Bu alan boş bırakılamaz")
    @Size(min = 11, max = 11 , message = "Bu alan boş bırakılamaz")
    private String tcNo;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String adSoyad;
    private String bulunduguKampus;
    private String kampusBirimAdi;
    private String kadroBirimi;
    private String unvan;
    private String gorevYaptigiBirim;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String kurumSicil;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String icHat;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String firma;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    @Size(min = 11 , max = 11 , message = "Bu alan boş bırakılamaz")
    private String cepTelefonu;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    @Email(message = "Bu alan boş bırakılamaz")
    private String eposta;
    private String serialNo;

    public KurumSticker() {
        super();
        this.tcNo = "00000000000";
        this.adSoyad = "null";
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getBulunduguKampus() {
        return bulunduguKampus;
    }

    public void setBulunduguKampus(String bulunduguKampus) {
        this.bulunduguKampus = bulunduguKampus;
    }

    public String getKampusBirimAdi() {
        return kampusBirimAdi;
    }

    public void setKampusBirimAdi(String kampusBirimAdi) {
        this.kampusBirimAdi = kampusBirimAdi;
    }

    public String getKadroBirimi() {
        return kadroBirimi;
    }

    public void setKadroBirimi(String kadroBirimi) {
        this.kadroBirimi = kadroBirimi;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getGorevYaptigiBirim() {
        return gorevYaptigiBirim;
    }

    public void setGorevYaptigiBirim(String gorevYaptigiBirim) {
        this.gorevYaptigiBirim = gorevYaptigiBirim;
    }

    public String getKurumSicil() {
        return kurumSicil;
    }

    public void setKurumSicil(String kurumSicil) {
        this.kurumSicil = kurumSicil;
    }

    public String getIcHat() {
        return icHat;
    }

    public void setIcHat(String icHat) {
        this.icHat = icHat;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getCepTelefonu() {
        return cepTelefonu;
    }

    public void setCepTelefonu(String cepTelefonu) {
        this.cepTelefonu = cepTelefonu;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }
}
