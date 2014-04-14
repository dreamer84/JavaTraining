package com.practicaljava.unit_10.sockets;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * The multi socket server listens and accepts multiple
 * client connections using threads.
 */
public class MultiSocketServer {

	public static void main(String[] args) {
		int portNumber = 4000;

		// Creates a ServerSocket
		try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
			while (true) {
				// Waits for a client connection,
				// creates a new thread for it,
				// and starts the thread.
				// ! The open socket will be close in the thread.
				new MultiSocketServerThread(serverSocket.accept()).start();
				System.out.println("New client is connected");
			}
		} catch (IOException e) {
			System.err.println("Couldn't listen port " + portNumber);
			System.exit(1);
		}
	}
}
