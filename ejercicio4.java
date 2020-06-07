
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ejercicio4", urlPatterns = {"/ejercicio4"})
public class ejercicio4 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Random aleatorio = new Random();
        
        int n1 = 1+ aleatorio.nextInt(6);
       
        int n2 = 1+ aleatorio.nextInt(6);
        
        int n = n1 +n2;
       
        String boton = request.getParameter("boton");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio N° 4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center> Ejercicio N° 4</center></h1>");
            out.println("<form action='' method='post'>");
            
            out.println("<input type='submit' value='Lanzar' name='boton'>");
            out.println("</form>");
            
            out.println("<h3>Instrucciones del juego</h3>");
            out.println("<h4>Pulsa el boton lanzar</h4>");
            out.println("<h4>Si la suma de los dados sale 7 o 11 ganas caso contraio perdiste</h4>");
            if(boton != null)
            {
            out.println("<h2> PrimerDado: "+n1+" SegundoDado: "+n2+"</h2>");
            }
            else
            {
                out.println("<h2>Lanza los Dados</h2>");
            }
            if (n == 7 || n == 11)
            {
                out.println("<h1>Ganaste</h1>");
            }
            else
            {
                out.println("<h1>Perdiste</h1>");
            }
            out.println("<br>");
            out.println("<a href='index.jsp'>Inicio</a>");    
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


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
