package com.intuit.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FlickrImageServiceTests {
	
	@Autowired
	private ImageService flickrImageService;

	@Test
	void getImagesWithTag_shouldWork() {
		var response = flickrImageService.getImagesWithTag("forest");
		
		Assertions.assertNotNull(response);
	}
}
