<%-- 
    Document   : index2
    Created on : 29-ene-2019, 16:59:25
    Author     : Pablo Rodriguez
--%>

<%@page import="java.util.Collection"%>
<%@page import="model.Patient"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index2 Page</title>
    </head>
    <body>
        <%@include file="menu.jsp"%>

        <table class="table">
            <tr>
                <th>GrupEdat</th>
                <th>Pes</th>
                <th>Imc</th>
                <th>Classificacio</th>
            </tr>
            
            <c:if test="${result != null}">
                <c:forEach items="${result}" var="patient">
                    <c:if test="${patient.idRegistre % 2 == 0}">
                        <tr bgcolor=#DCDCDC>
                    </c:if>
                    <c:if test="${patient.idRegistre % 2 == 1}">
                        <tr bgcolor=yellow>
                    </c:if>
                            <th>${patient.grupEdat}</th>
                            <th>${patient.pes}</th>
                            <th>${patient.imc}</th>
                            <th>${patient.classificacio}</th>
                        </tr>
                </c:forEach>               
            </c:if>
        </table>
    </body>
</html>
