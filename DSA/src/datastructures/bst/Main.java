package datastructures.bst;

public class Main {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(4);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(6);
        bst.insert(2);
        System.out.println("Testing if the bst contains the values from 0 to 8: ");
        for(int i = 0 ; i <= 8 ; i++){
            System.out.println("does the bst contain: " + i + "?  " + bst.contains(i));
        }
        System.out.println("Testing removal");
        bst.deleteNode(5);
        System.out.println("does the bst contain 5? "+ bst.contains(5));
    }
}
