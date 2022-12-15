package com.techelevator.model;

public class UserCourseDto {
    private User user;
    private double progress;

    public UserCourseDto(User user, double progress) {
        this.user = user;
        this.progress = progress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
