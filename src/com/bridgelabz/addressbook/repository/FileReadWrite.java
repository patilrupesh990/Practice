package com.bridgelabz.addressbook.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class FileReadWrite {

	static JSONObject jsonObject = new JSONObject();

	public static boolean WriteinFile(String data, String filename) {
		try {
			FileWriter fileWriter = new FileWriter(filename);
			fileWriter.write(data);
			fileWriter.flush();
			fileWriter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String readData(String fileName) {
		
		File file;
		file=new File(fileName);
		FileReader filereader=null;
		BufferedReader b_reader;
		String line="";
		
		
			try 
			{
				filereader = new FileReader(file);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			b_reader=new BufferedReader(filereader);
			String temp="";
		
			
		try
		{
			while((temp=b_reader.readLine())!=null)
			{
				line+=temp;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			b_reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
}
