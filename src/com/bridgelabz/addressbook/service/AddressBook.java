package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.utility.Util;

public abstract class AddressBook {

	static IAddressBook addressBook = new AddressBookImpl();
	static IPersonService person = new PersonServiceImpl();

	public static void mainMenu() {
		System.out.println("==========>>Wellcome to AddressBook Application<<==============");

		while (true) {
			int choice = 0;
			System.out.println("Eneter your choice");
			System.out.println("1.New Book  2.Open Book   3.close Book 4.Quite");
			try {
				choice = Util.InputInt();
			} catch (NumberFormatException ne) {
				System.out.println("Invalid input");
			}
			switch (choice) {
			case 1:
				addressBook.addBook();
				break;

			case 2:
				addressBook.openBook();
				break;

			case 3:
				break;
			case 4:
				System.exit(0);

			default:

			}
		}
	}

	public static void personMenu() {
		System.out.println("==========>>Person MainMenu<<================");
		while (true) {
			System.out.println("Select your option");
			System.out.println(
					"1.Add New Person 2.Delete Person 3.Show All Entry 4.sort List 5.Search Person  6.save File 7.MainMenu 8.exit");
			switch (Util.InputInt()) {
			case 1:
				person.addPerson();
				break;
			case 2:
				person.deletePerson();
				break;
			case 3:
				person.dipslayPersonName();
				break;
			case 4:
				person.sortPerson();
				break;
			case 5:
				person.searchPerson();
				break;
			case 6:
				person.save();
				break;
			}
		}
	}

}
