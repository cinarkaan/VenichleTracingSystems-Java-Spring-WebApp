<%@ page import="java.io.PrintWriter" %>
<%@ page import="com.AracStickerSistemi.Controller.PrintController" %>
<%@ page import="java.io.FileInputStream" %>
<%
    PrintWriter printWriter = response.getWriter();
    String filename = PrintController.filename;
    String filepath = "C:\\Users\\Kaan\\OneDrive\\Belgeler\\apache-tomcat-8.5.12\\bin\\";
    response.setContentType("APPLICATION/OCTET-STREAM");
    response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");

    FileInputStream fileInputStream=new FileInputStream(filepath + filename);

    int i;
    while ((i=fileInputStream.read()) != -1) {
        printWriter.write(i);
    }
    fileInputStream.close();
    printWriter.close();
%>
