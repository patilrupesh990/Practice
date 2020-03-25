package com.bridgelabz.oops.relationship.compotion;

public class Car {
	private final String name;
    private final Engine engine;
    
    public String getName() {
        return name;
    }
    
    public Engine getEngine() {
        return engine;
    }
    
    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }
    
    public void print() {
        System.out.println("Car " + this.name + 
                " engine is " + this.engine.getEngineType().toString());
    }
}
