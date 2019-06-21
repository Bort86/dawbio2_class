<%-- 
    Document   : index
    Created on : 09-nov-2018, 11:15:36
    Author     : alumne
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Objectes implícits</h1>
        <!--formulari-->
        <form method="post" action="index.jsp">
            El teu nom:<input type="text" name="nom"/><br/>
            La teva edat: <input type="number" name="edat" /><br/>
            Sexe?<input type="radio" name="sexe" value="Home">Home
            <input type="radio" name="sexe" value="Dona">Dona
            <input type="radio" name="sexe" value="Altres">Altres<br/>
            Sexe?
            <select name="sexe">
                <option value="Home">Home</option>
                <option value="Dona">Dona</option>
                <option value="Altres">Altres</option>
            </select>
            <br/>
            Quines aficions tens?
            <input type="checkbox" name="aficio" value="Muntanya">Muntanya
            <input type="checkbox" name="aficio" value="Cinema">Cinema
            <input type="checkbox" name="aficio" value="Música">Música
            <br/>
            <input type="submit" value="Clica" name="ok"/>

        </form>
        <%
            if (request.getParameter("ok") != null) //ok es el nom del vostre buto submit
            {
                int age;
                try {
                    age = Integer.parseInt(request.getParameter("edat"));
                } catch (Exception error) {
                    age = -1;
                }
                age = age - 3;//li trec 3 anys 
                out.println("<hr/>");
                out.println(request.getParameter("nom"));
                out.println("<br/>");
                out.println(request.getParameter("sexe"));
                out.println("<br/>");
                out.println(age);
                out.println("<br/>");
                String[] aficions;
                if (request.getParameterValues("aficio") != null) {
                    aficions = request.getParameterValues("aficio");//per a arrays

                    for (String aficio : aficions) {
                        out.println(aficio);

                    }
                } else {
                    out.println("Nos has clicat cap aficio");
                }
                if (age > 30) {
                    response.sendRedirect("page2.jsp");
                } else {
                    response.setHeader("Refresh", "5");

                }
                Enumeration val;
                //Capceleres
                for (val = request.getHeaderNames(); val.hasMoreElements();) {
                    String c = (String) val.nextElement();

                    String valor = request.getHeader(c);

                    out.println("<br/>Capcelera " + c + " i el seu contingut és " + valor);
                }
                out.println("<br/>El valor particular d'una d'aquestes capceleres " + request.getHeader("accept"));
                out.println("<br/>Ip s'està enviat per " + request.getRemoteAddr());
            }
            //Instruccions
            session.setAttribute("usuario", "Sergi");
            session.getAttribute("usuario");
            


        %>


    </body>
</html>