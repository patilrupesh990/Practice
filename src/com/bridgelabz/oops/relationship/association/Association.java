package com.bridgelabz.oops.relationship.association;

public class Association {
	public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Ratan sir");
        Teacher teacher2 = new Teacher("Kalpesh Sir");
        
        Student student1 = new Student("Ramesh");
        Student student2 = new Student("Suresh");
        Student student3 = new Student("Farukh");
        Student student4 = new Student("Mahesh");
        
        teacher1.addStudent(student1);
        teacher1.addStudent(student2);
        teacher1.addStudent(student3);
        
        teacher2.addStudent(student2);
        teacher2.addStudent(student3);
        teacher2.addStudent(student4);
        
        teacher1.print();
        teacher2.print();
        student1.print();
        student2.print();
        student3.print();
        student4.print();
    }
	
}
