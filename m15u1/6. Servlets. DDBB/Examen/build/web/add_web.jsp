<%-- 
    Document   : add_user
    Created on : 02-abr-2019, 17:49:05
    Author     : Pablo Rodriguez
--%>

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

        <title>Add Web</title>
    </head>
    <body>
        <%@include file="menu.jsp"%>
        <h1>Add Web</h1>
        <form method="post" action="webcontroller">
            <div class="container">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Web Code </label>
                        <div class='col-sm-2'>
                            <input type="text" class="form-control" name="webcode" />
                        </div>
                    </div>
                </div>
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Publication Date </label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control"  name="publication_date" />
                        </div>
                    </div>
                </div>
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Title </label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name="title" />
                        </div>
                    </div>
                </div>
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Url </label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name="url_web" />
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2"></div>
                    <input class="col-sm-2" type="submit" name="action" value="Add Web"/>
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


        <%@include file="footer.jsp"%>
    </body>
</html>