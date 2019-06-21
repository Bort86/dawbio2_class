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
import model.Patient;
import model.User;
import model.persist.PatientDAO;
import model.persist.UserDAO;

/**
 *
 * @author Pablo Rodriguez
 */
@WebServlet(name = "userController", urlPatterns = {"/userController"})
public class UserController extends HttpServlet {

    private String ruta;
    private UserDAO udao;
    private PatientDAO pdao;

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
                    response.sendRedirect("patientController?action=indexar");
                    break;
            }
        }
    }

    /**
     * login: it will receive the user's keys and validate them in the database
     *
     * @param response
     * @param request
     * @throws IOException
     * @throws ServletException
     * @throws ClassNotFoundException
     */
    private void login(HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException, ClassNotFoundException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        udao = new UserDAO(ruta);
        User u = new User(username, password);

        if (udao.findOne(u) != null) {
            Collection<Patient> result = new ArrayList();
            pdao = new PatientDAO(ruta);
            result = pdao.findAll();

            HttpSession session = request.getSession();
            session.setAttribute("rol", u.getRol());

            request.setAttribute("result", result);
            RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);

        } else {
            request.setAttribute("error", 1);
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * addUser
     * It will add a new user: it will check if params are right, and will
     * always add a rol=basic user
     * @param response
     * @param request
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ServletException 
     */
    private void addUser(HttpServletResponse response, HttpServletRequest request)
            throws IOException, ClassNotFoundException, ServletException {

        //Initialize attributes and route to ddbb
        udao = new UserDAO(ruta);
        String result;
        String rol = "basic";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatedPass = request.getParameter("repeatedPass");

        //check possible errors
        List<String> errors = new ArrayList<>();
        // if username or password are empty
        if (username == "" || password == "") {
            errors.add("Empty fields, please try again");
        }
        // if pass is not repeated
        if (!password.equals(repeatedPass)) {
            errors.add("Wrong repeated password, please try again");
        }
        // if there is any whitespace
        String checkWhite = username + password + repeatedPass;
        if (checkWhite.contains(" ")) {
            errors.add("Whitespaces are not allowed in username or password");
        }
        if (udao.findRepeated(username)) {
            errors.add("Username already exists, please try another one");
        }
        // if there are any errors, they are returned in a list
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher("add_user.jsp");
            rd.forward(request, response);
            // if there aren't any errors, we proceed to add the user
        } else {

            User user = new User(username, password, rol);

            if (udao.insertUser(user) != 1) {
                result = "Error inserting in database, please try again.";
            } else {
                result = "New user successfully added to database.";
            }

            request.setAttribute("success1", result);
            RequestDispatcher rd = request.getRequestDispatcher("add_user.jsp");
            rd.forward(request, response);

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
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
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

}

