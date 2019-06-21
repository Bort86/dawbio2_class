<%@page import="org.jfree.chart.ChartFactory" %>
<%@page import="org.jfree.chart.ChartUtilities" %>
<%@page import="org.jfree.chart.JFreeChart" %>
<%@page import="java.io.File" %>
<%@page import="org.jfree.chart.plot.*" %>
<%@page import="java.io.*" %>
<%@page import="org.jfree.data.category.DefaultCategoryDataset" %>
<%  // Create a simple Bar chart
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(5, "Compras", "Enero");
        dataset.setValue(7, "Compras", "Febrero");
        dataset.setValue(9, "Compras", "Marzo");
        dataset.setValue(5, "Compras", "Abril");
        dataset.setValue(10, "Compras", "Mayo");
        dataset.setValue(10, "Compras", "Junio");
        dataset.setValue(10, "Compras", "Julio");
        dataset.setValue(1, "Compras", "Agosto");
        dataset.setValue(2, "Compras", "Septiembre");
        dataset.setValue(10, "Compras", "Octubre");
        dataset.setValue(10, "Compras", "Noviembre");
        dataset.setValue(1, "Compras", "Diciembre");
        JFreeChart chart = ChartFactory.createBarChart("Llamadas Mensuales","2011", "Numero de Llamadas", dataset, PlotOrientation.VERTICAL, false,true, false);
 
        try {
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            ChartUtilities.writeChartAsPNG(os, chart, 625, 500);
 
 
        } catch (IOException e) {
            System.err.println("Error creando grafico.");
        }
%>