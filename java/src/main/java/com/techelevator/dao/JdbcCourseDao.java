package com.techelevator.dao;

import com.techelevator.model.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCourseDao implements CourseDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCourseDao(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    @Override
    public Course createCourse(Course course) {
        String sql = "INSERT INTO course (course_name, course_description, difficulty, cost) " +
                "VALUES (?, ?, ?, ?) RETURNING course_id;";

        Integer newCourseId = jdbcTemplate.queryForObject(sql, Integer.class, course.getCourseName(), course.getCourseDescription(), course.getDifficulty(), course.getCost());
        if (newCourseId == null) {
            System.out.println("Error: No course could not be created");
            return null;
        }
        else {
            Course newCourse = new Course(newCourseId);
            System.out.println("New Course created");
            return newCourse;
        }
    }

    @Override
    public Course getCourseByCourseId(int courseId) {
        Course course = new Course();

        String sql = "SELECT * from COURSE WHERE course_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseId);
        while (results.next()) {
            course = mapRowToCourse(results);

        }
        return course;
    }

    @Override
    public Course getCourseByName(String courseName) {
        Course course = new Course();

        String sql = "SELECT * from COURSE WHERE course_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, courseName);
        while (results.next()) {
            course = mapRowToCourse(results);

        }
        return course;
    }

    @Override
    public List<Course> listCourses(){
        List<Course> courses = new ArrayList<>();
        String sql = "select * from course";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Course course = mapRowToCourse(results);
            courses.add(course);
        }

        return courses;
    }

    @Override
    public List<Course> listCoursesByUserId(int userId){
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT course.course_id, course_name, course_description, difficulty, cost FROM course " +
                "JOIN user_course ON user_course.course_id = course.course_id " +
                "JOIN user ON user.user_id = user_course.user_id " +
                "WHERE user.user_id =?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,userId);
        while (results.next()) {
            Course course = mapRowToCourse(results);
            courses.add(course);
        }

        return courses;
    }

    @Override
    public void editCourse(Course course) {

        String sql = "UPDATE course SET course_name = ?, course_description = ?, difficulty = ?, cost = ? WHERE course_id = ?;";
        jdbcTemplate.update(sql, course.getCourseName(),course.getCourseDescription(),course.getDifficulty(), course.getCost(), course.getCourseId());

    }

    @Override
    public void deleteCourse(int courseId) {
        String sql1 = "DELETE FROM user_course WHERE course_id =?";
                jdbcTemplate.update(sql1, courseId);

        String sql2 = "DELETE FROM course WHERE course_id =?;";
       int numberOfCoursesDeleted = jdbcTemplate.update(sql2, courseId);

    }

    private Course mapRowToCourse(SqlRowSet result) {
        Course course = new Course();
        course.setCourseId(result.getInt("course_id"));
        course.setCourseName(result.getString("course_name"));
        course.setCourseDescription(result.getString("course_description"));
        course.setDifficulty(result.getString("difficulty"));
        course.setCost(result.getBigDecimal("cost"));
        return course;

    }
}
