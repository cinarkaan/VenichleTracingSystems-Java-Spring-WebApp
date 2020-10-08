package com.AracStickerSistemi.Model;


import KPSVerify.KPSPublic;
import KPSVerify.KPSPublicSoap;

public class TCNODogrula {

    private KPSPublic kpsPublic;
    private Long tcno;
    private String ad;
    private String soyad;
    private String stickertur;
    private int dogumyili;

    public TCNODogrula() {

    }

    public TCNODogrula(Long tcno, String ad, String soyad, String stickertur,int dogumyili) {
        this.tcno = tcno;
        this.ad = ad.toUpperCase();
        this.soyad = soyad.toUpperCase();
        this.stickertur = stickertur;
        this.dogumyili = dogumyili;
        this.kpsPublic = new KPSPublic();
    }

    public boolean verify () {
        boolean result;
        KPSPublicSoap kpsPublicSoap = kpsPublic.getKPSPublicSoap();
        result = kpsPublicSoap.tcKimlikNoDogrula(this.tcno,this.ad,this.soyad,this.dogumyili);
        if (result) {
            System.out.println(this.ad + " " + this.soyad + " : tc vatandaşıdır" );
        } else {
            System.out.println(this.ad + " " + this.soyad + " : tc vatandaşı değildir");
        }
        return result;
    }

    public boolean validation () {
        boolean check = false;
        if (this.ad.equalsIgnoreCase("") && this.soyad.equalsIgnoreCase(""))
            check = true;
        if (this.stickertur.equalsIgnoreCase(""))
            check = true;
        if (this.tcno == null)
            check = true;
        return check;
    }

    public String getStickertur() {
        return stickertur;
    }

    public void setStickertur(String stickertur) {
        this.stickertur = stickertur;
    }

    public Long getTcno() {
        return tcno;
    }

    public void setTcno(Long tcno) {
        this.tcno = tcno;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getDogumyili() {
        return dogumyili;
    }

    public void setDogumyili(int dogumyili) {
        this.dogumyili = dogumyili;
    }
}
