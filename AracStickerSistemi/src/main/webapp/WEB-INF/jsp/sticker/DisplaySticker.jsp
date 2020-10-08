<%@ page import="com.AracStickerSistemi.Controller.StickerController" %>
<%@ page import="com.AracStickerSistemi.Controller.PrintController" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 20.07.2020
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>DisplaySticker</title>
</head>
<body>
<jsp:include page="../TemplateMenu.jsp"/>
<div class="text-center">
    <img src="${pageContext.request.contextPath}/resources/img/logo.png" class="rounded" alt="..." style="width: 300px; height: 250px;">
</div>
    <%PrintController printController = new PrintController();%>
    <% if(StickerController.ogreciTcNo != null){%>
    <div class="container">
        <h2 class="h2" style="text-align: center">GIRMIS OLDUGUNUZ STICKER BILGILERI</h2>
        <ul class="list-group list-group-flush">
            <li class="list-group-item"> TCNO : ${ogrenciSticker.ogrenciTcNo} <br/><br/></li>
            <li class="list-group-item"> FAKULTE : ${ogrenciSticker.fakulteYO} <br/><br/></li>
            <li class="list-group-item"> BOLUM : ${ogrenciSticker.bolum} <br/><br/></li>
            <li class="list-group-item"> SINIF : ${ogrenciSticker.sinif} <br/><br/> </li>
            <li class="list-group-item"> TELEFON : ${ogrenciSticker.ogrTel} <br/><br/> </li>
            <li class="list-group-item"> E-POSTA : ${ogrenciSticker.ogrenciEposta} <br/><br/> </li>
            <li class="list-group-item"> STICKERNO : ${ogrenciSticker.stickerNo} <br/><br/> </li>
            <li class="list-group-item"> ARACRENGI : ${ogrenciSticker.aracRengi} <br/><br/></li>
            <li class="list-group-item"> VERILIS TARİHİ : ${ogrenciSticker.verilisTarihi} <br/><br/></li>
            <li class="list-group-item"> ARAC MARKA : ${ogrenciSticker.aracMarka} <br/><br/></li>
            <li class="list-group-item"> PLAKA : ${ogrenciSticker.plaka} <br/><br/></li>
            <li class="list-group-item"> RUHSAT SAHİBİ AD SOYAD : ${ogrenciSticker.ruhsatSahibininAdiSoyad} <br/><br/></li>
            <li class="list-group-item"> ARAC SAHİBİ AD SOYAD : ${ogrenciSticker.aracSahibininAdiSoyad} <br/><br/></li>
            <li class="list-group-item"> OGRENCİ AD SOYAD :${ogrenciSticker.ogrenciAdSoyad} <br/><br/></li>
            <li class="list-group-item"> ARAC TURU : ${ogrenciSticker.aracTuru}  <br/><br/></li>
        </ul>
    </div><%}
    %>
    <% if(StickerController.kurumTcNo != null){%>
    <div class="container">
        <ul class="list-group list-group-flush">
            <li class="list-group-item">TCNO : ${kurumSticker.tcNo} <br/><br/></li>
            <li class="list-group-item">AD SOYAD :${kurumSticker.adSoyad} <br/><br/></li>
            <li class="list-group-item">E-POSTA : ${kurumSticker.eposta} <br/><br/></li>
            <li class="list-group-item">TELEFON : ${kurumSticker.cepTelefonu} <br/><br/></li>
            <li class="list-group-item">BULUNDUGU KAMPUS : ${kurumSticker.bulunduguKampus}<br/><br/></li>
            <li class="list-group-item">KAMPUSBIRIMADI : ${kurumSticker.kampusBirimAdi}<br/><br/></li>
            <li class="list-group-item">KADRO BİRİM : ${kurumSticker.kadroBirimi}<br/><br/></li>
            <li class="list-group-item">UNVAN : ${kurumSticker.kadroBirimi}<br/><br/></li>
            <li class="list-group-item">GOREV YAPTIGI BİRİM : ${kurumSticker.gorevYaptigiBirim}<br/><br/></li>
            <li class="list-group-item">KURUMSİCİL : ${kurumSticker.kurumSicil}<br/><br/></li>
            <li class="list-group-item">STICKERNO : ${kurumSticker.stickerNo} <br/><br/></li>
            <li class="list-group-item">ARACRENGI : ${kurumSticker.aracRengi} <br/><br/></li>
            <li class="list-group-item">VERILIS TARİHİ : ${kurumSticker.verilisTarihi} <br/><br/></li>
            <li class="list-group-item">ARAC MARKA : ${kurumSticker.aracMarka} <br/><br/></li>
            <li class="list-group-item">PLAKA : ${kurumSticker.plaka} <br/><br/></li>
            <li class="list-group-item">RUHSAT SAHİBİ AD SOYAD : ${kurumSticker.ruhsatSahibininAdiSoyad} <br/><br/></li>
            <li class="list-group-item">ARAC SAHİBİ AD SOYAD : ${kurumSticker.aracSahibininAdiSoyad} <br/><br/></li>
            <li class="list-group-item">ARAC TURU : ${kurumSticker.aracTuru} <br/><br/></li>
        </ul>
    </div><%}
    %>

    <% if(StickerController.misafirTcNo != null){%>
    <div class="container">
        <ul class="list-group list-group-flush">
            <li class="list-group-item">TCNO : ${misafirSticker.misafirTcNo} <br/><br/></li>
            <li class="list-group-item">AD SOYAD :${misafirSticker.misafirAdSoyad} <br/><br/></li>
            <li class="list-group-item">TELEFON : ${misafirSticker.misafirCep} <br/><br/></li>
            <li class="list-group-item">E-POSTA : ${misafirSticker.misafirEposta} <br/><br/></li>
            <li class="list-group-item">BULUNDUGU KAMPUS : ${misafirSticker.misafirBulunduguKampus}<br/><br/></li>
            <li class="list-group-item">KAMPUSBIRIMADI : ${misafirSticker.misafirKampusBirimAdi}<br/><br/></li>
            <li class="list-group-item">FIRMA ADI : ${misafirSticker.misafirFirmaAdi}<br/><br/></li>
            <li class="list-group-item">FIRMA ADRESI : ${misafirSticker.misafirFirmaAdres}<br/><br/></li>
            <li class="list-group-item">FIRMA TELEFONU : ${misafirSticker.misafirFirmaTel}<br/><br/></li>
            <li class="list-group-item">STICKERNO : ${misafirSticker.stickerNo} <br/><br/></li>
            <li class="list-group-item">ARACRENGI : ${misafirSticker.aracRengi} <br/><br/></li>
            <li class="list-group-item">ARAC MARKA : ${misafirSticker.aracMarka} <br/><br/></li>
            <li class="list-group-item">VERILIS TARİHİ : ${misafirSticker.verilisTarihi} <br/><br/></li>
            <li class="list-group-item">PLAKA : ${misafirSticker.plaka} <br/><br/></li>
            <li class="list-group-item">RUHSAT SAHİBİ AD SOYAD : ${misafirSticker.ruhsatSahibininAdiSoyad} <br/><br/></li>
            <li class="list-group-item">ARAC SAHİBİ AD SOYAD : ${misafirSticker.aracSahibininAdiSoyad} <br/><br/></li>
            <li class="list-group-item">ARAC TURU : ${misafirSticker.aracTuru} <br/><br/></li>
        </ul>
    </div><%}
    %>
</body>
<div class="container">
    <div style="text-align: center">
        <a href="${pageContext.request.contextPath}/returnProfile" class="btn btn-primary" style="text-align: center">Pdf Olarak İndir</a>
    </div>
</div>
</html>
