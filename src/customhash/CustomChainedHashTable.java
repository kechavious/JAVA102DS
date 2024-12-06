package customhash;

public class CustomChainedHashTable implements IndexInterface_list {
	// Hash table implemented as an array of Integer LinkedLists
	private LinkedList<Integer>[] table;
	int numItems = 0; // Tracks the number of items in the hash table

	// Global variable for indicating NOT_FOUND
	public final int NOT_FOUND = -12345;
	
	// Constructor: Initialize an empty hash table with the given size
	public CustomChainedHashTable(int n) {
		table = (LinkedList<Integer>[]) new LinkedList[n]; 
		for (int i = 0; i < n; i++)
			table[i] = new LinkedList<>();
			numItems = 0;
	} 
	
	// Hash function: Computes hash value as x % table length
	private int hash(Integer x) {                         
		return x % table.length; 
	}
	
	// Inserts a key value into the hash table
	public void insert(Integer x) {	
		int index = hash(x); // Get hash index
		table[index].append(x); // Add to the linked list
		numItems++; // Increment item count
	}
	
	// Searches for a key in the hash table
	// Returns the node containing the key or null if not found
	public Node search(Integer x) {
		int index = hash(x); // Get hash index
		int pos = table[index].indexOf(x); // Get position in the linked list
		if (pos == -1) { // Key not found
			return null;
		}
		return table[index].getNode(pos); // Return the node containing the key
	}
	
	// Deletes a key from the hash table
	public void delete(Integer x) {
		int index = hash(x); // Get hash index
		int pos = table[index].indexOf(x); // Find position of the key
		if (pos != -1) { // If key exists, remove it
			table[index].remove(pos); 
			numItems--; // Decrement item count
		}
	}
	
	// Checks if the hash table is empty
	public boolean isEmpty() {
		return numItems == 0; // True if no items in the table
	}
	
	// Clears the entire hash table
	public void clear() {
		for (int i = 0; i < table.length; i++) { 
			table[i].clear(); // Clear each linked list
		}
		numItems = 0; // Reset item count
	}

	// Prints all elements in the hash table for debugging
	public void printAll() {
		for (int i = 0; i < table.length; i++) {
			System.out.print("Slot " + i + " : ");
			table[i].printAll(); // Print contents of each slot
		}
	}
}


