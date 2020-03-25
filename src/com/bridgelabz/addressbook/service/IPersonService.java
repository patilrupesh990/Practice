package com.bridgelabz.addressbook.service;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.FileReadWrite;

public interface IPersonService {
	JSONParser parser = new JSONParser();
	String originbook = "D:\\java programs\\javaProject\\Practice\\src\\com\\bridgelabz\\addressbook\\jsonfiles\\";

	public void addPerson();

	public void deletePerson();

	public void sortPerson();

	public void dipslayPersonName();
	public void searchPerson();
	public boolean save();

	@SuppressWarnings("unchecked")
	public static List<Person> getPersonDataFromJSon() {
		List<Person> persons = new ArrayList();
		String fileData = FileReadWrite.readData(originbook + AddressBookImpl.getBookName());
		JSONObject jobject = null;

		if (fileData != null) {
			try {
				jobject = (JSONObject) parser.parse(fileData);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		JSONObject jsonobj = jobject;
		jsonobj.forEach((k, v) -> {

			JSONArray array = (JSONArray) jsonobj.get(k);
			array.forEach(p -> {
				Person person=new Person();
				JSONObject object = (JSONObject) p;
				person.setFirstName(object.get("First Name").toString());
				person.setLastName(object.get("Last Name").toString());
				person.setPhoneNo((long) object.get("Mob No"));
				JSONObject jaddress = (JSONObject) object.get("Adress");
				Address address = new Address();
				address.setStreet(jaddress.get("street").toString());
				address.setCity(jaddress.get("city").toString());
				address.setState(jaddress.get("state").toString());
				address.setPinCode(Integer.parseInt(jaddress.get("pincode").toString()));
				person.setAddress(address);
				persons.add(person);
			});

		});
		return persons;
	}
}
