<%@ page import="com.AracStickerSistemi.Controller.StickerController" %>
<%@ page import="com.AracStickerSistemi.Model.OgrenciSticker" %>
<%@ page import="com.AracStickerSistemi.Controller.WelcomeController" %>
<%@ page import="com.AracStickerSistemi.Model.KurumSticker" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.AracStickerSistemi.Model.MisafirSticker" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 13.08.2020
  Time: 07:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Ayrıntılar</title>
</head>
<body style="background-color: #d2d6de">
<jsp:include page="../TemplateMenu.jsp"/>
<% if(StickerController.ogreciTcNo != null){
    OgrenciSticker ogrenciSticker = null;
    try {
        ogrenciSticker = WelcomeController.dataBaseController.getFindIdOgrenci(Integer.parseInt(StickerController.ogreciTcNo));
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<div class="container">
    <div class="jumbotron">
        <h3 class="h3" style="text-align: center">AYRINTILAR</h3>
        <ul class="list-group list-group-flush" style="max-height: 550px; overflow: auto">
            <li class="list-group-item"> TCNO : <%=ogrenciSticker.getOgrenciTcNo()%></li>
            <li class="list-group-item"> FAKULTE : <%=ogrenciSticker.getFakulteYO()%></li>
            <li class="list-group-item"> BOLUM : <%=ogrenciSticker.getBolum()%></li>
            <li class="list-group-item"> SINIF : <%=ogrenciSticker.getSinif()%></li>
            <li class="list-group-item"> TELEFON : <%=ogrenciSticker.getOgrTel()%></li>
            <li class="list-group-item"> E-POSTA : <%=ogrenciSticker.getOgrenciEposta()%></li>
            <li class="list-group-item"> STICKERNO : <%=ogrenciSticker.getStickerNo()%></li>
            <li class="list-group-item"> ARACRENGI : <%=ogrenciSticker.getAracRengi()%></li>
            <li class="list-group-item"> VERILIS TARİHİ : <%=ogrenciSticker.getVerilisTarihi()%></li>
            <li class="list-group-item"> ARAC MARKA : <%=ogrenciSticker.getAracMarka()%></li>
            <li class="list-group-item"> PLAKA : <%=ogrenciSticker.getPlaka()%></li>
            <li class="list-group-item"> RUHSAT SAHİBİ AD SOYAD : <%=ogrenciSticker.getRuhsatSahibininAdiSoyad()%></li>
            <li class="list-group-item"> ARAC SAHİBİ AD SOYAD : <%=ogrenciSticker.getAracSahibininAdiSoyad()%></li>
            <li class="list-group-item"> OGRENCİ AD SOYAD :<%=ogrenciSticker.getOgrenciAdSoyad()%></li>
            <li class="list-group-item"> ARAC TURU : <%=ogrenciSticker.getAracTuru()%></li>
        </ul>
    </div>
</div><%}
%>

<% if(StickerController.kurumTcNo != null){
    KurumSticker kurumSticker = null;
    try {
        kurumSticker = WelcomeController.dataBaseController.getFindIdKurum(Integer.parseInt(StickerController.kurumTcNo));
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<div class="container">
    <div class="jumbotron">
    <ul class="list-group list-group-flush">
        <h3 class="h3" style="text-align: center">AYRINTILAR</h3>
        <li class="list-group-item">TCNO : <%=kurumSticker.getTcNo()%></li>
        <li class="list-group-item">AD SOYAD : <%=kurumSticker.getAdSoyad()%></li>
        <li class="list-group-item">E-POSTA : <%=kurumSticker.getEposta()%></li>
        <li class="list-group-item">TELEFON : <%=kurumSticker.getCepTelefonu()%></li>
        <li class="list-group-item">BULUNDUGU KAMPUS : <%=kurumSticker.getBulunduguKampus()%></li>
        <li class="list-group-item">KAMPUSBIRIMADI : <%=kurumSticker.getKampusBirimAdi()%></li>
        <li class="list-group-item">KADRO BİRİM : <%=kurumSticker.getKadroBirimi()%></li>
        <li class="list-group-item">UNVAN : <%=kurumSticker.getUnvan()%></li>
        <li class="list-group-item">GOREV YAPTIGI BİRİM : <%=kurumSticker.getGorevYaptigiBirim()%></li>
        <li class="list-group-item">KURUMSİCİL : <%=kurumSticker.getKurumSicil()%></li>
        <li class="list-group-item">STICKERNO : <%=kurumSticker.getStickerNo()%></li>
        <li class="list-group-item">ARACRENGI : <%=kurumSticker.getAracRengi()%></li>
        <li class="list-group-item">VERILIS TARİHİ : <%=kurumSticker.getVerilisTarihi()%></li>
        <li class="list-group-item">ARAC MARKA : <%=kurumSticker.getAracMarka()%></li>
        <li class="list-group-item">PLAKA : <%=kurumSticker.getPlaka()%></li>
        <li class="list-group-item">RUHSAT SAHİBİ AD SOYAD : <%=kurumSticker.getRuhsatSahibininAdiSoyad()%></li>
        <li class="list-group-item">ARAC SAHİBİ AD SOYAD : <%=kurumSticker.getAracSahibininAdiSoyad()%></li>
        <li class="list-group-item">ARAC TURU : <%=kurumSticker.getAracTuru()%></li>
    </ul>
    </div>
</div><%}
%>

<% if(StickerController.misafirTcNo != null){
    MisafirSticker misafirSticker = null;
    try {
        misafirSticker = WelcomeController.dataBaseController.getFindIdMisafir(Integer.parseInt(StickerController.misafirTcNo));
    } catch (SQLException e) {
        e.printStackTrace();
    }
    StickerController.misafirTcNo = null;
%>
<div class="container">
    <div class="jumbotron">
    <ul class="list-group list-group-flush">
        <h3 class="h3" style="text-align: center">AYRINTILAR</h3>
        <li class="list-group-item">TCNO : <%=misafirSticker.getMisafirTcNo()%></li>
        <li class="list-group-item">AD SOYAD : <%=misafirSticker.getMisafirAdSoyad()%></li>
        <li class="list-group-item">TELEFON : <%=misafirSticker.getMisafirFirmaTel()%></li>
        <li class="list-group-item">E-POSTA : <%=misafirSticker.getMisafirEposta()%></li>
        <li class="list-group-item">BULUNDUGU KAMPUS : <%=misafirSticker.getMisafirBulunduguKampus()%></li>
        <li class="list-group-item">KAMPUSBIRIMADI : <%=misafirSticker.getMisafirKampusBirimAdi()%></li>
        <li class="list-group-item">FIRMA ADI : <%=misafirSticker.getMisafirFirmaAdi()%></li>
        <li class="list-group-item">FIRMA ADRESI : <%=misafirSticker.getMisafirFirmaAdres()%></li>
        <li class="list-group-item">FIRMA TELEFONU : <%=misafirSticker.getMisafirFirmaTel()%></li>
        <li class="list-group-item">STICKERNO : <%=misafirSticker.getStickerNo()%></li>
        <li class="list-group-item">ARACRENGI : <%=misafirSticker.getAracRengi()%></li>
        <li class="list-group-item">ARAC MARKA : <%=misafirSticker.getAracMarka()%></li>
        <li class="list-group-item">VERILIS TARİHİ : <%=misafirSticker.getVerilisTarihi()%></li>
        <li class="list-group-item">PLAKA : <%=misafirSticker.getPlaka()%></li>
        <li class="list-group-item">RUHSAT SAHİBİ AD SOYAD : <%=misafirSticker.getRuhsatSahibininAdiSoyad()%></li>
        <li class="list-group-item">ARAC SAHİBİ AD SOYAD : <%=misafirSticker.getAracSahibininAdiSoyad()%></li>
        <li class="list-group-item">ARAC TURU : <%=misafirSticker.getAracTuru()%></li>
    </ul>
    </div>
</div><%}
%>
</body>
</html>
