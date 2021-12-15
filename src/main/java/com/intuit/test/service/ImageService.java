package com.intuit.test.service;

import com.intuit.test.model.ImageServiceResponse;

public interface ImageService {

	ImageServiceResponse getImagesWithTag(String tag);
}
