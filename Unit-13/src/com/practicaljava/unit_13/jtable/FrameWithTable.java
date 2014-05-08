package com.practicaljava.unit_13.jtable;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;

public class FrameWithTable extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTable myTable;
	private MyTableModel myTableModel;

	public FrameWithTable(String title) {
		super(title);

		myTableModel = new MyTableModel();
		myTable = new JTable(myTableModel);

		add(new JScrollPane(myTable));
	}

	private class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;

		private ArrayList<Order> myData = new ArrayList<>();

		MyTableModel() {
			myData.add(new Order(1, "IBM", 100, 135.5));
			myData.add(new Order(2, "AAPL", 300, 290.12));
			myData.add(new Order(3, "MOT", 2000, 8.32));
			myData.add(new Order(4, "ORCL", 500, 27.8));
		}

		@Override
		public int getColumnCount() {
			return 4;
		}

		@Override
		public int getRowCount() {
			return myData.size();
		}

		@Override
		public Object getValueAt(int row, int col) {
			switch (col) {
			case 1:
				return myData.get(row).getOrderID();
			case 2:
				return myData.get(row).getStockSymbol();
			case 3:
				return myData.get(row).getQuantity();
			case 4:
				return myData.get(row).getPrice();
			default:
				return "";
			}
		}
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				JFrame frame = new FrameWithTable("Window with JTable");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}
}
