<%@ page import="com.AracStickerSistemi.Controller.WelcomeController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>Welcome</title>
</head>
<body style="background-color: #d2d6de">
    <div class="container d-flex justify-content-center" style="margin-top: 80px">
        <div class="col-lg-4">
            <div class="jumbotron">
                <div class="text-center">
                    <img src="${pageContext.request.contextPath}/resources/img/logo.png" class="rounded" alt="..." style="width: 150px; height: 120px;">
                </div>
                <h3 class="h3" style="text-align: center">MEÜ TAŞIT STİCKER SİSTEMİ</h3>
                <div class="row justify-content-center align-items-center">
                    <a href="${pageContext.request.contextPath}/LoginPanel" class="btn btn-outline-primary">Sisteme Giriş</a> <br/><br/><br/><br/>
                </div>
                <div class="row justify-content-center align-items-center">
                    <a href="${pageContext.request.contextPath}/StickerBasvuru" class="btn btn-outline-primary">Sticker Kayıt</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
