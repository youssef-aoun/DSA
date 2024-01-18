package datastructures.linkedlist;

public class Main {
    public static void main(String[] args){
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.append(6);
        myLinkedList.append(7);

        System.out.println("LL before reverse():");
        myLinkedList.printList();

        /*myLinkedList.reverse();

        System.out.println("\nLL after reverse():");
        myLinkedList.printList();*/
        System.out.println("Finding middle Node");
        int y = myLinkedList.findMiddleNode().value;
        System.out.println(y);
        System.out.println("After reversing 1 & 5: ");
        myLinkedList.reverseBetween(1,5);
        myLinkedList.printList();

    }
}
