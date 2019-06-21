<%-- 
    Document   : login2
    Created on : 23-ene-2019, 17:02:02
    Author     : Pablo Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Benvingut usuari <% out.println(session.getAttribute("name"));%></h1>
        
         <form method="post" action="user">
            <input type="password" name="password" placeholder="Contrassenya"/>
            
            <input type="submit" name="action" value="Continua2"/> 
                        
        </form>
        
        <%
            
            if (request.getAttribute("error2")!=null){
           
               String messages=(String)request.getAttribute("error2");
               out.println(messages);
            }
           

        %>
    </body>
</html>
