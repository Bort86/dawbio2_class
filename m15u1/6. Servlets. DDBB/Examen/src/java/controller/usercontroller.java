/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Image;
import model.User;
import model.persist.ImgDAO;
import model.persist.UserDAO;

/**
 *
 * @author Pablo Rodriguez
 */
@WebServlet(name = "usercontroller", urlPatterns = {"/usercontroller"})
public class usercontroller extends HttpServlet {

    private String ruta;
    private UserDAO udao;
    private ImgDAO imgdao;

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
            throws ServletException, IOException, ClassNotFoundException {
        if (request.getParameter("action") != null) {
            String action = request.getParameter("action");
            ruta = getServletContext().getRealPath("/WEB-INF/resources");
            switch (action) {
                case "login":
                    login(response, request);
                    break;
                case "Add User":
                    addUser(response, request);
                    break;
                default:
                    response.sendRedirect("controller?action=indexar");
                    break;
            }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usercontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(usercontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void login(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException, ClassNotFoundException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        udao = new UserDAO(ruta);
        User u = new User(username, password);

        if (udao.findOne(u) != null) {

            HttpSession session = request.getSession();
            session.setAttribute("role", u.getRole());
            
            imgdao = new ImgDAO(ruta);
            List<Image> list_image = new ArrayList();
            list_image = imgdao.findAll();

            request.setAttribute("list_image", list_image);
            RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
            rd.forward(request, response);

        } else {
            request.setAttribute("error", 1);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

    private void addUser(HttpServletResponse response, HttpServletRequest request) throws IOException, ClassNotFoundException, ServletException {
        udao = new UserDAO(ruta);
        String result;
        String rol = "basic";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatedPass = request.getParameter("repeatedPass");
        String email = username + "@google.es";
        String address = "Carrer " + username;        

        
        List<String> errors = new ArrayList<>();
        
        if (username.length()<=4) {
            errors.add("Min Username length is 4");
        }
        if (password.length()<=8) {
            errors.add("Min Password length is 8");
        }
        // if pass is not repeated
        if (!password.equals(repeatedPass)) {
            errors.add("Wrong repeated password, please try again");
        }
        if (!password.matches("[a-zA-Z0-9]*")){
            errors.add("Password can only have letters 'n numbers");
        }
                
        // if there are any errors, they are returned in a list
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher("add_user.jsp");
            rd.forward(request, response);
            // if there aren't any errors, we proceed to add the user
        } else {

            User user = new User(username, password, rol, email, address);

            if (udao.insertUser(user) != 1) {
                result = "Error inserting in database, please try again.";
            } else {
                result = "New user successfully added to database.";
            }

            request.setAttribute("success1", result);
            
            RequestDispatcher rd = request.getRequestDispatcher("controller?action=indexar");
            rd.forward(request, response);
            

        }
    }

}
