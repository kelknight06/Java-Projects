package lab7;
import java.util.Stack;
//Authors: Kel Knight and Kendall Ward-Hill
//Date: 11/2/2025
//For Compsci 2, CS265
//Purpose:to make character stack, reverse strings via text, check if theyre structurally equal, and then take a stack and convert it to string

public class CharStack {
	private Stack<Character> myCharacters;
	public CharStack() {
		myCharacters = new Stack<>();
	}
		/* 
		Precondition: check if a character is an alphabetic letter
		Postcondition: only alphabetic letters of the string are in the private
		stack..
		*/
		public void StringToStack(String s) {
	        if (s == null)
	            throw new IllegalArgumentException("input String is null");
	        
	        myCharacters = new Stack<Character>();
	        int n = s.length();
	        for (int i = 0; i < n; i++) {
	            char c = s.charAt(i);
	            if (Character.isLetterOrDigit(c))
	            	myCharacters.push(Character.toLowerCase(c));
	        }
	    }
		//Precondition: Private stack is not empty.
		//Postcondition: If private stack is empty, displays error and returns.
		public CharStack Reverse(){
			if (myCharacters == null) {
				throw new IllegalArgumentException("the stack is null");
			}
			//@SuppressWarnings("unchecked")
			 Stack<Character> cloneStack = new Stack<Character>();
			 cloneStack.addAll(myCharacters);
		     CharStack reversedStack = new CharStack();
		     while(!cloneStack.isEmpty()) {
		    	 reversedStack.myCharacters.push(cloneStack.pop());
		     }
		     return reversedStack;
		    }
		/* Reverse function first creates a deep copy of its private stack.
		Then it empties out the deep copy into another stack,
		causing the order of the characters to be reversed. Returns this new
		stack.
		Otherwise: Returns new stack containing private stack's
		elements in reverse order. Private stack should not be changed.
		
		*/
		/*Precondition: Neither stack is empty.
		Postcondition: If either stack is empty,
		displays error message and returns.*/
		@Override
		    public boolean equals(Object B) {
		        if (B == null) {
		        	System.out.println("The stack is empty");
		        	return false;
		        }
		        if (this.getClass().equals(B.getClass())) {
		        	CharStack otherStack = (CharStack) B; // Cast
		        	return myCharacters.equals(otherStack.myCharacters);
				}
		        return false;
		    }
	
		/* Postcondition: Contents of stack have been converted to string on one line.
		the private stack myCharacters is unchanged.
		*/
		@Override
		public String toString(){
			StringBuilder stringBuilder = new StringBuilder();
			for (char c: myCharacters) {
			stringBuilder.append(c);
			}
			String result = stringBuilder.toString();
			return result;
			}
		


}
