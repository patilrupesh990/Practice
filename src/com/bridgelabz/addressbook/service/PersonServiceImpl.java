package com.bridgelabz.addressbook.service;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.FileReadWrite;
import com.bridgelabz.addressbook.utility.Util;

public class PersonServiceImpl implements IPersonService {
	static JSONArray personDetailArray = new JSONArray();
	JSONParser parser = new JSONParser();
	static Scanner scanner = new Scanner(System.in);
	String originbook = "D:\\java programs\\javaProject\\Practice\\src\\com\\bridgelabz\\addressbook\\jsonfiles\\";
	static JSONObject fileObject = new JSONObject();

	public static void setFileObject(JSONObject object) {
		fileObject = object;
	}

	public static JSONObject getFileObject() {
		return fileObject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addPerson() {
		JSONObject finalObject = new JSONObject();
		JSONObject temp = new JSONObject();
		Person person = new Person();
		System.out.println("Enter FirstName");
		person.setFirstName(Util.InputString());
		temp.put("First Name", person.getFirstName());
		System.out.println("Enter Last Name");
		person.setLastName(Util.InputString());
		temp.put("Last Name", person.getLastName());
		System.out.println("Enter Contact Number");
		person.setPhoneNo(Util.inputLong());
		temp.put("Mob No", person.getPhoneNo());
		System.out.println("Enter Adress");
		temp.put("Adress", addAddress());
		String fileRead = null;
		try {
			if (FileReadWrite.readData(originbook + AddressBookImpl.getBookName()) != null) {
				fileRead = FileReadWrite.readData(originbook + AddressBookImpl.getBookName());
			}

			finalObject = (JSONObject) parser.parse(fileRead);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (finalObject != null) {
			personDetailArray.add(temp);
			finalObject.put(person.getFirstName(), personDetailArray);
		} else {
			personDetailArray.add(temp);
			finalObject.put(person.getFirstName(), personDetailArray);
		}
		fileObject=null;
		setFileObject(finalObject);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deletePerson() {
		String fileData = FileReadWrite.readData(originbook + AddressBookImpl.getBookName());
		JSONObject jobject = null;

		if (fileData != null) {
			try {
				jobject = (JSONObject) parser.parse(fileData);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println("================>>List Of Persons Available In File<<==========");

			Set<String> personsList = jobject.keySet();
			personsList.forEach(System.out::println);
			System.out.println("Do you Want Delete Person Data??  \n Enter The Person Name.");
			String name = Util.InputString();
			if (jobject.containsKey(name)) {
				jobject.remove(name);
			}
		}
		System.out.println(fileData);
		FileReadWrite.WriteinFile(jobject.toJSONString(), originbook + AddressBookImpl.getBookName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void dipslayPersonName() {
		String fileData = FileReadWrite.readData(originbook + AddressBookImpl.getBookName());
		JSONObject jobject = null;
		if (fileData != null) {
			try {
				jobject = (JSONObject) parser.parse(fileData);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.println("================>>List Of Persons Available In File<<==========");
			Set<String> personsList = jobject.keySet();
			personsList.forEach(System.out::println);

			System.out.println("Do you Want to know More??  \n Enter The Person Name.");
			String name = Util.InputString();
			JSONObject jsonobj = jobject;
			jsonobj.forEach((k, v) -> {

				if (k.equals(name)) {
					JSONArray array = (JSONArray) jsonobj.get(name);
					array.forEach(p -> {

						JSONObject person = (JSONObject) p;
						System.out.println("------------------>>Name&Contact<<--------------------");
						System.out.println("Name:" + person.get("First Name") + " " + person.get("Last Name"));
						System.out.println("Contact:" + person.get("Mob No"));
						JSONObject address = (JSONObject) person.get("Adress");
						System.out.println("----------------------->>Address<<---------------------");
						System.out.println("Street::" + address.get("street"));
						System.out.println("City::" + address.get("city"));
						System.out.println("State::" + address.get("state"));
						System.out.println("Pincode::" + address.get("pincode"));
					});
				}
			});
		}
		System.out.println("-----------------------------------------------------------------------");
	}

	@SuppressWarnings("unchecked")
	public JSONObject addAddress() {
		JSONObject address = new JSONObject();
		System.out.println("Enter Street");
		address.put("street", Util.InputString());
		System.out.println("Enter city");
		address.put("city", Util.InputString());
		System.out.println("Enter State");
		address.put("state", Util.InputString());
		System.out.println("Enter PinCode");
		address.put("pincode", Util.InputInt());

		return address;
	}

	public boolean save() {
		return FileReadWrite.WriteinFile(getFileObject().toJSONString(), originbook + AddressBookImpl.getBookName());
	}

	@Override
	public void sortPerson() {
		List<Person> persons = IPersonService.getPersonDataFromJSon().stream()
				.sorted(Comparator.comparing(Person::getFirstName)).collect(Collectors.toList());
		System.out.println("-------------------->>Persons Sorted List By Name<<--------------------------------");
		persons.forEach(p -> {
			System.out.println("Name:" + p.getFirstName());
			System.out.println("Contact:" + p.getPhoneNo());
			Address address = p.getAddress();
			System.out.println("city:" + address.getCity());
			System.out.println("State:" + address.getState());

		});
		System.out.println("-----------------------------------------------------------------------");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void searchPerson() {
		System.out.println("Enter the First Name/Last Name/City/State You Want to Search ");
		String search = Util.InputString();
		List<Person> person = IPersonService.getPersonDataFromJSon().stream()
				.filter(per -> per.getFirstName().equals(search) || per.getLastName().equals(search)
						|| per.getAddress().getCity().equals(search) || per.getAddress().getState().equals(search))
				.collect(Collectors.toList());
		System.out.println("-------------------->>Search Found<<--------------------------------");
		if (person != null) {
			person.forEach(p -> {
				System.out.println("Name:" + p.getFirstName());
				System.out.println("Contact:" + p.getPhoneNo());
				Address address = p.getAddress();
				System.out.println("city:" + address.getCity());
				System.out.println("State:" + address.getState());
				System.out.println("-----------------------------------------------------------------------");

			});
		} else {
			System.out.println("The Person You Searched Not Found");
		}
	}
}
