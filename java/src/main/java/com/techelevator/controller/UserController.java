package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Course;
import com.techelevator.model.CourseListDto;
import com.techelevator.model.User;
import com.techelevator.model.UserCourseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

public class UserController {

    private UserDao userDao;
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(path = "/{courseId}/users", method = RequestMethod.GET)
    public List<UserCourseDto> getUsersByCourseId(@PathVariable int courseId) {
        return userDao.getUsersByCourseId(courseId);}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "courses/{courseId}/{userId}", method = RequestMethod.POST)
    public boolean addUserToCourse(@PathVariable int userId, @PathVariable int courseId ) {
        userDao.addUserToCourse(userId, courseId);
        return true;

    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> findAll() {
        return userDao.findAll();}

    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        return userDao.getUserById(userId);}

    @RequestMapping(path = "/user/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable String username) {
        return userDao.findByUsername(username);}

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/users/{username}", method = RequestMethod.PUT)
    public void makeAdmin(@RequestBody String username) {
        userDao.makeAdmin(username);
    }

    @RequestMapping(path = "/{lessonId}/{userId}", method = RequestMethod.POST)
    public void markLessonCompleted(@PathVariable int lessonId, @PathVariable int userId) {
        userDao.markLessonCompleted(lessonId, userId);
    }

    @RequestMapping(path = "/{lessonId}/{userId}", method = RequestMethod.GET)
    public boolean checkLessonCompletion(@PathVariable int lessonId, @PathVariable int userId) {
        return userDao.checkLessonCompletion(lessonId, userId);
    }

    @RequestMapping(path = "/courses/{courseId}/users/{userId}", method = RequestMethod.GET)
    public double checkCourseCompletion(@PathVariable int courseId, @PathVariable int userId) {
        return userDao.checkCourseCompletion(courseId, userId);
    }

}
