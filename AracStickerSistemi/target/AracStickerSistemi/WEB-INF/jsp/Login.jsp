<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 17.07.2020
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body style="background-color: #d2d6de">

<div class="container d-flex justify-content-center" style="margin-top: 80px;">
    <div class="col-lg-4">
        <div class="jumbotron">
            <div class="text-center">
                <img src="${pageContext.request.contextPath}/resources/img/logo.png" class="rounded" alt="..." style="width: 150px; height: 120px;">
            </div>
            <h3 class="h3" style="text-align: center">MEÜ TAŞIT STİCKER SİSTEMİ GİRİŞ PANELİ</h3>
            <form action="${pageContext.request.contextPath}/Profile" method="post">
                <div class="form-group">
                    <label for="ID" class="col-form-label">Kullanıcı Adı :</label>
                    <input type="text" id="ID" name="ID" class="form-control" placeholder="Kullanıcı Adı">
                </div>
                <div class="form-group">
                    <label for="PASS" class="col-form-label">Parola : </label>
                    <input type="password" placeholder="Parola" id="PASS" name="PASS" class="form-control">
                </div>
                <div style="text-align: center">
                    <br/><button type="submit" class="btn btn-outline-primary">Giriş</button>
                </div>
            </form>
            <div style="text-align: center">
                <br/><a href="${pageContext.request.contextPath}/sifremiUnuttum" class="btn btn-outline-secondary">Şifremi Unuttum</a>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
