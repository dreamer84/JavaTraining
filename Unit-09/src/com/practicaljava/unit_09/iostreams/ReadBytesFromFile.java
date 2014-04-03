package com.practicaljava.unit_09.iostreams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadBytesFromFile {
	public static final String BINARY_FILE_NAME = "abc.dat";

	public static void main(String[] args) {

		try (BufferedInputStream fin = new BufferedInputStream(
				new FileInputStream(BINARY_FILE_NAME))) {

			System.out.println("Bytes from " + BINARY_FILE_NAME + ":");

			int c;
			while ((c = fin.read()) != -1) {
				System.out.print(c);
				System.out.print(" ");
			}
			System.out.print("\n");

			System.out.println("All done!");

		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found! (" + BINARY_FILE_NAME
					+ ")");
			System.exit(1);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
