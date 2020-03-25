package com.bridgelabz.oops.relationship.association;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private final String name;
    private final List<Teacher> teachers = new ArrayList<>();
      
    // student name 
    Student(String name) { 
        this.name = name; 
    } 
      
    public String getName() { 
        return this.name; 
    }
    
    public void addTeacher(Teacher teacher) { 
        this.teachers.add(teacher);
    }
    
    public List<Teacher> getTeachers() {
        return teachers;
    }
    
    public void print() {
        System.out.println("Student " + this.name + "'s teachers are:");
        for (Teacher teacher:this.teachers) {
            System.out.println("- " + teacher.getName());
        }
    }
}
