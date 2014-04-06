package com.practicaljava.unit_09.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Simple website reader using the URL class.
 */
public class WebSiteReader {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://example.com");

		// * try-with-resources
		// * openStream() is a shorthand for openConnection().getInputStream()
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				url.openStream()))) {
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
		}
	}
}
