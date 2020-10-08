package com.AracStickerSistemi.Controller;


import com.AracStickerSistemi.Model.SendMail;
import com.AracStickerSistemi.Model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

@RequestMapping("")
@Controller
public class WelcomeController {

    public static DataBaseController dataBaseController = new DataBaseController();;

    @RequestMapping("/sifremiUnuttum")
    public String resetPass () {
        return "ParolaSıfırla";
    }

    @RequestMapping("/Login")
    public String returnLogin(@RequestParam("EMAIL") String email) throws MessagingException {
        SendMail sendMail = new SendMail(email);
        return "Login";
    }

    @RequestMapping("/")
    public String welcome () {
        return "Welcome";
    }

    @RequestMapping(value = "/StickerBasvuru")
    public String basvur(Model model) {
        return "Basvuru/StickerBasvur";
    }

    @RequestMapping(value = "/Profile")
    public String login(){
        return "Kullanıcı/UserProfile";
    }

    @RequestMapping(value = "/LoginPanel")
    public String loginPage () {
        return "Login";
    }
}
