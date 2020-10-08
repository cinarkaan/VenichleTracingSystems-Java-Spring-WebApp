<%@ page import="com.AracStickerSistemi.Model.OgrenciSticker" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.AracStickerSistemi.Controller.SearchController" %>
<%@ page import="com.AracStickerSistemi.Model.Encryption" %><%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 8.08.2020
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modals.js"></script>
    <title>OgrenciBasvuruları</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/template"/>
<h2 class="h2" style="text-align: center">ÖĞRENCİ BASVURULARI</h2>
<table class="table table-bordered table-hover table w-auto small" style="margin-left: auto; margin-right: auto">
    <thead>
    <tr>
        <th scope="col"><b>ARACTURU</b></th>
        <th scope="col"><b>SAHİBİ</b></th>
        <th scope="col"><b>RUHSATSAHİBİ</b></th>
        <th scope="col"><b>PLAKA</b></th>
        <th scope="col"><b>MARKA</b></th>
        <th scope="col"><b>RENGİ</b></th>
        <th scope="col"><b>TCNO</b></th>
        <th scope="col"><b>ADSOYAD</b></th>
        <th scope="col"><b>OGRENCİNO</b></th>
        <th scope="col"><b>FAKULTE</b></th>
        <th scope="col"><b>BOLUM</b></th>
        <th scope="col"><b>SINIF</b></th>
        <th scope="col"><b>CEPTELEFONU</b></th>
        <th scope="col"><b>EPOSTA</b></th>
        <th scope="col"><b>REDDET</b></th>
        <th scope="col"><b>ONAYLA</b></th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<OgrenciSticker> ogrenciStickerrArrayList = SearchController.ogrenciStickers;
        for (OgrenciSticker getOgrenciSticker : ogrenciStickerrArrayList) {%>
    <tr>
        <td><%=getOgrenciSticker.getAracTuru()%></td>>
        <td><%=getOgrenciSticker.getAracSahibininAdiSoyad()%></td>
        <td><%=getOgrenciSticker.getRuhsatSahibininAdiSoyad()%></td>
        <td><%=getOgrenciSticker.getPlaka()%></td>
        <td><%=getOgrenciSticker.getAracMarka()%></td>
        <td><%=getOgrenciSticker.getAracRengi()%></td>
        <td><%=getOgrenciSticker.getOgrenciTcNo()%></td>
        <td><%=getOgrenciSticker.getOgrenciAdSoyad()%></td>
        <td><%=getOgrenciSticker.getOgrenciNo()%></td>
        <td><%=getOgrenciSticker.getFakulteYO()%></td>
        <td><%=getOgrenciSticker.getBolum()%></td>
        <td><%=getOgrenciSticker.getSinif()%></td>
        <td><%=getOgrenciSticker.getOgrTel()%></td>
        <td><%=getOgrenciSticker.getOgrenciEposta()%></td>
        <td><a href="${pageContext.request.contextPath}/StickerOperations/red/<%=Encryption.encode(getOgrenciSticker.getSerialno())%>" class="btn btn-warning" id="redButton">Reddet</a></td>
        <td><a href="${pageContext.request.contextPath}/editBasvuruOgr/<%=Encryption.encode(getOgrenciSticker.getSerialno())%>" class="btn btn-warning">Onayla</a></td>
    </tr>
    <%}%>
    </tbody>
</table>
<% if (SearchController.ogrenciStickers.size() > 10) { %>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
        </li>

        <li class="page-item">
            <a class="page-link" href="#">Next</a>
        </li>
    </ul>
</nav>
<%}%>

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
