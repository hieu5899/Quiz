/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 * Document : Object Question include questionCode, questionContent, createdAt, option, answer
 * @author Hieu Mau
 */
public class Question {

    /**
     * Store question ID
     */
    private int questionCode;
    /**
     * Store Question content
     */
    private String questionContent;
    /**
     * Store created date
     */
    private String createdAt;
    /**
     * Store List of Option
     */
    private List<Option> option;
    /**
     * Store List of Answer
     */
    private List<Answer> answer;

    /**
     * Constructor
     */
    public Question() {
    }

    /**
     * Constructor
     *
     * @param questionCode
     * @param questionContent
     * @param createdAt
     * @param option
     * @param answer
     */
    public Question(int questionCode, String questionContent, String createdAt, List<Option> option, List<Answer> answer) {
        this.questionCode = questionCode;
        this.questionContent = questionContent;
        this.createdAt = createdAt;
        this.option = option;
        this.answer = answer;
    }

    public int getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(int questionCode) {
        this.questionCode = questionCode;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }
}
