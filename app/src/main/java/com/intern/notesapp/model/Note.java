package com.intern.notesapp.model;

public class Note {
    private int id;
    private String title;
    private String note;
    private String date;
    private String color;
    private String textColor;

    public Note(String title, String note, String date, String color) {
        this.title = title;
        this.note = note;
        this.date = date;
        this.color = color;
    }
    public Note(int id, String title, String note, String date, String color) {
        this.title = title;
        this.note = note;
        this.id = id;
        this.date = date;
        this.color = color;
    }
    public Note() {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }
    public String getTextColor() { return textColor; }

    public void setTextColor(String color) { this.textColor = color; }
}
