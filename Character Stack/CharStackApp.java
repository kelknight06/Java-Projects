package lab7;
//Authors: Kel Knight and Kendall Ward-Hill
//Date: 11/2/2025
//For Compsci 2, CS265
//Purpose: Read files of text, determine if its palindrome with stack, and then output to new text files
import java.util.Scanner;
import java.util.Stack;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
public class CharStackApp {
	//(use provided palindrome1.txt and palindrome2.txt files)
	//read file line by line and use the CharStack class to check
	//if the line is palindrome, you need to call StringToStack() function to
	//push all letters from the line to a CharStack
	//output the stack using toString() function
	//then call reverse() function to get the reverse of the above CharStack
	//call equals() function to check if the contents of two CharStacks
	//are the same and make decision about palindrome
	//output all palindrome lines to a file to save them
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a filename: ");
		String fileName = input.nextLine();
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try{
			int lineNum = 1;
			String line;
			boolean palindrome = false;
			reader = new BufferedReader(new FileReader(fileName));
			writer = new BufferedWriter(new FileWriter(fileName.replace(".txt", "") + "_results.txt"));
			CharStack testStack = new CharStack();
			CharStack reverseTest = new CharStack();
			while ((line = reader.readLine())!=null) {
				testStack.StringToStack(line);
				reverseTest = testStack.Reverse();
				palindrome = testStack.equals(reverseTest);
				if(palindrome == true) {
					System.out.println("Line: " + lineNum + " is a palindrome: " + palindrome);
					writer.write(reverseTest.toString());
					writer.newLine();
				}
				else {
					System.out.println("Line: " + lineNum + " is a palindrome: " + palindrome);	
				}
				lineNum++;
			}
		}catch (FileNotFoundException e) {
			System.err.println("The file was not found.");
		}catch (IOException e) {
			System.err.println("There was an error reading the file.");
		}finally{
			try {
				if (reader != null) {
					reader.close();
					writer.close();
				}
			}catch (IOException e) {
				System.err.println("Error closing the file reader: " + e.getMessage());
			}
			input.close();
			
		}
	}

}
