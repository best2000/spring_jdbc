package dev.danvega.model;

public class Course {

    private int id;
    private String title;
    private String teacherId;

    public Course(int id) {
    }

    public Course(String title, String teacherId) {
        this.title = title;
        this.teacherId = teacherId;
    }

    public Course() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}