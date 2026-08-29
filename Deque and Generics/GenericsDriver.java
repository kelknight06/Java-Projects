package lab10;
//Authors: Kel Knight and Kendall Ward-Hill
//Date: 11/22/2025
//For Compsci 2, CS265
//Purpose: to show the 5x3 2d array max finder via generics, and sort an arraylist with 10 integers 
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class GenericsDriver {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//find max of a 5 by 3 2d array made up of user input
		Integer[][] twoArray = new Integer[5][3];
		System.out.println("Enter 15 integers to fill a 5 by 3 2d array: ");
		for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                twoArray[i][j] = scanner.nextInt(); 
            }
        }
		 System.out.println("Array elements are:");
	        for (int i = 0; i < 5; i++) {
	            for (int j = 0; j < 3; j++) {
	               System.out.print(twoArray[i][j] + "\t");
	            }
	            System.out.println();
	        }
	        System.out.println("The max in this 2d array is: ");
	        System.out.println(max(twoArray));
	        //sort an array list
	        ArrayList<Integer> list = new ArrayList<>(10);
	        System.out.println("Enter 10 integers: ");
	        int count = 0;
	        while(count!=10) {
	        	list.add(scanner.nextInt());
	        	count ++;
	        }
	        System.out.println("The numbers sorted: ");
	        sort(list); 
	        scanner.close();
	}
	
	public static <T extends Comparable<T>> T max(T[][] array) {
		T maxTemp = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[j].length; j++) {
				if(array[i][j] != null && maxTemp.compareTo(array[i][j]) < 0) {
					maxTemp = array[i][j];
				}
			}
		}
		return maxTemp;
	}
	public static <T extends Comparable<T>>
		void sort(ArrayList<T> array) {
			int length = array.size();
			boolean swap;
			for (int i = 0; i < length - 1; i++) {
				swap = false;
				for(int j = 0; j < length - 1; j++) {
					if(array.get(j).compareTo(array.get(j+1)) > 0) {
						Collections.swap(array, j, j+1);
						swap = true;
					}
				}
				if (swap == false) {
					break;
				}
			}
			System.out.println(array);
	}
}

