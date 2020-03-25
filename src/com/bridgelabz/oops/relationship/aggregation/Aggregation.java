package com.bridgelabz.oops.relationship.aggregation;

public class Aggregation {
	
	public static void main(String[] args) {
        Employee employee1 = new Employee("Malisha");
        Employee employee2 = new Employee("Kunal");
        Employee employee3 = new Employee("kaveri");
        Employee employee4 = new Employee("sitaram");
        Employee employee5 = new Employee("gaurang");
        Employee employee6 = new Employee("Vishal");
        Employee employee7 = new Employee("Vicky");
        Employee employee8 = new Employee("Rahul");
        
        employee3.setSupervisor(employee1);
        employee4.setSupervisor(employee1);
        employee5.setSupervisor(employee1);
        employee6.setSupervisor(employee2);
        employee7.setSupervisor(employee2);
        employee8.setSupervisor(employee2);
        
        employee1.print();
        employee2.print();
        employee3.print();
        employee8.print();
    }

}
