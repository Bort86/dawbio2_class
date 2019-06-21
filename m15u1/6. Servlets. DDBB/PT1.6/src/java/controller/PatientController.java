package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
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
import model.persist.PatientDAO;
import model.User;
import model.persist.UserDAO;
import utils.CreatePDF;

/**
 * Servlet for Patient Controller From here, the servlet will administrate 3
 * functions: index, filter and add patients
 *
 * @author Pablo Rodriguez
 */
@WebServlet(name = "patientController", urlPatterns = {"/patientController"})
public class PatientController extends HttpServlet {

    private String ruta;
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
                case "indexar":
                    indexar(response, request);
                    break;
                case "Filtrar":
                    filtrar(response, request);
                    break;
                case "Add Patient":
                    addPatient(response, request);
                    break;
                default:
                    response.sendRedirect("patientController?action=indexar");
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
            Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PatientController.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * Indexar: it will return all the patients from the database and send them
     * through a param
     *
     * @param response
     * @param request
     * @throws IOException
     * @throws ServletException
     * @throws ClassNotFoundException
     */
    private void indexar(HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException, ClassNotFoundException {
        Collection<Patient> result = new ArrayList();

        pdao = new PatientDAO(ruta);
        result = pdao.findAll();

        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
        rd.forward(request, response);
    }

    /**
     * Filtrar This method will receive the params for filter input It will
     * behave as an OR: this attribute OR this one
     *
     * @param response
     * @param request
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void filtrar(HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException, ClassNotFoundException {

        pdao = new PatientDAO(ruta);

        Collection<Patient> result = new ArrayList<>();

        String classificacio = request.getParameter("classificacio");
        String menopausia = request.getParameter("Menopausia");
        String tipusMenopausia = request.getParameter("tipusMenopausia");

        Patient filt_patient = new Patient();
        filt_patient.setClassificacio(classificacio);
        filt_patient.setMenopausia(menopausia);
        filt_patient.setTipusMenopausia(tipusMenopausia);

        result = pdao.filterPatient(filt_patient);

        request.setAttribute("result_filt", result);
        RequestDispatcher rd = request.getRequestDispatcher("filter_pac.jsp");
        rd.forward(request, response);
    }

    /**
     * addPatient: it will receive the patient's parameters and insert them in
     * the database
     *
     * @param response
     * @param request
     * @throws ServletException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void addPatient(HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException, ClassNotFoundException {

        pdao = new PatientDAO(ruta);
        String result = "";
        try {
            int edad = Integer.parseInt(request.getParameter("edad"));
            String grupEdat = request.getParameter("grupEdat");
            int peso = Integer.parseInt(request.getParameter("peso"));
            int talla = Integer.parseInt(request.getParameter("talla"));
            int menarquia = Integer.parseInt(request.getParameter("menarquia"));
            String classificacio = request.getParameter("classificacio");
            String menopausia = request.getParameter("Menopausia");
            String tipusMenopausia = request.getParameter("tipusMenopausia");
            double imc = peso / (talla / 100);

            Patient new_patient = new Patient(edad, grupEdat, peso, talla, imc,
                    classificacio, menarquia, menopausia, tipusMenopausia);

            if (pdao.insertPatient(new_patient) != 1) {
                result = "Error inserting in database, please try again.";
            } else {
                result = "New patient successfully added to database.";
            }

        } catch (Exception e) {
            result = e.toString();
        }

        request.setAttribute("result_addPat", result);
        RequestDispatcher rd = request.getRequestDispatcher("add_pac.jsp");
        rd.forward(request, response);

    }

   

}
