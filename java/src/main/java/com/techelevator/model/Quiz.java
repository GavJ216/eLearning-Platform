package com.techelevator.model;

import java.util.List;
import java.util.Map;

public class Quiz {

        private int quizId;
        private String quizName;
        private String quizDescription;
        private List<Question> questions;


        public Quiz() {

        }

        public Quiz(int quizId) {
            this.quizId = quizId;
        }

        public Quiz(int quizId, String quizName, String quizDescription, List<Question> questions) {
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
