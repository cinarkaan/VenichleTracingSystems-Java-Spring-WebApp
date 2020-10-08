<%@ page import="com.AracStickerSistemi.Model.KurumSticker" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.AracStickerSistemi.Controller.WelcomeController" %>
<%@ page import="com.AracStickerSistemi.Controller.ProfileController" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 15.08.2020
  Time: 09:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>SearchKurum</title>
</head>
<body>
<h2 class="h2" style="text-align: center">KURUMA KAYITLI STİCKERLAR</h2>
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
    </tr>
    </thead>
    <tbody>

    <%

        ArrayList<KurumSticker> kurumStickerArrayList= null;
        try {
            kurumStickerArrayList = WelcomeController.dataBaseController.getByKurum(ProfileController.userProfile.getKampusbirim());
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        <td><a href="#" class="btn btn-outline-danger">Sil</a></td>
        <td><a href="#" class="btn btn-outline-warning">Düzenle</a></td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
