package com.practicaljava.unit_05.swing0;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author Sergey
 */
public class SimpleFrameApp {

	public static void main(String[] args) {

		// Creates the SimpleFrame in the Event Dispatch Thread
		// * this method is just a cover for java.awt.EventQueue.invokeLater().
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new SimpleFrame("Simple Frame");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Places the window in the center of the screen
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
