<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 25.08.2020
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Yönlendiriliyorunuz</title>
</head>
<script type="text/javascript">
    window.history.forward();
    function noBack() {
        window.history.forward();
    }
</script>
<body onload="setTimeout(function() {document.location = '${pageContext.request.contextPath}/'},2000)">
<div class="container" style="margin-top: 70px">
    <div class="row justify-content-center align-items-center">
        <h3 class="h3" style="text-align: center">BAŞVURUNUZ ALINMIŞTIR ANA SAYFAYA YÖNLENDİRİLİYORSUNUZ</h3>
    </div>
</div>
</body>
</html>
