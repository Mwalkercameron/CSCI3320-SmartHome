/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controls;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import models.Thermostat;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Whoslala
 */
@WebServlet(name = "ThermostatCTL", urlPatterns = {"/ThermostatCTL"})
public class ThermostatCTL extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet thermostatCTL</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet thermostatCTL at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    /* These were other, but the examples in class were mainly used
        Nam Ha Minh
        03/11/2020
        Version N/A
        https://www.codejava.net/java-ee/servlet/handling-html-form-data-with-java-servlet
    
        Mukesh Kumar
        03/02/2014
        login.jsp Version N/A, LoginServlet.java Version N/A, web.xml Version N/A
        https://www.javawebtutor.com/articles/servlets/servlet_passing_parameter.php
    
        Prashant Srivastava
        N/A
        Version N/A
        https://www.javastudypoint.com/2018/10/get-data-from-html-form-in-servlet.html
    
        Begin With Java
        N/A
        Version N/A
        http://www.beginwithjava.com/servlet-jsp/servlet-basic/reading-form-get.html
    
        Edu 4 Java
        N/A
        Version N/A
        http://www.edu4java.com/en/servlet/servlet3.html
    
        Tutorials Point
        N/A
        Version N/A
        https://www.tutorialspoint.com/servlets/servlets-form-data.htm
    
        Oracle
        N/A
        Version N/A
        https://www.oracle.com/java/technologies/jpl1-writing-servlet.html
    
        Java T Point
        N/A
        register.html Version N/A, Register.java Version N/A, web.xml Version N/A
        https://www.javatpoint.com/example-of-registration-form-in-servlet
    
        Geeks for Geeks, priyarajtt
        02/02/2022
        Version N/A
        https://www.geeksforgeeks.org/servlet-form/
    
        Oracle
        02/10/2011
        Version N/A
        https://www.geeksforgeeks.org/servlet-form/
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        Thermostat thermostat = new Thermostat();
        String currentTemperature;
        currentTemperature = request.getParameter("temperature");
        boolean temperature = thermostat.adjustThermostat(currentTemperature);
        if (temperature) {
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("thermostat.jsp");
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
