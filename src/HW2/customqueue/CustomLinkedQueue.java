package customqueue;
import customqueue.Node;

public class CustomLinkedQueue<E> implements QueueInterface<E>{
	private Node<E> tail;

	// Constructor 1: Creating an LinkedQueue.
	public CustomLinkedQueue( ) {
		//**********************************//
		tail = null;
		//**********************************//
	}
 
	// Implementation of enqueue(): Inserting element x to the queue
	// Return -1 if an exception occurs when inserting an element into the queue
	// Return 0 after the enqueue() operation in other cases
	public int enqueue(E newItem) {
		try {
			Node<E> newNode = new Node<>(newItem);
			if (tail == null) {
				newNode.next = newNode;
				tail = newNode;
				
			} else {
				newNode.next = tail.next;
				tail.next = newNode;
				tail = newNode;
				
			}
			return 0;
		} catch (Exception e) {
			return -1;
		}
	}
		
	// Implementation of dequeue(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the dequeue operation
	public E dequeue( ) {
		try{
			if(isEmpty()){
				return null;
			}else if(tail== tail.next){
				E item = tail.item;
				tail = null;
				return item;
			}else{
				//creat the head;
				Node<E> head = tail.next;
				E item = head.item;
				tail.next = head.next;
				return item;
			}
			
		}catch(Exception e ){
			return null;
		}
	}
		
	// Implementation of front(): getting the front element in the queue
	// Return null if an exception occurs
	// Return false otherwise
	public E front() {
		try{
			if(isEmpty()){
				return null;
			}else{
				return tail.next.item;
			}
		}catch (Exception e){
			return null;
		}
	}
		
	// Implementation of isEmpty(): Checking if the queue is empty
	// Return true if the queue is empty
	// Return false otherwise
	public boolean isEmpty() {
		return tail == null;
	}
		 
	// Implementation of dequeueAll(): Empty queue
	public void dequeueAll ( ) {
		tail = null;
	} 
	
	/////////////////////////////////////////////////////
	public void printAll() {
		Node<E> t = tail;
		System.out.println("Queue from front to tail");
		if (!isEmpty()) 
			do {
				t = t.next;
				System.out.println(t.item);
			} while (t != tail);
		else System.out.println("Empty Queue!");
	}
} 
	
