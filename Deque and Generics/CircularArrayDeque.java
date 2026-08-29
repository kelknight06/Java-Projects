package lab10;
//Authors: Kel Knight and Kendall Ward-Hill
//Date: 11/22/2025
//For Compsci 2, CS265
//Purpose:Deque. Use circular array to add, remove, peek etc both sides of the array while using generics
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class CircularArrayDeque<E> implements Iterable<E>, Cloneable{
    private E[] array;
    private int front;
    private int back;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public CircularArrayDeque() {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = 3;
        this.array = (E[]) new Object[capacity];
        this.front = 0;
        this.back = 0; 
        this.size = 0;
    }
    @SuppressWarnings("unchecked")
    public CircularArrayDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.front = 0;
        this.back = 0; 
        this.size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void push_front(E element) {
        if (size == capacity) {
            throw new IllegalStateException("Deque is full.");
        }
        front = (front - 1 + capacity) % capacity;
        array[front] = element;
        size++;
    }
    public void push_back(E element) {
        if (size == capacity) {
            throw new IllegalStateException("Deque is full.");
        }
        array[back] = element;
        back = (back + 1) % capacity;
        size++;
    }

    public E pop_front() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty.");
        }
        E element = array[front];
        array[front] = null; 
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    public E pop_back() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty.");
        }
        back = (back - 1 + capacity) % capacity;
        E element = array[back];
        array[back] = null; 
        size--;
        return element;
    }

    public E front() {
        if (isEmpty()) {
            return null;
        }
        return array[front];
    }

    public E back() {
        if (isEmpty()) {
            return null;
        }
        return array[(back - 1 + capacity) % capacity];
    }
    @Override
	public String toString() {
		if (front == back) {
			return "Empty queue";
		}
		
		StringBuilder builder = new StringBuilder();
		for (int i = front; i != back; i = (i + 1) % capacity) {
			builder.append(String.valueOf(array[i]));
			builder.append(", ");
		}
		return builder.substring(0, builder.length() - 2);
	}
    @Override
    @SuppressWarnings("unchecked")
    public CircularArrayDeque<E> clone() {
        try {
            CircularArrayDeque<E> clonedDeque = (CircularArrayDeque<E>) super.clone();
            clonedDeque.array = Arrays.copyOf(this.array, this.capacity);
            return clonedDeque;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<E> {
        private int currentIndex = front;
        private int elementsLeft = size;

        @Override
        public boolean hasNext() {
            return elementsLeft > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = array[currentIndex];
            currentIndex = (currentIndex + 1) % capacity;
            elementsLeft--;
            return element;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported by this iterator.");
        }
    }

}
