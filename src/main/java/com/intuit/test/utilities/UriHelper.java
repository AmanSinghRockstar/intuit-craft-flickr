package com.intuit.test.utilities;

import java.util.Map;

public class UriHelper {
	private static final String FORWARD_SLASH_SEPARATOR = "/";
	private static final String QUERY_START_SYMBOL = "?";
	private static final String QUERY_SEPARATOR = "&";
	private static final String QUERY_EQUAL_SYMBOL = "=";

	public static String generateUri(String hostname, String path, Map<String, String> queryTags) {
		StringBuilder uriBuilder = new StringBuilder();
		
		uriBuilder.append(hostname);
		if (!path.isBlank()) {
			if (!uriBuilder.toString().endsWith(FORWARD_SLASH_SEPARATOR) && !path.startsWith(FORWARD_SLASH_SEPARATOR)) {
				uriBuilder.append(FORWARD_SLASH_SEPARATOR);
			}
			uriBuilder.append(path);
		}
		
		if (queryTags != null && !queryTags.isEmpty()) {
			// We have query tags
			StringBuilder queryStringBuilder = new StringBuilder();
			
			queryTags.entrySet().forEach(queryKeyValuePair -> {
				if (queryStringBuilder.length() != 0) {
					// A query is already added to the string, add an '&' symbol
					queryStringBuilder.append(QUERY_SEPARATOR);
				}
				
				queryStringBuilder.append(queryKeyValuePair.getKey())
					.append(QUERY_EQUAL_SYMBOL)
					.append(queryKeyValuePair.getValue());
			});
			
			uriBuilder.append(QUERY_START_SYMBOL).append(queryStringBuilder.toString());
		}
		
		return uriBuilder.toString();
	}
}
