package com.techelevator.model;

import java.util.Collections;
import java.util.List;

public class Question {

    private int number;
    private String question;
    private String solution;
    private List<String> options;

    public Question() {

    }

    public Question(int number, String question, String solution, List<String> options) {
        this.number = number;
        this.question = question;
        this.solution = solution;
        this.options = options;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestionString(String question) {
        this.question = question;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "number=" + number +
                ", question='" + question + '\'' +
                ", solution='" + solution + '\'' +
                ", answers=" + options +
                '}';
    }
}
