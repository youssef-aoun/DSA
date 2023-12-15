package datastructures.queue;

public class Main {
    public static void main(String[] args){
        Queue queue = new Queue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(7);
        queue.enqueue(1);
        queue.enqueue(6);
        queue.enqueue(2);
        System.out.println("Queue after adding elements: ");
        queue.printQueue();
        int front = queue.dequeue().value;
        System.out.println("\nQueue after removing front element: ");
        queue.printQueue();
        System.out.println("\nFront element removed value: " + front);
        queue.getFirst();
        queue.getLast();
        queue.getLength();
    }
}
