/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.persist.CategoryDAO;

/**
 *
 * @author Pablo Rodriguez
 */
@WebServlet(name = "categoryController", urlPatterns = {"/categoryController"})
public class categoryController extends HttpServlet {

    private String ruta;
    private CategoryDAO catdao;

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
            throws ServletException, IOException, SQLException {

        ruta = getServletContext().getRealPath("/WEB-INF/resources");
        catdao = new CategoryDAO(ruta);

        if (request.getParameter("actionCategory") != null) {
            String action = request.getParameter("actionCategory");
            switch (action) {
                case "List all categories":
                    listAll(request, response);
                    break;
                case "Insert a category":
                    insertForm(request, response);
                    break;
                case "Add Category":
                    addCategory(request, response);
                    break;
                case "Modify Categories":
                    modifyCategoriesForm(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
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
        } catch (SQLException ex) {
            Logger.getLogger(categoryController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(categoryController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        //llama al método de turno en el modelo
        List<Category> categorias = catdao.listAll();
        //cargo el objeto request
        request.setAttribute("categories", categorias);
        RequestDispatcher dis = request.getRequestDispatcher("category.jsp");
        dis.forward(request, response);
    }

    private void insertForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("category.jsp?showFormAdd");
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("catName") != null) {
            String categoryName = request.getParameter("catName");

            catdao = new CategoryDAO(ruta);
            Category newCat = new Category(categoryName);

            if (catdao.insert(newCat) == 1) {
                request.setAttribute("success", "Category " + categoryName + " Successfully inserted :) !");
            } else {
                request.setAttribute("error", "Category not inserted :( !");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("category.jsp");
        }
    }

    private void modifyCategoriesForm(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        catdao = new CategoryDAO(ruta);
        List<Category> cats = catdao.listAll();

        if (cats.isEmpty()) {
            request.setAttribute("error", "There aren't categories");
        }

        request.setAttribute("categories", cats);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp");
        dispatcher.forward(request, response);
    }

}
