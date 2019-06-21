<%-- 
    Document   : register
    Created on : Jan 15, 2019, 5:49:46 PM
    Author     : alumne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h3>Register page</h3>
        <%@include file="menu.jsp"%>
       
        <form method="post" action="user">
            Username: <input type="text" name="username" />
            <br/>
            Password: <input type="password" name="password" />
            <br/>
            Repeat Password: <input type="password" name="repassword" />
            <br/>
            <input type="submit" name="action" value="Register"/>
                        
        </form>
        <%
            
            /*if(request.getParameter("error")!=null){
                String error=request.getParameter("error");
                out.println(error);
            }*/
            if(request.getAttribute("error")!=null){
                String error= (String)request.getAttribute("error");
                out.println(error);
            }
            
            
            
            %>
    </body>
</html>
