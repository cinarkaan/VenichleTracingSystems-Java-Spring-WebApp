package com.AracStickerSistemi.Controller;

import com.AracStickerSistemi.Model.KurumSticker;
import com.AracStickerSistemi.Model.MisafirSticker;
import com.AracStickerSistemi.Model.OgrenciSticker;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;


public class PrintController {

    Document document = new Document(PageSize.A4);
    String tabList = "                                      ";
    String Path = "C:\\Users\\Kaan\\OneDrive\\Belgeler\\sticker\\Taşıt Sticker Takip Sistemi1_dosyalar\\logo.png";
    public static String filename;

    public void printOgrenciInfo (OgrenciSticker ogrenciSticker,String Isim) {
        PrintController.filename = Isim + "OgrenciSticker.pdf";
        try {
            PdfWriter PdfWriter= com.itextpdf.text.pdf.PdfWriter.getInstance(document,new FileOutputStream(Isim + "OgrenciSticker.pdf"));
            System.out.println(Isim);
            document.open();
            Image image = Image.getInstance(Path);
            image.scaleAbsolute(150f,125f);
            document.add(image);
            Paragraph header = new Paragraph();
            header.setTabSettings(new TabSettings(139f));
            header.add(Chunk.TABBING);
            header.add(new Chunk("OGRENCININ TASIT STICKER BILGILERI"));
            header.setSpacingAfter(10);
            document.add(header);
            List ogrenciStickerList = new List(List.ALPHABETICAL);
            ogrenciStickerList.setNumbered(false);
            ogrenciStickerList.setListSymbol(" ");
            ogrenciStickerList.add(new ListItem(tabList + "OgrenciTcNo : " + ogrenciSticker.getOgrenciTcNo()));
            ogrenciStickerList.add(new ListItem(tabList + "OgrenciAdSoyad : " + ogrenciSticker.getOgrenciAdSoyad()));
            ogrenciStickerList.add(new ListItem(tabList + "OgrenciNo : " + ogrenciSticker.getOgrenciNo()));
            ogrenciStickerList.add(new ListItem(tabList + "Fakulte/YO : " + ogrenciSticker.getFakulteYO()));
            ogrenciStickerList.add(new ListItem(tabList + "Bolum : " + ogrenciSticker.getBolum()));
            ogrenciStickerList.add(new ListItem(tabList + "Sınıf : " + ogrenciSticker.getSinif()));
            ogrenciStickerList.add(new ListItem(tabList + "OgrenciEposta : " + ogrenciSticker.getOgrenciEposta()));
            ogrenciStickerList.add(new ListItem(tabList + "OgrenciTel : " + ogrenciSticker.getOgrTel()));
            document.add(ogrenciStickerList);
            List taşıtBilgileriList = new List(List.ALPHABETICAL);
            taşıtBilgileriList.setNumbered(false);
            taşıtBilgileriList.setListSymbol(" ");
            taşıtBilgileriList.add(new ListItem(tabList + "AracTuru : " + ogrenciSticker.getAracTuru()));
            taşıtBilgileriList.add(new ListItem(tabList + "StickerNo : " + ogrenciSticker.getStickerNo()));
            taşıtBilgileriList.add(new ListItem(tabList + "AracSahibininAdiSoyad : " + ogrenciSticker.getAracSahibininAdiSoyad()));
            taşıtBilgileriList.add(new ListItem(tabList + "RuhsatSahibininAdiSoyad : " + ogrenciSticker.getRuhsatSahibininAdiSoyad()));
            taşıtBilgileriList.add(new ListItem(tabList + "Plaka : " + ogrenciSticker.getPlaka()));
            taşıtBilgileriList.add(new ListItem(tabList + "AracMarka : " + ogrenciSticker.getAracMarka()));
            taşıtBilgileriList.add(new ListItem(tabList + "VerilisTarihi : " + ogrenciSticker.getVerilisTarihi()));
            document.add(taşıtBilgileriList);
            document.close();
            PdfWriter.close();
        }catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void printKurumInfo (KurumSticker kurumSticker,String Isim) {
        try {
            PdfWriter PdfWriter= com.itextpdf.text.pdf.PdfWriter.getInstance(document,new FileOutputStream("KurumSticker.pdf"));
            System.out.println(Isim);
            document.open();
            Image image = Image.getInstance(Path);
            image.scaleAbsolute(150f,125f);
            document.add(image);
            Paragraph header = new Paragraph();
            header.setTabSettings(new TabSettings(139f));
            header.add(Chunk.TABBING);
            header.add(new Chunk("KURUMUN TASIT STICKER BILGILERI"));
            header.setSpacingAfter(10);
            document.add(header);
            List kurumStickerList = new List(List.ALPHABETICAL);
            kurumStickerList.setNumbered(false);
            kurumStickerList.setListSymbol(" ");
            kurumStickerList.add(new ListItem(tabList  + "Tcno : " + kurumSticker.getTcNo()));
            kurumStickerList.add(new ListItem(tabList  + "Ad Soyad : " + kurumSticker.getAdSoyad()));
            kurumStickerList.add(new ListItem(tabList  + "Bulundugu Kampus : " + kurumSticker.getBulunduguKampus()));
            kurumStickerList.add(new ListItem(tabList  + "Kampus Birim : " + kurumSticker.getKampusBirimAdi()));
            kurumStickerList.add(new ListItem(tabList  + "Kadro Birim : " + kurumSticker.getKadroBirimi()));
            kurumStickerList.add(new ListItem(tabList  + "Unvan : " + kurumSticker.getUnvan()));
            kurumStickerList.add(new ListItem(tabList  + "Gorev Birim : " + kurumSticker.getGorevYaptigiBirim()));
            kurumStickerList.add(new ListItem(tabList  + "Kurum Sicil : " + kurumSticker.getKurumSicil()));
            kurumStickerList.add(new ListItem(tabList  + "Ic Hat : " + kurumSticker.getIcHat()));
            kurumStickerList.add(new ListItem(tabList  + "Firma : " + kurumSticker.getFirma()));
            kurumStickerList.add(new ListItem(tabList  + "Telefon : " + kurumSticker.getCepTelefonu()));
            kurumStickerList.add(new ListItem(tabList  + "E-posta : " + kurumSticker.getEposta()));
            document.add(kurumStickerList);
            List taşıtBilgileriList = new List(List.ALPHABETICAL);
            taşıtBilgileriList.setNumbered(false);
            taşıtBilgileriList.setListSymbol(" ");
            taşıtBilgileriList.add(new ListItem(tabList + "AracTuru : " + kurumSticker.getAracTuru()));
            taşıtBilgileriList.add(new ListItem(tabList + "StickerNo : " + kurumSticker.getStickerNo()));
            taşıtBilgileriList.add(new ListItem(tabList + "AracSahibininAdiSoyad : " + kurumSticker.getAracSahibininAdiSoyad()));
            taşıtBilgileriList.add(new ListItem(tabList + "RuhsatSahibininAdiSoyad : " + kurumSticker.getRuhsatSahibininAdiSoyad()));
            taşıtBilgileriList.add(new ListItem(tabList + "Plaka : " + kurumSticker.getPlaka()));
            taşıtBilgileriList.add(new ListItem(tabList + "AracMarka : " + kurumSticker.getAracMarka()));
            taşıtBilgileriList.add(new ListItem(tabList + "VerilisTarihi : " + kurumSticker.getVerilisTarihi()));
            document.add(taşıtBilgileriList);
            document.close();
            PdfWriter.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void printMisafirInfo (MisafirSticker misafirSticker,String Isim) {
        try {

            PdfWriter PdfWriter= com.itextpdf.text.pdf.PdfWriter.getInstance(document,new FileOutputStream("MisafirSticker.pdf"));
            System.out.println(Isim);
            document.open();
            Image image = Image.getInstance(Path);
            image.scaleAbsolute(150f,125f);
            document.add(image);
            Paragraph header = new Paragraph();
            header.setTabSettings(new TabSettings(139f));
            header.add(Chunk.TABBING);
            header.add(new Chunk("MISAFIRIN TASIT STICKER BILGILERI"));
            header.setSpacingAfter(10);
            document.add(header);
            List misafirBilgileriList = new List(List.ALPHABETICAL);
            misafirBilgileriList.setNumbered(false);
            misafirBilgileriList.setListSymbol(" ");
            misafirBilgileriList.add(new ListItem(tabList + "TcNo : " + misafirSticker.getMisafirTcNo()));
            misafirBilgileriList.add(new ListItem(tabList + "Ad Soyad : " + misafirSticker.getMisafirAdSoyad()));
            misafirBilgileriList.add(new ListItem(tabList + "Cep Telefonu : " + misafirSticker.getMisafirCep()));
            misafirBilgileriList.add(new ListItem(tabList + "E-posta : " + misafirSticker.getMisafirEposta()));
            misafirBilgileriList.add(new ListItem(tabList + "Bulundugu Kampus : " + misafirSticker.getMisafirBulunduguKampus()));
            misafirBilgileriList.add(new ListItem(tabList + "Kampus Birim : " + misafirSticker.getMisafirKampusBirimAdi()));
            misafirBilgileriList.add(new ListItem(tabList + "Firma Adi : " + misafirSticker.getMisafirFirmaAdi()));
            misafirBilgileriList.add(new ListItem(tabList + "Firma Adres : " + misafirSticker.getMisafirFirmaAdres()));
            misafirBilgileriList.add(new ListItem(tabList + "Firma Tel : " + misafirSticker.getMisafirFirmaTel()));
            document.add(misafirBilgileriList);
            List taşıtBilgileriList = new List(List.ALPHABETICAL);
            taşıtBilgileriList.setNumbered(false);
            taşıtBilgileriList.setListSymbol(" ");
            taşıtBilgileriList.add(new ListItem(tabList + "AracTuru : " + misafirSticker.getAracTuru()));
            taşıtBilgileriList.add(new ListItem(tabList + "StickerNo : " + misafirSticker.getStickerNo()));
            taşıtBilgileriList.add(new ListItem(tabList + "AracSahibininAdiSoyad : " + misafirSticker.getAracSahibininAdiSoyad()));
            taşıtBilgileriList.add(new ListItem(tabList + "RuhsatSahibininAdiSoyad : " + misafirSticker.getRuhsatSahibininAdiSoyad()));
            taşıtBilgileriList.add(new ListItem(tabList + "Plaka : " + misafirSticker.getPlaka()));
            taşıtBilgileriList.add(new ListItem(tabList + "AracMarka : " + misafirSticker.getAracMarka()));
            taşıtBilgileriList.add(new ListItem(tabList + "VerilisTarihi : " + misafirSticker.getVerilisTarihi()));
            document.add(taşıtBilgileriList);
            document.close();
            PdfWriter.close();
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println(e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Document download() {
        return document;
    }
}
