package com.bridgelabz.oops.relationship.compotion;
public class Composition {
	public static void main(String[] args) {
        Car peugeot = new Car("Peugeot 3008", new Engine(EngineType.PETROL));
        Car bmw = new Car("BMW X5 Diesel", new Engine(EngineType.DIESEL));    
        peugeot.print();
        bmw.print();
    }
}
