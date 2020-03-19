package com.bridgelabz.addressbook.utility;

import java.util.Scanner;

public class Util {
final public static Scanner scanner=new Scanner(System.in);
	
	public static int InputInt()
	{
		int int_variable=scanner.nextInt();
		return int_variable;
	}
	
	public static float InputFloat()
	{
		float float_varialble=scanner.nextFloat();
		
		return float_varialble;
	}
	
	public static long inputLong()
	{
		long long_variable=scanner.nextLong();
		return long_variable;
	}
	
	public static char InputChar()
	{
		char char_variable=scanner.next().charAt(0); 
		return char_variable;
	}
	
	public static String InputString()
	{
		String string_variable=scanner.next(); 
		return string_variable;
	}
	
	public static double InputDouble()
	{
		double double_variable=scanner.nextDouble();
		
		return double_variable;
	}
	
	public static boolean InputBoolean()
	{
		boolean boolean_variable=scanner.nextBoolean();
		return boolean_variable;
	}
}
