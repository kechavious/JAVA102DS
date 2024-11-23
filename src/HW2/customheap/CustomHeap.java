package customheap;

public class CustomHeap<E extends Comparable<E>> implements PQInterface<E> {
    private E[] A;
    private int numItems;

    // Constructor 1: Creating an empty heap.
    public CustomHeap(int arraySize) {
        A = (E[]) new Comparable[arraySize];
        numItems = 0;
    }

    // Constructor 2: Creating a heap using the given array.
    public CustomHeap(E[] B, int numElements) {
        A = B; 
        numItems = numElements;
        buildHeap(); // Build the heap after initializing with existing elements
    }

    // Implementation of insert(): Inserting newItem to the heap
    // You should consider using percorlateUp() function
    // Return -1 if an exception occurs when inserting newItem into the heap
    // Return 0 after the insert() operation in other cases
    public int insert(E newItem) {
        //***************Write your code in the below******************//
        try {
            if (numItems >= A.length) {
                return -1; // becasue the array is full;
            } else {
                // Insert the new item in the heap;
                A[numItems] = newItem;

                // noting to say
                numItems++;

                // put the elements go up if it fullfill the conditions
                // numItems - 1 is the index of the last node in tree
                percolateUp(numItems - 1);
                
                return 0;
            }
        } catch (Exception e) {
            return -1;
        }
        //*************************************************************//
    } 

    // Implementation of percolateUp()
    // Adjust the elements starting from A[i] to satisfy the heap property
    // The elements in A[0...i-1] are already satisfying the heap property
    // You need to implement this function using a recursive approach
    private void percolateUp(int i) {
        //***************Write your code in the below******************//
        // if(i is the root node of the index with 0, that stop recursion)
        if (i <= 0) {
            return;
        }

        // create the parent node of the index first, it is important!
        int parentindex = (i - 1) / 2;

        // if the current element is small er than the parent
        // swap it and recusive again until it fullfill the requirment
        if (A[i].compareTo(A[parentindex]) > 0) { // Changed < to >
            E tmp = A[i];
            A[i] = A[parentindex];
            A[parentindex] = tmp;

            // recursive again until fullfill the requirments
            percolateUp(parentindex);
        }
        //*************************************************************//
    }

    // Implementation of deleteMax(): Deleting a root node from the heap
    // You should consider using percolateDown() function
    // Return the maximum value if the operation is successful 
    // Return null if an exception occurs
    public E deleteMax() {
        //***************Write your code in the below******************//
        try {
            if (numItems == 0) { // if the root node is 0 that return empty
                return null;
            } else {
                // create the max for the root node. remenmber the type is E~
                E max = A[0];
                // and just move the last elements to the root node
                // so the root node become the last elements of the previouse leaf node!
                A[0] = A[numItems - 1];
                numItems--;

                // shift down, until it fullfill the requirments
                // the heap property for complete binary tree
                // it is always the index
                percolateDown(0);

                return max;
            }
        } catch (Exception e) {
            return null;
        }
        //*************************************************************//
    }

    // Implementation of percolateDown(): Inserting newItem to the heap
    // Percolating down A[i] to become the root in A[0...numItems-1]
    // You need to implement this function using a recursive approach
    private void percolateDown(int i) {
        //***************Write your code in the below******************//
        int left = 2 * i + 1; // the left node is always odd
        int right = 2 * i + 2; // the right is always even
        int largest = i; // the largest node so far after the recusion step

        // compare the left node
        if (left < numItems && A[left].compareTo(A[largest]) > 0) {
            // the ndoe swap it
            largest = left;
        }

        // compare the right node
        if (right < numItems && A[right].compareTo(A[largest]) > 0) {
            // the node swap it
            largest = right;
        }

        // swap it if it is not the largest
        // and recusive again until it fullfill the requirments: the heap porperty
        if (largest != i) {
            // swap the current largest node and largest node;
            E tmp = A[i];
            A[i] = A[largest];
            A[largest] = tmp;

            // recursion again until it fullfill the requirments
            percolateDown(largest); // Changed i to largest
        }
        //*************************************************************//
    }

    // Implementation of buildHeap():  Building a new heap
    // Note that array A[] is already initialized by a Constructor
    // You need to implement this function using percolateDown()
    public void buildHeap() {
        //***************Write your code in the below******************//

        // this part is very easy just using shif down and you can finish it
        for (int i = numItems / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
        //*************************************************************//
    }

    // Implementation of max(): Getting the maximum value from the heap
    // You should consider using percolateDown() function
    // Return the maximum value if the operation is successful 
    // Return null if an exception occurs
    public E max() {
        //***************Write your code in the below******************//
        try {
            if (numItems == 0) {
                return null;
            } else {
                return A[0];
            }
        } catch (Exception e) {
            return null;
        }
        //*************************************************************//
    }

    // Implementation of isEmpty(): Checking if the heap is empty
    // Return true if the heap is empty
    // Return false otherwise
    public boolean isEmpty() { 
        //***************Write your code in the below******************//
        try {
            return numItems == 0; // Simplified condition
        } catch (Exception e) {
            return false;
        }
        //*************************************************************//
    }

    // Implementation of clear(): Clear the heap
    public void clear() {
        //***************Write your code in the below******************//
        numItems = 0;
        //*************************************************************//
    }

    //////////////////////////////////////////////////
    public String heapPrint() {
        String print_all = "Print list (#items=" + numItems + ") ";
        for (int i = 0; i <= numItems-1; i++) { // Changed <= to <
            print_all += A[i] + " ";
        }
        return print_all;
    }
}
