package com.techelevator.controller;


import com.techelevator.dao.CourseDao;
import com.techelevator.dao.LessonDao;
import com.techelevator.dao.ProgressDao;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProgressController {
    private ProgressDao progressDao;

    public ProgressController(ProgressDao progressDao) {
        this.progressDao = progressDao;
    }

    @RequestMapping(path = "/courses/users/{userId}", method = RequestMethod.PUT)
    public void updateUserCourseProgress(@PathVariable int userId) {
        progressDao.updateUserCourseProgress(userId);
    }
}
