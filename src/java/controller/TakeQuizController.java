/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Answer;
import entity.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/* 
    Document   : xử lí phần Take Quiz
    Created on : Nov 23, 2020, 8:07:17 AM
    Author     : ThangNQ
*/
public class TakeQuizController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //Khai báo questionIndex
            int questionIndex = 0;
            HttpSession session = request.getSession();
            try {
                //Lấy về questionIndex từ request, rồi lưu vào biến questionIndex
                if (request.getParameter("questionIndex") != null) {
                    questionIndex = Integer.parseInt(request.getParameter("questionIndex"));
                }
            } catch (NumberFormatException e) {
                questionIndex = 0;
            }

            //Lấy về list Question từ session, nếu list rỗng thì sẽ trở lại trang takeQuizNumber
            List<Question> list = new ArrayList<>();
            if(session.getAttribute("list") != null){
                list = (List<Question>) session.getAttribute("list");
            }else{
                request.getRequestDispatcher("view/takeQuizNumber.jsp").forward(request, response);
            }
            
            //Lần đầu lấy câu hỏi sẽ lấy thời gian
            if(session.getAttribute("questionIndex") == null){
                int totalTime = list.size() * (1 * 60 * 1000);
                long time = new Date().getTime() + totalTime;
                session.setAttribute("time", time);
            }
            
            
            Question currentQuestion = list.get(questionIndex);
            session.setAttribute("questionIndex", questionIndex);
            request.setAttribute("currentQuestion", currentQuestion);

            if (request.getParameter("answer") != null) {

                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();

                String[] x = {"0"};
                if (request.getParameterValues("answer") != null) {
                    x = (String[]) request.getParameterValues("answer");
                }

                for (String text : x) {
                    int number = Integer.parseInt(text);
                    if (number != 0) {
                        list1.add(number);
                    }
                }

                if (list1.isEmpty()) {
                    list1.add(0);
                }
                
                TreeSet<Integer> getAnswer = new TreeSet<>(list1);
                System.out.print("Answer from User: ");
                for (Integer integer : getAnswer) {
                    System.out.println(integer + " ");
                }

                Question question = currentQuestion;

                question.getAnswer();
                for (Answer answer : question.getAnswer()) {
                    list2.add(answer.getOptionCode());
                }
                
                TreeSet<Integer> getAnswer2 = new TreeSet<>(list2);
                System.out.print("Answer from Database: ");
                for (Integer integer : getAnswer2) {
                    System.out.println(integer + " ");
                }
                
                //Nếu đáp án người dùng chọn trùng với đáp án database thì sẽ tăng score, lưu score lại
                int score = (int) session.getAttribute("score");
                if (getAnswer.equals(getAnswer2)) {
                    score += 1;
                    session.setAttribute("score", score);
                }

                if (questionIndex + 1 == list.size()) {
                    
                    response.sendRedirect("timeout");
                } else {
                    session.setAttribute("questionIndex", questionIndex + 1);
                    Question question2 = list.get(questionIndex + 1);
                    request.setAttribute("currentQuestion", question2);
                    request.getRequestDispatcher("view/takeQuizQuestion.jsp").forward(request, response);
                }

            } else {
                request.getRequestDispatcher("view/takeQuizQuestion.jsp").forward(request, response);
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
