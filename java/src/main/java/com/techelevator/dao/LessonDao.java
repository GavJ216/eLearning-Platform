package com.techelevator.dao;

import com.techelevator.model.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getAllLessons();

    Lesson getLessonById();

    Lesson getLessonIdByName();

    boolean createLesson(String lessonName, String lessonDescription);


}
