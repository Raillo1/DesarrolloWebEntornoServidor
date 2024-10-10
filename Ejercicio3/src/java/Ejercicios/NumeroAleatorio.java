/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Ejercicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author usuario
 */
@WebServlet(name = "NumeroAleatorio", urlPatterns = {"/NumeroAleatorio"})
public class NumeroAleatorio extends HttpServlet {

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
        
        int numeromin = 0;
        int numeromax = 0;
        int numeroAleatorio = 0;
        boolean hayParametros=false;
        
        
        if (request.getParameter("numeromin") != null) {
            numeromin = Integer.parseInt(request.getParameter("numeromin"));
            numeromax = Integer.parseInt(request.getParameter("numeromax"));
            hayParametros = true;
        }
        
        if (hayParametros) {
            numeroAleatorio = (int)(Math.random() * (numeromax-numeromin + 1)+numeromin);
        }

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NumeroAleatorio</title>");
            out.println("<link rel='stylesheet' type='text/css' href='estilos/principal.css'/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Generar número aleatorio </h1>");
            out.println("<form>");
            out.println("<label>Entre</label>");
            out.println("<input type='number name='numeromin' required />");
            out.println("<label>Hasta</label>");
            out.println("<input type='number name='numeromax' required />");

            out.println("<button>Generar</button>");
            if (hayParametros) {
                out.println("<h2>" + numeroAleatorio + "</h2>");
            }
            out.println("</form>");

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

}
