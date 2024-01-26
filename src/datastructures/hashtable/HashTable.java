package datastructures.hashtable;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable(){
        dataMap = new Node[size];
    }

    private int hash(String key){
        int hash = 0;
        char[] chars = key.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            int asciiValue = chars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(dataMap[index] == null) {
            dataMap[index] = newNode;
            return;
        }
        Node temp = dataMap[index];
        while(temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public Integer get(String key){
        int index = hash(key);
        if(dataMap[index] == null)
            return null;
        Node temp = dataMap[index];
        while(temp.key != key)
            temp = temp.next;
        return temp.value;
    }

    public void printTable(){
        for(int i = 0 ; i < dataMap.length ; i++){
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while(temp!= null){
                System.out.println(" {" + temp.key + " = " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    public ArrayList<String> keys(){
        ArrayList<String> keys = new ArrayList(dataMap.length);
        for(int i = 0 ; i < 7 ; i++){
            Node temp = dataMap[i];
            while(temp != null){
                keys.add(temp.key);
                temp = temp.next;
            }
        }
        return keys;
    }

    class Node{
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
