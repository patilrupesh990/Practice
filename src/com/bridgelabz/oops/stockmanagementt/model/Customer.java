package com.bridgelabz.oops.stockmanagementt.model;

import java.util.List;

public class Customer {
	String name;
	Long contact;
	String email;
	int totalShares;
	double totalAssests;
	List<Company> company;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalShares() {
		return totalShares;
	}
	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}
	public double getTotalAssests() {
		return totalAssests;
	}
	public void setTotalAssests(double totalAssests) {
		this.totalAssests = totalAssests;
	}
	public List<Company> getCompany() {
		return company;
	}
	public void setCompany(List<Company> company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Customer name=" + name + "\n contact=" + contact + "\n email=" + email + "\n totalShares=" + totalShares
				+ "\n totalAssests=" + totalAssests + "\n company=" + company + "\n";
	}
	
	
}
