package com.practicaljava.unit_05.swing1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		add(panel);

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 100;
		constraints.weighty = 100;
		// Input: First name
		JLabel labelFirstName = new JLabel("First name:");
		panel.add(labelFirstName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 100;
		constraints.weighty = 100;
		JTextField textFieldFirstName = new JTextField(20);
		panel.add(textFieldFirstName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 100;
		constraints.weighty = 100;
		// Input: Middle name
		JLabel labelMiddleName = new JLabel("Middle name:");
		panel.add(labelMiddleName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.weightx = 100;
		constraints.weighty = 100;
		JTextField textFieldMiddleName = new JTextField(20);
		panel.add(textFieldMiddleName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.weightx = 100;
		constraints.weighty = 100;
		// Input: Last name
		JLabel labelLastName = new JLabel("Last name:");
		panel.add(labelLastName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.weightx = 100;
		constraints.weighty = 100;
		JTextField textFieldLastName = new JTextField(20);
		panel.add(textFieldLastName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.weightx = 100;
		constraints.weighty = 100;
		constraints.gridwidth = 2;
		// Output: Combined name
		JLabel labelCombName = new JLabel("-");
		panel.add(labelCombName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.weightx = 100;
		constraints.weighty = 100;
		// Buttons
		JButton buttonGetFullName = new JButton("Get full name");
		panel.add(buttonGetFullName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.weightx = 100;
		constraints.weighty = 100;
		JButton buttonGetShortName = new JButton("Get short name");
		panel.add(buttonGetShortName, constraints);
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
