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
}
