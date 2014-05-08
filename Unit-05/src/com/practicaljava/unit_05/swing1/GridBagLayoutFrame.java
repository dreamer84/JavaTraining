package com.practicaljava.unit_05.swing1;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * A simple JFrame for playing with GridLayout.
 */
public class GridBagLayoutFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public GridBagLayoutFrame(String title) {
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

		// Input: First name

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 100;
		constraints.weighty = 100;
		JLabel labelFirstName = new JLabel("First name:");
		panel.add(labelFirstName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.weightx = 100;
		constraints.weighty = 100;
		final JTextField textFieldFirstName = new JTextField(20);
		panel.add(textFieldFirstName, constraints);

		// Input: Middle name

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.weightx = 100;
		constraints.weighty = 100;
		JLabel labelMiddleName = new JLabel("Middle name:");
		panel.add(labelMiddleName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 1;
		constraints.weightx = 100;
		constraints.weighty = 100;
		final JTextField textFieldMiddleName = new JTextField(20);
		panel.add(textFieldMiddleName, constraints);

		// Input: Last name

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.weightx = 100;
		constraints.weighty = 100;
		JLabel labelLastName = new JLabel("Last name:");
		panel.add(labelLastName, constraints);

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.weightx = 100;
		constraints.weighty = 100;
		final JTextField textFieldLastName = new JTextField(20);
		panel.add(textFieldLastName, constraints);

		// Output: Combined name

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.weightx = 100;
		constraints.weighty = 100;
		constraints.gridwidth = 2;
		final JLabel labelCombName = new JLabel("-");
		panel.add(labelCombName, constraints);

		// Control buttons

		constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.weightx = 100;
		constraints.weighty = 100;

		JButton buttonGetFullName = new JButton("Get full name");
		panel.add(buttonGetFullName, constraints);

		buttonGetFullName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				labelCombName.setText(textFieldFirstName.getText() + " "
						+ textFieldMiddleName.getText() + " "
						+ textFieldLastName.getText());
			}
		});

		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.weightx = 100;
		constraints.weighty = 100;
		JButton buttonGetShortName = new JButton("Get short name");
		panel.add(buttonGetShortName, constraints);

		buttonGetShortName.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				labelCombName.setText(textFieldFirstName.getText().charAt(0)
						+ ". " + textFieldMiddleName.getText().charAt(0) + ". "
						+ textFieldLastName.getText());
			}
		});
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new GridBagLayoutFrame(
						"Simple Frame with GridLayout");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Places the window in the center of the screen
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
