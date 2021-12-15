package com.intuit.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.test.model.ImageControllerSearchResponse;
import com.intuit.test.service.ImageService;

@RestController
@RequestMapping("/api/v1/image")
public class ImageControllerV1 implements ImageController {
	private ImageService imageService; 
	
	public ImageControllerV1(@Autowired final ImageService imageService) {
		this.imageService = imageService;
	}
	
	@Override
	public ImageControllerSearchResponse search(String query) {
		var response = imageService.getImagesWithTag(query);
		
		var apiResponse = new ImageControllerSearchResponse();
		apiResponse.setImageUri(new ArrayList<>(response.getImageLinks()));
		
		return apiResponse;
	}
	
}
