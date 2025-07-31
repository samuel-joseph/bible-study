package com.biblestudy.biblebackend.dto;

import java.util.List;

public class BibleApiResponse {
    private String reference;
    private List<BibleApiVerse> verses;

    public BibleApiResponse() {}

    public String getReference() {
        return reference;
    }

    public List<BibleApiVerse> getVerses() {
        return verses;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setVerses(List<BibleApiVerse> verses) {
        this.verses = verses;
    }
}
