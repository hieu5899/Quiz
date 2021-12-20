/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Answer;
import entity.Option;
import entity.Question;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hieu Mau
 */
public class QuizDAO extends dbcontext.DBContext {

    /**
     * Get a list of quiz include options and answers
     *
     * @param numberOfQuestion
     * @return list of question
     */
    public List<Question> getNumberQuestionForQuiz(int numberOfQuestion) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy"); 
        List<Question> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "SELECT TOP (?) [questionCode],[questionContent],[createdAt] FROM [Questions]";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, numberOfQuestion);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("questionCode");
                list.add(new Question(
                        rs.getInt("questionCode"),
                        rs.getString("questionContent"),
                        df.format(rs.getDate("createdAt")),
                        getOption(id),
                        getAnswer(id)
                ));
                System.out.println("Get Question: " + id);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * Get list option of every questions
     *
     * @param id
     * @return list of option
     */
    public List<Option> getOption(int id) {
        List<Option> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "Select * from [Options] where questionCode = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Option(
                        rs.getInt("questionCode"),
                        rs.getInt("optionCode"),
                        rs.getString("optionContent")
                ));
            }
            System.out.println("Option from question: " + id);
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * Get list answer of every question
     *
     * @param id
     * @return list of answer
     */
    public List<Answer> getAnswer(int id) {
        List<Answer> list = new ArrayList<>();
        ResultSet rs = null;
        String sql = "Select * from [Answers] where questionCode = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Answer(
                        rs.getInt("questionCode"),
                        rs.getInt("optionCode")
                ));
            }
            System.out.println("Answer from question: " + id);
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * Get list of Question for Manage Quiz
     *
     * @param username
     * @param amount
     * @param pageNumber
     * @return list of question
     */
    public List<Question> getQuestionByPage(String username, int amount, int pageNumber) {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        List<Question> list = new ArrayList<>();
        ResultSet rs = null;
        int start = (pageNumber * amount) - (amount - 1);
        int end = (pageNumber * amount);

        String sql = " select * \n"
                + "  from (select ROW_NUMBER() OVER (ORDER BY questionCode) AS ID,* from Questions where username = ?) as R\n"
                + "  where R.ID between ? and ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, start);
            ps.setInt(3, end);

            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("questionCode");
                list.add(new Question(
                        rs.getInt("questionCode"),
                        rs.getString("questionContent"),
                        df.format(rs.getDate("createdAt")),
                        getOption(id),
                        getAnswer(id)
                ));
                System.out.println("Get Question: " + id);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    /**
     * Get amount of question follow by username
     *
     * @param username
     * @return amount of question
     */
    public int getNumberOfQuestion(String username) {
        ResultSet rs = null;
        String sql = "SELECT COUNT(questionCode) as number FROM Questions where username = ?";
        int number = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                number = rs.getInt("number");
            }
            return number;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    /**
     * Add new Question
     *
     * @param question
     * @param username
     * @return true if add successfully
     */
    public boolean addQuestion(String question, String username) {
        String sql = "insert into [Questions]([questionContent],[createdAt],[username])\n"
                + " values (?,GETDATE(),?)";
        int check = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, question);
            ps.setString(2, username);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    /**
     * Get ID of question
     *
     * @param questionContent
     * @return id
     */
    public int getQuestionID(String questionContent) {
        ResultSet rs = null;
        String sql = "select questionCode from Questions where questionContent = ?";
        int number = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, questionContent);
            rs = ps.executeQuery();
            while (rs.next()) {
                number = rs.getInt("questionCode");
            }
            return number;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return 0;
    }

    /**
     * Add new option into DB
     *
     * @param questionCode
     * @param optionCode
     * @param optionContent
     * @return true if add successfully
     */
    public boolean addOption(int questionCode, int optionCode, String optionContent) {
        String sql = "  insert into [Options]([questionCode],[optionCode],[optionContent])\n"
                + "  values(?,?,?)";
        int check = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, questionCode);
            ps.setInt(2, optionCode);
            ps.setString(3, optionContent);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    /**
     * Add new answer intoDB
     *
     * @param questionCode
     * @param answer
     * @return true if add successfully
     */
    public boolean addAnswer(int questionCode, int answer) {
        String sql = "insert into [Answers]([questionCode],[optionCode])\n"
                + "  values(?,?)";
        int check = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, questionCode);
            ps.setInt(2, answer);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {

            return check > 0;
        }
    }

    /**
     * Add Result into DB
     * @param name
     * @param score
     * @return true if add successfully
     */
    public boolean addResult(String name, float score) {
        ResultSet rs = null;
        String sql = "  insert into [Result]([userName],[score],[submitTime])\n"
                + "  values (?, ? , GETDATE())";
        int check = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setFloat(2, score);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }
    
    /**
     * Check existed question
     *
     * @param username
     * @param password
     * @return Question if existed
     */
    public Question checkQuestion(int questionCode) {
        ResultSet rs = null;
        String sql = "  SELECT * FROM [Questions] where questionCode = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, questionCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Question(rs.getInt("questionCode"),
                        rs.getString("questionContent"), 
                        rs.getString("createdAt"), 
                        new ArrayList<Option>(), 
                        new ArrayList<Answer>());
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    
    /**
     * Delete Question, Options and Answers
     * @param questionCode
     * @return true when delete successfully
     */
    public boolean deleteQuestion(int questionCode){
        int checkQues = 0;
        int checkAnswer = 0;
        int checkOption = 0;
        String sqlDelAns = "DELETE FROM [Answers] where questionCode = ?";
        String sqlDelOpt = "DELETE FROM [Options] where questionCode = ?";
        String sqlDelQues = "DELETE FROM [Questions] where questionCode = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlDelAns);
            ps.setInt(1, questionCode);
            checkAnswer = ps.executeUpdate();
            ps = connection.prepareStatement(sqlDelOpt);
            ps.setInt(1, questionCode);
            checkOption = ps.executeUpdate();
            ps = connection.prepareStatement(sqlDelQues);
            ps.setInt(1, questionCode);
            checkQues = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checkQues > 0 && checkAnswer > 0 && checkOption > 0;
    }
}
