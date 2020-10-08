<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 31.08.2020
  Time: 06:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Ara</title>
</head>
<body style="background-color: #d2d6de">

<div class="container-lg" style="text-align: center; margin-top: 50px;">

    <form action="${pageContext.request.contextPath}/ara">
        <div class="jumbotron">
            <div class="row justify-content-center align-items-center">
                <h3 class="h3" style="text-align: center">STICKER ARAMA</h3>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label for="ID" class="col-form-label">STİCKER NO</label>
                    <input id="ID" name="ID" type="text" class="form-control" placeholder="Stickerno" />
                </div>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label  for="PLAKA" class="col-form-label">PLAKA</label>
                    <input id="PLAKA" name="PLAKA" type="text" class="form-control" placeholder="Plaka"/>
                </div>
            </div>
            <div class="text-center">
                <br/><br/><button type="submit" class="btn btn-outline-primary">ARA</button>
            </div>
        </div>
    </form>
</div>


</body>
</html>
