import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    static Node head = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int ch;
        while (true) {
            System.out.println("\nEnter the choice of operation:");
            System.out.println("1. Add at Begin");
            System.out.println("2. Add at End");
            System.out.println("3. Add After");
            System.out.println("4. Length");
            System.out.println("5. Displayfor");
            System.out.println("6. Displayback");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1 -> addAtBegin();
                case 2 -> addAtEnd();
                case 3 -> addAfter();
                case 4 -> System.out.println("Length: " + length() + "\n");
                case 5 -> displayfor();
                case 6 -> displayback();
                case 7 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice!");
            }
        }
    }

    static Node getNode() {
        System.out.print("Enter data value for node: ");
        int data = sc.nextInt();
        return new Node(data);
    }

    static void addAtBegin() {
        Node newNode = getNode();
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("One node created at beginning.\n");
    }

    static void addAtEnd() {
        Node newNode = getNode();
        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = newNode;
            newNode.prev = p;
        }
        System.out.println("One node created at end.\n");
    }

    static void addAfter() {
        System.out.print("Enter location after which to add node: ");
        int loc = sc.nextInt();
        int len = length();

        if (loc > len) {
            System.out.println("Invalid location! Current list has " + len + " nodes.\n");
            return;
        }

        Node newNode = getNode();
        Node p = head;
        for (int i = 1; i < loc; i++) {
            p = p.next;
        }

        newNode.next = p.next;
        if (p.next != null) {
            p.next.prev = newNode;
        }
        newNode.prev = p;
        p.next = newNode;

        System.out.println("One node created after location " + loc + ".\n");
    }


    static int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }


    static void displayfor() {
        if (head == null) {
            System.out.println("List is empty.\n");
        } else {
            Node p = head;
            while (p != null) {
                System.out.print(p.data + " --> ");
                p = p.next;
            }
            System.out.println("null\n");
        }
    }


    static void displayback() {
    if (head == null) {
        System.out.println("List is empty.\n");
    } else {
        Node p = head;
        while (p.next != null) {  // Step 1: Move to last node
            p = p.next;
        }
        while (p != null) {       // Step 2: Traverse backward
            System.out.print(p.data + " --> ");
            p = p.prev;
        }
        System.out.println("null\n");
    }
}
}
