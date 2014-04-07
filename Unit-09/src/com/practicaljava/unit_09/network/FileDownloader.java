package com.practicaljava.unit_09.network;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;

/**
 * Simple file downloader using the URL class.
 */
public class FileDownloader {

	public static void main(String[] args) throws Exception {
		if (args.length != 2) {
			System.out.println("Usage: java FileDownloader fromURL toFile");
			System.exit(1);
		}

		String fromURL = args[0];
		String toFile = args[1];

		URL url = new URL(fromURL);

		System.out.println("Downloading. Please wait...");

		// * try-with-resources
		// * openStream() is a shorthand for openConnection().getInputStream()
		try (BufferedInputStream in = new BufferedInputStream(url.openStream());
				FileOutputStream fout = new FileOutputStream(toFile)) {
			int data;
			while ((data = in.read()) != -1) {
				fout.write(data);
			}
		}

		System.out.println(fromURL + " -> " + toFile + " OK");
	}
}
