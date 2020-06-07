
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ejercicio2", urlPatterns = {"/ejercicio2"})
public class ejercicio2 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio N° 2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center> Ejercicio N° 2</center></h1>");
            out.println("<form action='' method='post'>");
            out.println("<label>Convertir</label>");
            
            out.println("<select name='tipo'>");
            out.println("<option value=''></option>");
            out.println("<option value='dolares'>Bolivianos a Dolares</option>");
            out.println("<option value='bolivianos'>Dolares a Bolivianos </option>");
            out.println("</select>");
            out.println("<br>");
            out.println("<br>");
            out.println("<label>Monto</label>");
            out.println("<input type='text' name='monto'>");
            out.println("<br></br>");
            out.println("<input type='submit' value='convertir'>");
            out.println("</form>");
            out.println("<br>");
            out.println("<a href='index.jsp'>Inicio</a>");
            
          
            float monto = Float.parseFloat(request.getParameter("monto"));
            String tipo = request.getParameter("tipo");
            float cotizacion = 6.92f;
            
            if(tipo.equals("dolares")){
                float cambio = monto / cotizacion;
                out.println("<h4>El tipo de cambio es: " + cambio + " $us. </h4>");
            }
            else if(tipo.equals("bolivianos")){
                float cambio = monto * cotizacion;
                out.println("<h4>El tipo de cambio es: " + cambio + " Bs. </h4>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}