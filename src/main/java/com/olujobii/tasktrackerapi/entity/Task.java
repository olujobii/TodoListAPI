package com.olujobii.tasktrackerapi.entity;

public class Task {

    private static int idGenerator = 1;
    private int id;
    private String title;
    private String description;

    public Task( String title, String description) {
        this.id =idGenerator++;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
