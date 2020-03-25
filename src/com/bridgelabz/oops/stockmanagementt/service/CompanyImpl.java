package com.bridgelabz.oops.stockmanagementt.service;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

import com.bridgelabz.oops.stockmanagementt.model.Company;

public class CompanyImpl implements ICompany{
	static LinkedList<Company> companyList=new LinkedList<Company>();
	static Scanner scanner=new Scanner(System.in);
	@Override
	public void addCompany() {
		Company company=new Company();
		try {
		System.out.println("Enter Company Name");
		company.setName(scanner.nextLine());
		System.out.println("Enter Company Symbol");
		company.setSymbol(scanner.next());
		System.out.println("Enter Number Of Shares");
		company.setShares(scanner.nextInt());
		System.out.println("Enter The Value per Share");
		company.setPrice(scanner.nextDouble());
		company.setTotalValue(company.getPrice()*company.getShares());
		}catch (InputMismatchException e) {
			System.out.println("Wrong Input Please Try Again");
			addCompany();
		}
		companyList.add(company);
	}

	@Override
	public void removeCompany() {
		System.out.println("Enter The Company Name");
		String companyName=scanner.next();
		Optional<Company> list=companyList.stream().filter(p->p.getName().equals(companyName)).findFirst();
		if (list.isPresent()) {
			companyList.remove(list.get());
			System.out.println(companyList+"Removed Successfully from list");
		}
		else {
			System.out.println("not present");
		}
		
		
	}

	@Override
	public void displayCompanyValue() {
		companyList.forEach(System.out::println);
	}

	@Override
	public void searchCompany() {
		System.out.println("Enter The Company Name/Symbol");
		String name=scanner.next();
		Optional<Company> list=companyList.stream().filter(p->p.getName().equals(name)||p.getSymbol().equals(name)).findAny();
		if (list.isPresent()) {
			System.out.println(list);
		}
		else {
			System.out.println("not present");
		}
	}
	
}
