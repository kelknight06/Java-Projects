package lab8;
//Authors: Kel Knight and Kendall Ward-Hill
//Purpose: to test recursion knowledge by doing different recursion methods/functions, and then calling them in main
import java.util.ArrayList;
public class Recursion {
	// a recursive function that writes a char based on the amount of times determined
	public static char writeLine(char symbol, int num) {
		if (num > 0) {
			System.out.print(symbol);
			return writeLine(symbol, num - 1);
		} else {
			return ' ';
		}
	}
	//a recursive function that writes a black of characters using writeLine
	public static char writeBlock(char symbol, int num, int rows) {
		System.out.println(writeLine(symbol, num));
		if (rows > 0) {
			return writeBlock(symbol, num, rows -1);
		} else {
			return ' ';
		}
	}
	//a recursive function that takes a string of characters and reverses them and returns a string
	public static String writeBackward(String words, int num) {
		if (num > 0) {
			
			return words.charAt(num-1)+ writeBackward(words.substring(0, num -1),num-1);
		}
		else {
			return "";
		}
	}
	// a recursive function that displays an array list in order
	public static void displayArrayList (ArrayList<Integer> A, int first, int last) {
		if (first > last) {
			return;
		}
		else {
			System.out.println(A.get(first));
			displayArrayList(A, first + 1, last);
		}
	}
	// a recursive function that counts the amount of vowels in a string and returns that int
	public static int vowels(String s, int size) {
		
		if (size > 0) {
			char currChar = Character.toLowerCase(s.charAt(size-1));
			int count = 0;
			if (currChar == 'a' ||currChar == 'e'||currChar == 'i'||currChar == 'o' ||currChar == 'u' ) {
				count = 1;
			}
			return count + vowels(s, size - 1);
		}
		else {
			return 0;
			
		}
	}
	// a recursive void method that reverses a string
	public static void ReverseString(String s) {
		if (s == null || s.length() <= 1) {
			System.out.print(s);
			return;
		}
		else {
			System.out.print(s.charAt(s.length()-1));
			ReverseString(s.substring(0,s.length() - 1));
		}
	}
	public static void main(String[] args) {
		char test = writeLine('*',3);
		System.out.println(test);
		char test2 = writeBlock('*',5, 3);
		System.out.println(test2);
		String test3 = writeBackward("abcde",5);
		System.out.println(test3);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(34);
		list.add(76);
		list.add(2);
		displayArrayList(list, 0, 3);
		String test4 = "I love Jake!";
		System.out.println("Vowels in: " + test4 +vowels(test4, test4.length()));
		String test5  = "I love albert!";
		System.out.println(test5);
		System.out.print("Now reversed: ");
		ReverseString(test5);
	}

}
