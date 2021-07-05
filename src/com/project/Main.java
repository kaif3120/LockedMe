package com.project;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Operations op= new Operations();
		
		System.out.println("Welcome to LockedMe.Com developed by Mohd Kaif");
		System.out.println(" ");
		
		op.listFile();
		//conditional rendering of operations using a a loop
		while(true) {
			System.out.println(" ");
			System.out.println("press y to continue to operations, press n to exit");
			String ask = scanner.nextLine();
			
			if(ask.equals("y")) {
				//number of operations that can be performed
			System.out.println("Enter c: create file");
			System.out.println("Enter r: read file");
			System.out.println("Enter d: delete file");
			System.out.println("Enter l: list of files ");
			System.out.println("Enter e: to exit");
			}else if(ask.equals("n")) {
				break;
			}
			
			String command = scanner.nextLine();
			
			if(command.equals("c")) {
				op.createFile();
			}else if(command.equals("r")) {
				try {
				op.readFile();
				} catch (FileNotFoundException e) {
					System.out.println("File doesn't exists");
				}
			}else if(command.equals("d")) {
				op.deleteFile();
			}else if(command.equals("l")) {
				op.listFile();
			}else if(command.equals("e")) {
				break;
			   }
	  }
	}
	
}
