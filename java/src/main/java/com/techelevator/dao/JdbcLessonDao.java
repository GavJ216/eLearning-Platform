package com.techelevator.dao;

import com.techelevator.model.Course;
import com.techelevator.model.Lesson;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLessonDao implements LessonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLessonDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Lesson> getAllLessonsByCourseId(int courseId) {
        List<Lesson> lessons = new ArrayList<>();
        String sql = "SELECT * FROM lesson WHERE course_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        while (results.next()) {
            Lesson lesson = mapRowToLesson(results);
            lessons.add(lesson);
        }
        return lessons;
    }

    @Override
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        String sql = "SELECT * FROM lesson";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Lesson lesson = mapRowToLesson(results);
            lessons.add(lesson);
        }
        return lessons;
    }
//
    @Override
    public Lesson getLessonById(int lessonId) {
        Lesson lesson = new Lesson();

        String sql = "SELECT * FROM lesson WHERE lesson_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, lessonId);
        while (results.next()) {
            lesson = mapRowToLesson(results);
        }

        return lesson;
    }
//
    @Override
    public Lesson getLessonIdByName(String lessonName) {
        Lesson lesson = new Lesson();

        String sql = "SELECT * FROM lesson WHERE lesson_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, lessonName);
        while (results.next()) {
            lesson = mapRowToLesson(results);

        }
        return lesson;
    }
//
    @Override
    public Lesson createLesson(String lessonName, String lessonDescription) {
        String sql = "INSERT INTO lesson (lesson_name, lesson_description) " +
                "VALUES (?, ?) RETURNING lesson_id;";

        Integer newLessonId = jdbcTemplate.queryForObject(sql, Integer.class, lessonName , lessonDescription);
        if (newLessonId == null) {
            System.out.println("No lesson ID returned.");
            return null;
        }
        else {
            Lesson newLesson = new Lesson(newLessonId);
            System.out.println("New lesson created");
            return newLesson;
        }


    }

    @Override
    public void deleteLesson(int lessonId) {
        String sql1 = "DELETE FROM lesson WHERE lesson_id = ?";
            jdbcTemplate.update(sql1, lessonId);
    }

    @Override
    public void editLesson(Lesson lesson) {
        String sql = "UPDATE lesson SET lesson_name = ?, lesson_description =? WHERE lesson_id = ?";
        jdbcTemplate.update(sql, lesson.getLessonName(), lesson.getLessonDescription(), lesson.getLessonId());

    }


    private Lesson mapRowToLesson(SqlRowSet rs) {
        Lesson lesson = new Lesson();
        lesson.setLessonId(rs.getInt("lesson_id"));
        lesson.setLessonName(rs.getString("lesson_name"));
        lesson.setLessonDescription(rs.getString("lesson_description"));
        return lesson;
    }


}
