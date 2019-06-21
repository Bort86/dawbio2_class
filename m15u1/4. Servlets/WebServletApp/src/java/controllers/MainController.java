/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aleja
 */
@WebServlet(name = "MainController", urlPatterns = {"/main"})
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Ens preguntem si estem entrant per formulari
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "Clica":
                    escriuNom(request, response);
                    break;
            }
        } else {
            response.sendRedirect("index.jsp");
        }
        
        // Prints a "virtual" webpage
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet MainController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>El teu nom es " + request.getParameter("username") + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void escriuNom(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("username");
        //response.sendRedirect("response.jsp?nom=" + name + "&numero=4"); // HARD CODE! (example)
        
        List <String> llista = new ArrayList<>();
        llista.add("Barcelona");
        llista.add("Lleida");
        llista.add("Girona");
        
        /* Opcio b
        request.setAttribute("nom", name);
        request.setAttribute("numero", 4);
        request.setAttribute("list", llista);
        
        //declarar cap a on enviem les dades
        RequestDispatcher rd = request.getRequestDispatcher("response.jsp");
        
        //quina informacio li envies
        rd.forward(request, response);*/
       
       //Opcio C
       //recollint i donant nom a totes les variables de sessió
       HttpSession session = request.getSession();
       session.setAttribute("validate", name);
       session.setAttribute("numero", 4);
       session.setAttribute("list", llista);
       
       //no cal enviar res perque totes les variables de sessio estan gravades
       //al servidor
       response.sendRedirect("response.jsp");
    }

}
