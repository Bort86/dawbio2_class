<%-- 
    Document   : response
    Created on : 12-dic-2018, 18:03:46
    Author     : aasensio
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response JSP Page</title>
    </head>
    <body>
        <!-- Opcio A-->
        <%//les variables es recullen amb un request.getParameter %>
        
        <!-- Opcio B -->
        <%
            /*
            if (request.getAttribute("nom") != null) {
                out.println("<br>" + request.getAttribute("nom"));
            }

            if (request.getAttribute("list") != null) {
                List<String> llistatdeCapitals = (List<String>) request.getAttribute("list");
                for (String capital : llistatdeCapitals) {
                    out.println("<br>" + capital);
                }
            }*/%>
            
        <!-- Opcio C-->
        <%=session.getAttribute("numero")%>
        <%
            if (session.getAttribute("nom") != null) {
                out.println("<br>" + session.getAttribute("nom"));
            }

            if (session.getAttribute("list") != null) {
                List<String> llistatdeCapitals = (List<String>) session.getAttribute("list");
                for (String capital : llistatdeCapitals) {
                    out.println("<br>" + capital);
                }
            }

        %>

    </body>
</html>
