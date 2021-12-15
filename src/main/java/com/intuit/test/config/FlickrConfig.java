package com.intuit.test.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "flickr")
public class FlickrConfig {
	
	private String hostName;
	
	@NestedConfigurationProperty
	private FlickrUrlConfig url;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public FlickrUrlConfig getUrl() {
		return url;
	}

	public void setUrl(FlickrUrlConfig url) {
		this.url = url;
	}
}
