<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 20.07.2020
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>MisafirStickerEkle</title>
</head>
<body style="background-color: #d2d6de;">
<jsp:include page="${pageContext.request.contextPath}/template"/>
<div class="container-lg" style="text-align: center; margin-top: 50px;">
<form:form method="post" action="AddedStickerMisafir" modelAttribute="misafirSticker">
    <div class="row">
        <div class="col-sm-6">
            <div class="jumbotron">
                <div class="row justify-content-center align-items-center">
                    <h3 class="h3" style="text-align: center">TAŞIT BİLGİLERİ</h3>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label class="col-form-label">ARAC TURU</label>
                        <form:select cssClass="form-control" path="aracTuru" >
                            <form:option value="NONE" label="Select"/>
                            <form:options items="${aracturlistesi}"/>
                        </form:select><br><br>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">STİCKER NO</label>
                        <form:input cssClass="form-control" placeholder="Stickerno" path="stickerNo"/>
                        <form:errors  path="stickerNo" cssClass="text-danger"/>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">ARACSAHİBİ</label>
                        <form:input cssClass="form-control" placeholer="AracSahibinAdiSoyadi" path="aracSahibininAdiSoyad"/>
                        <form:errors  path="aracSahibininAdiSoyad" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label  class="col-form-label">RUHSATSAHİBİ</label>
                        <form:input cssClass="form-control" path="ruhsatSahibininAdiSoyad"/>
                        <form:errors  path="ruhsatSahibininAdiSoyad" cssClass="text-danger"/>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">PLAKA</label>
                        <form:input cssClass="form-control" placeholder="Plaka" path="plaka"/>
                        <form:errors  path="plaka" cssClass="text-danger"/>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">MARKA</label>
                        <form:input cssClass="form-control" placeholder="Marka" path="aracMarka"/>
                        <form:errors  path="aracMarka" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label class="col-form-label">RENGİ</label>
                        <form:input cssClass="form-control" placeholder="Rengi" path="aracRengi"/>
                        <form:errors  path="aracRengi" cssClass="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="jumbotron">
                <div class="row justify-content-center align-items-center">
                    <h3 class="h3" style="text-align: center">MİSAFİR BİLGİLERİ</h3>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label class="col-form-label">TCNO</label>
                        <form:input cssClass="form-control" placeholder="Tc" path="misafirTcNo"/>
                        <form:errors path="misafirTcNo" cssClass="text-danger"/><br><br>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">ADSOYAD</label>
                        <form:input cssClass="form-control" placeholder="Adsoyad" path="misafirAdSoyad"/>
                        <form:errors path="misafirAdSoyad" cssClass="text-danger"/>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">TELEFON</label>
                        <form:input cssClass="form-control" placeholder="Telefon" path="misafirCep"/>
                        <form:errors path="misafirCep" cssClass="text-danger"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label class="col-form-label">EPOSTA</label>
                        <form:input cssClass="form-control" placeholder="Eposta" path="misafirEposta"/>
                        <form:errors path="misafirEposta" cssClass="text-danger"/>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">KAMPUS</label>
                        <form:select cssClass="form-control" path="misafirBulunduguKampus">
                            <form:option value="NONE" label="Select"/>
                            <form:options items="${kampusList}"/>
                        </form:select>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">BİRİM</label>
                        <form:select cssClass="form-control" path="misafirKampusBirimAdi">
                            <form:option value="NONE" label="Select"/>
                            <form:options items="${kampusBirimList}"/>
                        </form:select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-4">
                        <label class="col-form-label">FİRMA ADI</label>
                        <form:input cssClass="form-control" placeholder="FirmaAd" path="misafirFirmaAdi"/>
                        <form:errors path="misafirFirmaAdi" cssClass="text-danger"/>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">FİRMA ADRES</label>
                        <form:input cssClass="form-control" placeholder="Adres" path="misafirFirmaAdres"/>
                        <form:errors path="misafirFirmaAdres" cssClass="text-danger"/>
                    </div>
                    <div class="col-sm-4">
                        <label class="col-form-label">FİRMA TELEFON</label>
                        <form:input cssClass="form-control" placeholder="Telefon" path="misafirFirmaTel"/>
                        <form:errors path="misafirFirmaTel" cssClass="text-danger"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <c:if test="${not empty error}">
            <p class="text-danger">${error}</p>
        </c:if>
    </div>
    <div style="text-align: center">
        <input type="submit" class="btn btn-primary" style="text-align: center" value="Stickerı Kaydet"/>
    </div>
    </form:form>
</div>
</body>
</html>
