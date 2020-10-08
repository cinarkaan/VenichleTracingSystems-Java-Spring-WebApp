<%@ page import="com.AracStickerSistemi.Model.Encryption" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 24.08.2020
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>StickerBaşvuru</title>
</head>
<body style="background-color: #d2d6de">
<%Encryption encryption = new Encryption();%>
<c:url value="/verification" var="verifcation">
    <c:param name="verify" value="<%=encryption.map()%>"/>
</c:url>
<div class="container-lg" style="margin-top: 60px;">
    <h3 class="h3" style="text-align: center">MEU TAŞIT STİCKER BAŞVURU</h3>
    <div class="jumbotron">
        <form action="${verifcation}" method="post">
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label class="col-form-label" for="TCNO">TCNO :</label>
                    <input type="number" id="TCNO" name="TCNO" class="form-control" placeholder="TCNO"/>
                </div>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label class="col-form-label" for="AD">AD: </label>
                    <input type="text" id="AD" name="AD" class="form-control" placeholder="AD"/>
                </div>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label class="col-form-label" for="SOYAD">SOYAD: </label>
                    <input type="text" id="SOYAD" name="SOYAD" class="form-control" placeholder="SOYAD"/>
                </div>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label class="col-form-label" for="STICKER">STICKER: </label>
                    <select type="text" id="STICKER" name="STICKER" class="form-control">
                        <option value="Akademik Personel">Akademik Personel</option>
                        <option value="İdari Personel">İdari Personel</option>
                        <option value="Sözleşmeli Personel">Sözleşmeli Personel</option>
                        <option value="Misafir">Misafir</option>
                        <option value="Öğrenci">Öğrenci</option>
                        <option value="" selected>Seçiniz</option>
                    </select>
                </div>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label class="col-form-label" for="DTARIH">DOGUM TARİHİ: </label>
                    <input type="number" id="DTARIH" name="DTARIH" class="form-control" placeholder="DOGUM YILI"/>
                </div>
            </div>
            <div class="container">
                <c:if test="${not empty error}">
                    <p class="text-danger" style="text-align: center">${error}</p>
                </c:if>
            </div>
            <div class="text-center">
                <br/><br/><button type="submit" class="btn btn-outline-primary">SONRAKİ</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
