<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.AracStickerSistemi.Controller.ProfileController" %>
<%@ page import="com.AracStickerSistemi.Model.Encryption" %>
<%@ page import="com.AracStickerSistemi.Controller.WelcomeController" %><%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 17.07.2020
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Profile</title>
</head>
<body>
<%
Encryption encryption = new Encryption();
%>
<div>
    <img src="${pageContext.request.contextPath}/resources/img/logo.png" class="rounded float-right" alt="..." style="width: 300px; height: 250px;">
</div>
<c:url value="/getBasvuruList" var="ogrenciBasvuru">
    <c:param name="getBasvuruList" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/StickerOperations/ogrenciStickerEkle" var="ogrSticker">
    <c:param name="getBasvuruList" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/StickerOperations/kurumStickerEkle" var="kurumSticker">
    <c:param name="kurumSticker" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/StickerOperations/misafirStickerEkle" var="misafirSticker">
    <c:param name="misafirSticker" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/searchOgreciSticker" var="searchOgrenci">
    <c:param name="searcOgrenci" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/searchKurumSticker" var="searcKurum">
    <c:param name="searcKurum" value="<%=encryption.map()%>"/>
</c:url>

<c:url value="/searchMisafirSticker" var="searchMisafir">
    <c:param name="searchMisafir" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/kullaniciEkle" var="kullaniciEkle">
    <c:param name="add" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/viewuser" var="kullanicilar">
    <c:param name="users" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/kurumbasvurulari"  var="kurumBasvuru">
    <c:param name="basvuru" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/misafirbasvurulari" var="misafirBasvuru">
    <c:param name="basvuru" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/kurumList" var="kurumStickerlar">
    <c:param name="kurum" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/stickerAra" var="stickerara">
    <c:param name="search" value="<%=encryption.map()%>"/>
</c:url>
<c:url value="/StickerOperations/stickerekle" var="kurumstickerekle">
    <c:param name="stickerekle" value="<%=encryption.map()%>"/>
</c:url>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/returnProfile">Profile</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <% if (ProfileController.userProfile.getGörev().equals("ÖZEL GÜVENLİK BİRİMİ ") && ProfileController.userProfile.getStickerTur().equals("Birim")) {%>
                <li class="nav-item">
                    <a class="nav-link" href="${stickerara}">Sticker Ara<span class="sr-only">(current)</span></a>
                </li>
            <%}%>
            <% if (ProfileController.userProfile.getStickerTur().equals("Kullanici") && ProfileController.userProfile.getGörev().equals("null")) {%>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/StickerOperations/basvuruAl">BasvuruYap <span class="sr-only">(current)</span></a>
            </li><%}%>
            <% if (ProfileController.userProfile.getStickerTur().equals("Adminastor")) {%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="DropdownBasvurular" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Basvurular
                </a>
                <div class="dropdown-menu" aria-labelledby="DropdownBasvurular">
                    <a class="dropdown-item" href="${ogrenciBasvuru}">OgrenciBasvuruları</a>
                    <a class="dropdown-item" href="${kurumBasvuru}">KurumBasvuruları</a>
                    <a class="dropdown-item" href="${misafirBasvuru}">MisafirBasvuruları</a>
                </div>
            </li><%}%>
            <% if (!ProfileController.userProfile.getGörev().equals("null") && !ProfileController.userProfile.getGörev().equals("Admin")) {%>
            <li class="nav-item active">
                <a class="nav-link" href="${kurumStickerlar}">Kurumdaki Stickerlar<span class="sr-only">(current)</span></a>
            </li><%}%>
            <% if (!ProfileController.userProfile.getGörev().equals("null") && !ProfileController.userProfile.getGörev().equals("Admin")) {%>
            <li class="nav-item active">
                <a class="nav-link" href="${kurumstickerekle}">StickerEkle<span class="sr-only">(current)</span></a>
            </li><%}%>
            <% if (ProfileController.userProfile.getStickerTur().equals("Adminastor")) {%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="DropdownMenuLinkAdd" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    StickerEkle
                </a>
                <div class="dropdown-menu" aria-labelledby="DropdownMenuLinkAdd">
                    <a class="dropdown-item" href="${ogrSticker}">OgrenciStickerEkle</a>
                    <a class="dropdown-item" href="${kurumSticker}">KullanıcıStickerEkle</a>
                    <a class="dropdown-item" href="${misafirSticker}">MisafirStickerEkle</a>
                </div>
            </li><%}%>
            <% if (ProfileController.userProfile.getStickerTur().equals("Adminastor")) {%>
            <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle"  id="DropdownMenuLinkSearch" role="button"
               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                StickerAra
            </a>
            <div class="dropdown-menu" aria-labelledby="DropdownMenuLinkSearch">
                <a class="dropdown-item" href="${searchOgrenci}">OgrenciStickerAra</a>
                <a class="dropdown-item" href="${searcKurum}">KurumStickerAra</a>
                <a class="dropdown-item" href="${searchMisafir}">MisafirStickerAra</a>
            </div>
            </li><%}%>
            <% if (ProfileController.userProfile.getStickerTur().equals("Adminastor")) {%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="DropdownMenuLinkUserAdd" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Kullanıcılar
                </a>
                <div class="dropdown-menu" aria-labelledby="DropdownMenuLinkUserAdd">
                    <a class="dropdown-item" href="${kullaniciEkle}">KullanıcıEkle</a>
                    <a class="dropdown-item" href="${kullanicilar}">Kullanıcılar</a>
                </div>
            </li><%}%>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/LoginPanel">Cikis</a>
            </li>
        </ul>
    </div>
</nav>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<div class="container-md">
    <h2 class="h2" style="text-align: center">Hoşgeldiniz Sayın <%=ProfileController.userProfile.getAd()%>
        <%=ProfileController.userProfile.getSoyAdi()%></h2>
</div>
</body>
</html>
