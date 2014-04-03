package com.practicaljava.unit_09.iostreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
	public static final String CHAR_FILE_IN_NAME = "abc.dat";
	public static final String CHAR_FILE_OUT_NAME = "abc_copy.dat";

	public static void main(String[] args) {

		try (BufferedReader fin = new BufferedReader(new FileReader(
				CHAR_FILE_IN_NAME));
				BufferedWriter fout = new BufferedWriter(new FileWriter(
						CHAR_FILE_OUT_NAME))) {

			System.out.println("Copying " + CHAR_FILE_IN_NAME + " into "
					+ CHAR_FILE_OUT_NAME + "...");

			int c;
			while ((c = fin.read()) != -1) {
				fout.write(c);
			}

			System.out.println("All done!");

		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found!");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
