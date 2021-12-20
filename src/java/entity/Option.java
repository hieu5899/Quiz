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
public class Option {
    /**
     * Store question ID
     */
    private int questionCode;
    /**
     * Store option code
     */
    private int optionCode;
    /**
     * Store option content
     */
    private String optionContent;

    /**
     * Constructor
     */
    public Option() {
    }

    /**
     * Constructor
     * @param questionCode
     * @param optionCode
     * @param optionContent
     */
    public Option(int questionCode, int optionCode, String optionContent) {
        this.questionCode = questionCode;
        this.optionCode = optionCode;
        this.optionContent = optionContent;
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

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }
}
