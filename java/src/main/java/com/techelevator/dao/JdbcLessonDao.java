package com.techelevator.dao;

import com.techelevator.model.Lesson;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcLessonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLessonDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}

//    @Override
//    public List<Lesson> getAllLessons() {
//        return null;
//    }
//
//    @Override
//    Lesson getLessonById() {
//        return null;
//    }
//
//    @Override
//    Lesson getLessonIdByName() {
//        return null;
//    }
//
//    @Override
//    boolean createLesson(String lessonName, String lessonDescription) {
//        return false;
//    }

    private Lesson mapRowToLesson(SqlRowSet rs) {
        Lesson lesson = new Lesson();
        lesson.setLessonId(rs.getInt("lesson_id"));
        lesson.setLessonName(rs.getString("lesson_name"));
        lesson.setLessonDescription(rs.getString("lesson_description"));
        return lesson;
    }


}
