package com.bridgelabz.oops.relationship.instanceofoperator;

public class Call {

	public void isParrotAnimal(Animal animal) {
		if (animal instanceof Parrot) {
			Parrot parrot = (Parrot) animal;
			System.out.println("Parrot is Animal");
			parrot.run();
		} else {
			System.out.println("Parrot is Not a Animal");
		}
	}

	public void isParrotBird(Bird bird) {
		if (bird instanceof Bird) {
			System.out.println("Parrot is Bird");
			Parrot parrot = (Parrot) bird;
			parrot.fly();
		} else {
			System.out.println("Parrot is not a Bird");
		}
	}

	public void isHorshAnimal(Animal animal) {
		if (animal instanceof Horsh) {
			System.out.println("Horsh is Animal");
			Horsh horsh = (Horsh) animal;
			horsh.run();
		} else {
			System.out.println("Horsh is Not a Animal");
		}
	}

	public void isHorshBird(Bird bird) {
		if (bird instanceof Horsh) {
			System.out.println("Horsh is Bird");
			Horsh horsh = (Horsh) bird;
			horsh.fly();
		} else {
			System.out.println("Horsh is not a Bird");
		}
	}
}
