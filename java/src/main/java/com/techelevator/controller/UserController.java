package com.techelevator.controller;

import com.techelevator.dao.CourseDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Course;
import com.techelevator.model.CourseListDto;
import com.techelevator.model.User;
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
    public List<User> getUsersByCourseId(@PathVariable int courseId) {
        return userDao.getUsersByCourseId(courseId);}

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "courses/{courseId}/{userId}", method = RequestMethod.POST)
    public boolean addUserToCourse(@PathVariable int userId, @PathVariable int courseId ) {
        userDao.addUserToCourse(userId, courseId);
        return true;

    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> findAll() {
        for (User user : userDao.findAll()) {
            System.out.println(user.getId());
            System.out.println(user.getFirstName());
            System.out.println(user.getLastName());
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        };
        return userDao.findAll();}

//    @RequestMapping(path = "/users/{userId}", method = RequestMethod.GET)
//    public User getUserById(@PathVariable int userId) {
//        return userDao.getUserById(userId);}

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(path = "/users/{username}", method = RequestMethod.PUT)
    public void makeAdmin(@RequestBody String username) {
        userDao.makeAdmin(username);
    }


}
