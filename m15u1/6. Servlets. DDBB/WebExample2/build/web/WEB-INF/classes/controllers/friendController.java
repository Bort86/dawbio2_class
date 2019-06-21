/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Friend;
import model.persist.CategoryDAO;
import model.persist.FriendDAO;

@WebServlet(name = "friendController", urlPatterns = {"/friendController"})
public class friendController extends HttpServlet {

    private FriendDAO friendAdo;
    private CategoryDAO catDAO;
    private String ruta;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doAction(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String action = request.getParameter("actionFriend");
        ruta = getServletContext().getRealPath("/WEB-INF/resources");

        if (action != null) {
            switch (action) {
                case "List all Friends":
                    listAll(request, response);
                    break;
                case "New Friend":
                    insertFriendForm(request,response);
                    break;
                case "insertFriend":
                    insertFriend(request, response);
                    break;
                case "Delete a Friend":
                    response.sendRedirect("friend.jsp?showFormDelete=1");
                    break;
                case "deleteFriend":
                    deleteFriend(request, response);
                    break;
                case "Modify a Friend":
                    response.sendRedirect("friend.jsp?choseToModify=1");
                    break;
                case "modifyFriend":
                    modifyFriendForm(request, response);
                    break;
                case "modify":
                    modify(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
            }

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
        try {
            doAction(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(friendController.class.getName()).log(Level.SEVERE, null, ex);
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
            doAction(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(friendController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void listAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        
        friendAdo = new FriendDAO(ruta);
        Collection<Friend> friends = friendAdo.findAll();
        request.setAttribute("friends", friends);
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insertFriendForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //montar una variable con las categorias y enviarla
        Collection<Category> categories = catDAO.findAll();
        request.setAttribute("categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFriend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    }

    private void deleteFriend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO
    }

    private void modifyFriendForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO

    }

    private void modify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO
    }

    

}
