package com.biblestudy.biblebackend.dto;

public class BibleApiVerse {
    private int verse;
    private String text;

    public BibleApiVerse() {}

    public int getVerse() {
        return verse;
    }

    public String getText() {
        return text;
    }

    public void setVerse(int verse) {
        this.verse = verse;
    }

    public void setText(String text) {
        this.text = text;
    }
}
