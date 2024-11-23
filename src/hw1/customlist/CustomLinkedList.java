package customlist;

public class CustomLinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;

	// Constructor 1: Creating an LinkedList with Dummy Head.
	// We consider that the index of Dummy Head as '-1'.
	public CustomLinkedList() { 			
		numItems = 0;
		head = new Node<>(null, null); 	//  Dummy Head (index = -1)
	}

	 // Implementation of getNode()
	 public Node<E> getNode(int index) {
        try {
            if (index < -1 || index >= numItems) {
                return null;  // If index is out of bounds, return null
            } else if (index == -1) {
                return head;  // If index is -1, return dummy head
            }
            Node<E> currNode = head;  // Start from dummy head
            for (int i = 0; i <= index; i++) {  // Iterate to the specified index
                currNode = currNode.next;
            }
            return currNode;  // Return the current node
        } catch (Exception e) {
            return null;  // Return null on exception
        }
    }

    // Implementation of add()
    public int add(int index, E item) {
        try {
            if (index < 0 || index > numItems) {
                return -1;  // If index is out of bounds, return -1
            } else {
                Node<E> newNode = new Node<>(item, null);
                if (index == 0) {
                    newNode.next = head.next;
                    head.next = newNode;  // Insert at the head
                } else {
                    Node<E> preNode = getNode(index - 1);
                    newNode.next = preNode.next;
                    preNode.next = newNode;  // Insert at specified index
                }
                numItems++;
                return 0;  // Return 0 on success
            }
        } catch (Exception e) {
            return -1;  // Return -1 on exception
        }
    }

    // Implementation of append()
    public int append(E item) {
        try {
            Node<E> newNode = new Node<>(item, null);
            Node<E> currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;  // Traverse to the end
            }
            currNode.next = newNode;  // Append the new node
            numItems++;
            return 0;  // Return 0 on success
        } catch (Exception e) {
            return -1;  // Return -1 on exception
        }
    }

    // Implementation of remove()
    public E remove(int index) {
        try {
            if (index < 0 || index >= numItems) {
                return null;  // If index is out of bounds, return null
            } else {
                Node<E> preNode = getNode(index - 1);
                if (preNode.next != null) {
                    E removeData = preNode.next.item;
                    preNode.next = preNode.next.next;  // Remove node
                    numItems--;
                    return removeData;  // Return the removed item
                }
                return null;
            }
        } catch (Exception e) {
            return null;  // Return null on exception
        }
    }

    // Implementation of removeItem()
    public boolean removeItem(E x) {
        try {
            Node<E> currNode = head;
            while (currNode.next != null) {
                if (currNode.next.item.equals(x)) {
                    currNode.next = currNode.next.next;  // Remove node
                    numItems--;
                    return true;  // Indicate success
                }
                currNode = currNode.next;  // Move to the next node
            }
            return false;  // Element not found
        } catch (Exception e) {
            return false;  // Return false on exception
        }
    }

    // Implementation of get()
    public E get(int index) {
        try {
            if (index < 0 || index >= numItems) {
                return null;  // If index is out of bounds, return null
            } else {
                Node<E> currNode = head;
                for (int i = 0; i <= index; i++) {
                    currNode = currNode.next;  // Traverse to the specified index
                }
                return currNode.item;  // Return the item at current node
            }
        } catch (Exception e) {
            return null;  // Return null on exception
        }
    }

    // Implementation of set()
    public int set(int index, E x) {
        try {
            if (index < 0 || index >= numItems) {
                return -1;  // If index is out of bounds, return -1
            } else {
                Node<E> currNode = head;
                for (int i = 0; i <= index; i++) {
                    currNode = currNode.next;  // Traverse to the specified index
                }
                currNode.item = x;  // Set the new value
                return 0;  // Return 0 on success
            }
        } catch (Exception e) {
            return -1;  // Return -1 on exception
        }
    }

    // Implementation of indexOf()
    public int indexOf(E x) {
        try {
            Node<E> currNode = head.next;  // Start from the first real node
            for (int i = 0; i < numItems; i++) {
                if (currNode.item.equals(x)) {
                    return i;  // Return the index if found
                }
                currNode = currNode.next;  // Move to the next node
            }
            return -1;  // If not found, return -1
        } catch (Exception e) {
            return -1;  // Return -1 on exception
        }
    }

    // Implementation of len()
    public int len() {
        return numItems;  // Return number of items
    }

    // Implementation of isEmpty()
    public boolean isEmpty() {
        return numItems == 0;  // Return true if empty
    }

    // Implementation of clear()
    public void clear() {
        head.next = null;  // Clear the list
        numItems = 0;  // Reset item count
    }
	
	
	///////////////////////////////////////////////////////////////////////
	public String printAll() {
		Node<E> t;
		// System.out.print("Print list (#items=" + numItems + ") ");
		// for(t=head.next; t != null; t = t.next) {
		// 	System.out.print(t.item + " ");
		// }
		// System.out.println();

		String print_all = "Print list (#items=" + numItems + ") ";
		for(t=head.next; t != null; t = t.next) 
			print_all += t.item + " ";
		System.out.println(print_all);
		return print_all;

	}
} 


