package com.biblestudy.biblebackend.service;

import com.biblestudy.biblebackend.dto.BibleApiResponse;
import com.biblestudy.biblebackend.dto.BibleApiVerse;
import com.biblestudy.biblebackend.dto.BibleVerseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@Service
public class BibleService {

    private final RestTemplate restTemplate = new RestTemplate();

    public BibleVerseDTO getVerseByReference(String reference) {
        String responseReference = reference.trim();
        BibleApiResponse response = fetchVerseFromApi(responseReference);
        return new BibleVerseDTO(responseReference, response.getVerses());
    }

    public BibleVerseDTO getDailyProverb() {
        int day = LocalDate.now().getDayOfMonth(); // 1–31
        String reference = "Proverbs " + day;
        BibleApiResponse response = fetchVerseFromApi(reference);
        return new BibleVerseDTO(reference, response.getVerses());
    }

    private BibleApiResponse fetchVerseFromApi(String reference) {
        URI uri = UriComponentsBuilder
            .fromHttpUrl("https://bible-api.com/" + reference)
            .build()
            .encode()
            .toUri();

        return restTemplate.getForObject(uri, BibleApiResponse.class);
    }
}
