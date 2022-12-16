package com.techelevator.dao;

import com.techelevator.model.CourseListDto;
import com.techelevator.model.User;
import com.techelevator.model.UserCourseDto;

import java.util.List;
import java.util.Map;

public interface UserDao {

    List<User> findAll();

    User getUserById(int userId);

    User findByUsername(String username);

    int findIdByUsername(String username);

    User create(String firstName, String lastName, String password, String role);

    List<UserCourseDto> getUsersByCourseId(int courseId);

    boolean addUserToCourse(int userId, int courseId);

    void makeAdmin(String username);

    void markLessonCompleted(int lessonId, int userId);

    boolean checkLessonCompletion(int lessonId, int userId);

    double checkCourseCompletion(int courseId, int userId);

    double overallCourseProgress(int userId);

}
