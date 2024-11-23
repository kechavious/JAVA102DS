package customstack;

public class CustomArrayStack<E> implements StackInterface<E> {	
	private E stack[];
	private int topIndex;              // the top index of Stack
	private static final int DEFAULT_CAPACITY = 10; // Do not change this value
 
	// Constructor 1: Creating an ArrayStack with DEFAULT_CAPACITY.
	public CustomArrayStack() {	
		stack = (E[]) new Object[DEFAULT_CAPACITY];
		//**********************************//
		topIndex = -1;
		//**********************************//
	}

	// Constructor 2: Creating an ArrayStack of size n.
	public CustomArrayStack(int n) {	
		stack = (E[]) new Object[n];
		//**********************************//
		topIndex = -1;
		//**********************************//
	}
	
	// Implementation of push(): Inserting element x to the stack
	// Return -1 if an exception occurs when inserting an element into the stack
	// Return 0 after the push() operation in other cases
	public int push(E newItem) {
	// ----------------- write your code here ----------------- //
		try{
			if(topIndex>=stack.length-1){
				return -1;
			}
			else{
				stack[++topIndex] = newItem;
				return 1;
			}
		}catch(Exception e){
			return -1;
		}
	
	// -------------------------------------------------------- //
	}
	
	// Implementation of pop(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the pop operation
	public E pop() {
	// ----------------- write your code here ----------------- //
		try{
			if(topIndex<0){
				return null;
			}else{
				E item = stack[topIndex];
				stack[topIndex--] = null;
				return item;
			}
		}catch(Exception e){
			return null;
		}
	
	// -------------------------------------------------------- //
	}

	// Implementation of top(): getting the top element in the stack
	// Return null if an exception occurs
	// Return false otherwise
	public E top() {
	// ----------------- write your code here ----------------- //
	try{
		if(topIndex<0){
			return null;
		}
		return stack[topIndex];
	}catch(Exception e){
		return null;
	}

		
	
	// -------------------------------------------------------- //
	}
	
	// Implementation of isEmpty(): Checking if the stack is empty
	// Return true if the stack is empty
	// Return false otherwise
	public boolean isEmpty() {
	// ----------------- write your code here ----------------- //
		try{
			return topIndex<0;
		}catch(Exception e){
			return false;
		}
	
	// -------------------------------------------------------- //
	}
	
	// Implementation of isFull(): Checking if the list is full
	// Return true if the list is full
	// Return false otherwise
	public boolean isFull() {
	// ----------------- write your code here ----------------- //
		try{
			if(topIndex==stack.length-1){
				return true;

			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	
	// -------------------------------------------------------- //
	}
 
	// Implementation of dequeueAll(): Empty stack
	public void popAll( ) {
	// ----------------- write your code here ----------------- //
		for(int i = 0; i < stack.length;i++){
			stack[i] = null;
			topIndex--;
		}
	
	// -------------------------------------------------------- //
	}

	////////////////////////////////////////////
	public void printAll() {
		System.out.print("Stack from top:");
		for(int i=topIndex; i>=0; i--) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}

	public int getTopIndex() {
		return topIndex;
	}
} // 코드 6-2
