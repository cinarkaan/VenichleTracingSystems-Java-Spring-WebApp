package com.AracStickerSistemi.Controller;

import com.AracStickerSistemi.Model.Encryption;
import com.AracStickerSistemi.Model.TasitSticker;
import com.AracStickerSistemi.Model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ProfileController {

    public static UserProfile userProfile = new UserProfile();
    private int id;

    @RequestMapping(value = "/returnProfile")
    public String returnProfile () {
        return "sticker/StickerDownload";
    }

    @RequestMapping(value = "stickerAra")
    public String arama() {
        return "Ara/Search";
    }

    @RequestMapping(value = "/ara")
    public String ara(@RequestParam(value = "ID") String id,@RequestParam(value = "PLAKA") String plaka, Model model) throws SQLException {
        TasitSticker tasitSticker = WelcomeController.dataBaseController.getSticker(plaka,id);
        if (tasitSticker != null)
            model.addAttribute("sticker",tasitSticker);
        if (tasitSticker == null)
            model.addAttribute("error","ARADIĞINIZ KAYIT BULUNAMADI");
        return "Ara/Result";
    }
    @RequestMapping("/kurumList")
    public String returnGetList () {
        return "Ara/SearhKurum";
    }

    @RequestMapping("/viewuser")
    public String getAllUsers (Model m) throws SQLException {
        List<UserProfile> list = WelcomeController.dataBaseController.getAllUsers();
        m.addAttribute("userlist",list);
        return "Kullanıcı/Kullanıcılar";
    }

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.GET)
    public String deleteUser(@PathVariable String id) throws SQLException {
        WelcomeController.dataBaseController.deleteUser(Encryption.decode(id));
        return "Kullanıcı/UserProfile";
    }

    @RequestMapping("/OgrenciStickerEkle")
    public String ogrenciSticker () {
        return "sticker/OgrenciStickerEkle";
    }

    @RequestMapping("/KurumStickerEkle")
    public String kurumSticker () {
        return "sticker/KurumStickerEkle";
    }

    @RequestMapping("/MisafirStickerEkle")
    public String misafirSticker () {
        return "sticker/MisafirStickerEkle";
    }

    @ModelAttribute("kullanıcıtur")
    public Map<String,String> getBolumList () {
        HashMap<String,String> kullanicitur = new HashMap<>();
        kullanicitur.put("Adminastor","Adminastor");
        kullanicitur.put("Birim","Birim");
        kullanicitur.put("Kullanici","Kullanici");
        return kullanicitur;
    }

    @ModelAttribute("gorev")
    public Map<String,String> getGorevBirimList () {
        return  WelcomeController.dataBaseController.getFakulteBirimList();
    }

    @ModelAttribute("kampusBirimList")
    public HashMap<String, String> getKampusBirimList () {
        return WelcomeController.dataBaseController.getFakulteBirimList();
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

    @RequestMapping(value = "/editUser/{id}" , method = RequestMethod.GET)
    public String updateUser (@PathVariable String id,Model m) throws SQLException {
        UserProfile userProfile = WelcomeController.dataBaseController.getUser(Encryption.decode(id));
        this.id = Encryption.decode(id);
        m.addAttribute("updateUser",userProfile);
        return "Kullanıcı/KullanıcıDüzenle";
    }

    @RequestMapping(value = "/editUserSave", method = RequestMethod.POST)
    public String updateUserSave(@Valid @ModelAttribute("updateUser")UserProfile userProfile,BindingResult br,
                                 Model model,final HttpServletRequest request) throws SQLException {

        if (br.hasErrors()) {
            return "Kullanıcı/KullanıcıDüzenle";
        }
        boolean checkUnique = WelcomeController.dataBaseController.updateUser(userProfile,this.id);
        if (!checkUnique) {
            model.addAttribute("error","Kullanici ismi zaten kullanılıyor");
            return "Kullanıcı/KullanıcıDüzenle";
        } else  {

            return "Kullanıcı/UserProfile";
        }
    }

    @RequestMapping(value = "/kullaniciEkle",method = RequestMethod.GET)
    public String addUser (Model model) {
        UserProfile userProfile = new UserProfile();
        model.addAttribute("addUser",userProfile);
        return "Kullanıcı/AddUser";
    }

    @RequestMapping(value = "/AddUser" , method = RequestMethod.POST)
    public String Adduser (@Valid @ModelAttribute("addUser") UserProfile userProfile, BindingResult br,
                           Model model, final HttpServletRequest request) throws SQLException {
        System.out.println(userProfile.getAd());
        Encryption encryption = new Encryption();
        userProfile.setPassword(encryption.encrypt(userProfile.getPassword(),encryption.getKey()));
        userProfile.setCepTel(encryption.encrypt(userProfile.getCepTel(),encryption.getKey()));
        if (br.hasErrors()) {
            return "Kullanıcı/AddUser";
        }
        boolean checkUnique = WelcomeController.dataBaseController.createUser(userProfile);
        if (!checkUnique) {
            model.addAttribute("error","Kullanici ismi zaten kullanılıyor");
            return "Kullanıcı/AddUser";
        } else {
            return "Kullanıcı/UserProfile";
        }
    }



}
