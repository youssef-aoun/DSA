package datastructures.bst;

import java.util.*;

public class Main {
    public static void main(String[] args){

        // Testing Normal Creation:
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);

        System.out.println("Does bst contain 5? " + bst.contains(5));
        System.out.println("Does bst contain 4? " + bst.contains(4));

        // Testing Recursive Creation:
        BinarySearchTree rbst = new BinarySearchTree();
        rbst.rInsert(1);
        rbst.rInsert(2);
        rbst.rInsert(4);

        System.out.println("\nDoes rbst contain 5? " + rbst.rContains(5));
        System.out.println("Does rbst contain 4? " + rbst.rContains(4));

        rbst.deleteNode(1);
        System.out.println("\nDoes rbst contain 1? " + rbst.rContains(1));

        // Testing Tree Traversals:

        BinarySearchTree myBst = new BinarySearchTree();
        myBst.insert(47);
        myBst.insert(21);
        myBst.insert(76);
        myBst.insert(18);
        myBst.insert(27);
        myBst.insert(52);
        myBst.insert(82);

        ArrayList<Integer> bfsList = myBst.BFS();
        System.out.println("\nList after performing breadth first search:");
        System.out.println(bfsList);

        ArrayList<Integer> dfsPreList = myBst.DFSPreOrder();
        System.out.println("\nList after performing depth first search - Preorder:");
        System.out.println(dfsPreList);

        ArrayList<Integer> dfsPostList = myBst.DFSPostOrder();
        System.out.println("\nList after performing depth first search - Postorder:");
        System.out.println(dfsPostList);

        ArrayList<Integer> dfsInList = myBst.DFSInOrder();
        System.out.println("\nList after performing depth first search - Inorder:");
        System.out.println(dfsInList);

        System.out.println("\nThe 3rd smallest element in the above bst is: " + myBst.kthSmallest(3));

    }
}
