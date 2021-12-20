/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import entity.Question;
import java.io.IOException;
import java.io.PrintWriter;
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
public class GetRandomQuiz extends HttpServlet {

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
        request.getRequestDispatcher("view/takeQuizNumber.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        QuizDAO dao = new QuizDAO();
        try {
            //Get amount of quizes
            String x = request.getParameter("number");
            int numberOfQuestion = 0;
            try {
                numberOfQuestion = Integer.parseInt(x);
            } catch (Exception e) {
                numberOfQuestion = 0;
            }
            //Check input
            if (numberOfQuestion <= 0) {
                request.setAttribute("message", "Enter number more than 0 and a number.");
                request.getRequestDispatcher("view/takeQuizNumber.jsp").forward(request, response);
            }

            //Get list questions from DB
            List<Question> list = dao.getNumberQuestionForQuiz(numberOfQuestion);
            if (!list.isEmpty()) {
                //Calculating time limit when 1 quiz 1 minute
                int totalTime = numberOfQuestion * (1 * 60 * 1000);
                int hour = (int) Math.floor(totalTime / (60 * 60 * 1000));
                int minute = (int) Math.floor((totalTime % (60 * 60 * 1000)) / (60 * 1000));
                int second = (int) Math.floor((totalTime % (60 * 60 * 1000)) % (60 * 1000));

                session.setAttribute("score", 0);
                session.setAttribute("list", list);
                request.setAttribute("questionNumber", numberOfQuestion);
                //Show time limit for user
                request.setAttribute("time", "" + hour + ":" + minute + ":" + second);
            } else {
                request.setAttribute("message", "Load Question False !!");
            }
        } catch (Exception e) {
            System.err.println("Exception From Get Check Get Question: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("view/checkGetQuiz.jsp").forward(request, response);
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
