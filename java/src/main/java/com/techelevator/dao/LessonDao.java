package com.techelevator.dao;

import com.techelevator.model.Lesson;

import java.util.List;

public interface LessonDao {

    List<Lesson> getAllLessonsByCourseId(int courseId);

    List<Lesson> getAllLessons();

    Lesson getLessonById(int lessonId);

    Lesson getLessonIdByName(String lessonName);

    Lesson createLesson(String lessonName, String lessonDescription);

    void deleteLesson(int lessonId);

    void editLesson(Lesson lesson);


}
