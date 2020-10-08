package com.AracStickerSistemi.Controller;

import com.AracStickerSistemi.Model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("")
@Controller
public class BasvuruController {

    TCNODogrula tcnoDogrula = new TCNODogrula();
    private int id;

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
        HashMap<String,String> kampusYer = new HashMap<>();
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

    @RequestMapping(value = "/redKurumBasvuru/{id}",method = RequestMethod.GET)
    public String redKurum (@PathVariable String id) throws SQLException {
        WelcomeController.dataBaseController.redKurumBasvuru(Encryption.decode(id));
        return "Kullanıcı/UserProfile";
    }

    @RequestMapping(value = "/redMisafirBasvuru/{id}",method = RequestMethod.GET)
    public String redMisafir (@PathVariable String id) throws SQLException {
        WelcomeController.dataBaseController.redMisafirBasvuru(Encryption.decode(id));
        return "Kullanıcı/UserProfile";
    }

    @RequestMapping(value = "/kurumbasvurulari")
    public String getKurumBasvurulari(Model model) {
        List<KurumSticker> kurumStickerList = WelcomeController.dataBaseController.getKurumBasvuru();
        model.addAttribute("kurumlist",kurumStickerList);
        return "Basvuru/KurumBasvuru";
    }

    @RequestMapping(value = "/misafirbasvurulari")
    public String getMisafirBasvurulari(Model model) {
        List<MisafirSticker> misafirStickers = WelcomeController.dataBaseController.getMisafirBasvuru();
        model.addAttribute("misafirList",misafirStickers);
        return "Basvuru/MisafirBasvuru";
    }

    @RequestMapping(value = "/verification",method = RequestMethod.POST)
    public String verify(@RequestParam("TCNO") Long tcno, Model model,@RequestParam("AD")String ad,@RequestParam("SOYAD") String soyad,
                         @RequestParam("STICKER") String sticker,@RequestParam("DTARIH") String dtarihi,final HttpServletRequest request) {
        if (dtarihi.equalsIgnoreCase(""))
            dtarihi = "0";
        TCNODogrula tcnoDogrula = new TCNODogrula(tcno,ad,soyad,sticker,Integer.parseInt(dtarihi));
        this.tcnoDogrula = tcnoDogrula;
        if (tcnoDogrula.validation()) {
            model.addAttribute("error","Lütfen boş alan bırakmayınız");
            return "Basvuru/StickerBasvur";
        }
        if (!tcnoDogrula.verify()){
            model.addAttribute("error","Lütfen gerçek bilgiler giriniz");
            return "Basvuru/StickerBasvur";
        }
        if (sticker.equalsIgnoreCase("Öğrenci")){
            OgrenciSticker ogrenciSticker = new OgrenciSticker();
            ogrenciSticker.setOgrenciTcNo(String.valueOf(tcno));
            ogrenciSticker.setOgrenciAdSoyad(ad+" "+soyad);
            ogrenciSticker.setAracTuru(sticker);
            model.addAttribute("ogrenci",ogrenciSticker);
            return "Basvuru/Ogrenci";
        } else if (sticker.equalsIgnoreCase("Misafir")){
            MisafirSticker misafirSticker = new MisafirSticker();
            misafirSticker.setMisafirTcNo(String.valueOf(tcno));
            misafirSticker.setMisafirAdSoyad(ad+" "+soyad);
            misafirSticker.setAracTuru(sticker);
            model.addAttribute("misafir",misafirSticker);
            return "Basvuru/Misafir";
        }
        else {
            KurumSticker kurumSticker = new KurumSticker();
            kurumSticker.setTcNo(String.valueOf(tcno));
            kurumSticker.setAdSoyad(ad+" "+soyad);
            kurumSticker.setAracTuru(sticker);
            model.addAttribute("kurum",kurumSticker);
            return "Basvuru/Kurum";
        }
    }

    @RequestMapping(value = "/ogrenci")
    public String basvuruKaydetOgrenci(@Valid @ModelAttribute("ogrenci")OgrenciSticker ogrenciSticker, BindingResult br,
                                       Model model, final HttpServletRequest request) throws IOException, SQLException {
        ogrenciSticker.setOgrenciTcNo(tcnoDogrula.getTcno().toString());
        ogrenciSticker.setOgrenciAdSoyad(tcnoDogrula.getAd()+tcnoDogrula.getSoyad());
        ogrenciSticker.setAracTuru(tcnoDogrula.getStickertur());
        if (br.hasErrors()) {
            System.out.println(br.getFieldErrors());
            return "Basvuru/Ogrenci";
        } else {
            WelcomeController.dataBaseController.addBasvuru(ogrenciSticker);
            return "Yönlendirme";
        }
    }

    @RequestMapping(value = "/kurum")
    public String basvuruKaydetKurum(@Valid @ModelAttribute("kurum")KurumSticker kurumSticker, BindingResult br,
                                       Model model, final  HttpServletRequest request) throws SQLException {
        kurumSticker.setTcNo(tcnoDogrula.getTcno().toString());
        kurumSticker.setAdSoyad(tcnoDogrula.getAd()+tcnoDogrula.getSoyad());
        kurumSticker.setAracTuru(tcnoDogrula.getStickertur());
        if (br.hasErrors()) {
            return "Basvuru/Kurum";
        } else {
            WelcomeController.dataBaseController.addKurumBasvuru(kurumSticker);
            return "Yönlendirme";
        }
    }

    @RequestMapping(value = "/misafir")
    public String basvuruKaydetMisafir(@Valid @ModelAttribute("misafir")MisafirSticker misafirSticker, BindingResult br,
                                       Model model, final  HttpServletRequest request) throws SQLException {
        misafirSticker.setMisafirTcNo(tcnoDogrula.getTcno().toString());
        misafirSticker.setMisafirAdSoyad(tcnoDogrula.getAd()+tcnoDogrula.getSoyad());
        misafirSticker.setAracTuru(tcnoDogrula.getStickertur());
        if (br.hasErrors()) {
            return "Basvuru/Misafir";
        } else {
            WelcomeController.dataBaseController.addMisafirBasvuru(misafirSticker);
            return "Yönlendirme";
        }
    }

    @RequestMapping(value = "/editBasvuruKurum/{id}" ,method = RequestMethod.GET)
    public String getBasvuruKurum (@PathVariable String id,Model model) {
        KurumSticker kurumSticker = WelcomeController.dataBaseController.getFindidKurumBasvuru(Encryption.decode(id));
        this.id = Encryption.decode(id);
        model.addAttribute("kurumbasvuru",kurumSticker);
        return "Basvuru/KurumBasvuruDüzenle";
    }

    @RequestMapping(value = "/editBasvuruMisafir/{id}" ,method = RequestMethod.GET)
    public String getBasvuruMisafir (@PathVariable String id,Model model) {
        MisafirSticker misafirSticker = WelcomeController.dataBaseController.getFindIdBasvuruMisafir(Encryption.decode(id));
        this.id = Encryption.decode(id);
        model.addAttribute("misafirbasvuru",misafirSticker);
        return "Basvuru/MisafirBasvuruDüzenle";
    }


    @RequestMapping(value = "/BasvuruKurumSave",method = RequestMethod.POST)
    public String saveBasvuruKurum (@ModelAttribute("kurumbasvuru")KurumSticker kurumSticker,BindingResult br) throws SQLException {
        if (br.hasErrors()) {
            return "Basvuru/KurumBasvuruDüzenle";
        } else {
            kurumSticker.setSticker_id(this.id);
            WelcomeController.dataBaseController.addKurumSticker(kurumSticker);
            WelcomeController.dataBaseController.redKurumBasvuru(this.id);
            return "Kullanıcı/UserProfile";
        }
    }

    @RequestMapping(value = "/BasvuruMisafirSave",method = RequestMethod.POST)
    public String saveBasvuruMisafir (@ModelAttribute("misafirbasvuru")MisafirSticker misafirSticker,BindingResult br) throws SQLException {
        if (br.hasErrors()) {
            return "Basvuru/MisafirBasvuruDüzenle";
        } else {
            misafirSticker.setSticker_id(this.id);
            WelcomeController.dataBaseController.addMisafirSticker(misafirSticker);
            WelcomeController.dataBaseController.redMisafirBasvuru(this.id);
            return "Kullanıcı/UserProfile";
        }
    }

}
