package com.AracStickerSistemi.Controller;

import com.AracStickerSistemi.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/StickerOperations")
@Controller
public class StickerController {

    public static String ogreciTcNo;
    public static String kurumTcNo;
    public static String misafirTcNo;

    private OgrenciSticker ogrenciSticker;
    private KurumSticker kurumSticker;
    private MisafirSticker misafirSticker;

    @ModelAttribute("aracturlistesi")
    public Map<String,String> getAracList() {
        HashMap <String,String> araclist = new HashMap<>();
        araclist.put("Akademik Personel ","Akademik Personel ");
        araclist.put("İdari Personel  ","İdari Personel  ");
        araclist.put("Öğrenci  ","Öğrenci  ");
        araclist.put("Sözleşmeli Personel ","Sözleşmeli Personel ");
        araclist.put("Misafir ","Misafir ");
        return araclist;
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

    @ModelAttribute("kampusKadroBirimList")
    public HashMap<String, String> getKadroBirimList () {
        return WelcomeController.dataBaseController.getFakulteBirimList();
    }

    @ModelAttribute("Unvan")
    public HashMap<String, String> getUnvanList () {
        return WelcomeController.dataBaseController.getUnvanList();
    }

    @ModelAttribute("Gorev")
    public HashMap<String, String> getGorevList () {
        return WelcomeController.dataBaseController.getFakulteBirimList();
    }

    @ModelAttribute("Bolum")
    public HashMap<String, String> getBolumList () {
        return WelcomeController.dataBaseController.getBolumList();
    }

    @RequestMapping(value = "/basvuruAl", method = RequestMethod.GET)
    public String basvurual(Model model) {
        OgrenciSticker ogrenciSticker = new OgrenciSticker();
        model.addAttribute("basvuruform",ogrenciSticker);
        return "sticker/OgrenciBasvuru";
    }

    @RequestMapping(value = "/ogrenciStickerEkle" , method = RequestMethod.GET)
    public String ogrenciStickerEkle (Model model) {
        StickerController.kurumTcNo = null;
        StickerController.misafirTcNo = null;
        OgrenciSticker ogrenciSticker = new OgrenciSticker();
        model.addAttribute("ogrenciSticker",ogrenciSticker);
        return "sticker/OgrenciStickerEkle";
    }

    @RequestMapping(value = "/kurumStickerEkle" , method = RequestMethod.GET)
    public String kurumStickerEkle (Model model) {
        StickerController.ogreciTcNo = null;
        StickerController.misafirTcNo = null;
        KurumSticker kurumSticker = new KurumSticker();
        model.addAttribute("kurumSticker",kurumSticker);
        return "sticker/KurumStickerEkle";
    }

    @RequestMapping(value = "/misafirStickerEkle" , method = RequestMethod.GET)
    public String misafirStickerEkle (Model model) {
        StickerController.ogreciTcNo = null;
        StickerController.kurumTcNo = null;
        MisafirSticker misafirSticker = new MisafirSticker();
        model.addAttribute("misafirSticker",misafirSticker);
        return "sticker/MisafirStickerEkle";
    }

    @RequestMapping(value = "/stickerekle")
    public String addsticker (Model model) {
        StickerController.ogreciTcNo = null;
        StickerController.misafirTcNo = null;
        KurumSticker kurumSticker = new KurumSticker();
        model.addAttribute("stickerekle",kurumSticker);
        return "sticker/BirimKullanıcıEkle";
    }

    @RequestMapping("/ekle")
    public String ekle () {
        return "StickerEkle";
    }

    @RequestMapping(value = "birimstickerekle")
    public String addbirimsticker (@Valid @ModelAttribute("stickerekle")KurumSticker kurumSticker,
                                   BindingResult br,Model model,final HttpServletRequest request) throws SQLException {
        if (br.hasErrors()){
            return "sticker/BirimKullanıcıEkle";
        } else {
            StickerController.kurumTcNo = kurumSticker.getTcNo();
            this.kurumSticker = kurumSticker;
            boolean checkUnique = WelcomeController.dataBaseController.addKurumSticker(kurumSticker);
            if (!checkUnique) {
                model.addAttribute("error","StickerNo,Plaka,Tcno gibi tekil kısıtlamaları lütfen tekrar etmeyiniz");
                return "sticker/BirimKullanıcıEkle";
            }else {
                PrintController printController = new PrintController();
                printController.printKurumInfo(this.kurumSticker,this.kurumSticker.getAdSoyad());
                return "sticker/DisplaySticker";
            }
        }
    }

    @RequestMapping( value = "basvuruAl" , method = RequestMethod.POST)
    public String basvur (@Valid @ModelAttribute("basvuruform")OgrenciSticker ogrenciSticker , BindingResult br) throws SQLException {
        if (br.hasErrors()) {
            return "sticker/OgrenciBasvuru";
        } else {
            WelcomeController.dataBaseController.addBasvuru(ogrenciSticker);
            return "Kullanıcı/UserProfile";
        }
    }

    @RequestMapping("/AddedStickerOgrenci")
    public String addedOgrenci (@Valid  @ModelAttribute("ogrenciSticker") OgrenciSticker ogrenciSticker,
                                BindingResult br, Model model, final HttpServletRequest request) throws SQLException {
        if (br.hasErrors()) {
            return "sticker/OgrenciStickerEkle";
        } else {
            StickerController.ogreciTcNo = ogrenciSticker.getOgrenciTcNo();
            this.ogrenciSticker = ogrenciSticker;
            boolean checkUnique = WelcomeController.dataBaseController.addOgrenciSticker(ogrenciSticker);
            if (!checkUnique) {
                model.addAttribute("error","StickerNo,Plaka,Tcno gibi tekil kısıtlamaları lütfen tekrar etmeyiniz");
                return "sticker/OgrenciStickerEkle";
            } else {
                PrintController printController = new PrintController();
                printController.printOgrenciInfo(this.ogrenciSticker,this.ogrenciSticker.getOgrenciAdSoyad());
                return "sticker/DisplaySticker";
            }
        }
    }

    @RequestMapping("/downloadOgrenciSticker")
    public String printOgrenciPage() {
        ogreciTcNo = null;
        return "sticker/StickerDownload";
    }

    @RequestMapping("/downloadKurumSticker")
    public String printKurumPage() {
        kurumTcNo = null;
        return "Kullanıcı/UserProfile";
    }

    @RequestMapping("/downloadMisafirSticker")
    public String printMisafirPage() {
        misafirTcNo = null;
        return "Kullanıcı/UserProfile";
    }

    @RequestMapping("/AddedStickerKurum")
    public String addedKurum (@Valid @ModelAttribute("kurumSticker") KurumSticker kurumSticker , BindingResult br,
                              Model model , final HttpServletRequest request) throws SQLException {
        if (br.hasErrors()) {
            return "sticker/KurumStickerEkle";
        } else {
            kurumTcNo = kurumSticker.getTcNo();
            this.kurumSticker = kurumSticker;
            boolean checkUnique = WelcomeController.dataBaseController.addKurumSticker(kurumSticker);
            if (!checkUnique) {
                model.addAttribute("error","StickerNo,Plaka,Tcno gibi tekil kısıtlamaları lütfen tekrar etmeyiniz");
                return "sticker/KurumStickerEkle";
            } else {
                PrintController printController = new PrintController();
                printController.printKurumInfo(this.kurumSticker,this.kurumSticker.getAdSoyad());
                return "sticker/DisplaySticker";
            }
        }
    }

    @RequestMapping("/AddedStickerMisafir")
    public String addedMisafir (@Valid @ModelAttribute("misafirSticker") MisafirSticker misafirSticker , BindingResult br,
                                Model model, final HttpServletRequest request) throws SQLException {
       if (br.hasErrors()) {
           return "sticker/MisafirStickerEkle";
       } else {
           misafirTcNo = misafirSticker.getMisafirTcNo();
           this.misafirSticker = misafirSticker;
           boolean checkUnique = WelcomeController.dataBaseController.addMisafirSticker(misafirSticker);
           if (!checkUnique) {
               model.addAttribute("error","StickerNo,Plaka,Tcno gibi tekil kısıtlamaları lütfen tekrar etmeyiniz");
               return "sticker/MisafirStickerEkle";
           } else {
               PrintController printController = new PrintController();
               printController.printMisafirInfo(this.misafirSticker,this.misafirSticker.getMisafirAdSoyad());
               return "sticker/DisplaySticker";
           }
       }
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable String id) throws SQLException {
        System.out.println(id);
        WelcomeController.dataBaseController.delete(Encryption.decode(id));
        return "Kullanıcı/UserProfile";
    }

    @RequestMapping(value = "/red/{id}",method = RequestMethod.GET)
    public String red (@PathVariable String id) throws SQLException {
        WelcomeController.dataBaseController.reddet(Encryption.decode(id));
        return "Kullanıcı/UserProfile";
    }


}
