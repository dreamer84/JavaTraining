package com.practicaljava.unit_05.swing1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * A simple JFrame for playing with GridLayout.
 */
public class GridLayoutFrame extends JFrame {

	public GridLayoutFrame(String title) {
		super(title);
		initComponents();
		pack();
	}

	private void initComponents() {
		// Main panel
		JPanel panel = new JPanel();
		add(panel);

		// Input: First name
		JLabel labelFirstName = new JLabel("First name:");
		panel.add(labelFirstName);
		JTextField textFieldFirstName = new JTextField(20);
		panel.add(textFieldFirstName);

		// Input: Middle name
		JLabel labelMiddleName = new JLabel("Middle name:");
		panel.add(labelMiddleName);
		JTextField textFieldMiddleName = new JTextField(20);
		panel.add(textFieldMiddleName);

		// Input: Last name
		JLabel labelLastName = new JLabel("Last name:");
		panel.add(labelLastName);
		JTextField textFieldLastName = new JTextField(20);
		panel.add(textFieldLastName);

		// Output: Combined name
		JLabel labelCombName = new JLabel("");
		panel.add(labelCombName);

		// Buttons
		JButton buttonGetFullName = new JButton("Get full name");
		panel.add(buttonGetFullName);
		JButton buttonGetShortName = new JButton("Get short name");
		panel.add(buttonGetShortName);
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new GridLayoutFrame(
						"Simple Frame with GridLayout");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Places the window in the center of the screen
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
