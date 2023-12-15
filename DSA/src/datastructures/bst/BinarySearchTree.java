package datastructures.bst;


public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(){
        root = null;
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true){
            if(value == temp.value){
                return false;
            }
            if(value > temp.value && temp.right != null){
                temp = temp.right;
                continue;
            }
            else if(value < temp.value && temp.left != null){
                temp = temp.left;
                continue;
            }
            if(value > temp.value){
                temp.right = newNode;
                return true;
            }
            else{
                temp.left = newNode;
                return true;
            }
        }
    }

    private Node deleteNode(Node currentNode, int value){
        if(currentNode == null) return null;
        if(currentNode.value < value){
            currentNode.right = deleteNode(currentNode.right, value);
        }
        else if(currentNode.value > value){
            currentNode.left = deleteNode(currentNode.left, value);
        }
        else{
            if(currentNode.left == null && currentNode.right == null){
                return null;
            }
            else if(currentNode.left == null){
                currentNode = currentNode.right;
            }
            else if(currentNode.right == null){
                currentNode = currentNode.left;
            }
            else{
                Node rightNode = currentNode.right;
                Node smallestNode = getSmallest(rightNode);
                currentNode.value = smallestNode.value;
                currentNode.right = deleteNode(rightNode, smallestNode.value);
            }
        }
        return currentNode;
    }

    private Node getSmallest(Node currentNode){
        while(currentNode.left != null)
            currentNode = currentNode.left;
        return currentNode;
    }

    public void deleteNode(int value){
        deleteNode(root, value);
    }


    public boolean contains(int value){
        if(root == null){
            return false;
        }
        if(root.value == value){
            return true;
        }
        Node temp = root;
        while(true){
            if(value == temp.value){
                return true;
            }
            else if(value > temp.value){
                if(temp.right == null)
                    return false;
                temp = temp.right;
            }
            else{
                if(temp.left == null)
                    return false;
                temp = temp.left;
            }
        }
    }
    class Node{
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }
}
