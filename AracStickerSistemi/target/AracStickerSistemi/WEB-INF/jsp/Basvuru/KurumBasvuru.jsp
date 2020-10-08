<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 27.08.2020
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modals.js"></script>
    <title>KurumBasvuruları</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/template"/>
<h2 class="h2" style="text-align: center">KURUMBAŞVURULARI</h2>
    <table class="table table-bordered table-hover table w-auto small" style="margin-left: auto; margin-right: auto;">
        <thead>
        <tr>
            <th scope="col"><b>ARACTURU</b></th>
            <th scope="col"><b>SAHİBİ</b></th>
            <th scope="col"><b>RUHSATSAHİBİ</b></th>
            <th scope="col"><b>PLAKA</b></th>
            <th scope="col"><b>MODEL</b></th>
            <th scope="col"><b>RENGİ</b></th>
            <th scope="col"><b>TCNO</b></th>
            <th scope="col"><b>ADSOYAD</b></th>
            <th scope="col"><b>KAMPUS</b></th>
            <th scope="col"><b>KAMPUSBİRİM</b></th>
            <th scope="col"><b>KADROBİRİM</b></th>
            <th scope="col"><b>UNVAN</b></th>
            <th scope="col"><b>GOREVBİRİMİ</b></th>
            <th scope="col"><b>KURUMSİCİL</b></th>
            <th scope="col"><b>İCHAT</b></th>
            <th scope="col"><b>CEPTELEFONU</b></th>
            <th scope="col"><b>EPOSTA</b></th>
            <th scope="col"><b>REDDET</b></th>
            <th scope="col"><b>ONAYLA</b></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${kurumlist}" var="kurumbasvuru">
            <td>${kurumbasvuru.aracTuru}</td>
            <td>${kurumbasvuru.aracSahibininAdiSoyad}</td>
            <td>${kurumbasvuru.ruhsatSahibininAdiSoyad}</td>
            <td>${kurumbasvuru.plaka}</td>
            <td>${kurumbasvuru.aracMarka}</td>
            <td>${kurumbasvuru.aracRengi}</td>
            <td>${kurumbasvuru.tcNo}</td>
            <td>${kurumbasvuru.adSoyad}</td>
            <td>${kurumbasvuru.bulunduguKampus}</td>
            <td>${kurumbasvuru.kampusBirimAdi}</td>
            <td>${kurumbasvuru.kadroBirimi}</td>
            <td>${kurumbasvuru.unvan}</td>
            <td>${kurumbasvuru.gorevYaptigiBirim}</td>
            <td>${kurumbasvuru.kurumSicil}</td>
            <td>${kurumbasvuru.icHat}</td>
            <td>${kurumbasvuru.cepTelefonu}</td>
            <td>${kurumbasvuru.eposta}</td>
            <td><a href="${pageContext.request.contextPath}/redKurumBasvuru/${kurumbasvuru.serialNo}" class="btn btn-outline-danger" id="redButton">REDDET</a></td>
            <td><a href="${pageContext.request.contextPath}/editBasvuruKurum/${kurumbasvuru.serialNo}" class="btn btn-outline-warning">ONAYLAR</a></td>
        </c:forEach>
        </tbody>
    </table>

<div class="modal" tabindex="-1" id="redModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">REDDET</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Talep reddedilsinmi ?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <a href="" class="btn btn-danger" id="redRef">Evet,Reddet</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
