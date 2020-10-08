<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.AracStickerSistemi.Controller.ProfileController" %>
<%@ page import="com.AracStickerSistemi.Model.Encryption" %><%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 12.08.2020
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Template</title>
</head>
<%Encryption encryption = new Encryption();%>
<body>
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
<c:url value="/AddUser" var="kullaniciEkle">
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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/returnProfile">Profile</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <% if (ProfileController.userProfile.getStickerTur().equals("Kullanici")) {%>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/StickerOperations/basvuruAl">BasvuruYap <span class="sr-only">(current)</span></a>
            </li><%}%>
            <% if (ProfileController.userProfile.getStickerTur().equals("Adminastor")) {%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="DropdownBasvurular" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Basvurular
                </a>
                <div class="dropdown-menu" aria-labelledby="DropdownBasvurular">
                    <a class="dropdown-item" href="${ogrenciBasvuru}">OgrenciBasvuruları</a>
                    <a class="dropdown-item" href="${kurumBasvuru}">KurumBasvuruları</a>
                    <a class="dropdown-item" href="${misafirBasvuru}">MisafirBasvuruları</a>
                </div>
            </li>
            <%}%>
            <% if (ProfileController.userProfile.getStickerTur().equals("Adminastor")) {%>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="DropdownMenuLinkAdd" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                <a class="nav-link dropdown-toggle"  id="DropdownMenuLinkSearch"
                   role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
                <a class="nav-link" href="${pageContext.request.contextPath}/">Cikis</a>
            </li>
        </ul>
    </div>
</nav>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
