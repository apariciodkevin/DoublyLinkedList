package DoublyLinkedList;

public class DoublyLinkedList {

    // Inner Class for Nodes
    public class Node {
        private Object data;
        private Node next;
        private Node prev;

        // Constructor to initialize variables.
        Node (Object data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public String toString() {
            // Converts input to String
            return String.valueOf(this.data);
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size;

    // Prints to terminal
    public String printList() {
        // Checks if list is empty
        if (head ==  null) {
            return "";
        }
        Node temp = head;
        String str = "[ ";
        while (temp.next != null) { // iterates through data until it reaches the tail
            str += temp.data + " | ";
            temp = temp.next; // set temp to the next node
        }
        str += temp.data;
        return str + " ]";
    }

    // Method to add to the beginning of the linkedlist.
    public void addFirst (Object data) {
        Node newNode = new Node(data); // Creates new node

        if (size == 0) {
            // Head and tail are the same because the list is empty.
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++; // Increases size of list.
    }

    // Adds to the end of the linked list
    public void addLast (Object data) {
        Node newNode = new Node(data);
        // if empty; perform the add first method.
        if (size == 0) {
            addFirst(data);
            size++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Methods to delete
    public Node deleteFirst () {
        if (head == null) {
            return null; // if empty there is nothing to return
        } else {
            head = head.next; // set head to the next node
            head.prev = null; // set prev to null so memory address gets deleted.
        }
        size--;
        return head;
    }

    public Node deletelast () {
        if (tail == null) {
            return null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return tail;
    }

    // Method to add and delete from a specific index.
    public Node nodePlacement (int index) {
        Node n = head; // set n to index 0 or first node on the list
        for (int i = 0; i < index; i++) {
            n = n.next; // loop until you reach the index
        }
        return n;
    }
    // Use this as a get method
    // Use this as a get method
    public Node get (int index) {
        return nodePlacement(index);
    }

    public void add (int index, Object data) {
        if (index == 0) {
            // if they want you to add at index 0 then just run addFirst method.
            addFirst(data);
            size ++;
        } else if (index == size - 1) { // Same if they want youto add at the end of the list.
            addLast(data);
            size++;
        } else {
            Node temp1 = nodePlacement(index - 1);
            Node temp2 = temp1.next;

            Node newNode = new Node(data);
            temp1.next = newNode;
            newNode.next = temp2;
            size++;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public void delete (int index) {
        if (index == 0) {
            // if they want you to add at index 0 then just run addFirst method.
            deleteFirst();
            size--;
        } else if (index == size - 1) { // Same if they want youto add at the end of the list.
            deletelast();
            size--;
        } else {
            // set node to previous before the index
            Node temp1 = nodePlacement(index - 1);
            // set node to one after the index
            Node temp2 = nodePlacement(index + 1);

            temp1.next = temp2;
            // likns prev and after from the index (deletes the middle node)
            temp2.prev = temp1;
            size--;
        }
    }

    // displays size of list
    public int getSize() {
        return size;
    }


}
