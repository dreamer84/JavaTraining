package com.practicaljava.unit_05.swing2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FileDownloader {
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new FileDownloaderFrame("Simple File Downloader");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Places the window in the center of the screen
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}