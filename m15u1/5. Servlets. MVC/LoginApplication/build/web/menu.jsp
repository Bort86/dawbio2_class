<%
    if(session.getAttribute("name")!=null){
        out.println("Hello "+session.getAttribute("name"));
    }
%>
<br/>
<a href="#">Home</a>

<%
    if(session.getAttribute("name")==null){
        out.println("<a href='login.jsp'>Validate</a>");
        out.println("<a href='register.jsp'>Register</a>");
    }else{
        out.println("<a href='logout.jsp'>Logout</a>");
    }
%>

<a href="#">Page 4</a>
