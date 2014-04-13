package com.practicaljava.unit_10.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleSocketClient {

	public static void main(String[] args) throws IOException {
		String hostName = "localhost";
		int portNumber = 4000;

		try (Socket clientSocket = new Socket(hostName, portNumber);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(
						clientSocket.getOutputStream(), true);) {

			String inputLine, outputLine;

			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					System.in));
			while ((inputLine = stdIn.readLine()) != null) {
				out.println(inputLine);
			}
		}
	}
}
