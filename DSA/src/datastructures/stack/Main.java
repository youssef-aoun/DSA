package datastructures.stack;

public class Main {
    public static void main(String[] args){

        // Creating and pushing into the stack
        Stack stack = new Stack(5);
        stack.push(4);
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        System.out.println("Stack after pushing: ");
        stack.printStack();
        int top = stack.pop().value;
        System.out.println("\nStack after removing the top element: ");
        stack.printStack();
        System.out.println("\nTop element value: " + top);
        System.out.print("The ");
        stack.getHeight();
        System.out.print("Getting the top element without removing it from stack ");
        stack.getTop();
    }
}
