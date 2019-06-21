/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.persist.FriendDAO;

@WebServlet(name = "friendController", urlPatterns = {"/friendController"})
public class friendController extends HttpServlet {

    private FriendDAO friendAdo;

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
            throws ServletException, IOException {
        String action = request.getParameter("actionFriend");

        if (action != null) {
            switch (action) {
                case "List all Friends":
                    listAll(request, response);
                    break;
                case "New Friend":
                    response.sendRedirect("friend.jsp?showFormAdd=1");
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
        doAction(request, response);
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
        doAction(request, response);
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
            throws ServletException, IOException {

        // TODO
    }

    private void insertFriend(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO

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
