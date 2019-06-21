<%-- 
    Document   : welcome
    Created on : Dec 19, 2018, 4:17:45 PM
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h3>Welcome page</h3>
        <%@include file="menu.jsp"%>
        <%
            if(session.getAttribute("name")==null){
                response.sendRedirect("index.jsp");
            }
             



        %>
        <br/><br/>Welcome page
            
            
    </body>
</html>
