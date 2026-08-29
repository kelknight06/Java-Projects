package lab2;
//Author: Kel Knight and Kendall Ward-Hill
//Date: 9/3/2025
//Purpose: This program is the methods and constructors, it creates methods to do
//various functions to a department's student record
//It processes a department student’s name, and gpa as well as how many entries there are.
//StudentRecords class
import java.util.Arrays;
import java.util.Scanner;
class StudentRecords {
	//student names
   private String[] names;
   //student GPAS
   private double[] gpas;
   //number of records stored
   private int size;     
   //constructors
   //by using constructor chaining, one constructor can be called
   // upon by another instructor inside the same class
   public StudentRecords() { this(100); }
   public StudentRecords(int capacity) {
       if (capacity < 0) capacity = 0;
       names = new String[capacity];
       gpas  = new double[capacity];
       size  = 0;
   }
   	//Preconditions: takes in user input as an argument
	//Postconditions: fills records from user input (number of records then number of lines of name, and then GPA)
   public void fillStudentRecords(Scanner input) {
       int num = input.nextInt();
       //use ensureCapacity to make sure the minimum capacity can store
       //the input into the record, and it doesnt exceed the capacity
       ensureCapacity(size + num);
       for (int i = 0; i < num; i++) {
           String name = input.next();
           double gpa = input.nextDouble();
           names[size] = name;
           gpas[size]  = gpa;
           size++;
       }
   }
   
   //Preconditions: pass the student name through the parameter
   //Postconditions: returns GPA if found, else return -1
   public double getGPA(String student) {
	   //check the indexOf the student to find if the name exists and is at an index in the record
       int idx = indexOf(student);
       // use ? as a condensed if-else statement. if idx is greater than or equal to 0, then get the corresponding gpa
       return (idx >= 0) ? gpas[idx] : -1.0;
   }
   //Preconditions: takes in a students name, and their gpa, passing it through parameters
   //Postconditions: sets GPA if the name is found in the record
   public boolean setGPA(String student, double gpa) {
       int idx = indexOf(student);
       if (idx >= 0) {
           gpas[idx] = gpa;
           //return true so that the display conditional can tell the user there has been an update
           return true;
       }
       return false;
   }
   //Preconditions: takes in the object of StudentRecords through a parameter
   //Postconditions: appends two records together then returns a NEW object
   public StudentRecords appendRecords(StudentRecords A) {
	   //use the field this size, and the passed through record's size for new object
       StudentRecords out = new StudentRecords(this.size + A.size);
       //copy everything of this
       for (int i = 0; i < this.size; i++) {
           out.names[out.size] = this.names[i];
           out.gpas[out.size]  = this.gpas[i];
           out.size++;
       }
       //copies everything of A
       for (int i = 0; i < A.size; i++) {
           out.names[out.size] = A.names[i];
           out.gpas[out.size]  = A.gpas[i];
           out.size++;
       }
       //return the new object that is a combination of the two
       return out;
   }
   //Preconditions: called with a record to calculate the records average
   //Postconditions: returns average GPA in the record
   public double averageGPA() {
	   //ensure there is no division by 0 error
       if (size == 0) return 0.0;
       
       double sum = 0.0;

       for (int i = 0; i < size; i++) {
    	   sum += gpas[i];
       }
       return sum / size;
   }
   //strings form
   //Preconditions:usage of string objects, must override
   //Postconditions:avoids creating a new string object each time, returns object
   @Override
   public String toString() {
       StringBuilder sb = new StringBuilder("Record Size = " + size + "\n");
       for (int i = 0; i < size; i++) {
    	   //format the names and gpas with spacing and correct decimal places
           sb.append(String.format("%-12s %.2f%n", names[i], gpas[i]));
       }
       return sb.toString();
   }
   //methods to help program running
   
   //Preconditions: pass the minimum capacity through
   //Postconditions: resize arrays based on capacity, copies all previous values into new ones
   private void ensureCapacity(int minCapacity) {
	   //if said capacity is not as long as the names array return the validity of that
       if (minCapacity <= names.length) return;
       //math.max finds the larger of the two, names.length*2 is for a 
       //potential new capacity and whichever is the larger
       //is the capacity
       int newCap = Math.max(minCapacity, names.length * 2);
       
       names = Arrays.copyOf(names, newCap);
       gpas  = Arrays.copyOf(gpas,  newCap);
   }
   //Precondition: pass student name through that was user input
   //Postcondition: make a method to ignore the case of the student name input, returns correct name
   private int indexOf(String student) {
       for (int i = 0; i < size; i++) {
           if (names[i].equalsIgnoreCase(student)) return i;
       }
       return -1;
   }
}



