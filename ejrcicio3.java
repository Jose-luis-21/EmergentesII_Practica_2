
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ejrcicio3", urlPatterns = {"/ejrcicio3"})
public class ejrcicio3 extends HttpServlet {

  
       protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ejercicio N° 3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center> Ejercicio N° 3</center></h1>");
            out.println("<h1>Operaciones Basicas</h1>");
            out.println("<form action='' method='post'>");
            
            
            out.println("<label>Num1</label>");
            out.println("<input type='text' name='num1'>");
            out.println("<br></br>");
            out.println("<label>Num2</label>");
            out.println("<input type='text' name='num2'>");
            out.println("<br>");
            out.println("<br>");
            out.println("<label>Operador</label>");
            out.println("<select name='tipo'>");
            out.println("<option value=''></option>");
            out.println("<option value='suma'>Suma</option>");
            out.println("<option value='resta'>Resta</option>");
            out.println("<option value='multiplicacion'>Multiplicacion</option>");
            out.println("<option value='division'>Division</option>");
            out.println("</select>");
            
            out.println("<br></br>");
            out.println("<input type='submit' value='Procesar'>");
            out.println("</form>");
            out.println("<br>");
            out.println("<a href='index.jsp'>Inicio</a>");
            
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));
            String tipo = request.getParameter("tipo");
            
            
            if(tipo.equals("suma")){
                Integer resultado = num1 + num2;
                out.println("<h4>La suma es: " + resultado + "  </h4>");
            }
            else if(tipo.equals("resta")){
                Integer resultado = num1 - num2;
                out.println("<h4>La resta es: " + resultado + "  </h4>");
            }
            else if(tipo.equals("multiplicacion")){
               Integer resultado = num1 * num2;
                out.println("<h4>La multiplicacion es: " + resultado + "  </h4>");
            }
            else if(tipo.equals("division")){
                Integer resultado = num1 / num2;
                out.println("<h4>La division es: " + resultado + "  </h4>");
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
