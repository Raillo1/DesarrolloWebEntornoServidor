/**
 * Resolver ecuaciones de 2º grado
 */
package Ejercicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloEcuacion.Ecuacion2Grado;

/**
 *
 * @author usuario
 */
@WebServlet(name = "Ejercicio4", urlPatterns = {"/Ejercicio4"})
public class Ejercicio4 extends HttpServlet {

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
        
        //Controlador
        boolean hayParametros = false;
        String error = "";
        String strA = request.getParameter("a");   
        String strB = request.getParameter("b");    
        String strC = request.getParameter("c");
        double a = 0;
        double b = 0;
        double c = 0;
        double[] solucion = null;
        
        if (strA != null) {
            hayParametros = true;
            try {
                a = Double.parseDouble(strA);             
                b = Double.parseDouble(strB);            
                c = Double.parseDouble(strC);
            } catch (NumberFormatException e) {
                error = "Debe introducir números reales";
            }
        }
        
        //Modelo
        if (hayParametros && error.isEmpty()) {
            Ecuacion2Grado ecuacion = new Ecuacion2Grado();
            solucion = ecuacion.resolver(a,b,c);
        }


        //Vista
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Ejercicio4</title>");
            out.println("<link rel='stylesheet' type='text/css' href='estilos/principal.css'/>");
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2>Ecuación de 2º grado</h2>");
            out.println("<br>");
            
            out.println("<form>");  
            out.println("<input type='number' name='a' required size='5' step='0.001' value='" + strA + "'>");        
            out.println("x<sup>2</sup> + ");
            out.println("<input type='number' name='b' required size='5' step='0.001' value='" + strB + "'>");        
            out.println("x + ");
            out.println("<input type='number' name='c' required size='5' step='0.001' value='" + strC + "'>");        
            out.println("= 0");
            out.println("<input type='submit' value='Resolver'>");        

            out.println("</form>");
            out.println("<br><br>");
            if (hayParametros) {
                if (error.isEmpty()) {
                    if (solucion.length == 2) {
                        out.println("<p>x<sub>1<sub> = " + solucion[0] + "</p>");            
                        out.println("<p>x<sub>2<sub> = " + solucion[1] + "</p>");

                    }/* else if (solucion.length == 1) {
                           out.println("<p>x<sub>1<sub> = " + solucion[0] + "</p>");            

                    } else {
                        out.println("<h3>La ecuacion no tiene soluciones reales</h3>");
                    }
                    */
                    else {
                        out.println("<div class='error'>" + error + "</div>");
                    }
                }
            }
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
