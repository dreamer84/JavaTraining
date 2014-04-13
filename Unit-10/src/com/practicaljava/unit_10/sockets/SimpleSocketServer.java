package com.practicaljava.unit_10.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The simple socket server listens and accepts a single
 * client connection, and prints out messages from it.
 */
public class SimpleSocketServer {

	public static void main(String[] args) throws IOException {
		int portNumber = 4000;

		// 1. Creates a ServerSocket instance
		// 2. Waits for a client connection, and then gets a Socket
		// 3. Gets input and output streams from this socket
		try (ServerSocket serverSocket = new ServerSocket(portNumber);
				Socket clientSocket = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(
						clientSocket.getOutputStream(), true);) {

			// Prints out receiving lines
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
		}
	}
}
