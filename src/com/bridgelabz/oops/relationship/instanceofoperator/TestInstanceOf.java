package com.bridgelabz.oops.relationship.instanceofoperator;

public class TestInstanceOf {
	static Call call=new Call();

	public static void main(String[] args) {
		System.out.println("Is Horsh Is Animal??");
		Animal horsh=new Horsh();
		call.isHorshAnimal(horsh);
		System.out.println("\n \nIs Horsh Is Bird??");
		Bird horshBird=new Bird() {
		};
		call.isHorshBird(horshBird);		
		
		System.out.println("\n \nIs Parrot Is Animal");
		Animal anima=new Animal() {
		};
		call.isParrotAnimal(anima);
		System.out.println("\n \nIs Parrot Is Bird");
		Bird bird=new Parrot();
		call.isParrotBird(bird);
		

	}

}
