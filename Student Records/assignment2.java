package lab2;
//Author: Kel Knight and Kendall Ward-Hill
//Date: 9/3/2025
//Purpose: This program is the main one, uses and calls the methods in student records,
//and creates StudentRecords. 
//import scanner for user input
import java.util.Scanner;
public class assignment2 {
 public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     //declare and initialize scanner for user input
     //create the first record by asking user for their input
     System.out.println("Please enter the first record. Enter the number of students, then list them individually with their GPA beside their name: ");
    
     // create the first record by making an object, StudentRecords
     StudentRecords firstRecord = new StudentRecords();
    
     //call fillStudentRecords with the first record/ user input  
     firstRecord.fillStudentRecords(in);
     //ask for the second record
     System.out.println("\nPlease enter the second record with the number of students first, then list them individually including their GPA : ");
    
     //create a new record object
     StudentRecords secondRecord = new StudentRecords();
    
     //call the fill method to pass the input into the object 
     secondRecord.fillStudentRecords(in);
     //create a combined record, appending the second record to the first record and thus creating a combined new record
     StudentRecords combined = firstRecord.appendRecords(secondRecord);
     //show the user the averages with correct formatting, call average method with each record
     System.out.printf("%nFirst record average GPA:   %.2f%n", firstRecord.averageGPA());
     System.out.printf("Second record average GPA:  %.2f%n", secondRecord.averageGPA());
     System.out.printf("The combined records average GPA:%.2f%n%n", combined.averageGPA());
    
     //display all of the records to the user once more so they can see the records after averages
     System.out.println("Record 1:\n" + firstRecord);
     System.out.println("Record 2:\n" + secondRecord);
     System.out.println("Student Records:\n" + combined);
     //use the get gpa method, ask for which student name to look for then search for the student
     System.out.print("Which student would you like to look up? : ");
    
     //create whichStudent, this variable will be used to hold the name of the user input
     //create a double grade variable to store the gpa of the correlating student by
     //calling the getGPA method to search all of the combined record for a name in all of the records
     String whichStudent = in.next();
     double grade = combined.getGPA(whichStudent);
    
     //prints out the desired students GPA, or prints an error if the name is not inside the record list since -1 is returned
     //if g >= 0 then the student record will get pulled up, otherwise results in error message
     if ( grade >=0) {
     	//display the searched name and their gpa since they are in the record
     	System.out.println(whichStudent + " 's gpa is " + grade);
     }
     //tell the user the student was not found in the record
     else { System.out.println(whichStudent + " was not found in the record.");
     }
     //call the setGPA method to update the student’s gpa, based on the name input
     System.out.print("\nUpdate a student's record (enter the name and new GPA): ");
    
     //use a string variable to hold user input for name, use double to get user input for the replacement gpa or if the name and gpa did not previously exist inside the record
     String newName = in.next();
     double newGpa = in.nextDouble();
    
     //use the setGPA method with the combined record so it goes through all of the student records    
     //check to see that the name being updated is in the record to begin with, if it is not tell the user that name was not found,
     //if it is found tell the user the record was updated
//
     System.out.println(combined.setGPA(newName, newGpa) ? newName  + "'s record has been updated." : "Not found in record.");
     System.out.println("\nUpdated Record:\n" + combined);
 }
}
