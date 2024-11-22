/**
 * @description: This file generates 10 random values and saves them to a file called outFile.txt. The program will then
 * 		retrieve those values and print them to the console.
 * 
 * @inputs: There are no inputs required for this program, it generates its own random integer values.
 * 
 * @outputs: This program outputs a list of random values to "../FileIO/outFile.txt", it will then read that document and 
 * 		print all of the numbers to the console.
 * 
 * 
 * @author: Erik Jackson
 * @contact: erik.jackson@my.century.edu
 * @since:10/27/2024
 * 
 * Institution: Century College
 * Instructor: Mathew Nyamagwa
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
	
	public static void readFile(File readFile) throws IOException {
		
		// try/catch
		try {
			//Create an instance of the FileInputStream Class to read the readFile(a.k.a. output.txt)
			FileInputStream textFile = new FileInputStream(readFile);
			// Create an instance of the Scanner Class to read the readFile input.
			Scanner reader = new Scanner(textFile);
			
			// While loop checks if there are any more values...
			while(reader.hasNextInt()) {
				// ...if there are more values, it prints them out.
				System.out.println(reader.nextInt());
			}
			
			// close the FileInputStream to release the file lock.
			reader.close();
			
		}
		// Handles exceptions.
		catch (IOException ex) {
			// error message in case things don't work.
			ex.printStackTrace();
		}
	}
	
	// This method will generate random values to populate the outFile.txt file
	public static void writeToFile(File writeFile) throws IOException {
		// listNumber is a variable to determine how many items should be in the list.
		int listNumber = 10;
		// listOfNums is an array to temporarily store the randomly generated values.
		int[] listOfNums = new int[listNumber];
		
		// try/catch
		try {
			// creates a PrintWriter instance to write to the writeFile(a.k.a. outFile.txt)
			PrintWriter output = new PrintWriter(writeFile);
			
			// loop to create random numbers to save to the text file.
			for(int i = 0; i < listNumber; ++i) {
				int newInt = (int) (Math.random() * 1000);
				listOfNums[i] = newInt;
			}
			
			// loop to save each value to the text file using PrintWriter output stream.
			for (int val : listOfNums) {
				output.println(val);
			}
			
			// closes the PrintWriter, to release the file lock.
			output.close();
		
		} 
		// Handles exceptions.
		catch (IOException ex) {
			// error message in case things don't work
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// filePath is a variable to save the relative path to the FileIO
		String filePath = "../FileIO/outFile.txt";
		
		// try/catch
		try {
			File externalFile = new File(filePath);
			// calls the method to generate numbers and writes them to a file.
			writeToFile(externalFile);
			
			// calls the method to read the file and print them to the console.
			readFile(externalFile);
		} 
		// Handles exceptions.
		catch (IOException ex) { 
			// error message, in case things don't work.
			ex.printStackTrace(); 
		};
		 
		//Prints absolute file path. Not necessary, but cool.
		//System.out.println(new File(".").getAbsolutePath());
	}
	
	
	
	

}
