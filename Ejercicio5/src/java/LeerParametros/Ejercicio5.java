package LeerParametros;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Ejercicio5", urlPatterns = {"/Ejercicio5"})
public class Ejercicio5 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String urlCompleta = request.getRequestURL().toString();
            String urlParametros = request.getQueryString();

            String[] partesCabecera = urlCompleta.split("\\?")[0].split("/");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio5</title>");
            out.println("</head>");
            out.println("<body>");

            //Cabecera
            out.println("<h2>Cabecera de la URL</h2>");
            out.println("<table border='1'>");
            out.println("<tr>"
                    + "<th>Parte de la Cabecera</th>"
                    + "<th>Valor</th>"
                    + "</tr>");
            for (int i = 0; i < partesCabecera.length; i++) {
                out.println("<tr>");
                out.println("<td>Parte " + (i + 1) + "</td>");
                out.println("<td>" + partesCabecera[i] + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            //Tipo de petición
            String tipo = request.getMethod();
            out.println("<h2>Tipo de petición: " + tipo + "</h2>");

            //Valores de la URL
            if (urlParametros != null) {
                out.println("<h2>Parámetros de la URL</h2>");
                out.println("<table border='1'>");
                out.println("<tr>"
                        + "<th>Nombre del Parámetro</th>"
                        + "<th>Valor</th>"
                        + "</tr>");

                String[] parametros = urlParametros.split("&");
                for (String param : parametros) {
                    String[] Valores = param.split("=");
                    String nombre = Valores[0];
                    String valor = "";
                    if (Valores.length > 1) {
                        valor = Valores[1];
                    }

                    out.println("<tr>");
                    out.println("<td>" + nombre + "</td>");
                    out.println("<td>" + valor + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("<p>No hay parámetros en la URL.</p>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
