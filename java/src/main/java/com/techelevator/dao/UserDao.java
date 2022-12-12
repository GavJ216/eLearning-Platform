package com.techelevator.dao;

import com.techelevator.model.CourseListDto;
import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    User create(String firstName, String lastName, String password, String role);

    List<User> getUsersByCourseId(int courseId);

    boolean addUserToCourse(int userId, int courseId);

    void makeAdmin(String username);

}
