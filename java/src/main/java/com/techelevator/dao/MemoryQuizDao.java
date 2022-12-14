//package com.techelevator.dao;
//
//import com.techelevator.model.Question;
//import com.techelevator.model.Quiz;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class MemoryQuizDao implements QuizDao {
//
//    private static List<Question> questions = new ArrayList<>();
////    private static List<String> options = new ArrayList<>({"A","B","C","D"});
//
//    public MemoryQuizDao() {
//        if (questions.size() == 0) {
//            setQuiz();
//        }
//    }
//
//
//    public Question getQuestion(int number){
//        Question thisQuestion = new Question();
//        for (Question question : questions) {
//            if (question.getNumber() == number) {
//                thisQuestion = questions.get(number - 1);
//            }
//        }
//        return thisQuestion;
//    }
//
//    @Override
//    public List<Question> getQuestions() {
//        return questions;
//    }
//
//    @Override
//    public Quiz getQuizByLessonId(int lessonId) {
//        return null;
//    }
//
//    @Override
//    public Quiz createQuiz(Quiz quiz) {
//        return null;
//    }
//
//    @Override
//    public List<Quiz> getQuizzesByUserId() {
//        return null;
//    }
//
//    private void setQuiz() {
//            List<String> answers = new ArrayList<>();
//            answers.add("A");
//            answers.add("B");
//            answers.add("C");
//            answers.add("D");
//
//        questions.add(new Question(1,"Question 1?","answer", answers));
//
//        questions.add(new Question(2,"Question 2?","this", answers));
//
//        questions.add(new Question(3,"Question 3?","that", answers));
//
//        questions.add(new Question(4,"Question 4?","these", answers));
//
//        questions.add(new Question(5,"Question 5?","those", answers));
//
//        questions.add(new Question(6,"Question 6?","eeny", answers));
//
//        questions.add(new Question(7,"Question 7?","meeny", answers));
//
//        questions.add(new Question(8,"Question 8?","miny", answers));
//
//        questions.add(new Question(9,"Question 9?","moe", answers));
//
//        questions.add(new Question(10,"Question 10?","GUH", answers));
//
//    }
//}
