package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Image;
import model.ImgDAO;
import model.User;
import model.UserDAO;

/**
 *
 * @author Pablo Rodriguez
 */
@WebServlet(name = "controller", urlPatterns = {"/user"})
public class controller extends HttpServlet {

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
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "Continua":
                    validateUsername(request, response);
                    break;
                case "Continua2":
                    validatePassword(request, response);
                    break;
            }
        /*} else if (request.getParameter("printar") != null) {

            printImg(request, response);*/

        } else {
            response.sendRedirect("index.jsp");
        }
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

    private void validateUsername(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        String ruta = getServletContext().getRealPath("/WEB-INF");
        UserDAO udao = new UserDAO(ruta);

        if (udao.findUsername(username)) {
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
            response.sendRedirect("login2.jsp");
        } else {
            request.setAttribute("error", "Usuario no encontrado, inténtelo de nuevo");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }

    }

    private void validatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("name");
        String password = request.getParameter("password");

        String ruta = getServletContext().getRealPath("/WEB-INF");
        UserDAO udao = new UserDAO(ruta);

        User u = new User(username, password);
        if (udao.findOne(u)) {
            
            request.setAttribute("error3", printImg());
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
            //response.sendRedirect("welcome.jsp");
        } else {
            request.setAttribute("error2", "Password erróneo, inténtelo de nuevo");
            RequestDispatcher rd = request.getRequestDispatcher("login2.jsp");
            rd.forward(request, response);
        }

    }
    
    //no he logrado pasar los datos del fichero alergies.txt a la siguiente pantalla
    // mi idea era guardar el id y el nombre en un array de objetos o string y pasarlos
    // en un atributo, pero no logro convertir dicho atributo en la página welcome
    private String printImg(){
        String ruta = getServletContext().getRealPath("/WEB-INF");
        ImgDAO idao = new ImgDAO(ruta);
        
        String list = idao.printAll().toString();
        return list;
        
    }


}
