<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 31.08.2020
  Time: 07:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Sonuc</title>
</head>
<body>
    <h2 class="h2" style="text-align: center">ARAMA SONUCLARI</h2>
    <c:if test="${empty error}">
        <div class="container">
            <h3 style="text-align: center">${sticker.stickerNo} STICKER NUMARALI ARAC BULUNDU</h3>
            <ul class="list-group list-group-flush" style="max-height: 550px; overflow: auto">
                <li class="list-group-item"> STICKERNO : ${sticker.stickerNo}</li>
                <li class="list-group-item"> ARACRENGI : ${sticker.aracRengi}</li>
                <li class="list-group-item"> VERILIS TARİHİ : ${sticker.verilisTarihi}</li>
                <li class="list-group-item"> ARAC MARKA : ${sticker.aracMarka}</li>
                <li class="list-group-item"> PLAKA : ${sticker.plaka}</li>
                <li class="list-group-item"> RUHSAT SAHİBİ AD SOYAD : ${sticker.ruhsatSahibininAdiSoyad}</li>
                <li class="list-group-item"> ARAC SAHİBİ AD SOYAD : ${sticker.aracSahibininAdiSoyad}</li>
                <li class="list-group-item"> ARAC TURU : ${sticker.aracTuru}</li>
            </ul>
        </div>
    </c:if>
    <c:if test="${not empty error}">
        <h2 class="text-danger" style="text-align: center">${error}</h2>
    </c:if>
</body>
</html>
