<%-- 
    Document   : index.jsp
    Created on : 29-ene-2019, 16:53:50
    Author     : Pablo Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <% response.sendRedirect("patientController?action=indexar");
            %>
        
    </body>
</html>
