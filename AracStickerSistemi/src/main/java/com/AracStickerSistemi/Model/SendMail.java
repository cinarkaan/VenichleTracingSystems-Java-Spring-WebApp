package com.AracStickerSistemi.Model;

import com.AracStickerSistemi.Controller.WelcomeController;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    private final String from = "cnrkaan98@gmail.com";
    private final String password = "Lchkdr16";
    private String to = null;
    private String resetPass = null;
    Properties properties;
    Session session;


    private void resetPassword () {
        Encryption encryption = new Encryption();
        this.resetPass = encryption.map();
        WelcomeController.dataBaseController.parolaSifirla(to,this.resetPass);
    }

    private Message prepareMessage (Session session,String from,String to){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Parola sıfırlama");
            message.setText("Yeni parolanız : " + this.resetPass);
            return message;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    private void getSession () {
        this.session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,password);
            }
        });
    }
    public SendMail (String to) throws MessagingException {
        this.to = to;
        this.properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
        getSession();
        resetPassword();
        Message message = prepareMessage(this.session,from,to);
        assert message != null;
        Transport.send(message);
    }







}
