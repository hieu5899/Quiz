/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.QuizDAO;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hieu Mau
 */
public class MakeQuizController extends HttpServlet {

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
        request.getRequestDispatcher("view/makeQuiz.jsp").forward(request, response);
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
        //Get session with login account's infomation
        HttpSession session = request.getSession();
        QuizDAO quizDb = new QuizDAO();
        try {
            User user = (User) session.getAttribute("account");
            String username = user.getUsername();
            //Check input of question get from page
            String question = request.getParameter("question");
            if (question == "") {
                request.setAttribute("message", "Question can not null.");
                throw new ArithmeticException();
            }
            int questionId = 0;

            //Get array of option and answer
            String[] getOption = (String[]) request.getParameterValues("option");
            String[] getAnswer = (String[]) request.getParameterValues("answer");
            //Check options are null
            if ("".equals(getOption[0]) && "".equals(getOption[1]) && "".equals(getOption[2]) && "".equals(getOption[3])) {
                request.setAttribute("message", "Option can not null.");
                throw new ArithmeticException();
            }
            //Check answer is null
            if (getAnswer == null) {
                request.setAttribute("message", "Answer can not null.");
                throw new ArithmeticException();
            }

            //Add quiz to DB
            if (quizDb.addQuestion(question, username)) {
                questionId = quizDb.getQuestionID(question);
                System.out.println("Question ID: " + questionId);
            } else {
                request.setAttribute("message", "Add Question Failed");
                throw new ArithmeticException();
            }
            //Add options to DB
            for (int i = 0; i < getOption.length; i++) {
                if (!getOption[i].trim().equals("")) {
                    if (quizDb.addOption(questionId, i + 1, getOption[i])) {
                        System.out.println("Add " + getOption[i] + " successful.");
                    } else {
                        request.setAttribute("message", "Add Question Failed");
                        throw new ArithmeticException();
                    }
                }

            }
            //Add awswer to DB
            for (int i = 0; i < getAnswer.length; i++) {
                if (quizDb.addAnswer(questionId, Integer.parseInt(getAnswer[i]))) {
                    System.out.println("Add " + getAnswer[i] + " successful.");
                } else {
                    request.setAttribute("message", "Add Question False.");
                    throw new ArithmeticException();
                }
            }
            request.setAttribute("message", "Add Question Successful.");
        } catch (Exception e) {
            System.err.println("Exception from Make Quiz");
        } finally {
            request.getRequestDispatcher("view/makeQuiz.jsp").forward(request, response);
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
