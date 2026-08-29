package lab5;
/*Author: Kel Knight and Kendall Ward-Hill
Date: 10/14/2025
Purpose: to read a file and write onto another with exceptions being handled*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
public class recordsProgram {

	public static void main(String[] args) throws Exception { 
	
		String file = ("C:\\Users\\pinhead\\eclipse-workspace\\lab5\\src\\lab5\\files\\studentRecords.txt");
		String newFile = ("C:\\Users\\pinhead\\eclipse-workspace\\lab5\\src\\lab5\\files\\averages.txt");
		//try to run all of the code with the scanner scanning the file with the string name, then write to the new file with that string name
	    try (Scanner fileScanner = new Scanner(new File(file));
	    		PrintWriter writer = new PrintWriter(new FileWriter(newFile))){
	        fileScanner.useDelimiter(",");
	        while (fileScanner.hasNext()) {
	        	String curr = fileScanner.next();
		        int delimCounter=1;
	            boolean validInput = false;
		        boolean validScore = true;
	            double curraverage = 0.0;
	            int currgrade1 = 0,currgrade2 = 0,currgrade3 = 0;
	            //check if there is an int, then put it in the grade and check if it is a valid int
	            if (fileScanner.hasNextInt()) {
                    currgrade1 = fileScanner.nextInt();
                    validInput = true;
                    delimCounter+=1;
                   if(currgrade1 <0 || currgrade1 > 100) {
                    validScore = false;
                    writer.write(curr + ": ERROR: Invalid Score Value (0-100)");
                    }
	            }
                if (fileScanner.hasNextInt()) {
                	currgrade2 = fileScanner.nextInt();
                	validInput = true;
                	delimCounter+=1;
                	 
                	if(currgrade2 <0 || currgrade2 > 100) {
                     	validScore = false;
                		 writer.write(curr + ": ERROR: Invalid Score Value (0-100)");
                	 }
                }
                if (fileScanner.hasNextInt()) {
                	currgrade3 = fileScanner.nextInt();
                	delimCounter+=1;
                	validInput = true;
                	 if(currgrade3 <0 || currgrade3 > 100) {
                     	validScore = false;
                		 writer.write(curr + ": ERROR: Invalid Score Value (0-100)");
                	 }
                }
                //check if there is the correct amount of values and then if not write error message
            if (delimCounter != 4 && validInput == true) {
            	 writer.write(curr + ": ERROR:(Invalid Data Format)");
            	 validInput=true;
           	 }//check if there is a non numeric score
            if (validInput!=true) {
            	writer.write(curr + ": ERROR: Non-numeric score.");
            }//write the id and average
            if (delimCounter == 4 && validScore == true) {
                curraverage = (currgrade1 + currgrade2 + currgrade3)/3;
                writer.write(curr + ": " + String.format("%.2f", curraverage));
            }
	    	}
	        //close scanner and writer
	        fileScanner.close();
	        writer.close();
	  //handle the exceptions and then close the writers
		}catch (FileNotFoundException e) {
	    		PrintWriter write = new PrintWriter(new FileWriter(newFile));
	    		write.println(e.getMessage());
	    		write.close();
		}catch(NumberFormatException e) {
				PrintWriter write = new PrintWriter(new FileWriter(newFile));
				write.println(e.getMessage());
				write.close();
	    }catch (IOException e) {
	    		PrintWriter write = new PrintWriter(new FileWriter(newFile));
	    		write.println(e.getMessage());
	    		write.close();
		}
	}
}
	



