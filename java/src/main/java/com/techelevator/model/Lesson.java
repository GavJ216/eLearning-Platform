package com.techelevator.model;

public class Lesson {

    private int lessonId;
    private String lessonName;
    private String lessonDescription;


    public Lesson() {

    }

    public Lesson(int lessonId) {
        this.lessonId = lessonId;
    }


    public Lesson(int lessonId, String lessonName, String lessonDescription) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }
}