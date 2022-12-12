package com.techelevator.dao;

import com.techelevator.model.Question;
import com.techelevator.model.Quiz;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
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
    public List<Quiz> getAllQuizzes() {
        return null;
    }

    @Override
    public Quiz getQuizById(int quizId) {
        String sql = "SELECT * FROM quiz WHERE quiz_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, quizId);
        if (results.next()) {
            return mapRowToQuiz(results);
        } else {
            return null;
        }
    }

    @Override
    public Quiz getQuizIdByName(String quizName) {
        return null;
    }

    @Override
    public boolean createQuiz(String quizName, String quizDescription, Map<String, List<String>> questions) {
        return false;
    }

    @Override
    public List<Quiz> getQuizzesByUserId() {
        return null;
    }



    private Quiz mapRowToQuiz(SqlRowSet rs) {
        Quiz quiz = new Quiz();
        quiz.setQuizId(rs.getInt("quiz_id"));
        quiz.setQuizName(rs.getString("quiz_name"));
        quiz.setQuizDescription(rs.getString("quiz_description"));
//        List<Question> questions = quiz.getQuestionsByQuizId();
//        for (Question question : questions) {
//            quiz.getQuestions().add(question);
//        }
        return quiz;
    }

    }


