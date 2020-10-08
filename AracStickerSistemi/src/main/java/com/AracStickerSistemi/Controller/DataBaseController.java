package com.AracStickerSistemi.Controller;

import com.AracStickerSistemi.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseController {

    Connection connection;
    String url = "jdbc:postgresql://localhost:5432/AracStickerSistemi";
    String user = "postgres";
    String pass = "123";
    Savepoint savepoint;
    String lastSql;
    Long gkey;


    public Connection connection () {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.getMessage();
            Logger.getLogger(DataBaseController.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Veritabani Baglanti basarisiz!!!!!");
        }
        return connection;
    }

    public boolean loginControl (UserProfile userProfile) throws SQLException {
        String password = null;
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select * from kullanıcılar where kullanici_ismi = ?");
            stmt.setString(1,userProfile.getId());
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()){
                ProfileController.userProfile.setKullanici_id(resultSet.getInt("kullanici_id"));
                ProfileController.userProfile.setAd(resultSet.getString("isim"));
                ProfileController.userProfile.setSoyAdi(resultSet.getString("soyisim"));
                ProfileController.userProfile.setId(resultSet.getString("kullanici_ismi"));
                ProfileController.userProfile.setPassword(resultSet.getString("parola"));
                ProfileController.userProfile.setCepTel(resultSet.getString("telefon"));
                ProfileController.userProfile.setStickerTur(resultSet.getString("kullanici_tür"));
                ProfileController.userProfile.setGörev(resultSet.getString("gorev"));
                ProfileController.userProfile.setKampus(resultSet.getString("kampus"));
                ProfileController.userProfile.setKampusbirim(resultSet.getString("kampusbirim"));
            }
            if (userProfile.getPassword().equals(ProfileController.userProfile.getPassword())) {
                connection.close();

                return true;
            }
            else {
                connection.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return false;
        }
    }

    public OgrenciSticker getFindIdOgrenci (int id) throws SQLException {
        System.out.println(id);
        OgrenciSticker ogrenciSticker = new OgrenciSticker();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select * from aracsticker ast inner join aracogrencisticker aos on ast.sticker_id = aos.serialno where sticker_id = ?");
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                ogrenciSticker.setAracTuru(resultSet.getString("aracturu"));
                ogrenciSticker.setStickerNo(resultSet.getString("aracstickerno"));
                ogrenciSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                ogrenciSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                ogrenciSticker.setPlaka(resultSet.getString("plaka"));
                ogrenciSticker.setAracMarka(resultSet.getString("modelmarka"));
                ogrenciSticker.setAracRengi(resultSet.getString("rengi"));
                ogrenciSticker.setVerilisTarihi(resultSet.getDate("verilistarihi").toString());
                ogrenciSticker.setOgrenciTcNo(resultSet.getString("tcno"));
                ogrenciSticker.setOgrenciAdSoyad(resultSet.getString("adsoyad"));
                ogrenciSticker.setOgrenciNo(resultSet.getString("ogrencino"));
                ogrenciSticker.setFakulteYO(resultSet.getString("fakulte"));
                ogrenciSticker.setBolum(resultSet.getString("bolum"));
                ogrenciSticker.setSinif(resultSet.getInt("sınıf"));
                ogrenciSticker.setOgrTel(resultSet.getString("ceptelefonu"));
                ogrenciSticker.setOgrenciEposta(resultSet.getString("eposta"));
            }
            connection.close();
            return ogrenciSticker;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return null;
        }
    }

    public KurumSticker getFindIdKurum (int id) throws SQLException {
        KurumSticker kurumSticker = new KurumSticker();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select * from aracsticker ast inner join arackurumsticker aks on ast.sticker_id = aks.serialno where sticker_id = ?");
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                kurumSticker.setSticker_id(resultSet.getInt("sticker_id"));
                kurumSticker.setAracTuru(resultSet.getString("aracturu"));
                kurumSticker.setStickerNo(resultSet.getString("aracstickerno"));
                kurumSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                kurumSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                kurumSticker.setPlaka(resultSet.getString("plaka"));
                kurumSticker.setAracMarka(resultSet.getString("modelmarka"));
                kurumSticker.setAracRengi(resultSet.getString("rengi"));
                kurumSticker.setVerilisTarihi(resultSet.getDate("verilistarihi").toString());
                kurumSticker.setTcNo(resultSet.getString("tcno"));
                kurumSticker.setAdSoyad(resultSet.getString("adsoyad"));
                kurumSticker.setBulunduguKampus(resultSet.getString("kampus"));
                kurumSticker.setKampusBirimAdi(resultSet.getString("kampusbirim"));
                kurumSticker.setKadroBirimi(resultSet.getString("kadrobirim"));
                kurumSticker.setUnvan(resultSet.getString("unvan"));
                kurumSticker.setGorevYaptigiBirim(resultSet.getString("gorevbirimi"));
                kurumSticker.setKurumSicil(resultSet.getString("kurumsicil"));
                kurumSticker.setIcHat(resultSet.getString("ichat"));
                kurumSticker.setCepTelefonu(resultSet.getString("eptelefonu"));
                kurumSticker.setEposta(resultSet.getString("eposta"));
            }
            connection.close();
            return  kurumSticker;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return null;
        }
    }

    public MisafirSticker getFindIdMisafir (int id) throws SQLException {
        MisafirSticker misafirSticker = new MisafirSticker();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement( "select * from aracsticker ast inner join aracmisafirsticker ams on ast.sticker_id = ams.serialno where sticker_id = ?");
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                misafirSticker.setSticker_id(resultSet.getInt("sticker_id"));
                misafirSticker.setAracTuru(resultSet.getString("aracturu"));
                misafirSticker.setStickerNo(resultSet.getString("aracstickerno"));
                misafirSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                misafirSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                misafirSticker.setPlaka(resultSet.getString("plaka"));
                misafirSticker.setAracMarka(resultSet.getString("modelmarka"));
                misafirSticker.setAracRengi(resultSet.getString("rengi"));
                misafirSticker.setVerilisTarihi(resultSet.getDate("verilistarihi").toString());
                misafirSticker.setMisafirTcNo(resultSet.getString("tcno"));
                misafirSticker.setMisafirAdSoyad(resultSet.getString("adsoyad"));
                misafirSticker.setMisafirCep(resultSet.getString("ceptelefonu"));
                misafirSticker.setMisafirEposta(resultSet.getString("eposta"));
                misafirSticker.setMisafirBulunduguKampus(resultSet.getString("kampus"));
                misafirSticker.setMisafirKampusBirimAdi(resultSet.getString("kampusbirim"));
                misafirSticker.setMisafirFirmaAdi(resultSet.getString("firmaad"));
                misafirSticker.setMisafirFirmaAdres(resultSet.getString("firmadresi"));
                misafirSticker.setMisafirFirmaTel(resultSet.getString("firmatel"));
            }
            connection.close();
            return misafirSticker;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return null;
        }
    }

    public boolean createUser (UserProfile userProfile) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("insert into kullanıcılar" +
                    "(isim,soyisim,kullanici_ismi,parola,telefon,kullanici_tür,kampus,gorev) values(?,?,?,?,?,?,?,?)");
            stmt.setString(1,userProfile.getAd());
            stmt.setString(2,userProfile.getSoyAdi());
            stmt.setString(3,userProfile.getId());
            stmt.setString(4,userProfile.getPassword());
            stmt.setString(5,userProfile.getCepTel());
            stmt.setString(6,userProfile.getStickerTur());
            stmt.setString(7,userProfile.getKampus());
            stmt.setString(8,userProfile.getGörev());
            stmt.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return false;
        }
    }

    private void addAracSticker (TasitSticker tasitSticker,Connection connection) throws SQLException {
        Date datesql = new Date(new java.util.Date().getTime());
        tasitSticker.setVerilisTarihi(datesql.toString());
        try {
            connection.setAutoCommit(false);
            this.savepoint = connection.setSavepoint("savepoint");
            PreparedStatement stmt = connection.prepareStatement("insert into aracsticker(aracturu,aracstickerno,sahibinadisoyadi,ruhsatsahibininadsoyadi,plaka,modelmarka,rengi,verilistarihi) " +
                    "values(?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1,tasitSticker.getAracTuru());
            stmt.setString(2,tasitSticker.getStickerNo());
            stmt.setString(3,tasitSticker.getAracSahibininAdiSoyad());
            stmt.setString(4,tasitSticker.getRuhsatSahibininAdiSoyad());
            stmt.setString(5,tasitSticker.getPlaka());
            stmt.setString(6,tasitSticker.getAracMarka());
            stmt.setString(7,tasitSticker.getAracRengi());
            stmt.setDate(8,datesql);
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
            if (resultSet.next())
                gkey = resultSet.getLong("sticker_id");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String selectKurumSearchSql (SearchSticker searchSticker) {
        String sql ="";

        if (searchSticker.getKampus() != "") {
            sql = "select * from aracsticker ast inner join arackurumsticker aks on ast.sticker_id = aks.serialno where kampus = '"+searchSticker.getKampus()+"' " ;
            return sql;
        }
        else if (searchSticker.getStickerNo() != "") {
            sql = "select * from aracsticker ast inner join arackurumsticker aks on ast.sticker_id = aks.serialno where aracstickerno = '"+searchSticker.getStickerNo()+"' " ;
            return sql;
        } else if (searchSticker.getKapmusBirimi() != "") {
            sql = "select * from aracsticker ast inner join arackurumsticker aks on ast.sticker_id = aks.serialno where kampusbirim = '"+searchSticker.getKapmusBirimi()+"' " ;
            return sql;
        } else if (searchSticker.getStickerTur() != "") {
            sql = "select * from aracsticker ast inner join arackurumsticker aks on ast.sticker_id = aks.serialno where aracturu = '"+searchSticker.getStickerTur()+"' " ;
            return sql;
        } else {
            sql = "select * from aracsticker ast inner join arackurumsticker aks on ast.sticker_id = aks.serialno";
            return sql;
        }
    }

    private String selectMisafiSearchSql (SearchSticker searchSticker) {
        String sql = "";
        if (searchSticker.getStickerNo() != "") {
            sql = "select * from aracsticker ast inner join aracmisafirsticker ams on ast.sticker_id = ams.serialno where aracstickerno = '"+searchSticker.getStickerNo()+"' ";
            return sql;
        } else if (searchSticker.getKampus() != "") {
            sql = "select * from aracsticker ast inner join aracmisafirsticker ams on ast.sticker_id = ams.serialno where kampus = '"+searchSticker.getKampus()+"' ";
            return sql;
        } else if (searchSticker.getKapmusBirimi() != "") {
            sql = "select * from aracsticker ast inner join aracmisafirsticker ams on ast.sticker_id = ams.serialno where kampusbirim = '"+searchSticker.getKapmusBirimi()+"' ";
            return sql;
        } else {
            sql = "select * from aracsticker ast inner join aracmisafirsticker ams on ast.sticker_id = ams.serialno";
            return sql;
        }
    }

    private String selectOgrenciSearchSql (SearchSticker searchSticker) {
        String sql = "";
        if (searchSticker.getStickerNo() != "" ) {
            sql = "select * from aracsticker ast inner join aracogrencisticker aos on ast.sticker_id = aos.serialno where aracstickerno = '"+searchSticker.getStickerNo()+"' ";
            return sql;
        } else if (searchSticker.getKapmusBirimi() != "" && searchSticker.getKapmusBirimi() != null) {
           sql = "select * from aracsticker ast inner join aracogrencisticker aos on ast.sticker_id = aos.serialno where bolum = '"+searchSticker.getKapmusBirimi()+"' ";
            return sql;
        } else if (searchSticker.getKampus() != "") {
            sql = "select * from aracsticker ast inner join aracogrencisticker aos on ast.sticker_id = aos.serialno where fakulte = '"+searchSticker.getKampus()+"' ";
            return sql;
        } else {
            sql = "select * from aracsticker ast inner join aracogrencisticker aos on ast.sticker_id = aos.serialno ";
            return sql;
        }
    }

    private String selectDeleteSticker (TasitSticker tasitSticker) {
        String sql="";
        if (tasitSticker.getPlaka() != "") {
            sql = "select * from aracsticker where plaka = '"+ tasitSticker.getPlaka()+"'";
            return sql;
        } else if (tasitSticker.getStickerNo() != "") {
            sql = "select * from aracsticker where aracstickerno = '" + tasitSticker.getStickerNo() + "'";
            return sql;
        }else if (tasitSticker.getSticker_id() != 0) {
            sql = "select * from aracsticker where sticker_id = '"+ tasitSticker.getSticker_id()+"'";
            return  sql;
        }  else {
            return null;
        }
    }

    public boolean addOgrenciSticker (OgrenciSticker ogrenciSticker) throws SQLException {
        try {
            connection = connection();
            addAracSticker(ogrenciSticker,connection);
            PreparedStatement stmt = connection.prepareStatement("insert into aracogrencisticker(serialno,tcno,adsoyad,ogrencino,fakulte,bolum,sınıf,ceptelefonu,eposta)" +
                    "values (?,?,?,?,?,?,?,?,?)");
            stmt.setInt(1,gkey.intValue());
            stmt.setString(2,ogrenciSticker.getOgrenciTcNo());
            stmt.setString(3,ogrenciSticker.getOgrenciAdSoyad());
            stmt.setString(4,ogrenciSticker.getOgrenciNo());
            stmt.setString(5,ogrenciSticker.getFakulteYO());
            stmt.setString(6,ogrenciSticker.getBolum());
            stmt.setInt(7,ogrenciSticker.getSinif());
            stmt.setString(8,ogrenciSticker.getOgrTel());
            stmt.setString(9,ogrenciSticker.getOgrenciEposta());
            stmt.executeUpdate();
            connection.commit();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            connection.rollback(savepoint);
            connection.commit();
            connection.close();
            return false;
        }
    }

    public boolean addKurumSticker (KurumSticker kurumSticker) throws SQLException {
     try {
         connection = connection();
         addAracSticker(kurumSticker,connection);
         PreparedStatement stmt = connection.prepareStatement("insert into arackurumsticker(serialno,tcno,adsoyad,kampus,kampusbirim,kadrobirim,unvan,gorevbirimi,kurumsicil,ichat,eptelefonu,eposta)" +
                 "values (?,?,?,?,?,?,?,?,?,?,?,?)");
         stmt.setInt(1,gkey.intValue());
         stmt.setString(2,kurumSticker.getTcNo());
         stmt.setString(3,kurumSticker.getAdSoyad());
         stmt.setString(4,kurumSticker.getBulunduguKampus());
         stmt.setString(5,kurumSticker.getKampusBirimAdi());
         stmt.setString(6,kurumSticker.getKadroBirimi());
         stmt.setString(7,kurumSticker.getUnvan());
         stmt.setString(8,kurumSticker.getGorevYaptigiBirim());
         stmt.setString(9,kurumSticker.getKurumSicil());
         stmt.setString(10,kurumSticker.getIcHat());
         stmt.setString(11,kurumSticker.getCepTelefonu());
         stmt.setString(12,kurumSticker.getEposta());
         stmt.executeUpdate();
         connection.commit();
         connection.close();
         return true;
        }catch (Exception e) {
         System.out.println(e);
         connection.rollback(savepoint);
         connection.commit();
         connection.close();
         return false;
        }
    }

    public boolean addMisafirSticker (MisafirSticker misafirSticker) throws SQLException {
       try {
           connection = connection();
           addAracSticker(misafirSticker,connection);
           PreparedStatement stmt = connection.prepareStatement("insert into aracmisafirsticker(serialno,tcno,adsoyad,ceptelefonu,eposta,kampus,kampusbirim,firmaad,firmadresi,firmatel)" +
                   "values(?,?,?,?,?,?,?,?,?,?)");
           stmt.setInt(1,gkey.intValue());
           stmt.setString(2,misafirSticker.getMisafirTcNo());
           stmt.setString(3,misafirSticker.getMisafirAdSoyad());
           stmt.setString(4,misafirSticker.getMisafirCep());
           stmt.setString(5,misafirSticker.getMisafirEposta());
           stmt.setString(6,misafirSticker.getMisafirBulunduguKampus());
           stmt.setString(7,misafirSticker.getMisafirKampusBirimAdi());
           stmt.setString(8,misafirSticker.getMisafirFirmaAdi());
           stmt.setString(9,misafirSticker.getMisafirFirmaAdres());
           stmt.setString(10,misafirSticker.getMisafirFirmaTel());
           stmt.executeUpdate();
           connection.commit();
           connection.close();
           return true;
        }catch (Exception e) {
           System.out.println(e);
           connection.rollback(savepoint);
           connection.commit();
           connection.close();
           return false;
        }
    }

    public void updatearacsticker (TasitSticker tasitSticker, int id,Connection connection) {
        String sql = "update aracsticker set aracturu = ?,aracstickerno=?,sahibinadisoyadi = ?,ruhsatsahibininadsoyadi =?,plaka = ?,modelmarka = ?,rengi =? where sticker_id = ? ";
        try {
            connection.setAutoCommit(false);
            this.savepoint = connection.setSavepoint("savepoint");
            PreparedStatement stmt = connection.prepareStatement("update aracsticker set aracturu = ?,aracstickerno=?,sahibinadisoyadi = ?" +
                    ",ruhsatsahibininadsoyadi =?,plaka = ?,modelmarka = ?,rengi =? where sticker_id = ? ");
            stmt.setString(1,tasitSticker.getAracTuru());
            stmt.setString(2,tasitSticker.getStickerNo());
            stmt.setString(3,tasitSticker.getAracSahibininAdiSoyad());
            stmt.setString(4,tasitSticker.getRuhsatSahibininAdiSoyad());
            stmt.setString(5,tasitSticker.getPlaka());
            stmt.setString(6,tasitSticker.getAracMarka());
            stmt.setString(7,tasitSticker.getAracRengi());
            stmt.setInt(8,id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean updateOgrenciSticker (OgrenciSticker ogrenciSticker, int id) throws SQLException {
      try {
          connection = connection();
          updatearacsticker(ogrenciSticker,id,connection);
          PreparedStatement stmt = connection.prepareStatement("update  aracogrencisticker set tcno = ?,adsoyad=?,fakulte = ?,bolum =?" +
                  ",sınıf = ?,ceptelefonu =?,eposta =? where serialno = ? ");
          stmt.setString(1,ogrenciSticker.getOgrenciTcNo());
          stmt.setString(2,ogrenciSticker.getOgrenciAdSoyad());
          stmt.setString(3,ogrenciSticker.getFakulteYO());
          stmt.setString(4,ogrenciSticker.getBolum());
          stmt.setInt(5,ogrenciSticker.getSinif());
          stmt.setString(6,ogrenciSticker.getOgrTel());
          stmt.setString(7,ogrenciSticker.getOgrenciEposta());
          stmt.setInt(8,id);
          stmt.executeUpdate();
          connection.commit();
          connection.close();
          return true;
        } catch (Exception e) {
          System.out.println(e);
          connection.rollback(savepoint);
          connection.commit();
          connection.close();
          return false;
        }
    }

    public boolean updateKurumSticker (KurumSticker kurumSticker, int id) throws SQLException {
      try {
          connection = connection();
          updatearacsticker(kurumSticker,id,connection);
          PreparedStatement stmt = connection.prepareStatement("update arackurumsticker set tcno=?,adsoyad = ?,kampus = ?,kampusbirim=?," +
                  "kadrobirim = ?,gorevbirimi =?,kurumsicil = ?,ichat =?,eptelefonu =?,eposta =? where serialno =? ");
          stmt.setString(1,kurumSticker.getTcNo());
          stmt.setString(2,kurumSticker.getAdSoyad());
          stmt.setString(3,kurumSticker.getBulunduguKampus());
          stmt.setString(4,kurumSticker.getKampusBirimAdi());
          stmt.setString(5,kurumSticker.getKadroBirimi());
          stmt.setString(6,kurumSticker.getGorevYaptigiBirim());
          stmt.setString(7,kurumSticker.getKurumSicil());
          stmt.setString(8,kurumSticker.getIcHat());
          stmt.setString(9,kurumSticker.getCepTelefonu());
          stmt.setString(10,kurumSticker.getEposta());
          stmt.setInt(11,id);
          stmt.executeUpdate();
          connection.commit();
          connection.close();
          return true;
        } catch (Exception e) {
            System.out.println(e);
            connection.rollback(savepoint);
            connection.commit();
            connection.close();
            return false;
        }
    }

    public boolean updateMisafirSticker (MisafirSticker misafirSticker, int id) throws SQLException {
       try {
           connection = connection();
           updatearacsticker(misafirSticker,id,connection);
           PreparedStatement stmt = connection.prepareStatement("update aracmisafirsticker set tcno = ?,adsoyad = ?,ceptelefonu = ?," +
                   "eposta = ?,kampus = ?,kampusbirim = ?,firmaad = ?,firmadresi = ?,firmatel = ? where serialno = ? ");
           stmt.setString(1,misafirSticker.getMisafirTcNo());
           stmt.setString(2,misafirSticker.getMisafirAdSoyad());
           stmt.setString(3,misafirSticker.getMisafirCep());
           stmt.setString(4,misafirSticker.getMisafirEposta());
           stmt.setString(5,misafirSticker.getMisafirBulunduguKampus());
           stmt.setString(6,misafirSticker.getMisafirKampusBirimAdi());
           stmt.setString(7,misafirSticker.getMisafirFirmaAdi());
           stmt.setString(8,misafirSticker.getMisafirFirmaAdres());
           stmt.setString(9,misafirSticker.getMisafirFirmaTel());
           stmt.setInt(10,id);
           stmt.executeUpdate();
           connection.commit();
           connection.close();
           return true;
       } catch (Exception e) {
           System.out.println(e);
           connection.rollback(savepoint);
           connection.commit();
           connection.close();
           return false;
       }
    }

    public int getKurumStickerCount (SearchSticker searchSticker) {
        String getSubSql = selectKurumSearchSql(searchSticker);
        String sql = "select count(sticker_id) as reccount from(" + getSubSql + ")as lastsql";
        this.lastSql = getSubSql;
        int recordCount = 0;
        System.out.println(sql);
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                recordCount = resultSet.getInt("reccount");
            }
            connection.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e);
            return recordCount;
        }
    }

    public int getMisafirStickerCount (SearchSticker searchSticker) {
        String getSubSql = selectMisafiSearchSql(searchSticker);
        String sql = "select count(sticker_id) as reccount from(" + getSubSql + ")as lastsql";
        this.lastSql = getSubSql;
        int recordCount = 0;
        System.out.println(sql);
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                recordCount = resultSet.getInt("reccount");
            }
            connection.close();
            return recordCount;
        }catch (Exception e) {
            System.out.println(e);
            return recordCount;
        }
    }

    public int getOgreciStickerCount (SearchSticker searchSticker) {
        String getSubSql = selectOgrenciSearchSql(searchSticker);
        String sql = "select count(sticker_id) as reccount from (" + getSubSql + ")as lastsql";
        this.lastSql = getSubSql;
        int recordCount = 0;
        System.out.println(sql);
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                recordCount= resultSet.getInt("reccount");
            }
            connection.close();
            return recordCount;
        } catch (Exception e) {
            System.out.println(e);
            return recordCount;
        }
    }

    public ArrayList<KurumSticker> getByKurum (String kampusBirim) throws SQLException {
        ArrayList<KurumSticker> kurumStickerArrayList = new ArrayList<>();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select * from aracsticker ast inner join arackurumsticker aks on ast.sticker_id = aks.serialno where kampusbirim = ?" );
            stmt.setString(1,kampusBirim);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                KurumSticker kurumSticker = new KurumSticker();
                kurumSticker.setSticker_id(resultSet.getInt("sticker_id"));
                kurumSticker.setAracTuru(resultSet.getString("aracturu"));
                kurumSticker.setStickerNo(resultSet.getString("aracstickerno"));
                kurumSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                kurumSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                kurumSticker.setPlaka(resultSet.getString("plaka"));
                kurumSticker.setAracMarka(resultSet.getString("modelmarka"));
                kurumSticker.setAracRengi(resultSet.getString("rengi"));
                kurumSticker.setVerilisTarihi(resultSet.getDate("verilistarihi").toString());
                kurumSticker.setTcNo(resultSet.getString("tcno"));
                kurumSticker.setAdSoyad(resultSet.getString("adsoyad"));
                kurumSticker.setBulunduguKampus(resultSet.getString("kampus"));
                kurumSticker.setKampusBirimAdi(resultSet.getString("kampusbirim"));
                kurumSticker.setKadroBirimi(resultSet.getString("kadrobirim"));
                kurumSticker.setUnvan(resultSet.getString("unvan"));
                kurumSticker.setGorevYaptigiBirim(resultSet.getString("gorevbirimi"));
                kurumSticker.setKurumSicil(resultSet.getString("kurumsicil"));
                kurumSticker.setIcHat(resultSet.getString("ichat"));
                kurumSticker.setCepTelefonu(resultSet.getString("eptelefonu"));
                kurumSticker.setEposta(resultSet.getString("eposta"));
                kurumStickerArrayList.add(kurumSticker);
            }
            connection.close();
            return kurumStickerArrayList;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return null;
        }

    }

    public ArrayList<OgrenciSticker> getPaginationOgrenci (int pageSize,int offset) {
        offset = offset - 1;
        String sql = "select * from(" + lastSql +") as lastsql limit "+pageSize+" offset "+offset+"";
        System.out.println(sql);
        ArrayList<OgrenciSticker> list = new ArrayList<>();
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                OgrenciSticker ogrenciSticker = new OgrenciSticker();
                ogrenciSticker.setAracTuru(resultSet.getString("aracturu"));
                ogrenciSticker.setStickerNo(resultSet.getString("aracstickerno"));
                ogrenciSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                ogrenciSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                ogrenciSticker.setPlaka(resultSet.getString("plaka"));
                ogrenciSticker.setAracMarka(resultSet.getString("modelmarka"));
                ogrenciSticker.setAracRengi(resultSet.getString("rengi"));
                ogrenciSticker.setVerilisTarihi(resultSet.getDate("verilistarihi").toString());
                ogrenciSticker.setSticker_id(resultSet.getInt("sticker_id"));
                ogrenciSticker.setOgrenciTcNo(resultSet.getString("tcno"));
                ogrenciSticker.setOgrenciAdSoyad(resultSet.getString("adsoyad"));
                ogrenciSticker.setOgrenciNo(resultSet.getString("ogrencino"));
                ogrenciSticker.setFakulteYO(resultSet.getString("fakulte"));
                ogrenciSticker.setBolum(resultSet.getString("bolum"));
                ogrenciSticker.setSinif(resultSet.getInt("sınıf"));
                ogrenciSticker.setOgrTel(resultSet.getString("ceptelefonu"));
                ogrenciSticker.setOgrenciEposta(resultSet.getString("eposta"));
                list.add(ogrenciSticker);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<KurumSticker> getPaginationKurum (int PageSize,int offset){
        offset = offset - 1;
        String sql = "select * from(" + lastSql +") as lastsql limit "+PageSize+" offset "+offset+"";
        ArrayList<KurumSticker> list = new ArrayList<>();
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                KurumSticker kurumSticker = new KurumSticker();
                kurumSticker.setSticker_id(resultSet.getInt("sticker_id"));
                kurumSticker.setAracTuru(resultSet.getString("aracturu"));
                kurumSticker.setStickerNo(resultSet.getString("aracstickerno"));
                kurumSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                kurumSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                kurumSticker.setPlaka(resultSet.getString("plaka"));
                kurumSticker.setAracMarka(resultSet.getString("modelmarka"));
                kurumSticker.setAracRengi(resultSet.getString("rengi"));
                kurumSticker.setVerilisTarihi(resultSet.getDate("verilistarihi").toString());
                kurumSticker.setTcNo(resultSet.getString("tcno"));
                kurumSticker.setAdSoyad(resultSet.getString("adsoyad"));
                kurumSticker.setBulunduguKampus(resultSet.getString("kampus"));
                kurumSticker.setKampusBirimAdi(resultSet.getString("kampusbirim"));
                kurumSticker.setKadroBirimi(resultSet.getString("kadrobirim"));
                kurumSticker.setUnvan(resultSet.getString("unvan"));
                kurumSticker.setGorevYaptigiBirim(resultSet.getString("gorevbirimi"));
                kurumSticker.setKurumSicil(resultSet.getString("kurumsicil"));
                kurumSticker.setIcHat(resultSet.getString("ichat"));
                kurumSticker.setCepTelefonu(resultSet.getString("eptelefonu"));
                kurumSticker.setEposta(resultSet.getString("eposta"));
                list.add(kurumSticker);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<MisafirSticker> getPaginationMisafir (int PageSize,int offset) {
        offset = offset - 1;
        String sql = "select * from(" + lastSql +") as lastsql limit "+PageSize+" offset "+offset+"";
        System.out.println(sql);
        ArrayList<MisafirSticker> list = new ArrayList<>();
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                MisafirSticker misafirSticker = new MisafirSticker();
                misafirSticker.setSticker_id(resultSet.getInt("sticker_id"));
                misafirSticker.setAracTuru(resultSet.getString("aracturu"));
                misafirSticker.setStickerNo(resultSet.getString("aracstickerno"));
                misafirSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                misafirSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                misafirSticker.setPlaka(resultSet.getString("plaka"));
                misafirSticker.setAracMarka(resultSet.getString("modelmarka"));
                misafirSticker.setAracRengi(resultSet.getString("rengi"));
                misafirSticker.setVerilisTarihi(resultSet.getDate("verilistarihi").toString());
                misafirSticker.setMisafirTcNo(resultSet.getString("tcno"));
                misafirSticker.setMisafirAdSoyad(resultSet.getString("adsoyad"));
                misafirSticker.setMisafirCep(resultSet.getString("ceptelefonu"));
                misafirSticker.setMisafirEposta(resultSet.getString("eposta"));
                misafirSticker.setMisafirBulunduguKampus(resultSet.getString("kampus"));
                misafirSticker.setMisafirKampusBirimAdi(resultSet.getString("kampusbirim"));
                misafirSticker.setMisafirFirmaAdi(resultSet.getString("firmaad"));
                misafirSticker.setMisafirFirmaAdres(resultSet.getString("firmadresi"));
                misafirSticker.setMisafirFirmaTel(resultSet.getString("firmatel"));
                list.add(misafirSticker);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public TasitSticker willbeDeleted (TasitSticker tasitSticker) {
        String sql = selectDeleteSticker(tasitSticker);
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tasitSticker.setSticker_id(resultSet.getInt("sticker_id"));
                tasitSticker.setStickerNo(resultSet.getString("aracstickerNo"));
                tasitSticker.setVerilisTarihi(resultSet.getDate("verilistarihi").toString());
                tasitSticker.setAracMarka(resultSet.getString("modelmarka"));
                tasitSticker.setPlaka(resultSet.getString("plaka"));
                tasitSticker.setAracRengi(resultSet.getString("rengi"));
                tasitSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                tasitSticker.setAracTuru(resultSet.getString("aracturu"));
                tasitSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
            }
            connection.close();
            return tasitSticker;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void delete (int sticker_id) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("delete from aracsticker where sticker_id = ?");
            stmt.setInt(1,sticker_id);
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            connection.close();
            System.out.println(e);
        }
    }

    public void reddet(int id) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("delete from ogrencibasvuru where basvuru_id = ? ");
            stmt.setInt(1,id);
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            connection.close();
            System.out.println(e);
        }
    }

    public OgrenciSticker getBasvuru(int id) throws SQLException {
        OgrenciSticker ogrenciSticker = new OgrenciSticker();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select * from ogrencibasvuru where basvuru_id = ?");
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                ogrenciSticker.setAracTuru(resultSet.getString("aracturu"));
                ogrenciSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                ogrenciSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibinadsoyad"));
                ogrenciSticker.setPlaka(resultSet.getString("plaka"));
                ogrenciSticker.setAracMarka(resultSet.getString("modelmarka"));
                ogrenciSticker.setAracRengi(resultSet.getString("rengi"));
                ogrenciSticker.setSerialno(resultSet.getInt("basvuru_id"));
                ogrenciSticker.setOgrenciTcNo(resultSet.getString("tcno"));
                ogrenciSticker.setOgrenciAdSoyad(resultSet.getString("adsoyad"));
                ogrenciSticker.setOgrenciNo(resultSet.getString("ogrencino"));
                ogrenciSticker.setFakulteYO(resultSet.getString("fakulte"));
                ogrenciSticker.setBolum(resultSet.getString("bolum"));
                ogrenciSticker.setSinif(resultSet.getInt("sınıf"));
                ogrenciSticker.setOgrTel(resultSet.getString("ceptelefonu"));
                ogrenciSticker.setOgrenciEposta(resultSet.getString("eposta"));
            }
            connection.close();
            return ogrenciSticker;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return null;
        }
    }

    public HashMap<String, String> getBolumList () {
        String sql = "select * from bolum";
        HashMap<String,String> bolumList = new HashMap<>();
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                bolumList.put(resultSet.getString("isim"),resultSet.getString("isim"));
            }
            connection.close();
            return bolumList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public HashMap<String, String> getUnvanList () {
        String sql = "select * from unvan";
        HashMap<String,String> unvanList = new HashMap<>();
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                unvanList.put(resultSet.getString("isim"),resultSet.getString("isim"));
            }
            connection.close();
            return unvanList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public HashMap<String, String> getFakulteBirimList () {
        String sql = "select * from fakultebirim";
        HashMap<String,String> fakulteBirimList = new HashMap<>();
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                fakulteBirimList.put(resultSet.getString("isim"),resultSet.getString("isim"));
            }
            connection.close();
            return fakulteBirimList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<UserProfile> getAllUsers() throws SQLException {
        List<UserProfile> list = new ArrayList<>();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select  * from kullanıcılar");
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                UserProfile userProfile = new UserProfile();
                userProfile.setUrlcodeid(Encryption.encode(resultSet.getInt("kullanici_id")));
                userProfile.setKullanici_id(resultSet.getInt("kullanici_id"));
                userProfile.setAd(resultSet.getString("isim"));
                userProfile.setSoyAdi(resultSet.getString("soyisim"));
                userProfile.setId(resultSet.getString("kullanici_ismi"));
                userProfile.setPassword(resultSet.getString("parola"));
                userProfile.setCepTel(resultSet.getString("telefon"));
                userProfile.setStickerTur(resultSet.getString("kullanici_tür"));
                userProfile.setKampus(resultSet.getString("kampus"));
                userProfile.setGörev(resultSet.getString("gorev"));
                list.add(userProfile);
            }
            connection.close();
            return list;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return null;
        }
    }

    public void deleteUser(int id) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("delete from kullanıcılar where kullanici_id = ?");
            stmt.setInt(1,id);
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            connection.close();
            System.out.println(e);
        }
    }

    public UserProfile getUser (int id) throws SQLException {
        UserProfile userProfile = new UserProfile();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select * from kullanıcılar where kullanici_id = ?");
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                userProfile.setKullanici_id(resultSet.getInt("kullanici_id"));
                userProfile.setAd(resultSet.getString("isim"));
                userProfile.setSoyAdi(resultSet.getString("soyisim"));
                userProfile.setId(resultSet.getString("kullanici_ismi"));
                userProfile.setPassword(resultSet.getString("parola"));
                userProfile.setCepTel(resultSet.getString("telefon"));
                userProfile.setStickerTur(resultSet.getString("kullanici_tür"));
                userProfile.setKampus(resultSet.getString("kampus"));
                userProfile.setGörev(resultSet.getString("gorev"));
            }
            connection.close();
            return userProfile;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return null;
        }
    }

    public boolean updateUser(UserProfile userProfile, int id) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("update kullanıcılar set isim = ?, soyisim = ? ,kullanici_ismi = ?,telefon = ?," +
                    "kampus = ? , gorev = ? where kullanici_id = ?");
            stmt.setString(1,userProfile.getAd());
            stmt.setString(2,userProfile.getSoyAdi());
            stmt.setString(3,userProfile.getId());
            stmt.setString(4,userProfile.getCepTel());
            stmt.setString(5,userProfile.getKampus());
            stmt.setString(6,userProfile.getGörev());
            stmt.setInt(7,id);
            stmt.executeUpdate();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return false;
        }
    }

    public void addBasvuru (OgrenciSticker ogrenciSticker) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("insert into ogrencibasvuru(aracturu,sahibinadisoyadi,ruhsatsahibinadsoyad,plaka,modelmarka,rengi," +
                    "tcno,adsoyad,ogrencino,fakulte,bolum,sınıf,ceptelefonu,eposta) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,ogrenciSticker.getAracTuru());
            stmt.setString(2,ogrenciSticker.getAracSahibininAdiSoyad());
            stmt.setString(3,ogrenciSticker.getRuhsatSahibininAdiSoyad());
            stmt.setString(4,ogrenciSticker.getPlaka());
            stmt.setString(5,ogrenciSticker.getAracMarka());
            stmt.setString(6,ogrenciSticker.getAracRengi());
            stmt.setString(7,ogrenciSticker.getOgrenciTcNo());
            stmt.setString(8,ogrenciSticker.getOgrenciAdSoyad());
            stmt.setString(9,ogrenciSticker.getOgrenciNo());
            stmt.setString(10,ogrenciSticker.getFakulteYO());
            stmt.setString(11,ogrenciSticker.getBolum());
            stmt.setInt(12,ogrenciSticker.getSinif());
            stmt.setString(13,ogrenciSticker.getOgrTel());
            stmt.setString(14,ogrenciSticker.getOgrenciEposta());
            stmt.executeUpdate();
            connection.close();
        }catch (Exception e) {
            connection.close();
            System.out.println(e);
        }
    }

    public void addKurumBasvuru(KurumSticker kurumSticker) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("insert into kurumbasvuru(aracturu,sahibinadisoyadi,ruhsatsahibininadsoyadi," +
                    "plaka,modelmarka,rengi,tcno,adsoyad,kampus,kampusbirim,kadrobirim,unvan,gorevbirimi,kurumsicil,ichat,ceptelefonu,eposta)" +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,kurumSticker.getAracTuru());
            stmt.setString(2,kurumSticker.getAracSahibininAdiSoyad());
            stmt.setString(3,kurumSticker.getAracSahibininAdiSoyad());
            stmt.setString(4,kurumSticker.getPlaka());
            stmt.setString(5,kurumSticker.getAracMarka());
            stmt.setString(6,kurumSticker.getAracRengi());
            stmt.setString(7,kurumSticker.getTcNo());
            stmt.setString(8,kurumSticker.getAdSoyad());
            stmt.setString(9,kurumSticker.getBulunduguKampus());
            stmt.setString(10,kurumSticker.getKampusBirimAdi());
            stmt.setString(11,kurumSticker.getKadroBirimi());
            stmt.setString(12,kurumSticker.getUnvan());
            stmt.setString(13,kurumSticker.getGorevYaptigiBirim());
            stmt.setString(14,kurumSticker.getKurumSicil());
            stmt.setString(15,kurumSticker.getIcHat());
            stmt.setString(16,kurumSticker.getCepTelefonu());
            stmt.setString(17,kurumSticker.getEposta());
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e){
            connection.close();
            System.out.println(e);
        }
    }

    public void addMisafirBasvuru(MisafirSticker misafirSticker) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("insert  into misafirbaşvuru(aracturu,sahibinadisoyadi,ruhsatsahibininadsoyadi," +
                    "plaka,modelmarka,rengi,tcno,adsoyad,ceptelefonu,eposta,kampus,kampusbirim,firmaad,firmadresi,firmatel) " +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,misafirSticker.getAracTuru());
            stmt.setString(2,misafirSticker.getAracSahibininAdiSoyad());
            stmt.setString(3,misafirSticker.getRuhsatSahibininAdiSoyad());
            stmt.setString(4,misafirSticker.getPlaka());
            stmt.setString(5,misafirSticker.getAracMarka());
            stmt.setString(6,misafirSticker.getAracRengi());
            stmt.setString(7,misafirSticker.getMisafirTcNo());
            stmt.setString(8,misafirSticker.getMisafirAdSoyad());
            stmt.setString(9,misafirSticker.getMisafirCep());
            stmt.setString(10,misafirSticker.getMisafirEposta());
            stmt.setString(11,misafirSticker.getMisafirBulunduguKampus());
            stmt.setString(12,misafirSticker.getMisafirKampusBirimAdi());
            stmt.setString(13,misafirSticker.getMisafirFirmaAdi());
            stmt.setString(14,misafirSticker.getMisafirFirmaAdres());
            stmt.setString(15,misafirSticker.getMisafirFirmaTel());
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            connection.close();
            System.out.println(e);
        }
    }

    public ArrayList<OgrenciSticker> getBasvuruList() {
        String sql = "select * from ogrencibasvuru";
        ArrayList<OgrenciSticker> ogrenciStickerArrayList = new ArrayList<>();
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                OgrenciSticker ogrenciSticker = new OgrenciSticker();
                ogrenciSticker.setAracTuru(resultSet.getString("aracturu"));
                ogrenciSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                ogrenciSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibinadsoyad"));
                ogrenciSticker.setPlaka(resultSet.getString("plaka"));
                ogrenciSticker.setAracMarka(resultSet.getString("modelmarka"));
                ogrenciSticker.setAracRengi(resultSet.getString("rengi"));
                ogrenciSticker.setSerialno(resultSet.getInt("basvuru_id"));
                ogrenciSticker.setOgrenciTcNo(resultSet.getString("tcno"));
                ogrenciSticker.setOgrenciAdSoyad(resultSet.getString("adsoyad"));
                ogrenciSticker.setOgrenciNo(resultSet.getString("ogrencino"));
                ogrenciSticker.setFakulteYO(resultSet.getString("fakulte"));
                ogrenciSticker.setBolum(resultSet.getString("bolum"));
                ogrenciSticker.setSinif(resultSet.getInt("sınıf"));
                ogrenciSticker.setOgrTel(resultSet.getString("ceptelefonu"));
                ogrenciSticker.setOgrenciEposta(resultSet.getString("eposta"));
                ogrenciStickerArrayList.add(ogrenciSticker);
            }
            connection.close();
            return ogrenciStickerArrayList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<KurumSticker> getKurumBasvuru() {
        String sql = "select * from kurumbasvuru";
       List<KurumSticker> kurumBasvuruList = new ArrayList();
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                KurumSticker kurumSticker = new KurumSticker();
                kurumSticker.setSerialNo(Encryption.encode(resultSet.getInt("basvuru_id")));
                kurumSticker.setAracTuru(resultSet.getString("aracturu"));
                kurumSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                kurumSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                kurumSticker.setPlaka(resultSet.getString("plaka"));
                kurumSticker.setAracMarka(resultSet.getString("modelmarka"));
                kurumSticker.setAracRengi(resultSet.getString("rengi"));
                kurumSticker.setTcNo(resultSet.getString("tcno"));
                kurumSticker.setAdSoyad(resultSet.getString("adsoyad"));
                kurumSticker.setBulunduguKampus(resultSet.getString("kampus"));
                kurumSticker.setKampusBirimAdi(resultSet.getString("kampusbirim"));
                kurumSticker.setKadroBirimi(resultSet.getString("kadrobirim"));
                kurumSticker.setUnvan(resultSet.getString("unvan"));
                kurumSticker.setGorevYaptigiBirim(resultSet.getString("gorevbirimi"));
                kurumSticker.setIcHat(resultSet.getString("ichat"));
                kurumSticker.setCepTelefonu(resultSet.getString("ceptelefonu"));
                kurumSticker.setEposta(resultSet.getString("eposta"));
                kurumBasvuruList.add(kurumSticker);
            }
            connection.close();
            return kurumBasvuruList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<MisafirSticker> getMisafirBasvuru() {
        String sql = "select * from misafirbaşvuru";
        List<MisafirSticker> misafirStickerArrayList = new ArrayList<>();
        try{
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                MisafirSticker misafirSticker = new MisafirSticker();
                misafirSticker.setSerialNo(Encryption.encode(resultSet.getInt("basvuru_id")));
                misafirSticker.setAracTuru(resultSet.getString("aracturu"));
                misafirSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                misafirSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                misafirSticker.setPlaka(resultSet.getString("plaka"));
                misafirSticker.setAracMarka(resultSet.getString("modelmarka"));
                misafirSticker.setAracRengi(resultSet.getString("rengi"));
                misafirSticker.setMisafirTcNo(resultSet.getString("tcno"));
                misafirSticker.setMisafirAdSoyad(resultSet.getString("adsoyad"));
                misafirSticker.setMisafirCep(resultSet.getString("ceptelefonu"));
                misafirSticker.setMisafirEposta(resultSet.getString("eposta"));
                misafirSticker.setMisafirBulunduguKampus(resultSet.getString("kampus"));
                misafirSticker.setMisafirKampusBirimAdi(resultSet.getString("kampusbirim"));
                misafirSticker.setMisafirFirmaAdi(resultSet.getString("firmaad"));
                misafirSticker.setMisafirFirmaAdres(resultSet.getString("firmadresi"));
                misafirSticker.setMisafirFirmaTel(resultSet.getString("firmatel"));
                misafirStickerArrayList.add(misafirSticker);
            }
            connection.close();
            return misafirStickerArrayList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void redKurumBasvuru(int id) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("delete from kurumbasvuru where basvuru_id = ?");
            stmt.setInt(1,id);
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            connection.close();
            System.out.println(e);
        }
    }

    public void redMisafirBasvuru(int id) throws SQLException {
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("delete from misafirbaşvuru where basvuru_id = ?");
            stmt.setInt(1,id);
            stmt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            connection.close();
            System.out.println(e);
        }
    }

    public KurumSticker getFindidKurumBasvuru(int id) {
        KurumSticker kurumSticker = new KurumSticker();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select * from kurumbasvuru where basvuru_id = ?");
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                kurumSticker.setSerialNo(Encryption.encode(resultSet.getInt("basvuru_id")));
                kurumSticker.setAracTuru(resultSet.getString("aracturu"));
                kurumSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                kurumSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                kurumSticker.setPlaka(resultSet.getString("plaka"));
                kurumSticker.setAracMarka(resultSet.getString("modelmarka"));
                kurumSticker.setAracRengi(resultSet.getString("rengi"));
                kurumSticker.setTcNo(resultSet.getString("tcno"));
                kurumSticker.setAdSoyad(resultSet.getString("adsoyad"));
                kurumSticker.setBulunduguKampus(resultSet.getString("kampus"));
                kurumSticker.setKampusBirimAdi(resultSet.getString("kampusbirim"));
                kurumSticker.setKadroBirimi(resultSet.getString("kadrobirim"));
                kurumSticker.setUnvan(resultSet.getString("unvan"));
                kurumSticker.setGorevYaptigiBirim(resultSet.getString("gorevbirimi"));
                kurumSticker.setIcHat(resultSet.getString("ichat"));
                kurumSticker.setCepTelefonu(resultSet.getString("ceptelefonu"));
                kurumSticker.setEposta(resultSet.getString("eposta"));
            }
            connection.close();
            return kurumSticker;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public MisafirSticker getFindIdBasvuruMisafir(int id) {
        MisafirSticker misafirSticker = new MisafirSticker();
        try {
            connection = connection();
            PreparedStatement stmt = connection.prepareStatement("select * from misafirBaşvuru where basvuru_id = ?");
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                misafirSticker.setSerialNo(Encryption.encode(resultSet.getInt("basvuru_id")));
                misafirSticker.setAracTuru(resultSet.getString("aracturu"));
                misafirSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                misafirSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                misafirSticker.setPlaka(resultSet.getString("plaka"));
                misafirSticker.setAracMarka(resultSet.getString("modelmarka"));
                misafirSticker.setAracRengi(resultSet.getString("rengi"));
                misafirSticker.setMisafirTcNo(resultSet.getString("tcno"));
                misafirSticker.setMisafirAdSoyad(resultSet.getString("adsoyad"));
                misafirSticker.setMisafirCep(resultSet.getString("ceptelefonu"));
                misafirSticker.setMisafirEposta(resultSet.getString("eposta"));
                misafirSticker.setMisafirBulunduguKampus(resultSet.getString("kampus"));
                misafirSticker.setMisafirKampusBirimAdi(resultSet.getString("kampusbirim"));
                misafirSticker.setMisafirFirmaAdi(resultSet.getString("firmaad"));
                misafirSticker.setMisafirFirmaAdres(resultSet.getString("firmadresi"));
                misafirSticker.setMisafirFirmaTel(resultSet.getString("firmatel"));
            }
            connection.close();
            return misafirSticker;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public TasitSticker getSticker (String plaka,String id) throws SQLException {
        TasitSticker tasitSticker = new TasitSticker();
        String sql = null;
        if (!plaka.equalsIgnoreCase("") && plaka != null) {
            sql = "select * from aracsticker where plaka = '"+plaka+"'";
            System.out.println(sql);
        } else if (!id.equalsIgnoreCase("") && id != null) {
            sql = "select * from aracsticker where aracstickerno = '"+id+"'";
            System.out.println(sql);
        } else {
            return null;
        }
        try {
            connection = connection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                tasitSticker.setStickerNo(resultSet.getString("aracstickerno"));
                tasitSticker.setPlaka(resultSet.getString("plaka"));
                tasitSticker.setAracMarka(resultSet.getString("modelmarka"));
                tasitSticker.setAracRengi(resultSet.getString("rengi"));
                tasitSticker.setAracTuru(resultSet.getString("aracturu"));
                tasitSticker.setAracSahibininAdiSoyad(resultSet.getString("sahibinadisoyadi"));
                tasitSticker.setRuhsatSahibininAdiSoyad(resultSet.getString("ruhsatsahibininadsoyadi"));
                tasitSticker.setVerilisTarihi(resultSet.getString("verilistarihi"));
            }
            connection.close();
            return tasitSticker;
        } catch (Exception e) {
            System.out.println(e);
            connection.close();
            return null;
        }

    }


    public void parolaSifirla(String to, String pass) {
        String sql = "update kullanıcılar set parola = ? where email = ? ";
        try {
            connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,pass);
            preparedStatement.setString(2,to);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}


