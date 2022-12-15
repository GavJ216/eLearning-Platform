package com.techelevator.dao;

import com.techelevator.model.Course;

import java.util.List;
import java.util.Map;

public interface CourseDao {

        Course createCourse(Course course);

        Course getCourseByCourseId(int courseId);

        Course getCourseByName(String courseName);

        List<Course> listCourses();

        List<Course> listCoursesByUserId(int userId);

        List<Course> listCoursesByUsername(String username);

        void editCourse(Course course);

        void deleteCourse(int courseId);

        Map<Integer, Double> mapCourseProgress(String username);
        



}
