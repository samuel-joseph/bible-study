package com.biblestudy.biblebackend.controller;

import com.biblestudy.biblebackend.dto.BibleVerseDTO;
import com.biblestudy.biblebackend.service.BibleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bible")
@CrossOrigin(origins = "*")
public class BibleController {

	private final BibleService bibleService;

	public BibleController(BibleService bibleService) {
		this.bibleService = bibleService;
	}

	@GetMapping("/verse")
	public ResponseEntity<BibleVerseDTO> getVerse(@RequestParam String reference) {
		return ResponseEntity.ok(bibleService.getVerseByReference(reference));
	}

	@GetMapping("/proverbs")
	public ResponseEntity<BibleVerseDTO> getProverbOfTheDay() {
		return ResponseEntity.ok(bibleService.getDailyProverb());
	}
}
