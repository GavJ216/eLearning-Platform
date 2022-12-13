package com.techelevator.model;

public class Lesson {

    private int lessonId;
    private String lessonName;
    private String lessonDescription;
    private boolean lessonCompletion;


    public Lesson() {

    }

    public Lesson(int lessonId) {
        this.lessonId = lessonId;
    }


    public Lesson(int lessonId, String lessonName, String lessonDescription, boolean lessonCompletion) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.lessonDescription = lessonDescription;
        this.lessonCompletion = lessonCompletion;
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

    public boolean isLessonCompletion() {
        return lessonCompletion;
    }

    public void setLessonCompletion(boolean lessonCompletion) {
        this.lessonCompletion = lessonCompletion;
    }
}