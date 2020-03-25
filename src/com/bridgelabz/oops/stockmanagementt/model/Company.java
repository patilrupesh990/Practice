package com.bridgelabz.oops.stockmanagementt.model;

public class Company {
	private String name;
	private String symbol;
	private int shares;
	private double price;
	private double totalValue;
	@Override
	public String toString() {
		return "Company name=" + name + "\n symbol=" + symbol + "\n shares=" + shares + "\n price=" + price
				+ "\n totalValue=" + totalValue + "\n";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
}
