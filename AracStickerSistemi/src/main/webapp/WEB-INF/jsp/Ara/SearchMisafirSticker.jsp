<%@ page import="com.AracStickerSistemi.Model.Encryption" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Kaan
  Date: 29.07.2020
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <title>MISAFIRSTICKERARA</title>
</head>
<body style="background-color: #d2d6de">
<jsp:include page="../TemplateMenu.jsp"/>
<div class="container-lg" style="text-align: center; margin-top: 50px;">
    <form:form action="${pageContext.request.contextPath}/paginationMisafirp/MQ==" modelAttribute="misafirstickersearch" >
        <div class="jumbotron">
            <div class="row justify-content-center align-items-center">
                <h3 class="h3" style="text-align: center">MİSAFİR STİCKER ARA</h3>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label class="col-form-label">STİCKER NO</label>
                    <form:input cssClass="form-control" placeholder="Stickerno" path="stickerNo"/>
                </div>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label class="col-form-label">KAMPUS</label>
                    <form:select cssClass="form-control" placeholder="Kampus" path="kampus">
                        <form:option value="" label="Select"/>
                        <form:options items="${kampusList}"/>
                    </form:select>
                </div>
            </div>
            <div class="row justify-content-center align-items-center">
                <div class="col-sm-4">
                    <label class="col-form-label">KAMPUS BİRİM</label>
                    <form:select cssClass="form-control" path="kapmusBirimi">
                        <form:option value="" label="Select"/>
                        <form:options items="${kampusBirimList}"/>
                    </form:select>
                </div>
            </div>
        </div>
        <div style="text-align: center">
            <input type="submit" class="btn btn-primary" style="text-align: center" value="Stickerı Ara"/>
        </div>
    </form:form>
</div>
</body>
</html>
