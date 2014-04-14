package com.practicaljava.unit_10.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * A thread prints out messages from single client connection.
 * The connection close on message "bye" from the client.
 */
public class MultiSocketServerThread extends Thread {
	private Socket socket;

	public MultiSocketServerThread(Socket socket) {
		super("MultiSocketServerThread");
		this.socket = socket;
	}

	@Override
	public void run() {
		try (BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream(),
						true);) {

			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
				if (inputLine.equalsIgnoreCase("Bye")) {
					break;
				}
			}

			socket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
