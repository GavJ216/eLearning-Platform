package com.techelevator.dao;

import com.techelevator.model.Quiz;

import java.util.List;
import java.util.Map;

public interface QuizDao {

    List<Quiz> getAllQuizzes();

    Quiz getQuizById(int quizId);

    Quiz getQuizIdByName(String quizName);

    boolean createQuiz(String quizName, String quizDescription, Map<String, List<String>> questions);

    List<Quiz> getQuizzesByUserId();
}
