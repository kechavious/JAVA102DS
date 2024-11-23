package customstack;
import customstack.Node;

public class CustomLinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode; // the top node of stack

	// Constructor 1: Creating an Linked.
	public CustomLinkedStack() {
		//**********************************//
		topNode = null;
		//**********************************//
	}
	
	// Implementation of push(): Inserting element x to the stack
	// Return 0 after the push() operation in other cases
	public int push(E newItem) {
		try{
			Node<E> newNode = new Node<>(newItem);
			newNode.next = topNode;
			topNode = newNode;
			return 0;
		}catch(Exception e){
			return -1;
		}
		
		
	}
	
	// Implementation of pop(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the pop operation
	public E pop() {
		try{
			E item = topNode.item;
			topNode = topNode.next;
			return item;

		}catch(Exception e){
			return null;
		}
	}
	
	// Implementation of top(): getting the top element in the stack
	// Return null if an exception occurs
	// Return false otherwise
	public E top() {
		try{
			if(topNode == null){
				return null;
			}
			return topNode.item;
			
		}catch(Exception e ){
			return null;
		}
	}
	
	// Implementation of isEmpty(): Checking if the stack is empty
	// Return true if the stack is empty
	// Return false otherwise
	public boolean isEmpty() {
		try{
			if(topNode == null){
				return true;
			}
			else{
				return false;
			}
			
		}catch(Exception e){
			return false;
		}
	}
	
	// Implementation of dequeueAll(): Empty stack
	public void popAll() {
		while(topNode != null){
			topNode = topNode.next;
		}
	}

	//////////////////////////////////////////////
	public void printAll() {
		Node<E> t;
		System.out.print("Stack from top: ");
		for(t=topNode; t != null; t = t.next) {
			System.out.print(t.item + " ");
		}
		System.out.println();
	}
} // 코드 6-4
