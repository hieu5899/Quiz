/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Hieu Mau
 */
public class Answer {

    /**
     * Store Question ID
     */
    private int questionCode;
    /**
     * Store option Code
     */
    private int optionCode;
    /**
     * Constructor
     */
    public Answer() {
    }
    /**
     * Constructor
     *
     * @param questionCode
     * @param optionCode
     */
    public Answer(int questionCode, int optionCode) {
        this.questionCode = questionCode;
        this.optionCode = optionCode;
    }

    public int getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(int questionCode) {
        this.questionCode = questionCode;
    }

    public int getOptionCode() {
        return optionCode;
    }

    public void setOptionCode(int optionCode) {
        this.optionCode = optionCode;
    }
}
