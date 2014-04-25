package com.practicaljava.unit_05.swing0;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A simple JFrame.
 * 
 * @author Sergey
 */
public class SimpleFrame extends JFrame {

	public SimpleFrame(String title) {
		super(title);
		initComponents();
	}

	private void initComponents() {
		JPanel container = new JPanel();
		add(container, BorderLayout.CENTER);

		JButton button = new JButton("Click me!");
		container.add(button);

		pack();
	}
}
