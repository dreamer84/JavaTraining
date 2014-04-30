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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	private final JTextField textURL;
	private final JTextField textSaveAs;
	private final JButton buttonGet;

	// Target URL content size (length)
	private Long downloadUrlSize;

	public FileDownloaderFrame(String title) {
		super(title);

		downloadUrlSize = null;

		// Main panel

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(mainPanel);

		// Input group panel

		JPanel inputGroupPanel = new JPanel();

		JLabel labelURL = new JLabel("Enter a URL:");
		inputGroupPanel.add(labelURL);

		textURL = new JTextField(40);
		inputGroupPanel.add(textURL);

		JLabel labelSaveAs = new JLabel("Save as:");
		inputGroupPanel.add(labelSaveAs);

		textSaveAs = new JTextField("downloaded_file", 20);
		inputGroupPanel.add(textSaveAs);

		buttonGet = new JButton("Download the file");
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

				DownloadTask task = new DownloadTask(url, textSaveAs.getText());
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

	private void download(String fromURL, String saveAs) throws IOException {
		System.out.println("Downloading. Please wait...");

		try {
			URL url = new URL(fromURL);
			URLConnection conn = url.openConnection();

			// Saves the target URL content size
			downloadUrlSize = conn.getContentLengthLong();

			try (BufferedInputStream in = new BufferedInputStream(
					conn.getInputStream());
					FileOutputStream fout = new FileOutputStream(saveAs)) {
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

		} finally {
			downloadUrlSize = null;
		}

		System.out.println(fromURL + " -> " + saveAs + " OK");
	}

	private class DownloadTask extends SwingWorker<Void, String> {
		private final String fromUrl;
		private final String toFile;

		public DownloadTask(String fromUrl, String toFile) {
			this.fromUrl = fromUrl;
			this.toFile = toFile;
		}

		@Override
		protected Void doInBackground() throws Exception {
			// Disables UI controls
			setUIControlsEnabled(false);

			// Sets the progress bar to 0%
			progressBar.setValue(progressBar.getMinimum());

			// Deletes an existing file with the same name
			Path file = Paths.get(toFile);
			if (Files.exists(file) && !Files.isDirectory(file)) {
				Files.delete(file);
			}

			// Creates and runs the timer for checking size of the downloading
			// file
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					Path file = Paths.get(toFile);
					if (Files.exists(file) && !Files.isDirectory(file)) {
						try {
							long fileSize = Files.size(file);
							setProgress((int) ((fileSize * 100) / downloadUrlSize));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}, 500L, 500L);

			// Starts downloading
			download(fromUrl, toFile);

			// Stops the "check-size" timer
			timer.cancel();

			// Sets the progress bar to 100%
			progressBar.setValue(progressBar.getMaximum());

			return null;
		}

		@Override
		protected void process(List<String> chunks) {
		}

		@Override
		protected void done() {
			// Enables UI controls
			setUIControlsEnabled(true);

			setStatus("Done.");
		}
	}

	public void setUIControlsEnabled(boolean enabled) {
		buttonGet.setEnabled(enabled);
	}
}
