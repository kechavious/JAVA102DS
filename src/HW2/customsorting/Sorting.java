package customsorting;

public class Sorting {

	int A[];

	public Sorting(int B[]) {
		A = B;
	}
	
	// Please write code in the given function to complete the bubble sort.
	// Utilize the 'swapped' variable to check whether any element swaps occur in the for-loop.
	// This will enable achieving the best-case time complexity of 'n'.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void bubbleSort() {
		int tmp = 0;
		boolean swapped;
		// ----------------- write your code here ----------------- //
		for(int i = 1; i<A.length;i++){
			//i is the loop to the n-1 time.
			swapped = true;
			//if swapped is true, that menas that no any elemnts swap and the function finish swapping!
			for(int j = 0; j < A.length-i;j++){
				//j is the elemnts that you want to compare with it!
				if(A[j]>A[j+1]){
					//swap it if the first elememt>second one;
					tmp = A[j+1];
					A[j+1] = A[j];
					A[j] = tmp;

					//false means that it must be in the for loop and runs n-1 time~
					swapped = false;
				}
			}
			if(swapped){
				break;
			}
		}
		
		// -------------------------------------------------------- //
	}

	// Please complete the selection sort by writing code in the given function.
	// Implement it using the theLargest function, which finds the largest number A[k] among A[0,...,last].
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void selectionSort() {
		int k; int tmp;
		// ----------------- write your code here ----------------- //

		//Iterate over the array, from the last element to the first
		for(int i = A.length-1;i>=0;i--){
			//we use last as the largst so far and find the real largest element in the return part
			k = theLargest(i);
			//swap the largest element if have for the last index until it move to the previous one
			tmp = A[k];
			A[k] = A[i];
			A[i] = tmp;
		}
		
		// -------------------------------------------------------- //
	}
	
	// Implement the theLargest function that returns the index of the largest element in the array A[0...last].
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private int theLargest(int last) {
		int largest = 0;//we consider that if A[0] is the largest;
		// ----------------- write your code here ----------------- //

		//this is the A[i], which is the second element.
		for(int i=1;i<=last;i++){
			if(A[i]>A[largest]){
				//set the largst number if it exsit. 
				largest = i;

			}
		}
		// -------------------------------------------------------- //
		return largest;
	}
	
	
	// Write code in the provided function to complete the insertion sort.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void insertionSort() {
		// ----------------- write your code here ----------------- //
		for(int i = 1; i < A.length;i++){
			int tmp = A[i];//将A[i]变成临时变量住存在tmp中，表示要插入的元素。
			int j = i;
			// 向前查找插入的位置，同时将比 tmp 大的元素向后移动
			while(j>0&&tmp<A[j-1]){
				A[j] = A[j-1];// 将 A[j-1] 向后移，给 tmp 留出插入位置
				j--;
			}
			 // 找到合适的位置后，将 tmp 插入
			A[j] = tmp;
			
		}
		// -------------------------------------------------------- //
	}
	
	// write code in the functions mSort() and merge() to complete the merge sort.
	public void mergeSort() { 
		int[] B = new int[A.length];
		mSort(0, A.length-1, B);	
	}
	
	// write code in the given function to complete the mSort() function.
	// The mSort function should be structured as follows:
	// First, calculate the midpoint between p and r.
	// Second, perform sorting on the first half.
	// Third, perform sorting on the second half.
	// Finally, merge the results using the merge() function.
	// Notably, the second and third steps should be implemented as recursive calls to mSort().
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void mSort(int p, int r, int[] B) { 
		if (p < r) {
		// ----------------- write your code here ----------------- //
		
		//cal the mid point first;
		int q = (p+r)/2;
		//Left order
		mSort(p,q,B);
		//right order
		mSort(q+1,r,B);
		//Merge it together;

		merge(p,q,r,B);
		// -------------------------------------------------------- //
		} 
	}

	// Write code in the provided function to complete the merge() function.
	// Merge the arrays A[p, ..., q] and A[q+1, ..., r] to create a sorted array A[p, ..., r]. 
	// Note that A[p, ..., q] and A[q+1, ..., r] are already sorted.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void merge(int p, int q, int r, int[] B) {
	// ----------------- write your code here ----------------- //

	int i = p;//the left start part of the element;
	int j = q+1;//the right start part of the element;
	int k = p; //B's start point;

	while(i<=q&&j<=r){ // Merge back to B
		if(A[i]<=A[j]){
			B[k++] = A[i++]; //Becasue we want to find the smaill elementsto the B
		}else{
			B[k++] = A[j++];
		}
	}

	//put the left elements of the left part to the B
	while(i<=q){
		B[k++] = A[i++];
	}

	//put the left elements of the right part to the B
	while(j<=r){
		B[k++] = A[j++];
	}
	//copy the B to the orginal array A
	for(k = p;k<=r;k++){
		A[k] = B[k];
	}
	
	// -------------------------------------------------------- //
	}
	
	// Write code in the functions qSort() and partition() to complete the quicksort.
	public void quickSort() {
			qSort(0, A.length-1);
	}

	// Write code in the given function to complete the qSort() function.
	// The qSort function should be structured as follows:
	// First, the partition() function returns the pivot element q.
	// Second, sort the left sub-array using p and q.
	// Third, sort the right sub-array using q and r.
	// Notably, the second and third steps should be implemented as recursive calls to qSort().
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void qSort(int p, int r) {
		if (p < r) {
		// ----------------- write your code here ----------------- //

		int q = partition(p, r);//Partition array and get pivot index;
		qSort(p,q-1);//recursive left subarray
		qSort(q+1, r);//recursive right subarray;
		// -------------------------------------------------------- //
		}
	}
	
	// The partition() function rearranges the elements of the array A[p, ..., r] on either side 
	// based on their relative sizes compared to the pivot element A[r]. 
	// It then returns the position where the pivot element is placed.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private int partition(int p, int r) {
		int position = 0; // Initialize position
		// ----------------- write your code here ----------------- //
		int pivot = A[r]; // Make rightmost element as the pivot
		int i = p - 1; // Index of smaller element, starting from one position before p
		for (int j = p; j < r; j++) { // Iterate over elements from p to r-1
			if (A[j] <= pivot) {
				i++;
				// Swap A[i] and A[j] if A[j] is smaller or equal to pivot
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		// Swap the pivot with the element at i+1 position
		int tmp = A[i + 1];
		A[i + 1] = A[r];
		A[r] = tmp;

		position = i+1;
		
		// Return the final position of the pivot
		return position;
		// -------------------------------------------------------- //
	}
}
