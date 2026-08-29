package lab10;
//Authors: Kel Knight and Kendall Ward-Hill
//Date: 11/22/2025
//For Compsci 2, CS265
//Purpose: To show the deque being tested and all the functions implemented
public class DequeTest {
    public static void main(String[] args) {
        CircularArrayDeque<Integer> deque = new CircularArrayDeque<>(5);
        deque.push_front(3);
        deque.push_back(14);
        deque.push_front(707);
        System.out.println("The current size after adding 3 elements: " + deque.size());
        System.out.println("First element: " + deque.front()); 
        System.out.println("Last element: " + deque.back());  
        Integer removedFirst = deque.pop_front(); 
        System.out.println("The removed first: " + removedFirst); 
        System.out.println("Size after removing: " + deque.size()); 
        deque.push_back(67); 
        deque.push_front(5); 
        System.out.println("The entire current deque: " + deque.toString());
        CircularArrayDeque<Integer> clonedDeque = deque.clone();
        clonedDeque.pop_front();
        clonedDeque.push_front(30);
        System.out.println("Cloned deque after changing: " + clonedDeque);
        System.out.println("The original deque(unchanged since its a deep copy): " + deque);
        //System.out.println("Cloned Deque: " + clonedDeque);
        for (Integer num: deque) {
        	 System.out.println("Removing via iterator implementation: " + deque.pop_back());
        }
        System.out.println("The original deque is empty: " + deque.isEmpty());
    }
}
