package com.AracStickerSistemi.Controller;


import com.AracStickerSistemi.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SearchController {

    public static ArrayList<OgrenciSticker> ogrenciStickers;
    public static ArrayList<KurumSticker> kurumStickers;
    public static ArrayList<MisafirSticker> misafirStickers;

    public static int currentPage;
    public static int totalPage;

    private boolean oneRun;
    int pageSize = 1;

    @ModelAttribute("StickerTur")
    public Map<String,String> getAracList() {
        HashMap<String,String> aracList = new HashMap<>();
        aracList.put("Akademik Personel ","Akademik Personel ");
        aracList.put("İdari Personel  ","İdari Personel  ");
        aracList.put("Öğrenci  ","Öğrenci  ");
        aracList.put("Sözleşmeli Personel  ","Sözleşmeli Personel  ");
        aracList.put("Misafir  ","Misafir  ");
        return aracList;
    }

    @ModelAttribute("kampusList")
    public Map<String,String> getKampusList () {
        HashMap <String,String> kampusYer = new HashMap<>();
        kampusYer.put("ÇİFTLİKKÖY ","ÇİFTLİKKÖY ");
        kampusYer.put("YENİŞEHİR  ","YENİŞEHİR  ");
        kampusYer.put("ERDEMLİ  ","ERDEMLİ  ");
        kampusYer.put("SİLİFKE  ","SİLİFKE  ");
        kampusYer.put("GÜLNAR  ","GÜLNAR  ");
        kampusYer.put("ANAMUR   ","ANAMUR   ");
        kampusYer.put("TECE   ","TECE   ");
        kampusYer.put("HASTANE   ","HASTANE   ");
        kampusYer.put("TARSUS   ","TARSUS   ");
        return kampusYer;
    }

    @ModelAttribute("kampusBirimList")
    public HashMap<String, String> getKampusBirimList () {
        return WelcomeController.dataBaseController.getFakulteBirimList();
    }

    @RequestMapping("/searchOgreciSticker")
    public String searchogrencisticker (Model model) {
        StickerController.kurumTcNo = null;
        StickerController.misafirTcNo = null;
        SearchSticker searchSticker = new SearchSticker();
        oneRun = true;
        SearchController.currentPage = 1;
        model.addAttribute("ogrstickersearch",searchSticker);
        return "Ara/SearchOgrenciSticker";
    }

    @RequestMapping("/searchKurumSticker")
    public String searchkurumsticker (Model model) {
        StickerController.misafirTcNo = null;
        StickerController.ogreciTcNo = null;
        SearchSticker searchSticker = new SearchSticker();
        oneRun = true;
        SearchController.currentPage = 1;
        model.addAttribute("kurumstickersearch",searchSticker);
        return "Ara/SearchKurumSticker";
    }

    @RequestMapping("/searchMisafirSticker")
    public String searchMisafirsticker (Model model) {
        StickerController.ogreciTcNo = null;
        StickerController.kurumTcNo = null;
        SearchSticker searchSticker = new SearchSticker();
        oneRun = true;
        SearchController.currentPage = 1;
        model.addAttribute("misafirstickersearch",searchSticker);
        return "Ara/SearchMisafirSticker";
    }

    @RequestMapping(value = "/getBasvuruList")
    public String getBasvuruList () {
        getList();
        return "Basvuru/OgrenciBasvuru";
    }

    @RequestMapping(value = "/paginationogrn/{number}")
    public String paginationOgrAzalt (@PathVariable String number) {
        int pagenumber = Encryption.decode(number);
        pagenumber -=1;
        SearchController.currentPage = pagenumber;
        pagenumber = (pagenumber - 1) * pageSize + 1;
        SearchController.ogrenciStickers = WelcomeController.dataBaseController.getPaginationOgrenci(pageSize,pagenumber);
        return "Ara/SearchResult";
    }

    @RequestMapping(value = "/paginationogrp/{number}")
    public String paginationOgrArttir (@PathVariable String number,@ModelAttribute("ogrstickersearch")SearchSticker searchSticker) {
        int pagenumber = Encryption.decode(number);
        if (oneRun) {
            StickerController.ogreciTcNo = "1";
            SearchController.ogrenciStickers = new ArrayList<>();
            int totalRecord = WelcomeController.dataBaseController.getOgreciStickerCount(searchSticker);
            totalPage = (totalRecord / pageSize) + (totalRecord % pageSize);
            oneRun = false;
        } else {
            pagenumber +=1;
            SearchController.currentPage = pagenumber;
        }
        pagenumber = (pagenumber - 1) * pageSize + 1;
        SearchController.ogrenciStickers = WelcomeController.dataBaseController.getPaginationOgrenci(pageSize,pagenumber);
        return "Ara/SearchResult";
    }

    @RequestMapping(value = "/paginationKurumn/{number}")
    public String paginationKurumAzalt (@PathVariable String number) {
        int pagenumber = Encryption.decode(number);
        pagenumber -=1;
        SearchController.currentPage = pagenumber;
        pagenumber = (pagenumber - 1) * pageSize + 1;
        SearchController.kurumStickers = WelcomeController.dataBaseController.getPaginationKurum(pageSize,pagenumber);
        return "Ara/SearchResult";}

    @RequestMapping(value = "/paginationKurump/{number}")
    public String paginationKurumArttir (@PathVariable String number,@ModelAttribute("kurumstickersearch")SearchSticker searchSticker) {
        int pagenumber = Encryption.decode(number);
        if (oneRun) {
            StickerController.kurumTcNo = "1";
            SearchController.kurumStickers = new ArrayList<>();
            int recordCount = WelcomeController.dataBaseController.getKurumStickerCount(searchSticker);
            totalPage = (recordCount / pageSize) + (recordCount % pageSize);
            oneRun = false;
        } else {
            pagenumber +=1;
            SearchController.currentPage = pagenumber;
        }
        pagenumber = (pagenumber - 1) * pageSize + 1;
        SearchController.kurumStickers = WelcomeController.dataBaseController.getPaginationKurum(pageSize,pagenumber);
        return "Ara/SearchResult";
    }

    @RequestMapping(value = "/paginationMisafirn/{number}")
    public String paginationMisafirAzalt (@PathVariable String number) {
        int pagenumber = Encryption.decode(number);
        System.out.println("SearchController.currentPage" + currentPage);
        System.out.println("Number" + number);
        pagenumber -=1;
        SearchController.currentPage = pagenumber;
        pagenumber = (pagenumber - 1) * pageSize + 1;
        System.out.println(Encryption.encode(1));
        SearchController.misafirStickers = WelcomeController.dataBaseController.getPaginationMisafir(pageSize,pagenumber);
        return "Ara/SearchResult";
    }

    @RequestMapping(value = "/paginationMisafirp/{number}")
    public String paginationMisafirArttir (@PathVariable String number,@ModelAttribute("misafirstickersearch")SearchSticker searchSticker) {
        int pagenumber = Encryption.decode(number);
        if (oneRun) {
            StickerController.misafirTcNo = "1";
            SearchController.misafirStickers = new ArrayList<>();
            int totalRecord = WelcomeController.dataBaseController.getMisafirStickerCount(searchSticker);
            totalPage = (totalRecord / pageSize) + (totalRecord % pageSize);
            oneRun = false;
        } else {
            pagenumber +=1;
            SearchController.currentPage = pagenumber;
        }
        System.out.println("SearchController.currentPage" + currentPage);
        System.out.println("pagenumber" + pagenumber);
        pagenumber = (pagenumber - 1) * pageSize + 1;
        SearchController.misafirStickers = WelcomeController.dataBaseController.getPaginationMisafir(pageSize,pagenumber);
        return "Ara/SearchResult";
    }

    public void getList () {
        SearchController.ogrenciStickers = new ArrayList<>();
        SearchController.ogrenciStickers = WelcomeController.dataBaseController.getBasvuruList();
    }


}
