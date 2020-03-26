package com.bridgelabz.oops.polymorphism.runtimepolymorphism;

public class RuntimePolymorphysam {

	public static void main(String[] args) {
		Car car;
		System.out.println("---------->Honda Amaze Specification<-------------");
		car=new HondaAmaze();
		car.Speed();
		car.mileage();
		car.fuelType();
		
		System.out.println("---------------->Trevita Specification<-------------------");
		car=new Trevita();
		car.Speed();
		car.fuelType();
		car.mileage();
		
		System.out.println("-------------->BucatiChiron Specification<------------------------");
		car=new BucatiChiron();
		car.Speed();
		car.fuelType();
		car.mileage();
		
	}

}
