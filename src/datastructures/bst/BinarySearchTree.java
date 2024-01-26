package datastructures.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {
    Node root;

    // Normal Creation:
    public BinarySearchTree() {
        root = null ;
    }
    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root== null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while(temp!= null){
            if(temp.value == value)
                return false;
            else if(temp.value < value){
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
            else{
                if(temp.left==null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
        }
        return false;
    }
    public boolean contains(int value){
        if(root == null)
            return false;
        Node temp = root;
        while(temp != null){
            if(temp.value == value)
                return true;
            else if(temp.value < value)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return false;
    }
    class Node{
        int value;
        Node right, left;

        public Node(int value) {
            this.value = value;
        }
    }

    // Recursive Creation:
    public void rInsert(int value){
        Node newNode = new Node(value);
        if(root==null)
            root = newNode;
        rInsert(root, value);
    }
    private Node rInsert(Node root, int value){
        if(root == null)
            return new Node(value);
        if(value > root.value) {
            root.right = rInsert(root.right, value);
        }
        else if(value < root.value){
            root.left = rInsert(root.left, value);
        }
        return root;
    }

    public boolean rContains(int value){
        if(root == null)
            return false;
        return rContains(root, value);
    }
    private boolean rContains(Node node, int value){
        if(node.value == value)
            return true;
        if(value > node.value){
            if(node.right == null)
                return false;
            node = node.right;
        }
        else{
            if(node.left == null)
                return false;
            node = node.left;
        }
        return rContains(node, value);
    }

    public Node deleteNode(int value){
        if (root == null)
            return null;
        return deleteNode(root,value);
    }
    private Node deleteNode(Node node, int value){
        if(node == null)
            return null;
        if(value > node.value){
            node.right = deleteNode(node.right, value);}
        else if(value < node.value){
            node.left = deleteNode(node.left, value);}
        else{
            if(node.right == null && node.left==null){
                node = null;
            }
            else if(node.left == null){
                node = node.right;
            }
            else if(node.right == null){
                node = node.left;
            }
            else{
                int subTreeMin = minValue(node.right);
                node.value = subTreeMin;
                node.right = deleteNode(node.right, subTreeMin);
            }
        }

        return node;
    }

    private int minValue(Node node){
        while(node.left != null)
            node = node.left;
        return node.value;
    }

    // Tree Traversal
    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);
        while(!queue.isEmpty()){
            currentNode = queue.poll();
            result.add(currentNode.value);
            if(currentNode.left!= null)
                queue.add(currentNode.left);
            if(currentNode.right!= null)
                queue.add(currentNode.right);
        }

        return result;
    }

    public ArrayList<Integer> DFSPreOrder(){
        Node currentNode = root;
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse{
            Traverse(Node currentNode){
                result.add(currentNode.value);
                if(currentNode.left!= null)
                    new Traverse(currentNode.left);
                if(currentNode.right!= null)
                    new Traverse(currentNode.right);

            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.left != null)
                    new Traverse(currentNode.left);
                if(currentNode.right != null)
                    new Traverse(currentNode.right);
                result.add(currentNode.value);
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.left != null)
                    new Traverse(currentNode.left);
                result.add(currentNode.value);
                if(currentNode.right != null)
                    new Traverse(currentNode.right);

            }
        }
        new Traverse(root);
        return result;
    }

    public Integer kthSmallest(int k){
        Node currentNode = root;
        Stack<Integer> stack = new Stack<>();
        class Traverse{
            Traverse(Node currentNode){
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }
                stack.push(currentNode.value);
                if(currentNode.left != null){
                    new Traverse(currentNode.left);
                }
            }
        }
        new Traverse(currentNode);
        Integer result = null;
        while(k > 0 && !stack.isEmpty()){
            result = stack.pop();
            k--;
        }
        if(stack.isEmpty() && k!=0)
            return null;

        return result;
    }

}
