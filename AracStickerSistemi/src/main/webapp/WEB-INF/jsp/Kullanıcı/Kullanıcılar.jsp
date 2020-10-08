<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 20.08.2020
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modals.js"></script>
    <title>Kullanıcılar</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/template"/>
<h2 class="h2" style="text-align: center">KULLANICILAR</h2>
<table class="table table-bordered table-hover table w-auto small" style="margin-left: auto; margin-right: auto;">
    <thead>
    <tr>
        <th scope="col"><b>İD</b></th>
        <th scope="col"><b>İSİM</b></th>
        <th scope="col"><b>SOYİSİM</b></th>
        <th scope="col"><b>KULLANICI_İSMİ</b></th>
        <th scope="col"><b>PAROLA</b></th>
        <th scope="col"><b>TELEFON</b></th>
        <th scope="col"><b>KULLANICI_TÜR</b></th>
        <th scope="col"><b>KAMPUS</b></th>
        <th scope="col"><b>GÖREV</b></th>
        <th scope="col"><b>SİL</b></th>
        <th scope="col"><b>DÜZENLE</b></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="userlist" items="${userlist}">
    <tr>
        <td>${userlist.kullanici_id}</td>
        <td>${userlist.ad}</td>
        <td>${userlist.soyAdi}</td>
        <td>${userlist.id}</td>
        <td>${userlist.password}</td>
        <td>${userlist.cepTel}</td>
        <td>${userlist.stickerTur}</td>
        <td>${userlist.kampus}</td>
        <td>${userlist.görev}</td>
        <td><a href="${pageContext.request.contextPath}/deleteUser/${userlist.urlcodeid}" class="btn btn-outline-danger" id="userDeleteButton">SİL</a></td>
        <td><a href="${pageContext.request.contextPath}/editUser/${userlist.urlcodeid}" class="btn btn-outline-warning">DÜZENLE</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>

<div class="modal" tabindex="-1" id="deleteUserModal">
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
                <a href="" class="btn btn-danger" id="delUserRef">Evet,Sil</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>
