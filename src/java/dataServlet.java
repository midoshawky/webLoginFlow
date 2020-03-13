/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author shawky
 */
@WebServlet(urlPatterns = {"/dataServlet"})
public class dataServlet extends HttpServlet {
        Cookie UserNameCk;
        Cookie PasswordCk;
        String Username = null, Password = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            Cookie ckLst[] = request.getCookies();
            if (ckLst == null || ckLst.length == 0) {
                UserNameCk = new Cookie("UserName", request.getParameter("UserName"));
                PasswordCk = new Cookie("Password", request.getParameter("password"));
                UserNameCk.setMaxAge(600);
                PasswordCk.setMaxAge(600);
                 response.addCookie(UserNameCk);
                 response.addCookie(PasswordCk);
                for (Cookie i : ckLst) {
                    if (i.getName().equals("UserName")) {
                        Username=i.getValue();
                    }
                    if (i.getName().equals("Password")) {
                        Password=i.getValue();
                    }
                }
            } else {
                for (Cookie ckLst1 : ckLst) {
                    if (ckLst1.getName().equals("UserName")) {
                        Username = ckLst1.getValue();
                    }
                    if (ckLst1.getName().equals("Password")) {
                        Password = ckLst1.getValue();
                    }
                }
            }
        } catch (NullPointerException e) {

        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dataServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>"+Username+"</h1>");
            out.println("<h1>"+Password+"</h1>");
            out.println("</center>");
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
