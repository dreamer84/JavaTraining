package com.practicaljava.unit_10.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The simple socket client connects to the server, gets user input
 * and sends it to the server. The connection will be closed if
 * the user types "bye".
 */
public class MultiSocketClient {

	public static void main(String[] args) throws IOException {
		String hostName = "localhost";
		int portNumber = 4000;

		// 1. Creates a Socket instance
		// 2. Gets input and output streams from this socket
		try (Socket clientSocket = new Socket(hostName, portNumber);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(
						clientSocket.getOutputStream(), true);) {

			// Gets the standard input stream
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					System.in));

			// Gets user input and writes it to the output
			// stream (sends to the server).
			String inputLine;
			while ((inputLine = stdIn.readLine()) != null) {
				out.println(inputLine);
				if (inputLine.equalsIgnoreCase("Bye")) {
					break;
				}
			}
		}
	}
}
