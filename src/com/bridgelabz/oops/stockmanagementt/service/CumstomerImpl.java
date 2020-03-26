package com.bridgelabz.oops.stockmanagementt.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.bridgelabz.oops.stockmanagementt.model.Company;
import com.bridgelabz.oops.stockmanagementt.model.Customer;

public class CumstomerImpl implements ICustomer {

	static LinkedList<Customer> customerList = new LinkedList<Customer>();
	static Scanner scanner = new Scanner(System.in);
	Customer customer=null;

	@Override
	public void register() {
		Customer customer = new Customer();
		try {
			System.out.println("Enter Name");
			customer.setName(scanner.next());
			System.out.println("Enter contact");
			customer.setContact(scanner.nextLong());
			System.out.println("Entert Email");
			customer.setEmail(scanner.next());
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input Please Try again");
			register();
		}
		customerList.add(customer);
	}

	@Override
	public void purchase() {
		System.out.println("==============>>Compnay List<<==============");
		CompanyImpl.companyList.forEach(System.out::println);
		System.out.println("-------------------------------------------------");
		System.out.println("Enter Your Name/Email");
		String name = scanner.next();
		Optional<Customer> customerlist = customerList.stream()
				.filter(p -> p.getName().equals(name) || p.getEmail().equals(name)).findAny();
		if (customerlist.isPresent())
			customer = customerlist.get();
		else {
			System.out.println("User Doesent Exist Please Register");
			register();
		}

		System.out.println("Enter Company Name/Symbol");
		String compnayName = scanner.next();
		Optional<Company> company = CompanyImpl.companyList.stream()
				.filter(p -> p.getName().equals(compnayName) || p.getSymbol().equals(compnayName)).findAny();
		company.ifPresent(p -> {
			System.out.println("Enter Number of Shares");
			int share = scanner.nextInt();
			share += customer.getTotalShares();
			customer.setTotalShares(share);
			double total = p.getPrice() * share;
			total += customer.getTotalAssests();
			customer.setTotalAssests(total);
			try {
				Optional<List<Company>> list = Optional.ofNullable(customer.getCompany());
				if (list.isPresent()) {
					list.get().add(p);
					customer.setCompany(list.get());
				} else {
					List<Company> clist = new LinkedList<Company>();
					clist.add(p);
					customer.setCompany(clist);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		if (!company.isPresent()) {
			System.out.println("Invalid Company Name or symbol Please Try again");
			purchase();
		}
	}

	@Override
	public void sell() {

	}

	@Override
	public void totalValue() {
		System.out.println("Enter Customer Name/email");
		String customerName = scanner.next();
		Optional<Customer> customerlist = customerList.stream()
				.filter(p -> p.getName().equals(customerName) || p.getEmail().equals(customerName)).findAny();
		if (customerlist.isPresent()) {
			customer = customerlist.get();
			System.out.println(customerlist.get().getName()+"'s"+" Total Assets is "+customerlist.get().getTotalAssests());
		} else {
			System.out.println("User Doesent Exist Please Register");
			register();
		}
	}

	@Override
	public void displayUsers() {
		System.out.println("====================>>Customer List<<===========================");
		customerList.forEach(System.out::println);
	}

}