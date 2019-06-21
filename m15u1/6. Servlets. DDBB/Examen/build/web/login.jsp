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
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <form method="post" action="usercontroller">
            <div class="container login-container">

                <div class="col-md-6 login-form-1">
                    <h3>Login Form </h3>

                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Your Username * " name="username" />
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" placeholder="Your Password *" name="password" />
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btnSubmit" name="action" value="login" />
                        <a href="add_user.jsp">Register</a>
                    </div>
                </div>
            </div>
        </form>

        <c:if test="${error != null}">
            <div class="alert alert-danger" role="alert"> Wrong username or password, please try again</div>
        </c:if>
        <%@include file="footer.jsp"%>
    </body>
</html>
