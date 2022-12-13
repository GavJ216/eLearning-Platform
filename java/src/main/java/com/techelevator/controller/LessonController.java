package com.techelevator.controller;

import com.techelevator.dao.LessonDao;
import com.techelevator.model.Lesson;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LessonController {

    private LessonDao lessonDao;

    public LessonController(LessonDao lessonDao) {
        this.lessonDao = lessonDao;}

    @RequestMapping(path = "/course/{courseId}/lessons", method = RequestMethod.GET)
    public List<Lesson> getAllLessonsByCourseId(@PathVariable int courseId) {return lessonDao.getAllLessonsByCourseId(courseId);}

    @RequestMapping(path = "/lessons", method = RequestMethod.GET)
    public List<Lesson> getAllLessons() {return lessonDao.getAllLessons();}

    @RequestMapping(path = "/lessons/{lessonId}", method = RequestMethod.GET)
    public Lesson getLessonById(@PathVariable int lessonId) {return lessonDao.getLessonById(lessonId);}

    @RequestMapping(path = "/lesson/{lessonName}", method = RequestMethod.GET)
    public Lesson getLessonIdByName(@PathVariable String lessonName) {return lessonDao.getLessonIdByName(lessonName);}

    @RequestMapping(path = "/lessons", method = RequestMethod.POST)
    public Lesson createLesson(@RequestBody Lesson lesson) {return lessonDao.createLesson(lesson.getLessonName(), lesson.getLessonDescription());}

    @RequestMapping(path = "/lessons/{lessonId}", method = RequestMethod.DELETE)
    public void deleteLesson(@PathVariable int lessonId) {lessonDao.deleteLesson(lessonId);}

  @RequestMapping(path = "/lesson/{lessonId}", method = RequestMethod.PUT)
    public void editLesson(@RequestBody Lesson lesson, @PathVariable int lessonId) {lessonDao.editLesson(lesson);}

    }

