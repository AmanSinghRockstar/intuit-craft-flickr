package com.intuit.test.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.intuit.test.model.ImageControllerSearchResponse;

@RequestMapping("/image")
@CrossOrigin
public interface ImageController {

	@GetMapping("/search")
	ImageControllerSearchResponse search(@RequestParam String query);
}
