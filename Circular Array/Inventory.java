package lab9;
//Author: Kel Knight and Kendall Ward-Hill
//Date: 11/14/2025
//Purpose: the interface for the queue, called inventory
public interface Inventory extends Iterable<Object>, Cloneable {
	public static final int DEFAULT_CAPACITY = 5;
	public boolean isEmpty();
	public void enqueue(Object item);
	public Object dequeue();
	public int length();
	public Object peek();
	public void clear();
	public Object clone();
}
