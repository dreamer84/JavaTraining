package com.practicaljava.unit_13.jtable;

public class Order {
	private int orderID;
	private String stockSymbol;
	private int quantity;
	private double price;

	public Order(int id, String stockSymbol, int quantity, double price) {
		this.orderID = id;
		this.stockSymbol = stockSymbol;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderID() {
		return orderID;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}
}
