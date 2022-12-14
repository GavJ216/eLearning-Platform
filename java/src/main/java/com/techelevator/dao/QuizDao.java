package com.techelevator.dao;

import com.techelevator.model.Question;
import com.techelevator.model.Quiz;

import java.util.List;
import java.util.Map;

public interface QuizDao {

    List<Question> getQuestionsByLessonId(int lessonId);

//    Question getQuestion(int number);

//    List<Quiz> getAllQuizzes();

//    Quiz getQuizByLessonId(int lessonId);

//    Quiz getQuizById(int quizId);

//    Quiz getQuizIdByName(String quizName);

//    Quiz createQuiz(Quiz quiz);

//    void deleteQuiz(int quizId);

//    List<Quiz> getQuizzesByUserId();
}
