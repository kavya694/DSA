class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SingleLinkedList {

    Node head;

    // Check if list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Insert at beginning
    public void insertFirst(int value) {
        Node firstElement = new Node(value);
        firstElement.next = head;
        head = firstElement;
    }

    // Insert at end
    public void insertLast(int value) {
        Node lastElement = new Node(value);

        if (head == null) {
            head = lastElement;
            return;
        }

        Node n = head;
        while (n.next != null) {
            n = n.next;
        }

        n.next = lastElement;
    }

    // Delete first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Empty list");
        } else {
            head = head.next;
        }
    }

    // Delete last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node n = head;
        while (n.next.next != null) {
            n = n.next;
        }

        n.next = null;
    }

    // Find size
    public int size() {
        int count = 0;
        Node n = head;

        while (n != null) {
            count++;
            n = n.next;
        }

        return count;
    }

    // Print list
    public void printList() {
        if (head == null) {
            System.out.println("null");
            return;
        }

        Node n = head;

        while (n != null) {
            System.out.print(n.data + " --> ");
            n = n.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        linkedlist list = new linkedlist();
        System.out.println("===== Test Case 1 : isEmpty() =====");
        System.out.println("Is Empty : " + list.isEmpty());
        System.out.println("\n===== Test Case 2 : insertFirst() =====");

        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);

        System.out.print("List : ");
        list.printList();
        System.out.println("\n===== Test Case 3 : insertLast() =====");

        list.insertLast(40);
        list.insertLast(50);

        System.out.print("List : ");
        list.printList();
        System.out.println("\n===== Test Case 4 : size() =====");
        System.out.println("Size = " + list.size());
        System.out.println("\n===== Test Case 5 : deleteFirst() =====");

        list.deleteFirst();

        System.out.print("List : ");
        list.printList();
        System.out.println("\n===== Test Case 6 : deleteLast() =====");

        list.deleteLast();

        System.out.print("List : ");
        list.printList();
        System.out.println("\n===== Test Case 7 : size() =====");
        System.out.println("Size = " + list.size());
        
        
    }
}