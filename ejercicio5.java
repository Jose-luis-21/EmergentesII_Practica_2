/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author spncr
 */
@WebServlet(name = "ejercicio5", urlPatterns = {"/ejercicio5"})
public class ejercicio5 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<h1><center> Ejercicio N° 5</center></h1>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h3>MATRIZ FORMA CARACOL</h3>");
            
            
            int paso = 1, cont = 1;
            int a[][] = new int[50][50];
            
            out.println("<form action='' method='post'>");
            out.println("Matrix Size: ");
            out.println("<input type='number' name='tamanio' value='1' min='1' max='50'>");
            out.println("<br></br>");
            out.println("<input type='submit'>");
            out.println("</form><br>");
            
            int grado = Integer.parseInt(request.getParameter("tamanio"));

            for (int k = 0; k < grado; k++) {
                for (int j = 0; j < grado; j++) {
                    a[k][j] = 0;
                }
            }
            
            for (int i = 0; i < grado; i++) {

                if (paso == 1) {
                    for (int j = 0; j < grado; j++) {
                        if (a[i][j] == 0) {
                            a[i][j] = cont++;
                        }
                    }
                }
                paso++;

                if (paso == 2) {
                    for (int j = 0; j < grado; j++) {
                        if (a[j][grado - (i + 1)] == 0) {
                            a[j][grado - (i + 1)] = cont++;
                        }
                    }
                }

                paso++;
                if (paso == 3) {
                    for (int j = grado - 1; j >= 0; j--) {
                        if (a[grado - (i + 1)][j] == 0) {
                            a[grado - (i + 1)][j] = cont++;
                        }
                    }
                }
                paso++;

                if (paso == 4) {
                    for (int j = grado - 1; j >= 0; j--) {
                        if (a[j][i] == 0) {
                            a[j][i] = cont++;
                        }
                    }
                }
                paso = 1;

            }

            for (int ii = 0; ii < grado; ii++) {
                for (int j = 0; j < grado; j++) {
                    if (a[ii][j] < 10) {
                        out.print("0");
                    } 
                    out.println(a[ii][j] + "&emsp;");
                }
                out.println("<br>");
            }
            out.println("<br>");
            out.println("<a href='index.jsp'>Inicio</a>");
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
