package datastructures.stack;


import java.util.ArrayList;

public class Main {

    public static void sortStack(Stack stack){
        ArrayList<Integer> arrayList = new ArrayList<Integer>(stack.height);
        while(stack.height != 0){
            arrayList.add(stack.pop().value);
        }
        for(int i = 0 ; i < arrayList.size(); i++){
            int aux = 0;
            int min = arrayList.get(i);
            for(int j = i+1 ; j< arrayList.size(); j++){
                if(min > arrayList.get(j)){
                    aux = min;
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, aux);
                    min = arrayList.get(i);
                }
            }
        }
        for(int i = arrayList.size()-1 ; i >= 0 ; i--){
            stack.push(arrayList.get(i));
        }
    }
    public static void main(String[] args){
        Stack myStack = new Stack(2);
        myStack.push(1);
        myStack.push(10);
        myStack.push(15);
        myStack.push(7);
        myStack.push(4);

        System.out.println("My stack before sorting: ");
        myStack.printStack();

        sortStack(myStack);
        System.out.println("\nMy stack after sorting: ");
        myStack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            null

        */

    }
}
