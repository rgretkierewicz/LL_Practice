import java.util.Scanner;

public class practiceLL {
    public static Node head; //Holds head node


    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node reverseLL(Node head) {
        Node current = head;
        Node next = null;
        Node previous = null;

        while(current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous; //Equal to current
    }

    public static void printList(Node head){
        Node node = head;

        while (node != null) {

            //No comma for last value
            if (node.next == null){
                System.out.print(node.data);
                node = node.next;
            }
            else {
                System.out.print(node.data + ", ");
                node = node.next;
            }
        }
        System.out.println();
    }



    public static void main(String[] args) {
        /*
        If we don't want to use the scanner:

        practiceLL myLLPractice = new practiceLL();
        practiceLL.head = new Node(90);
        practiceLL.head.next = new Node(43);
        practiceLL.head.next.next = new Node(89);
         */


        // Our class object for calling methods
        practiceLL myLL = new practiceLL();

        // Getting our list from scanner
        System.out.println("Enter a list of numbers separated by commas. When finished, enter \"Stop\".");
        Scanner scan = new Scanner(System.in);
        String scannedS = scan.nextLine();
        String[] scannedIn = scannedS.split(",");
        scan.close();

        // Creating our nodes based on input
        for (String s : scannedIn) {
            if (!s.equals("Stop")) {
                Node newNode = new Node(Integer.parseInt(s));

                //If list is empty, list's head node equals new node
                if (head == null) {
                    head = newNode;
                }

                /* If list is not empty, current node = head. We iterate through list until next is null. If null, this is where we
                put our new node
                 */
                else {
                    Node curr = head;
                    while (curr.next != null) {
                        curr = curr.next;
                    }
                    curr.next = newNode;
                }
            }
        }

        System.out.println("The current linked list equals: ");
        practiceLL.printList(head);

        System.out.println("The reversed linked list equals: ");
        head = myLL.reverseLL(head);
        practiceLL.printList(head);

    }
}