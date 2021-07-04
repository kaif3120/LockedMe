package com.project;
import java.io.*;
import java.util.Scanner;

public class Main {

	public static BufferedOutputStream wstream;
	static Scanner scanner = new Scanner(System.in);
    public static BufferedInputStream  rstream;
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to the repository");
		System.out.println(" ");
		
		listFile();
		
		while(true) {
			System.out.println(" ");
			System.out.println("press y to continue to operations, press n to exit");
			String ask = scanner.nextLine();
			
			if(ask.equals("y")) {
			System.out.println("Enter c: create file");
			System.out.println("Enter r: read file");
			System.out.println("Enter d: delete file");
			System.out.println("Enter l: list of files ");
			System.out.println("Enter e: to exit");
			}else if(ask.equals("n")) {
				break;
			}
			
			String op = scanner.nextLine();
			
			if(op.equals("c")) {
				createFile();
			}else if(op.equals("r")) {
				try {
					readFile();
				} catch (FileNotFoundException e) {
					System.out.println("File doesn't exists");
				}
			}else if(op.equals("d")) {
				deleteFile();
			}else if(op.equals("l")) {
				listFile();
			}else if(op.equals("e")) {
				break;
			}
		}
		
		
		
		
		
		
	}
	
	
	public static void createFile() {
		System.out.println("Enter file name");
		String fileName = scanner.nextLine();
		String path = "files/"+fileName;
		try {
			wstream = new BufferedOutputStream(new FileOutputStream(path));
			
			System.out.println("Enter Content");
			String content = scanner.nextLine();
			String a = content;
			wstream.write(a.getBytes());
			System.out.println("sucessfully created file and added content");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(wstream != null) {
				try {
					wstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void readFile() throws FileNotFoundException {
		System.out.println("Enter file name");
		String fileName = scanner.nextLine();
		String path = "files/"+fileName;
	    File file = new File(path);
		
		try (Scanner sc = new Scanner(file)) {
			while(sc.hasNextLine()) {
				   System.out.print(sc.nextLine());
			   }
			System.out.println(" ");
			sc.close();
		}
	}
	
	public static void deleteFile() {
		System.out.println("Enter file name");
		String fileName = scanner.nextLine();
		String path = "files/"+fileName;
		File file = new File(path);
		
		boolean a = file.delete();
		if(a) {
			System.out.println("file deleted Sucessfully");
		}else {
			System.out.println("file not found");
		}
		
	}
	
	public static void listFile() {
		//Creating a File object for directory
	      File directoryPath = new File("files");
	      //List of all files and directories
	      File filesList[] = directoryPath.listFiles();
	      System.out.println("List of files in the directory:");
	      System.out.println(" ");
	      for(File file : filesList) {
	         System.out.println("File name: "+file.getName());
	      }
	}
}
