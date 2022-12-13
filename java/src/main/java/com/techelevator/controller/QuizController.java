package com.techelevator.controller;

import com.techelevator.dao.LessonDao;
import com.techelevator.dao.QuizDao;
import com.techelevator.model.Lesson;
import com.techelevator.model.Quiz;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuizController {

        private QuizDao quizDao;

    public QuizController(QuizDao quizDao) {
            this.quizDao = quizDao;}

        @RequestMapping(path = "/lessons/{lessonId}/quiz", method = RequestMethod.GET)
        public Quiz getQuizByLessonId(@PathVariable int lessonId) {return quizDao.getQuizByLessonId(lessonId);}

        @RequestMapping(path = "/quizzes", method = RequestMethod.GET)
        public List<Quiz> getAllQuizzes() {return quizDao.getAllQuizzes();}
//
        @RequestMapping(path = "/quizzes/{quizId}", method = RequestMethod.GET)
        public Quiz getQuizById(@PathVariable int quizId) {return quizDao.getQuizById(quizId);}
//
//        @RequestMapping(path = "/lesson/{lessonName}", method = RequestMethod.GET)
//        public Lesson getLessonIdByName(@PathVariable String lessonName) {return lessonDao.getLessonIdByName(lessonName);}
//
        @RequestMapping(path = "/quizzes", method = RequestMethod.POST)
        public Quiz createQuiz(@RequestBody Quiz quiz) {return quizDao.createQuiz(quiz);}
//
        @RequestMapping(path = "/quizzes/{quizId}", method = RequestMethod.DELETE)
        public void deleteQuiz(@PathVariable int quizId) {quizDao.deleteQuiz(quizId);}
//
//        @RequestMapping(path = "/lesson/{lessonId}", method = RequestMethod.PUT)
//        public void editLesson(@RequestBody Lesson lesson, @PathVariable int lessonId) {lessonDao.editLesson(lesson);}
}
