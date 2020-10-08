<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 2.09.2020
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>Şifremi Unuttum</title>
</head>
<body style="background-color: #d2d6de">


<div class="container d-flex justify-content-center" style="margin-top: 80px;">
    <div class="col-lg-4">
        <div class="jumbotron">
            <h3 class="h3" style="text-align: center">PAROLA SIFIRMALA</h3>
            <form action="${pageContext.request.contextPath}/Login" method="post">
                <div class="form-group">
                    <label for="EMAIL" class="col-form-label">EMAİL :</label>
                    <input type="text" id="EMAIL" name="EMAIL" class="form-control" placeholder="EMAİL">
                </div>
                <div style="text-align: center">
                    <br/><button type="submit" class="btn btn-outline-primary">Giriş</button>
                </div>
            </form>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
