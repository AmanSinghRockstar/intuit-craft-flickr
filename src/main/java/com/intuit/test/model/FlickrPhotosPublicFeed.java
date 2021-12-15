package com.intuit.test.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "feed", namespace = "http://www.w3.org/2005/Atom")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlickrPhotosPublicFeed {

	@XmlElement(name = "entry", namespace = "http://www.w3.org/2005/Atom")
	List<FlickrPhotosPublicEntry> entries;

	@XmlAnyElement(lax = true)
	private List<Object> any;

	public List<FlickrPhotosPublicEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<FlickrPhotosPublicEntry> entries) {
		this.entries = entries;
	}
}
