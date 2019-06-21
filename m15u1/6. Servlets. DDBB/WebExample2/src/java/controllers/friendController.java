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
                    insertFriendForm(request, response);
                    break;
                case "Add Friend":
                    insertFriend(request, response);
                    break;
                case "Delete Friends":
                    deleteFriendForm(request, response);
                    break;
                case "deleteFriend":
                    deleteFriend(request, response);
                    break;
                case "Modify a Friend":
                    modifyFriendForm(request, response);
                    break;
                case "friendToEdit":
                    modifyFriend(request, response);
                    break;
                case "modifyF":
                    modifyF(request, response);
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
        catDAO = new CategoryDAO(ruta);
        Collection<Category> categories = catDAO.findAll();
        request.setAttribute("select_categories", categories);
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }

    private void insertFriend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        if (request.getParameter("friendName") != null && request.getParameter("friendPhone") != null
                && request.getParameter("friendAge") != null && request.getParameter("friendCategory") != null) {
            String friendName = request.getParameter("friendName");
            String friendPhone = request.getParameter("friendPhone");
            int friendAge = Integer.parseInt(request.getParameter("friendAge"));
            String friendCategory = request.getParameter("friendCategory");

            friendAdo = new FriendDAO(ruta);
            
            Friend newFriend = new Friend(0, friendCategory, friendName, friendPhone, friendAge);

            if (friendAdo.insert(newFriend) == 1) {
                request.setAttribute("success", "Friend " + friendName + " Successfully inserted :) !");
            } else {
                request.setAttribute("error", "Friend not inserted :( !");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("friend.jsp");
        }

    }

    private void deleteFriendForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException, ServletException {
        
        friendAdo = new FriendDAO(ruta);
        Collection<Friend> friends = friendAdo.findAll();

        if (friends.isEmpty()) {
            request.setAttribute("error", "There aren't friends");
        }

        request.setAttribute("friends", friends);
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
        
    }

    private void deleteFriend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String friend = request.getParameter("friend");
        String[] friendParams = friend.split(";");
        Friend newFriend = new Friend(Integer.parseInt(friendParams[0]), friendParams[1]);

        friendAdo = new FriendDAO(ruta);

        int rowsAffected = friendAdo.delete(newFriend);

        if (rowsAffected > 0) {
            request.setAttribute("success", "Friend " + newFriend.getName() + " DELETED ;) !");
        } else {
            switch (rowsAffected) {
                case -1:
                    request.setAttribute("error", "Friend not deleted due to a Constraint fail.");
                    break;
                case -2:
                    request.setAttribute("error", "Friend not deleted due to an Error, contact administrator.");
                    break;
                default:
                    response.sendRedirect("friend.jsp");
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }

    private void modifyFriendForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        friendAdo = new FriendDAO(ruta);
        Collection<Friend> friends = friendAdo.findAll();

        if (friends.isEmpty()) {
            request.setAttribute("error", "There aren't Friends");
        }

        request.setAttribute("friends", friends);
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);

    }
    
    private void modifyFriend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String friend = request.getParameter("friendMo");
        String[] friendParams = friend.split(";");
        Friend newFriend = new Friend(Integer.parseInt(friendParams[0]),friendParams[1], friendParams[2], friendParams[3], Integer.parseInt(friendParams[4]) );
        request.setAttribute("friendmodify", newFriend);
        
        catDAO = new CategoryDAO(ruta);
        Collection<Category> categories = catDAO.findAll();
        request.setAttribute("modify_categories", categories);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }

    private void modifyF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        if (request.getParameter("friendName") != null && request.getParameter("friendPhone") != null
                && request.getParameter("friendAge") != null && request.getParameter("friendCategory") != null) {
            int friendId = Integer.parseInt(request.getParameter("friendID"));
            String friendName = request.getParameter("friendName");
            String friendPhone = request.getParameter("friendPhone");
            int friendAge = Integer.parseInt(request.getParameter("friendAge"));
            String friendCategory = request.getParameter("friendCategory");
   
            Friend newFriend = new Friend(friendId, friendCategory, friendName, friendPhone, friendAge);
            
            friendAdo = new FriendDAO(ruta);
            
            int rowsAffected = friendAdo.modify(newFriend);

            if (rowsAffected > 0) {
                request.setAttribute("success", "Friend " + newFriend.getName() + " Successfully modified :) !");
            } else {
                request.setAttribute("error", "Friend not modified :( !");
            }
        } else {
            response.sendRedirect("friend.jsp");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("friend.jsp");
        dispatcher.forward(request, response);
    }

    
}
