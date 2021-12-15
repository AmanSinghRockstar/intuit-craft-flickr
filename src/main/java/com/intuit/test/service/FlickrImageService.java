package com.intuit.test.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.intuit.test.config.FlickrConfig;
import com.intuit.test.model.FlickrPhotosPublicFeed;
import com.intuit.test.model.ImageServiceResponse;
import com.intuit.test.utilities.UriHelper;

@Service
public class FlickrImageService implements ImageService {
	private static final String IMAGE_TAG_KEY = "tag";
	private static final String ENCLOSURE_REL = "enclosure";
	private static final String IMAGE_JPEG_TYPE = "enclosure";
	
	private final RestTemplate restTemplate;
	private final FlickrConfig config;
	
	public FlickrImageService(
			@Autowired final RestTemplate restTemplate,
			@Autowired final FlickrConfig config) {
		this.restTemplate = restTemplate;
		this.config = config;
	}

	@Override
	public ImageServiceResponse getImagesWithTag(String tag) {
		Map<String, String> queryTags = new HashMap<>();
		queryTags.put(IMAGE_TAG_KEY, tag);
		var targetUri = UriHelper.generateUri(config.getHostName(), config.getUrl().getPublicPhotos(), queryTags); 
		var uriResponse = restTemplate.getForObject(targetUri, FlickrPhotosPublicFeed.class);
		
		List<String> imageLinks = new ArrayList<>();
		uriResponse.getEntries().forEach(entry -> {
			var imageLink = entry.getLinks().stream()
					.filter(link -> link.getRel().equalsIgnoreCase(ENCLOSURE_REL) && link.getType().equalsIgnoreCase(IMAGE_JPEG_TYPE))
					.findFirst();
			if (imageLink.isPresent()) {
				imageLinks.add(imageLink.get().getHref());
			}
		});
		
		var serviceResponse = new ImageServiceResponse();
		serviceResponse.getImageLinks().addAll(imageLinks);
		return serviceResponse;
	}
	
	
}
