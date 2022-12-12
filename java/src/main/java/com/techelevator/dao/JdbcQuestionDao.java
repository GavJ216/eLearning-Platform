package com.techelevator.dao;

import com.techelevator.model.Question;
import com.techelevator.model.Quiz;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcQuestionDao {

//        private final JdbcTemplate jdbcTemplate;
//
//        public JdbcQuestionDao(JdbcTemplate jdbcTemplate) {
//            this.jdbcTemplate = jdbcTemplate;
//        }
//
//        @Override
//        public List<Question> getQuestionsByQuizId(int questionId) {
//            String sql = "SELECT * FROM question WHERE question_id =?;";
//            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, questionId);
//            if (results.next()) {
//                return mapRowtoQuestion(results);
//            } else {
//                return null;
//            }
//        }
//
//        @Override
//        public Question createQuestion() {
//            return null;
//        }
//
//        private Question mapRowToQuestion(SqlRowSet rs) {
//            Question question = new Question();
//            question.setQuestion(rs.getString("question"));
//            question.setCorrectAnswer(rs.getString("answer"));
//            for (String option : options) {
//
//            }
//            question.setOptions(rs.);
//        }
}
