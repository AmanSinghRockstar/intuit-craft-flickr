package com.intuit.test.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry", namespace = "http://www.w3.org/2005/Atom")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlickrPhotosPublicEntry {

	@XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
	List<FlickrPhotosPublicEntryLink> links;

	public List<FlickrPhotosPublicEntryLink> getLinks() {
		return links;
	}

	public void setLinks(List<FlickrPhotosPublicEntryLink> links) {
		this.links = links;
	}
}
