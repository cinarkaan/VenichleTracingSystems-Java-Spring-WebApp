<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 8.08.2020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>BAŞVUR</title>
</head>
<body style="background-color: #d2d6de">
<div style="text-align: center">
    <h2 class="h2">OGRENCİ STİCKER BAŞVURU FORMU</h2>
</div>
<div class="container-lg" style="text-align: center; margin-top: 50px;">
    <form:form method="post" action="basvuruAl" modelAttribute="basvuruform">
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
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <label class="col-form-label">RENGİ</label>
                            <form:input cssClass="form-control" placeholder="Rengi" path="aracRengi"/>
                            <form:errors  path="aracRengi" cssClass="text-danger"/>
                        </div>
                        <div class="col-sm-4">
                            <label class="col-form-label">MARKA</label>
                            <form:input cssClass="form-control" placeholder="Marka" path="aracMarka"/>
                            <form:errors  path="aracMarka" cssClass="text-danger"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="jumbotron">
                    <div class="row justify-content-center align-items-center">
                        <h3 class="h3" style="text-align: center">ÖGRENCİ BİLGİLERİ</h3>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <label class="col-form-label">TCNO</label>
                            <form:input cssClass="form-control" placeholder="Tc" path="ogrenciTcNo"/>
                            <form:errors cssClass="text-danger" path="ogrenciTcNo"/>
                        </div>
                        <div class="col-sm-4">
                            <label class="col-form-label">ADSOYAD</label>
                            <form:input cssClass="form-control" placeholder="Adsoyad" path="ogrenciAdSoyad"/>
                            <form:errors cssClass="text-danger" path="ogrenciAdSoyad"/>
                        </div>
                        <div class="col-sm-4">
                            <label class="col-form-label">ÖGRENCİNO</label>
                            <form:input cssClass="form-control" placeholderr="Ogrencino" path="ogrenciNo"/>
                            <form:errors cssClass="text-danger" path="ogrenciNo"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <label class="col-form-label">FAKULTE</label>
                            <form:select cssClass="form-control" path="fakulteYO">
                                <form:option value="NONE" label="Select"/>
                                <form:options items="${kampusBirimList}"/>
                            </form:select><br><br>
                        </div>
                        <div class="col-sm-4">
                            <label class="col-form-label">BÖLÜM</label>
                            <form:select cssClass="form-control" path="bolum">
                                <form:option value="NONE" label="Select"/>
                                <form:options items="${Bolum}"/>
                            </form:select><br><br>
                        </div>
                        <div class="col-sm-4">
                            <label class="col-form-label">SINIF</label>
                            <form:input cssClass="form-control" placeholder="Sinif" path="sinif"/>
                            <form:errors cssClass="text-danger" path="sinif"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-4">
                            <label class="col-form-label">TELEFON</label>
                            <form:input cssClass="form-control" placeholder="Telefon" path="ogrTel"/>
                            <form:errors cssClass="text-danger" path="ogrTel"/>
                        </div>
                        <div class="col-sm-4">
                            <label class="col-form-label">EPOSTA</label>
                            <form:input cssClass="form-control" placeholder="Eposta" path="ogrenciEposta"/>
                            <form:errors cssClass="text-danger" path="ogrenciEposta"/>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div style="text-align: center">
            <input type="submit" class="btn btn-primary" style="text-align: center" value="Kaydet"/>
        </div>
    </form:form>

</div>
</body>
</html>
