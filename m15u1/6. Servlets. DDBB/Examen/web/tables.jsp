<%-- 
    Document   : tables
    Created on : 02-abr-2019, 17:17:31
    Author     : Pablo Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Examen PE1.2</title>
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <form action="webcontroller" method="POST">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">Code</th>
                        <th scope="col">Publication Date</th>
                        <th scope="col">Title</th>
                        <th scope="col">Url</th>
                        <c:if test="${role=='admin'}">
                            <th class="btn btn-info">
                                <a href="add_web.jsp"> Add Web</a>
                            </th>
                        </c:if>
                </thead>
                <tbody>
                <c:forEach items="${webList}" var="web">
                    <tr>
                        <th scope="row">${web.code}</th>
                        <td>${web.date}</td>
                        <td>${web.title}</td>
                        <td>${web.url}</td>
                        <c:if test="${role=='admin'}">
                            <td scope="col">
                                <button class="btn btn-primary" type="submit" name="update">Update</button>
                            </td>
                            <td scope="col">
                                <button class="btn btn-danger" type="submit" value="${web.code}" name="web">Delete</button>
                                <input type="hidden" name="action" value="deleteWeb"/>
                            </td>                                        
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </form>
        <%@include file="footer.jsp"%>
    </body>
</html>
