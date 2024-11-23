package customqueue;

public class CustomArrayQueue<E> implements QueueInterface<E> {

	private E queue[];
	private int front, tail, numItems;
	private static final int DEFAULT_CAPACITY = 10; // Do not change this value

	// Constructor 1: Creating an ArrayQueue with DEFAULT_CAPACITY.
	public CustomArrayQueue() { 
		queue = (E[]) new Object[DEFAULT_CAPACITY];
		//**********************************//
		front = 0;
		tail = -1;
		numItems= 0 ;
		//**********************************//
	}

	// Constructor 2: Creating an ArrayQueue of size n.
	public CustomArrayQueue(int n) { 
		queue = (E[]) new Object[n];
		//**********************************//
		front = 0;
		tail = -1;
		numItems= 0 ;
		//**********************************//
	}

	// Implementation of enqueue(): Inserting element x to the queue
	// Return -1 if an exception occurs when inserting an element into the queue
	// Return 0 after the enqueue() operation in other cases
	public int enqueue(E newItem) {
	// ----------------- write your code here ----------------- //
		try{
			if(isFull()){
				return -1;
			}else{
				tail = (tail+1)%queue.length;
				queue[tail] = newItem;
				++numItems;
				return 0;
			}
		}catch(Exception e ){
			return -1;
		}
	
	// -------------------------------------------------------- //
	}

	// Implementation of isFull(): Checking if the list is full
	// Return true if the list is full
	// Return false otherwise
	public boolean isFull() {
	// ----------------- write your code here ----------------- //
		try{
			if(tail>=DEFAULT_CAPACITY){
				return false;
			}else{
				return numItems == queue.length;
			}
		}catch(Exception e ){
			return false;
		}
	
	// -------------------------------------------------------- //
	}
 
	// Implementation of dequeue(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the dequeue operation
	public E dequeue() {
	// ----------------- write your code here ----------------- //
		try{
			if(isEmpty()){
				return null;
			}else{
				E item = queue[front];
				front = (front+1)%queue.length;
				numItems--;
				return item;
			}
		}catch(Exception e ){
			return null;
		}
	
	// -------------------------------------------------------- //
	}

	// Implementation of front(): getting the front element in the queue
	// Return null if an exception occurs
	// Return false otherwise
	public E front() {
	// ----------------- write your code here ----------------- //
		try{
			if(isEmpty()){
				return null;
			}else{
				return queue[front];
			}
		}catch(Exception e){
			return null;
		}
	
	// -------------------------------------------------------- //
	}

	// Implementation of isEmpty(): Checking if the queue is empty
	// Return true if the queue is empty
	// Return false otherwise
	public boolean isEmpty( ) {
	// ----------------- write your code here ----------------- //
		try{
			if(numItems == 0){
				return true;
			}
			return false;
		}catch(Exception e ){
			return false;
		}
	
	// -------------------------------------------------------- //
	}

	// Implementation of dequeueAll(): Empty queue
	public void dequeueAll ( ) {
	// ----------------- write your code here ----------------- //
		front = 0;
		tail = -1;
		numItems = 0;
	// -------------------------------------------------------- //
	}

	//////////////////////////////////////////////////////////////////
	public void printAll() {
		int j = front;
		System.out.print("PrintAll: ");
		for(int i = 0; i < numItems; i++) {
			System.out.print(queue[j] + " ");
			j = (j+1) % queue.length;
		}
		System.out.println();
	}
}  

