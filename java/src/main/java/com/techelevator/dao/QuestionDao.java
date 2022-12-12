package com.techelevator.dao;

import java.util.List;

public interface QuestionDao {

    public List<QuestionDao> getQuestionsByQuizId(int quizId);

    boolean createQuestion(String question, String correctAnswer, List<String> options);
}
