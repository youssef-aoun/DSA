package datastructures.graphs;

public class Main {
    public static void main(String [] args) {
        Graph myGraph = new Graph();

        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");

        System.out.println("Upon creating the vertices: ");
        myGraph.printGraph();

        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");

        System.out.println("Upon adding the edges: ");
        myGraph.printGraph();

        myGraph.removeEdge("A", "B");
        System.out.println("Upon deleting edge between A & B: ");
        myGraph.printGraph();

        myGraph.removeVertex("B");
        System.out.println("After removing vertex B: ");
        myGraph.printGraph();
    }
}
