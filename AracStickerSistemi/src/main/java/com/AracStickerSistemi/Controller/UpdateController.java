package com.AracStickerSistemi.Controller;

import com.AracStickerSistemi.Model.Encryption;
import com.AracStickerSistemi.Model.KurumSticker;
import com.AracStickerSistemi.Model.MisafirSticker;
import com.AracStickerSistemi.Model.OgrenciSticker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UpdateController {

    private int id;

    @ModelAttribute("aracturlistesi")
    public Map<String,String> getAracList() {
        HashMap<String,String> araclist = new HashMap<>();
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

    @RequestMapping(value = "/ayrintiOgr/{id}",method = RequestMethod.GET)
    public String getOneOgrenci (@PathVariable String id) {
        StickerController.ogreciTcNo = String.valueOf(Encryption.decode(id));
        return "Ara/StickerAyrıntı";
    }

    @RequestMapping(value = "/ayrintiKurum/{id}",method = RequestMethod.GET)
    public String getOneKurum (@PathVariable String id) {
        StickerController.kurumTcNo = String.valueOf(Encryption.decode(id));
        return "Ara/StickerAyrıntı";
    }

    @RequestMapping(value = "/ayrintiMisafir/{id}",method = RequestMethod.GET)
    public String getOneMisafir (@PathVariable String id) {
        StickerController.misafirTcNo = String.valueOf(Encryption.decode(id));
        return "Ara/StickerAyrıntı";
    }

    @RequestMapping(value = "/editKurumSticker/{id}", method = RequestMethod.GET)
    public String updateKurumSticker (@PathVariable String id,Model m) throws SQLException {
        KurumSticker kurumSticker = WelcomeController.dataBaseController.getFindIdKurum(Encryption.decode(id));
        this.id = Encryption.decode(id);
        m.addAttribute("updateKurumSticker",kurumSticker);
        return "sticker/KurumStickerDüzenle";
    }

    @RequestMapping(value = "/editMisafirSticker/{id}",method = RequestMethod.GET)
    public String updateMisafirSticker (@PathVariable String id, Model m) throws SQLException {
        MisafirSticker misafirSticker = WelcomeController.dataBaseController.getFindIdMisafir(Encryption.decode(id));
        this.id = Encryption.decode(id);
        m.addAttribute("updateMisafirSticker",misafirSticker);
        return "sticker/MisafirStickerDüzenle";
    }

    @RequestMapping(value = "/editOgrenciSticker/{id}", method = RequestMethod.GET)
    public String updateOgrenciSticker (@PathVariable String id, Model m) throws SQLException {
        OgrenciSticker ogrenciSticker = WelcomeController.dataBaseController.getFindIdOgrenci(Encryption.decode(id));
        this.id = Encryption.decode(id);
        m.addAttribute("updateOgrenciSticker",ogrenciSticker);
        return "sticker/OgrenciStickerDüzenle";
    }

    @RequestMapping(value = "/editBasvuruOgr/{id}", method = RequestMethod.GET)
    public String getBasvuru (@PathVariable String id, Model m) throws SQLException {
        OgrenciSticker ogrenciSticker = WelcomeController.dataBaseController.getBasvuru(Encryption.decode(id));
        if (ogrenciSticker == null)
            System.out.println("null " + id + "decoder  " + Encryption.decode(id));
        this.id = Encryption.decode(id);
        m.addAttribute("basvuru",ogrenciSticker);
        return "Basvuru/BasvuruDüzenle";
    }

    @RequestMapping(value = "/editOgrenciStickerSave", method = RequestMethod.POST)
    public String updateOgrenci (@ModelAttribute("updateOgrenciSticker")OgrenciSticker ogrenciSticker,
                                 Model model, final HttpServletRequest request) throws SQLException {
        boolean checkUnique = WelcomeController.dataBaseController.updateOgrenciSticker(ogrenciSticker,this.id);
        if (!checkUnique) {
            model.addAttribute("error","StickerNo,Plaka,Tcno gibi tekil kısıtlamaları lütfen tekrar etmeyiniz");
            return "sticker/OgrenciStickerDüzenle";
        } else
        {
            return "Kullanıcı/UserProfile";
        }
    }

    @RequestMapping(value = "/submitBasvuru",method = RequestMethod.POST)
    public String saveBasvuru (@ModelAttribute("basvuru")OgrenciSticker ogrenciSticker,BindingResult br) throws SQLException {
        if (br.hasErrors()) {
            return "Basvuru/BasvuruDüzenle";
        } else {
            ogrenciSticker.setSerialno(this.id);
            ogrenciSticker.setSticker_id(this.id);
            WelcomeController.dataBaseController.addOgrenciSticker(ogrenciSticker);
            WelcomeController.dataBaseController.reddet(this.id);
            return "Kullanıcı/UserProfile";
        }
    }


    @RequestMapping(value = "/editKurumStickerSave",method = RequestMethod.POST)
    public String updateKurum (@ModelAttribute("updateKurumSticker")KurumSticker kurumSticker,
                               Model model,final HttpServletRequest request) throws SQLException {
        boolean checkUnique = WelcomeController.dataBaseController.updateKurumSticker(kurumSticker,this.id);
        if (!checkUnique) {
            model.addAttribute("error","StickerNo,Plaka,Tcno gibi tekil kısıtlamaları lütfen tekrar etmeyiniz");
            return "sticker/KurumStickerDüzenle";
        } else {
            return "Kullanıcı/UserProfile";
        }
    }

    @RequestMapping(value = "/editMisafirStickerSave",method = RequestMethod.POST)
    public String updateMisafir (@ModelAttribute("updateMisafirSticker")MisafirSticker misafirSticker,
                                 Model model,final HttpServletRequest request) throws SQLException {
        boolean checkUnique = WelcomeController.dataBaseController.updateMisafirSticker(misafirSticker,this.id);
        if (!checkUnique) {
            model.addAttribute("error","StickerNo,Plaka,Tcno gibi tekil kısıtlamaları lütfen tekrar etmeyiniz");
            return "sticker/MisafirStickerDüzenle";
        } else {
            return "Kullanıcı/UserProfile";
        }
    }
}
