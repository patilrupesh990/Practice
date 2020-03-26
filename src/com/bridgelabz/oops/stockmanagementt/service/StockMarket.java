package com.bridgelabz.oops.stockmanagementt.service;

import java.util.Scanner;

public abstract class StockMarket {
	static Scanner scanner = new Scanner(System.in);
	static ICompany company = new CompanyImpl();
	static ICustomer customer = new CumstomerImpl();

	public static void mainMenu() {
		while (true) {
			System.out.println("==================>>Wellcome To Stock Market<<====================");
			System.out.println("\n\n 1.Admin Login   2.User Login");

			switch (scanner.nextInt()) {
			case 1:
				adminMenu();
				break;
			case 2:
				customerMenu();
				break;
			default:
				break;
			}
		}
	}

	public static void customerMenu() {
		while (true) {
			System.out.println("===============>>Costomer Menu<<=========================");
			System.out.println("\n\n 1.Register 2.Purchase 3.sell  4.TotalValue 5.UserList  6.MainMenu 7.Exit");
			switch (scanner.nextInt()) {
			case 1:
				customer.register();
				break;
			case 2:
				customer.purchase();
				break;
			case 3:
				customer.sell();
				;
				break;
			case 4:
				customer.totalValue();
				break;

			case 5:
				customer.displayUsers();
				break;
			case 6:
				mainMenu();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Invalid input");
				customerMenu();
				break;
			}
		}
	}

	public static void adminMenu() {
		while (true) {
			System.out.println("===============>>Admin Menu<<=========================");
			System.out.println(
					"\n\n 1.Add Company 2.Remove Compny 3.DisplayCompny Value  4.Search Compny  5.MainMenu 6.Exit");
			switch (scanner.nextInt()) {
			case 1:
				company.addCompany();
				break;
			case 2:
				company.removeCompany();
				break;
			case 3:
				company.displayCompanyValue();
				break;
			case 4:
				company.searchCompany();
				break;
			case 5:
				mainMenu();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid input");
				customerMenu();
				break;
			}
		}
	}

}
