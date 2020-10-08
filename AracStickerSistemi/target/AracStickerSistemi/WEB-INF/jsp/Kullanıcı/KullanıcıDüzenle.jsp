<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>KullanıcıDüzenle</title>
</head>
<body>
<jsp:include page="${pageContext.request.contextPath}/template"/>

<div class="container" STYLE="margin-top: 70px">
    <h3 class="h3" style="text-align: center">KULLANICI DÜZENLE</h3>
    <form:form cssClass="form-group" method="post" action="${pageContext.request.contextPath}/editUserSave" modelAttribute="updateUser" >
        <div class="row jumbotron">
            <div class="col-sm-4">
                <label class="col-form-label">ADI :</label>
                <form:input path="ad" cssClass="form-control" placeholder="Adı"/>
                <form:errors path="ad" cssClass="text-danger"/>
            </div>
            <div class="col-sm-4">
                <label class="col-form-label">SOYADI : </label>
                <form:input path="soyAdi" cssClass="form-control" placeholder="Soyadı"/>
                <form:errors path="soyAdi" cssClass="text-danger"/>
            </div>
            <div class="col-sm-4">
                <label class="col-form-label">KULLANICI ADI : </label>
                <form:input path="id" cssClass="form-control" placeholder="Kullanıcı Adı"/>
                <form:errors path="id" cssClass="text-danger"/>
            </div>
            <div class="col-sm-4">
                <label class="col-form-label">CEP TELEFONU : </label>
                <form:input path="cepTel" cssClass="form-control" placeholder="Telefon"/>
                <form:errors path="cepTel" cssClass="text-danger"/>
            </div>
            <div class="col-sm-4">
                <label class="col-form-label">KAMPUS</label>
                <form:select cssClass="form-control" path="kampus">
                    <form:option value="" label="Select"/>
                    <form:options items="${kampusList}"/>
                </form:select>
            </div>
            <div class="col-sm-4">
                <label class="col-form-label">Gorev</label>
                <form:select cssClass="form-control" path="görev">
                    <form:option value="" label="Select"/>
                    <form:options items="${gorev}"/>
                </form:select>
            </div>
        </div>
        <div class="container">
            <c:if test="${not empty error}">
                <p class="text-danger">${error}</p>
            </c:if>
        </div>
        <div style="text-align: center">
            <input type="submit" class="btn btn-primary" style="text-align: center;"  value="Kaydet">
        </div>
    </form:form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>
