/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import entity.Question;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hieu Mau
 */
public class TimeOutController extends HttpServlet {

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
         try {
            HttpSession session = request.getSession();
            List<Question> list = (List<Question>) session.getAttribute("list");
            
            int amount = list.size();
            int score = (int) session.getAttribute("score");
            double total = (double) (score * 10) / amount;
            DecimalFormat df = new DecimalFormat("#.##");
            //Check result
            if (total > 5) {
                //If result > 5 -> Passed
                request.setAttribute("result", df.format(total) + " (" + df.format(total * 10) + "%)" + " - Passed");
            } else {
                //If result <= 5 -> Not pass
                request.setAttribute("result", df.format(total) + " (" + df.format(total * 10) + "%)" + " - Not passed");
            }
            User user = (User) session.getAttribute("account");
            
            QuizDAO dao = new QuizDAO();
            dao.addResult( user.getUsername(), (float) total);
            
            session.removeAttribute("questionIndex");
            session.removeAttribute("list");
            session.removeAttribute("score");
        } catch (Exception e) {
            System.err.println("Exception From Time Out Result");
        } finally {
            request.getRequestDispatcher("view/takeQuizResult.jsp").forward(request, response);
        }

    }

    
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
