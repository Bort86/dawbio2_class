<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Pt 1.6</a>
        </div>

        <ul class="nav navbar-nav navbar-right">
            <li><a href="filter_pac.jsp"><span class="glyphicon glyphicon-search"></span> Filter Patient</a></li>
            <li><a href="add_pac.jsp"><span class="glyphicon glyphicon-plus"></span> Add Patient</a></li>
                <c:if test="${rol == 'admin'}">
                    <li><a href="add_user.jsp"><span class="glyphicon glyphicon-user"></span> Add User</a></li>
                    <li><a href="delete_user.jsp"><span class="glyphicon glyphicon-remove"></span> Delete User</a></li>
                </c:if>
            <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
        </ul>
    </div>
</nav> 
