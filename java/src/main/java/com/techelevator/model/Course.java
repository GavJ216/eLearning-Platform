package com.techelevator.model;

public class Course {

    private int courseId;
    private String courseName;
    private String courseDescription;
    private String difficulty;

    public Course() {

    }

    public Course(int courseId) {
        this.courseId = courseId;

    }

    public Course(int courseId, String courseName, String courseDescription, String difficulty) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.difficulty = difficulty;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

}
