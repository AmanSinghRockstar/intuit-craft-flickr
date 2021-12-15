package com.intuit.test.model;

import java.util.ArrayList;
import java.util.List;

public class ImageServiceResponse {
	private List<String> imageLinks = new ArrayList<>();

	public List<String> getImageLinks() {
		return imageLinks;
	}

	public void setImageLinks(List<String> imageLinks) {
		this.imageLinks = imageLinks;
	}
}
