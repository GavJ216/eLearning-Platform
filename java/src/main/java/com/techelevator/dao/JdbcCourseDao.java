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
        return null;
    }

    @Override
    public Course getCourseByCourseId(int courseId) {
        return null;
    }

    @Override
    public Course getCourseByName(String courseName) {
        return null;
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
        return null;
    }

    @Override
    public void editCourse(int courseId) {

    }

    @Override
    public void deleteCourse(int courseId) {

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
