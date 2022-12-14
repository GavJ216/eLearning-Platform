package com.techelevator.dao;

import com.techelevator.model.Question;
import com.techelevator.model.Quiz;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class JdbcQuizDao implements QuizDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcQuizDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Question> getQuestionsByLessonId(int lessonId) {
        List<Question> questions = new ArrayList<>();

        String sql = "SELECT * FROM lesson_question WHERE lessonId = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, lessonId);
        while (results.next()) {
            questions.add(mapRowToQuestion(results));
        }
        return questions;
    }

//    @Override
//    public List<Quiz> getAllQuizzes() {
//        List<Quiz> quizzes = new ArrayList<>();
//        String sql = "SELECT * FROM quiz";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//        while (results.next()) {
//            Quiz quiz = mapRowToQuiz(results);
//            quizzes.add(quiz);
//        }
//        return quizzes;
//    }

//    @Override
//    public Quiz getQuizById(int quizId) {
//        String sql = "SELECT * FROM quiz WHERE quiz_id = ?";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, quizId);
//        if (results.next()) {
//            return mapRowToQuiz(results);
//        } else {
//            return null;
//        }
//    }

//    @Override
//    public Quiz getQuizIdByName(String quizName) {
//        return null;
//    }

    //TO DO: update Lesson table then update Select statement
//    @Override
//    public Quiz getQuizByLessonId(int lessonId) {
//        Quiz quiz = new Quiz();
//        String sql = "SELECT * FROM lesson WHERE lesson_id = ?";
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, lessonId);
//        while (results.next()) {
//            quiz = mapRowToQuiz(results);
//        }
//        return quiz;
//    }

//    Question getQuestion(int number);

//    @Override
//    public Quiz createQuiz(Quiz quiz) {
//        String sql = "INSERT INTO quiz (quiz_name, quiz_description) VALUES (?,?) RETURNING quiz_id;";
//
//        Integer newQuizId = jdbcTemplate.queryForObject(sql, Integer.class, quiz.getQuizName(), quiz.getQuizDescription());
//        if (newQuizId == null) {
//            System.out.println("Error: Quiz could not be created");
//            return null;
//        }
//        Quiz newQuiz = new Quiz(newQuizId);
//        System.out.println("New Quiz Created");
//        return newQuiz;
//    }

//    @Override
//    public List<Quiz> getQuizzesByUserId() {
//        return null;
//    }

//    @Override
//    public void deleteQuiz(int quizId) {
//        String sql = "DELETE FROM quiz WHERE quiz_id = ?;";
//        jdbcTemplate.update(sql, quizId);
//    }


//    private Quiz mapRowToQuiz(SqlRowSet rs) {
//        Quiz quiz = new Quiz();
//        quiz.setQuizId(rs.getInt("quiz_id"));
//        quiz.setQuizName(rs.getString("quiz_name"));
//        quiz.setQuizDescription(rs.getString("quiz_description"));
////        List<Question> questions = quiz.getQuestionsByQuizId();
////        for (Question question : questions) {
////            quiz.getQuestions().add(question);
////        }
//        return quiz;
//    }

    private Question mapRowToQuestion(SqlRowSet rs) {
        Question question = new Question();
        question.setNumber(rs.getInt("question_number"));
        question.setQuestionString(rs.getString("question"));
        question.setSolution(rs.getString("solution"));
        question.getOptions().add(rs.getString("solution"));
        question.getOptions().add(rs.getString("wrong_choice_1"));
        question.getOptions().add(rs.getString("wrong_choice_2"));
        question.getOptions().add(rs.getString("wrong_choice_3"));
//        List<Question> questions = quiz.getQuestionsByQuizId();
//        for (Question question : questions) {
//            quiz.getQuestions().add(question);
//        }
        return question;

    }
}


