package com.techelevator.model;

import java.util.List;

public class Quiz {

        private int quizId;
        private String quizName;
        private String quizDescription;
        private List<String> questions;


        public Quiz() {

        }

        public Quiz(int quizId) {
            this.quizId = quizId;
        }

        public Quiz(int quizId, String quizName, String quizDescription, List<String> questions) {
            this.quizId = quizId;
            this.quizName = quizName;
            this.quizDescription = quizDescription;
            this.questions = questions;
        }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizDescription() {
        return quizDescription;
    }

    public void setQuizDescription(String quizDescription) {
        this.quizDescription = quizDescription;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }
}
