package com.biblestudy.biblebackend.dto;

import java.util.List;

public class BibleVerseDTO {
    private String reference;
    private List<BibleApiVerse> verses;

    public BibleVerseDTO() {}

    public BibleVerseDTO(String reference, List<BibleApiVerse> verses) {
        this.reference = reference;
        this.verses = verses;
    }

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
