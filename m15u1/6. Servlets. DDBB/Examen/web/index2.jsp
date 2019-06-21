<%-- 
    Document   : index2
    Created on : 02-abr-2019, 15:47:39
    Author     : Pablo Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Examen PE1.2</title>
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <div class="container">
            <div class="row">
                <c:forEach items="${list_image}" var="imagen">
                    <c:if test="${role == null}">
                        <img src="img/${imagen.id}.jpg" /> ${imagen.name} 
                    </c:if>
                    <c:if test="${role != null}">
                        <c:choose>
                            <c:when test="${imagen.name == 'webs'}">
                                <a href="webcontroller?action=showTable"><img src="img/${imagen.id}.jpg" /> ${imagen.name}</a>
                            </c:when>
                            <c:when test="${imagen.name != 'webs'}">
                                <a href="https://www.google.es"><img src="img/${imagen.id}.jpg" /> ${imagen.name}</a>
                            </c:when>
                        </c:choose>
                    </c:if>
                </c:forEach>
            </div>
        </div>

        <!--Success message -->
        <c:if test="${success1 != null}">
            <br/>
            <div class="container">
                <div class='form-horizontal'>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <div class='col-sm-2sm-2 alert alert-success'>${success1}</div>
                    </div>
                </div>
            </div>
        </c:if>

        <%@include file="footer.jsp"%>
    </body>
</html>