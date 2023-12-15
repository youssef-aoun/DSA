package datastructures;

public class Main {

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList(5);
        linkedList.prepend(3);
        linkedList.prepend(7);
        linkedList.prepend(1);
        linkedList.prepend(2);
        linkedList.append(6);
        linkedList.prepend(4);
        linkedList.printList();

        linkedList.removeFirst();
        linkedList.insertAtPosition(6, 4);
        System.out.print("\n");
        linkedList.printList();
        System.out.print("\n");
        System.out.print(linkedList.get(6));
        linkedList.removeLast();
        System.out.print("\n");
        linkedList.printList();
        linkedList.set(4, 2);
        System.out.print("\n");
        linkedList.printList();
        linkedList.reverse();
        System.out.print("\n");
        linkedList.printList();
    }
}
