<%-- 
    Document   : add_pac
    Created on : 05-feb-2019, 16:50:39
    Author     : Pablo Rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

        <title>PT 1.6 Añadir Usuario</title>
    </head>
    <body>
        <%@include file="menu2.jsp"%>
        <h1>Add users</h1>
        <form method="post" action="userController">
            <div class="container">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Username: </label>
                        <div class='col-sm-2'>
                            <input type="text" class="form-control" placeholder="Your Username * " name="username" />
                        </div>
                    </div>
                </div>
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Password: </label>
                        <div class="col-sm-2">
                            <input type="password" class="form-control" placeholder="Your Password *" name="password" />
                        </div>
                    </div>
                </div>
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Please repeat your password: </label>
                        <div class="col-sm-2">
                            <input type="password" class="form-control" name="repeatedPass" />
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2"></div>
                    <input class="col-sm-2" type="submit" name="action" value="Add User"/>
                </div>
            </div>
        </form>

        <!-- Errors-->
        <c:if test="${errors != null}">
            <br/>
            <div class="container">
                <div class='form-horizontal'>
                    <div class="form-group">
                        <div class="col-sm-2"></div>
                        <c:forEach items="${errors}" var="error">
                            <div class='col-sm-2sm-2 alert alert-warning'>${error}</div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:if>

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
    </body>
</html>