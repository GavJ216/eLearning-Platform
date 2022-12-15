package com.techelevator.controller;


import com.techelevator.dao.CourseDao;
import com.techelevator.model.Course;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
        return courseDao.getCourseByCourseId(courseId);
    }

    @RequestMapping(path ="/{courseName}", method = RequestMethod.GET)
    public Course getCourseByName(@PathVariable String courseName) {
        return courseDao.getCourseByName(courseName);
    }

    @RequestMapping(path ="/courses/user/{userId}", method = RequestMethod.GET)
    public List <Course> listCoursesByUserId(@PathVariable int userId) {
        return courseDao.listCoursesByUserId(userId);
    }

    @RequestMapping(path ="/{username}/courses", method = RequestMethod.GET)
    public List <Course> listCoursesByUsername(@PathVariable String username) {
        return courseDao.listCoursesByUsername(username);
    }

    @RequestMapping(path = "/course/{courseId}", method = RequestMethod.PUT)
    public void editCourse(@RequestBody Course course, @PathVariable int courseId) {
        courseDao.editCourse(course);
    }


    @RequestMapping(path = "/course/{courseId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int courseId) {
        courseDao.deleteCourse(courseId);
    }

    @RequestMapping(path = "/courses/progress/{username}", method = RequestMethod.GET)
    public Map<Integer, Double> mapCourseProgress(@PathVariable String username) {
        return courseDao.mapCourseProgress(username);
    }

}
