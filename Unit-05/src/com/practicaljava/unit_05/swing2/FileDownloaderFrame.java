package com.practicaljava.unit_05.swing2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

/**
 * A file downloader frame.
 */
public class FileDownloaderFrame extends JFrame {
	private final JProgressBar progressBar;
	private final JLabel labelStatus;

	public FileDownloaderFrame(String title) {
		super(title);

		// Main panel

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(mainPanel);

		// Input group panel

		JPanel inputGroupPanel = new JPanel();

		JLabel labelURL = new JLabel("Enter a URL:");
		inputGroupPanel.add(labelURL);

		final JTextField textURL = new JTextField(40);
		inputGroupPanel.add(textURL);

		JButton buttonGet = new JButton("Download the file");
		inputGroupPanel.add(buttonGet);

		mainPanel.add(inputGroupPanel, BorderLayout.NORTH);

		// Progress bar

		progressBar = new JProgressBar(0, 100);

		mainPanel.add(progressBar, BorderLayout.CENTER);

		// Status label

		labelStatus = new JLabel("No actions");
		mainPanel.add(labelStatus, BorderLayout.SOUTH);

		// Sets actions

		buttonGet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String url = textURL.getText();

				setStatus("Downloading...");

				DownloadTask task = new DownloadTask(url);
				task.addPropertyChangeListener(new PropertyChangeListener() {

					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if ("progress".equals(evt.getPropertyName())) {
							progressBar.setValue((Integer) evt.getNewValue());
						}
					}
				});
				task.execute();
			}
		});

		// Sizes the frame
		pack();
	}

	private void setStatus(String status) {
		labelStatus.setText(status);
	}

	private void download(String fromURL) throws IOException {
		String toFile = "downloaded_file";

		System.out.println("Downloading. Please wait...");

		try {
			URL url = new URL(fromURL);
			URLConnection conn = url.openConnection();
			System.out
					.println("Content-Length: " + conn.getContentLengthLong());

			try (BufferedInputStream in = new BufferedInputStream(
					conn.getInputStream());
					FileOutputStream fout = new FileOutputStream(toFile)) {
				int data;
				while ((data = in.read()) != -1) {
					fout.write(data);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println(fromURL + " -> " + toFile + " OK");
	}

	private class DownloadTask extends SwingWorker<Void, String> {
		private final String fromUrl;

		public DownloadTask(String fromUrl) {
			this.fromUrl = fromUrl;
		}

		@Override
		protected Void doInBackground() throws Exception {
			download(fromUrl);
			return null;
		}

		@Override
		protected void process(List<String> chunks) {
		}

		@Override
		protected void done() {
			setStatus("Done.");
		}
	}
}
