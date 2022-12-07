package com.techelevator.controller;


import com.techelevator.dao.CourseDao;
import com.techelevator.model.Course;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    private CourseDao courseDao;

    public CourseController(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @RequestMapping(path = "/courses", method = RequestMethod.GET)
    public List<Course> listCourses() { return courseDao.listCourses();}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/courses", method = RequestMethod.POST)
    public Course createCourse(@RequestBody Course course) { return courseDao.createCourse(course);}

    @RequestMapping(path ="/course/{courseId}", method = RequestMethod.GET)
    public Course getCourseByCourseId(@PathVariable int courseId) {
        Course course = courseDao.getCourseByCourseId(courseId);
        return course;
    }

    @RequestMapping(path ="/{courseName}", method = RequestMethod.GET)
    public Course getCourseByName(@PathVariable String courseName) {
        Course course = courseDao.getCourseByName(courseName);
        return course;
    }

    @RequestMapping(path ="/{userId}/courses", method = RequestMethod.GET)
    public List <Course> listCoursesByUserId(@PathVariable int userId) {
        List <Course> courses = courseDao.listCoursesByUserId(userId);
        return courses;
    }

    @RequestMapping(path = "/course/{courseId}", method = RequestMethod.PUT)
    public void editCourse(@RequestBody Course course, @PathVariable int courseId) {
        courseDao.editCourse(course);
    }

    @RequestMapping(path = "/course/{courseId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int courseId) {
        courseDao.deleteCourse(courseId);
    }

}
