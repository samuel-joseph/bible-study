package com.biblestudy.biblebackend.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/bible")
@CrossOrigin(origins = "*")
public class BibleController {

	private final RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/verse")
	public ResponseEntity<?> getVerse(@RequestParam String reference) {
		try {
			// 🔒 Safe URI building & encoding
			URI uri = UriComponentsBuilder
				.fromHttpUrl("https://bible-api.com/" + reference)
				.build()
				.encode()
				.toUri();

			String response = restTemplate.getForObject(uri, String.class);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("Error fetching verse: " + e.getMessage());
		}
	}
}
