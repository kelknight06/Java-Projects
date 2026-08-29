package lab9;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
//Author: Kel Knight and Kendall Ward-Hill
//Date: 11/14/2025
//Purpose: implement the interface of inventory, then update the queue/circular array and edit based off of the desired action
public class circularArray implements Inventory {
	private int front;
	private int back;
	private Object[] arr;
	private int length;
	
	public circularArray() {
		arr = new Object[DEFAULT_CAPACITY + 1];
		front = 0;
		back = 0;
		length = arr.length;
	}
	
	public circularArray(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity must be at least 1.");
		}
		arr = new Object[capacity + 1];
		front = 0;
		back = 0;
		length = arr.length;
	}
	@Override
	public boolean isEmpty() {
		return front == back;
	}
	@Override
	public void enqueue(Object item) {
		int backUpdate = (back + 1) % length;
		if (backUpdate == front) {
			System.out.println("Cannot add " + item + " to the queue.");
		}
		
		arr[back] = item;
		back = backUpdate;
		return;
	}
	@Override
	public Object dequeue() {
		if (front == back) {
			System.out.println("Cannot dequeue from an empty queue");
		}
		
		Object element = arr[front];
		front = (front + 1) % length;
		return element;
	}
	@Override
	public int length() {
		return back - front;
	}

	@Override
	public Object peek() {
		if (front == back) {
			System.out.println("Cannot dequeue from an empty queue");
		}

		return arr[front];
	}
	
	@Override
	public void clear() {
		arr = new Object[arr.length];
		front = 0;
		back = 0;
	}
	@Override
	public Iterator<Object> iterator() {
		Iterator<Object> queueIterator = new Iterator<Object>() {
			int index = front;
			
			@Override
			public boolean hasNext() {
				return index < back;
			}

			@Override
			public Object next() {
				if (index >= back) {
					throw new NoSuchElementException();
				}
				
				Object element = arr[index];
				index = (index + 1) % length;
				return element;
			}
		};
		return queueIterator; 
	}
	@Override
	public String toString() {
		if (front == back) {
			return "Empty queue";
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = front; i != back; i = (i + 1) % length) {
			builder.append(String.valueOf(arr[i]));
		}
		return builder.substring(0, builder.length() - 2);
	}
	@Override
	public Object clone() {
		circularArray clone = new circularArray(length - 1);	
		clone.front = this.front;
		clone.back = this.back;
		clone.arr = Arrays.copyOf(this.arr, length);
		return clone;
	}
	

}
