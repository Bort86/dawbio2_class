<%-- 
    Document   : filter_pac
    Created on : 05-feb-2019, 16:50:28
    Author     : Pablo Rodriguez
--%>

<%@page import="utils.CreatePDF"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="model.Patient"%>
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
        <title>PT 1.6 Filtrar paciente</title>
    </head>
    <body>
        <%@include file="menu2.jsp"%>
        <h1>Let's find some patients, shall we?!</h1>
        <form method="post" action="patientController">
            <div class="container">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Classification: </label>
                        <div class="col-sm-2">
                            <select class="form-control" name="classificacio" >
                                <option value=''>--</option>
                                <option value='OSTEOPONIA'>Osteoponia</option>
                                <option value='NORMAL'>Normal</option>
                                <option value='OSTEOPOROSI'>Osteoporosi</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Menopausia </label>
                        <div class="col-sm-2">
                            <input type="radio" name="Menopausia" value="SI" > Sí
                            <input type="radio" name="Menopausia" value="NO"> No
                        </div>
                    </div>
                </div>
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="formGroup">Menopause Type: </label>
                        <div class="col-sm-2">
                            <select class="form-control" name="tipusMenopausia" >
                                <option value=''>-</option>
                                <option value='NO CONSTA'>no consta</option>
                                <option value='NATURAL'>natural</option>
                                <option value='OVARIECTOMIA'>ovariectomia</option>
                                <option value='HISTEROCTOMIA'>histeroctomia</option>
                                <option value='AMBDUES'>ambdues</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2"></div>
                    <input class="col-sm-2" type="submit" name="action" value="Filtrar"/>
                    <input class="col-sm-2" type="submit" name="action" value="Export to pdf"/><% CreatePDF.run(); %>
                </div>
            </div>
        </form>
        <table class="table">
            <tr>
                <th> Edat</th>
                <th>GrupEdat</th>
                <th>Pes</th>
                <th>Talla</th>
                <th>Imc</th>
                <th>Classificacio</th>
                <th>Menarquia</th>
                <th>Menopausia</th>
                <th>Tipus de Menopausia</th>
            </tr>
            
             <c:if test="${error_pdf != ''}">
                    <h2>${error_pdf}</h2>
                </c:if>

            <c:if test="${result_filt != null}">
                <c:if test="${result_filt == ''}">
                    <h2>No hi ha cap coincidencies</h2>
                </c:if>
               
                <c:if test="${!(result_filt == '')}">
                    <c:forEach items="${result_filt}" var="patient">
                        <c:if test="${patient.idRegistre % 2 == 0}">
                            <tr bgcolor=#DCDCDC>
                            </c:if>
                            <c:if test="${patient.idRegistre % 2 == 1}">
                            <tr bgcolor=yellow>
                            </c:if>
                            <th>${patient.edat}</th>
                            <th>${patient.grupEdat}</th>
                            <th>${patient.pes}</th>
                            <th>${patient.talla}</th>
                            <th>${patient.imc}</th>
                            <th>${patient.classificacio}</th>
                            <th>${patient.menarquia}</th>
                            <th>${patient.menopausia}</th>
                            <th>${patient.tipusMenopausia}</th>
                        </tr>
                    </c:forEach> 
                </c:if>

            </c:if>

        </table>

    </body>
</html>
