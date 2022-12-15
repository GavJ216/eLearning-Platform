package com.techelevator.dao;

import com.techelevator.model.Course;
import com.techelevator.model.Lesson;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class  JdbcProgressDao implements ProgressDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcProgressDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void updateUserCourseProgress(int userId) {
        JdbcCourseDao courseDao = new JdbcCourseDao(this.getJdbcTemplate());
        JdbcLessonDao lessonDao = new JdbcLessonDao(this.getJdbcTemplate());
        JdbcUserDao userDao = new JdbcUserDao(this.getJdbcTemplate());


        List<Course> userCourses = courseDao.listCoursesByUserId(userId);
        for (Course course : userCourses) {
            List<Lesson> courseLessons = lessonDao.getAllLessonsByCourseId(course.getCourseId());
            double numberOfLessons = courseLessons.size();
            double completedLessons = 0;
            for (Lesson lesson : courseLessons) {
                if (userDao.checkLessonCompletion(lesson.getLessonId(), userId)) {
                    completedLessons ++;
                }
            }
            double courseCompletionPercentage = (completedLessons / numberOfLessons) * 100;

            String sql = "UPDATE users_course SET progress = ? WHERE user_id = ? AND course_id = ?;";

            jdbcTemplate.update(sql, courseCompletionPercentage, userId, course.getCourseId());

        }

    }
}
