/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import utilities.Validation;

import model.User;
import model.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alumne
 */
@WebServlet(name = "UserController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {
 private String ruta;
 private UserDAO udao;
 
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
        ruta= getServletContext().getRealPath("/WEB-INF");
        udao= new UserDAO(ruta);
        if(request.getParameter("action")!=null){
            String action=request.getParameter("action");
            switch(action){
                case "Validate":
                    login(request,response);
                    break;
                case "Register":
                    register(request,response);
                    break;
                
            }
            
            
        }else{
            response.sendRedirect("index.jsp");
        }
        
        
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
     
        //recogemos desde el formulario
        String username=request.getParameter("username");
        String password=request.getParameter("password"); 
       
        //le pasamos los valores al constructor
        User u=new User(username,password);
       
       
        //paso 1: llamar a UserDAO
        //calcula el path para legar a WEB-INF
        
        //paso 2: UserDAO comprobaría si está o no y se lo diría al controlador
        
        if(udao.findOne(u)){
            
            //crear una variable de sesion
            HttpSession session=request.getSession();
            session.setAttribute("name", username);
            
            response.sendRedirect("welcome.jsp");
            
            
        }else{
            
            response.sendRedirect("login.jsp?error=1");
            
        }
    
    
    }
    private String metodo1(){
      return "Hola";  
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

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
//recogemos desde el formulario
        String username=request.getParameter("username");
        String password=request.getParameter("password"); 
        String repassword=request.getParameter("repassword"); 
        
        String messages="";
        //obligatorietat d'escriure els 3 camps
        if(!username.equals("") && !password.equals("") && !repassword.equals("")){
            //validamos los posibles errores
            if(!password.equals(repassword)) messages +="La contrasenyes no coincideixen";
                     
            //validar mida mínima del password a 6 caràcters
            if(!Validation.minimSize(password,6)) messages +="<br>La mida mínima és 6 caràcters";
            
            //se podrían hacer mas validaciones
            //por ejemplo:validar que hi hagin lletres i números al username
            
            
            
            //cuando llego a este punto NO HAY errores
            if(messages.equals("")){
                User u=new User (username,password);
                //ACCESO AL ARCHIVO            
                int returned=udao.addUser(u);
                if(returned==-1)messages="El usuario ya existe";
                else if(returned==0)messages="Problemas con el fichero";
                else messages="Usuario insertado correctamente";
            }
            
        }else{
           messages += "Tots els camps han d'estar omplerts";
        }
        
       //response.sendRedirect("register.jsp?error="+messages);
              
       request.setAttribute("error",messages);
       RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
       rd.forward(request, response);
        
    
    }

    

}
