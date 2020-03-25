package com.bridgelabz.oops.relationship.association;

import java.util.ArrayList;
import java.util.List;

public class Teacher {

	private final String name;
	private final List<Student> students = new ArrayList<>();

	// teacher name
	Teacher(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void addStudent(Student student) {
		student.addTeacher(this);
		this.students.add(student);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void print() {
		System.out.println("Teacher " + this.name + "'s students are:");
		for (Student student : this.students) {
			System.out.println("- " + student.getName());
		}
	}
}

