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
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hieu Mau
 */
public class ManageQuizController extends HttpServlet {

    QuizDAO dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        dao = new QuizDAO();
    }

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
            User user = (User) session.getAttribute("account");

            String username = user.getUsername();

            //Get page number
            String page = request.getParameter("page");
            int numberOfPage = Integer.parseInt(page);
            //Number of records per page
            int numberOfRecord = 4;
            List<Question> list = dao.getQuestionByPage(username, numberOfRecord, numberOfPage);
            request.setAttribute("list", list);

            int amountOfQuestion = dao.getNumberOfQuestion(username);
            if (amountOfQuestion > 0) {
                request.setAttribute("page", Math.ceil((double) amountOfQuestion / numberOfRecord));
                request.setAttribute("numberOfQuestion", amountOfQuestion);
            } else {
                request.setAttribute("message", "Quiz bank is empty. You need to create new Questions");
            }
            
        } catch (Exception e) {
            System.err.println("ManagerController: " + e.getMessage());
        } finally{
            request.getRequestDispatcher("view/manageQuiz.jsp").forward(request, response);
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
