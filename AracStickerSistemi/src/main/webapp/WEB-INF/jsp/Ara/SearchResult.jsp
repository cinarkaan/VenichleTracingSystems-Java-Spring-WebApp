<%@ page import="com.AracStickerSistemi.Controller.StickerController" %>
<%@ page import="com.AracStickerSistemi.Model.OgrenciSticker" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.AracStickerSistemi.Model.KurumSticker" %>
<%@ page import="com.AracStickerSistemi.Model.MisafirSticker" %>
<%@ page import="com.AracStickerSistemi.Controller.SearchController" %>
<%@ page import="com.AracStickerSistemi.Model.Encryption" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modals.js"></script>
    <title>Result</title>
</head>
<body>

<jsp:include page="../TemplateMenu.jsp"/>

<% if (StickerController.ogreciTcNo != null) { %>
        <h2 class="h2" style="text-align: center">ARAMA SONUCLARI</h2>
        <table class="table table-bordered table-hover table w-auto small" style="margin-left: auto; margin-right: auto">
        <thead>
            <tr>
                <th scope="col"><b>STİCKERNO</b></th>
                <th scope="col"><b>SAHİBİ</b></th>
                <th scope="col"><b>PLAKA</b></th>
                <th scope="col"><b>TCNO</b></th>
                <th scope="col"><b>ADSOYAD</b></th>
                <th scope="col"><b>OGRENCİNO</b></th>
                <th scope="col"><b>FAKULTE</b></th>
                <th scope="col"><b>BOLUM</b></th>
                <th scope="col"><b>CEPTELEFONU</b></th>
                <th scope="col"><b>SİL</b></th>
                <th scope="col"><b>DÜZENLE</b></th>
                <th scope="col"><b>AYRINTI</b></th>
            </tr>
        </thead>
            <tbody>
                <%
                ArrayList<OgrenciSticker> ogrenciStickerrArrayList = SearchController.ogrenciStickers;
                for (OgrenciSticker getOgrenciSticker : ogrenciStickerrArrayList) {%>
            <tr>
                <td><%=getOgrenciSticker.getStickerNo()%></td>
                <td><%=getOgrenciSticker.getAracSahibininAdiSoyad()%></td>
                <td><%=getOgrenciSticker.getPlaka()%></td>
                <td><%=getOgrenciSticker.getOgrenciAdSoyad()%></td>
                <td><%=getOgrenciSticker.getOgrenciTcNo()%></td>
                <td><%=getOgrenciSticker.getOgrenciNo()%></td>
                <td><%=getOgrenciSticker.getFakulteYO()%></td>
                <td><%=getOgrenciSticker.getBolum()%></td>
                <td><%=getOgrenciSticker.getOgrTel()%></td>
                <td><a href="${pageContext.request.contextPath}/StickerOperations/delete/<%=Encryption.encode(getOgrenciSticker.getSticker_id())%>" class="btn btn-warning" id="deleteButtonOgrenci">Sil</a></td>
                <td><a href="${pageContext.request.contextPath}/editOgrenciSticker/<%=Encryption.encode(getOgrenciSticker.getSticker_id())%>" class="btn btn-warning">Düzenle</a></td>
                <td><a href="${pageContext.request.contextPath}/ayrintiOgr/<%=Encryption.encode(getOgrenciSticker.getSticker_id())%>" class="btn btn-info">Ayrıntı</a></td>
            </tr>
            <%}%>
            </tbody>
    </table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <% if (SearchController.currentPage > 1) { %>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/paginationogrn/
<%=Encryption.encode(SearchController.currentPage)%>">Previous</a></li>
        <%}%>
        <% if (SearchController.currentPage < SearchController.totalPage) { %>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/paginationogrp/
<%=Encryption.encode(SearchController.currentPage)%>">Next</a></li>
        <%}%></ul>
</nav>
<%}%>
    <% if (StickerController.kurumTcNo != null) { %>
        <h2 class="h2" style="text-align: center">ARAMA SONUCLARI</h2>
        <table class="table table-bordered table w-auto small" style="margin-right: auto; margin-left: auto;">
            <thead>
            <tr>
                <th scope="col"><b>STİCKERNO</b></th>
                <th scope="col"><b>SAHİBİ</b></th>
                <th scope="col"><b>PLAKA</b></th>
                <th scope="col"><b>TCNO</b></th>
                <th scope="col"><b>ADSOYAD</b></th>
                <th scope="col"><b>KAMPUS</b></th>
                <th scope="col"><b>BİRİM</b></th>
                <th scope="col"><b>KADRO</b></th>
                <th scope="col"><b>UNVAN</b></th>
                <th scope="col"><b>GOREV</b></th>
                <th scope="col"><b>TELEFON</b></th>
                <th scope="col"><b>POSTA</b></th>
                <th scope="col"><b>SİL</b></th>
                <th scope="col"><b>DÜZENLE</b></th>
                <th scope="col"><b>AYRINTI</b></th>
            </tr>
            </thead>
            <tbody>
            <%
            ArrayList<KurumSticker> kurumStickerArrayList= SearchController.kurumStickers;
            for (KurumSticker getKurumSticker : kurumStickerArrayList) {%>
                <tr>
                    <td><%=getKurumSticker.getStickerNo()%></td>
                    <td><%=getKurumSticker.getAracSahibininAdiSoyad()%></td>
                    <td><%=getKurumSticker.getPlaka()%></td>
                    <td><%=getKurumSticker.getTcNo()%></td>
                    <td><%=getKurumSticker.getAdSoyad()%></td>
                    <td><%=getKurumSticker.getBulunduguKampus()%></td>
                    <td><%=getKurumSticker.getKampusBirimAdi()%></td>
                    <td><%=getKurumSticker.getKadroBirimi()%></td>
                    <td><%=getKurumSticker.getUnvan()%></td>
                    <td><%=getKurumSticker.getGorevYaptigiBirim()%></td>
                    <td><%=getKurumSticker.getCepTelefonu()%></td>
                    <td><%=getKurumSticker.getEposta()%></td>
                    <td><a href="${pageContext.request.contextPath}/StickerOperations/delete/<%=Encryption.encode(getKurumSticker.getSticker_id())%>" class="btn btn-warning" id="deleteButtonKurum">Sil</a></td>
                    <td><a href="${pageContext.request.contextPath}/editKurumSticker/<%=Encryption.encode(getKurumSticker.getSticker_id())%>" class="btn btn-warning" id="editAracKurum">Düzenle</a></td>
                    <td><a href="${pageContext.request.contextPath}/ayrintiKurum/<%=Encryption.encode(getKurumSticker.getSticker_id())%>" class="btn btn-info">Ayrıntı</a></td>
                </tr>
            <%}%>
            </tbody>
        </table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <% if (SearchController.currentPage > 1) { %>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/paginationKurumn/<%=Encryption.encode(SearchController.currentPage)%>">Previous</a></li>
        <%}%>
        <% if (SearchController.currentPage < SearchController.totalPage) { %>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/paginationKurump/<%=Encryption.encode(SearchController.currentPage)%>">Next</a></li>
        <%}%></ul>
</nav>
<%}%>
    <% if (StickerController.misafirTcNo != null) { %>
        <h2 class="h2" style="text-align: center">ARAMA SONUCLARI</h2>
        <table class="table table-bordered table w-auto small" style="margin-left: auto; margin-right: auto;">
            <thead>
        <tr>
            <th scope="col"><b>STİCKERNO</b></th>
            <th scope="col"><b>SAHİBİ</b></th>
            <th scope="col"><b>PLAKA</b></th>
            <th scope="col"><b>TCNO</b></th>
            <th scope="col"><b>ADSOYAD</b></th>
            <th scope="col"><b>KAMPUS</b></th>
            <th scope="col"><b>BİRİM</b></th>
            <th scope="col"><b>FİRMAİSMİ</b></th>
            <th scope="col"><b>FİRMADRES</b></th>
            <th scope="col"><b>FİRMATEL</b></th>
            <th scope="col"><b>TELEFON</b></th>
            <th scope="col"><b>POSTA</b></th>
            <th scope="col"><b>SİL</b></th>
            <th scope="col"><b>DÜZENLE</b></th>
            <th scope="col"><b>AYRINTI</b></th>
        </tr>
            </thead>
            <tbody>
            <%
                ArrayList<MisafirSticker> misafirStickerArrayList = SearchController.misafirStickers;
                for (MisafirSticker getMisafirSticker : misafirStickerArrayList) {%>
            <tr>
                <td><%=getMisafirSticker.getStickerNo()%></td>
                <td><%=getMisafirSticker.getAracSahibininAdiSoyad()%></td>
                <td><%=getMisafirSticker.getPlaka()%></td>
                <td><%=getMisafirSticker.getMisafirTcNo()%></td>
                <td><%=getMisafirSticker.getMisafirAdSoyad()%></td>
                <td><%=getMisafirSticker.getMisafirBulunduguKampus()%></td>
                <td><%=getMisafirSticker.getMisafirKampusBirimAdi()%></td>
                <td><%=getMisafirSticker.getMisafirFirmaAdi()%></td>
                <td><%=getMisafirSticker.getMisafirFirmaAdres()%></td>
                <td><%=getMisafirSticker.getMisafirFirmaTel()%></td>
                <td><%=getMisafirSticker.getMisafirCep()%></td>
                <td><%=getMisafirSticker.getMisafirEposta()%></td>
                <td><a href="${pageContext.request.contextPath}/StickerOperations/delete/<%=Encryption.encode(getMisafirSticker.getSticker_id())%>" class="btn btn-warning" id="deleteButtonMisafir">Sil</a></td>
                <td><a href="${pageContext.request.contextPath}/editMisafirSticker/<%=Encryption.encode(getMisafirSticker.getSticker_id())%>" class="btn btn-warning" id="editAracMisafir">Düzenle</a></td>
                <td><a href="${pageContext.request.contextPath}/ayrintiMisafir/<%=Encryption.encode(getMisafirSticker.getSticker_id())%>" class="btn btn-info">Ayrıntı</a></td>
            </tr>
            <%}%>
            </tbody>
        </table>
<% if (SearchController.totalPage > 2) { %>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <% if (SearchController.currentPage > 1) { %>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/paginationMisafirn/<%=Encryption.encode(SearchController.currentPage)%>">Geri</a></li>
        <%}%>
        <% if (SearchController.currentPage < SearchController.totalPage) { %>
        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/paginationMisafirp/<%=Encryption.encode(SearchController.currentPage)%>">İleri</a></li>
        <%}%>
    </ul>
</nav>
<%}%>
<%}%>

<div class="modal" tabindex="-1" id="deleteModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">KAYDI SİL</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Silmek istediğinizden eminmisiniz ?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">İptal</button>
                <a href="" class="btn btn-danger" id="delRef">Evet,Sil</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
