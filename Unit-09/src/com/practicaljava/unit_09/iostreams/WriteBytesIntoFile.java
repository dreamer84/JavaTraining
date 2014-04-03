package com.practicaljava.unit_09.iostreams;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBytesIntoFile {
	public static final String BINARY_FILE_NAME = "xyz.dat";
	public static int[] bytes = { 97, 98, 99, 32, 97, 98, 99, 32, 32, 97, 98,
			99 };

	public static void main(String[] args) {

		try (BufferedOutputStream fout = new BufferedOutputStream(
				new FileOutputStream(BINARY_FILE_NAME))) {

			System.out.println("Writing into " + BINARY_FILE_NAME + "...");

			for (int i = 0; i < bytes.length; i++) {
				fout.write(bytes[i]);
			}

			System.out.println("All done!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
