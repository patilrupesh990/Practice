package com.bridgelabz.oops.relationship.aggregation;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	
	private final String name;
    private Employee supervisor;
    private final List<Employee> subordinates = new ArrayList<Employee>();
      
    Employee(String name) { 
        this.name = name; 
    } 
      
    public String getName() { 
        return this.name; 
    }
    
    public Employee getSupervisor() {
        return supervisor;
    }
 
    
    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
        supervisor.subordinates.add(this);
    }
    
    public void print() {
        System.out.println("Employee " + this.name + "'s supervisor is:" +
                (this.supervisor==null?"N.A.":supervisor.getName()));
        System.out.println("Employee " + this.name + "'s subordinates are:");
        for (Employee employee:this.subordinates) {
            System.out.println("- " + employee.getName());
        }
    }

}
