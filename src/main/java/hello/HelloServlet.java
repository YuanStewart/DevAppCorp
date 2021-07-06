/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
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
        
        String msg = "";
        
        String lang = request.getParameter("lang");
        
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
            case "de":
                msg = "Hallo,";
                break;
            case "es":
                msg = "Hola,";
                break;
            case "hl":
                msg = "Hallo,";
                break;
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
        String msg = "";
        
        String lang = request.getParameter("lang");
        TipoDeSaudacao saudacao;
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                saudacao = new TipoDeSaudacao("Bom dia, ", "Boa tarde, ", "Boa noite, ");
                break;
            case "en":
                saudacao = new TipoDeSaudacao("Good morning, ", "Good afternoon, ", "Good night, ");
                break;
            case "fr":
                saudacao = new TipoDeSaudacao("Bonjour, ", "Bon après-midi, ", "Bonne nuit, ");
                break;
            case "de":
                saudacao = new TipoDeSaudacao("Guten morgen, ", "Guten tag, ", "Gute nacht, ");
                break;
            case "es":
                saudacao = new TipoDeSaudacao("Buen día, ", "Buenas tardes, ", "Buenas noches, ");
                break;
            case "hl":
                saudacao = new TipoDeSaudacao("Goedemorgen", "Goedenmiddag", "Welterusten");
                break;
            default:
                saudacao = new TipoDeSaudacao("","","");
                break;
        }
        
        ZonedDateTime now =ZonedDateTime.now();
        int horaAtual = now.getHour();
        String parteDoDia;
                if (horaAtual > 5 && horaAtual < 12){
                    parteDoDia = saudacao.getDia();
                }else if (horaAtual >= 12 && horaAtual <19){
                    parteDoDia = saudacao.getTarde();
                }else{
                    parteDoDia = saudacao.getNoite();
                }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        msg = parteDoDia+nome+"!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='style.css'>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
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
