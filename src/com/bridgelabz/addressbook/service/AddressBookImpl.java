package com.bridgelabz.addressbook.service;

import java.io.File;
import java.io.IOException;

import com.bridgelabz.addressbook.exception.AddressBookException;
import com.bridgelabz.addressbook.utility.Util;


public class AddressBookImpl implements IAddressBook {
	String originbook="D:\\java programs\\javaProject\\Practice\\src\\com\\bridgelabz\\addressbook\\jsonfiles\\";
	private static String BookName;
	
	
	public static void setBookName(String bookName) {
		BookName = bookName;
	}
	
	public static String getBookName() {
		return BookName;
	}
	

	@Override
	public void addBook() {
		System.out.println("Enter the name of the book in (.json) extention (eg:file.json)");
		String book = Util.InputString();
		File file = new File(originbook + book);
		boolean newjason=false;
		try {
			newjason = file.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (newjason) {
			System.out.println("Book is succesfully created and add to the file");
		} else
			try {
				throw new AddressBookException("The Name of that book is already exists pls create new book");
			} catch (AddressBookException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void openBook() {
		File files=new File(originbook);
		File[] filesList=files.listFiles();
		System.out.println("--------->>Available Files<<------------");
		for(File file:filesList) {
			System.out.println(file.getName());
		}
		System.out.println("Choose the File and Eter Name of file");
		String bookName=Util.InputString();
		setBookName(bookName);
		
		for(File file:filesList) {
			if(bookName.equals(file.getName())) {
				System.out.println("Add New Data Into Book");		
				AddressBook.personMenu();
			}
		}
	}

	@Override
	public void closeBook() {
		// TODO Auto-generated method stub

	}
	
	

}
