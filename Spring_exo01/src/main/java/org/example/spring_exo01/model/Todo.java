package org.example.spring_exo01.model;

public class Todo {
    public String name;
    public String description;
    public String isDone;

    public Todo(String name, String description, String isDone) {
        this.name = name;
        this.description = description;
        this.isDone = isDone;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String isDone() {
        return isDone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(String done) {
        isDone = done;
    }
}
