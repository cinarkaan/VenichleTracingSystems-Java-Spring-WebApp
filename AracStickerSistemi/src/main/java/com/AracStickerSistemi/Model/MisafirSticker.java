package com.AracStickerSistemi.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MisafirSticker extends TasitSticker {

    //Misafir Bilgileri

    @NotEmpty(message = "Bu alan boş bırakılamaz")
    @Size(min = 11,max = 11,message = "TC numarası 11 haneli olmalıdır")
    private String misafirTcNo;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String misafirAdSoyad;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    @Size(min = 11 ,  max = 11 , message = "Bu alan boş bırakılamaz")
    private String misafirCep;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    @Email(message = "Lütfen geçerli bir email giriniz")
    private String misafirEposta;
    private String misafirBulunduguKampus;
    private String misafirKampusBirimAdi;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String misafirFirmaAdi;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String misafirFirmaAdres;
    @NotEmpty(message = "Bu alan boş bırakılamaz")
    private String misafirFirmaTel;
    private String serialNo;

    public MisafirSticker() {
        super();
        this.misafirTcNo = "00000000000";
        this.misafirAdSoyad = "null";
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String  serialNo) {
        this.serialNo = serialNo;
    }

    public String getMisafirTcNo() {
        return misafirTcNo;
    }

    public void setMisafirTcNo(String misafirTcNo) {
        this.misafirTcNo = misafirTcNo;
    }

    public String getMisafirAdSoyad() {
        return misafirAdSoyad;
    }

    public void setMisafirAdSoyad(String misafirAdSoyad) {
        this.misafirAdSoyad = misafirAdSoyad;
    }

    public String getMisafirCep() {
        return misafirCep;
    }

    public void setMisafirCep(String misafirCep) {
        this.misafirCep = misafirCep;
    }

    public String getMisafirEposta() {
        return misafirEposta;
    }

    public void setMisafirEposta(String misafirEposta) {
        this.misafirEposta = misafirEposta;
    }

    public String getMisafirBulunduguKampus() {
        return misafirBulunduguKampus;
    }

    public void setMisafirBulunduguKampus(String misafirBulunduguKampus) {
        this.misafirBulunduguKampus = misafirBulunduguKampus;
    }

    public String getMisafirKampusBirimAdi() {
        return misafirKampusBirimAdi;
    }

    public void setMisafirKampusBirimAdi(String misafirKampusBirimAdi) {
        this.misafirKampusBirimAdi = misafirKampusBirimAdi;
    }

    public String getMisafirFirmaAdi() {
        return misafirFirmaAdi;
    }

    public void setMisafirFirmaAdi(String misafirFirmaAdi) {
        this.misafirFirmaAdi = misafirFirmaAdi;
    }

    public String getMisafirFirmaAdres() {
        return misafirFirmaAdres;
    }

    public void setMisafirFirmaAdres(String misafirFirmaAdres) {
        this.misafirFirmaAdres = misafirFirmaAdres;
    }

    public String getMisafirFirmaTel() {
        return misafirFirmaTel;
    }

    public void setMisafirFirmaTel(String misafirFirmaTel) {
        this.misafirFirmaTel = misafirFirmaTel;
    }
}
