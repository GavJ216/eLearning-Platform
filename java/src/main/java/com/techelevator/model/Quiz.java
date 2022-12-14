package com.techelevator.model;

import java.util.List;
import java.util.Map;

public class Quiz {

        private List<Question> questions;

        public Quiz() {

        }

        public Quiz(List<Question> questions) {
            this.questions = questions;
        }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int size() {
            int size = questions.size();
            return size;
    }

    public Question getQuestion(int number) {
            Question thisQuestion = questions.get(number);
            return thisQuestion;
    }
}
