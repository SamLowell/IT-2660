package Graph;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);

        //initial test graph
        /*
        Graph test = new Graph(10);
        test.setEdge(0, 1, 5);
        test.setEdge(0, 4, 4);
        test.setEdge(1, 3, 1);
        test.setEdge(1, 6, 10);
        test.setEdge(2, 3, 3);
        test.setEdge(2, 5, 9);
        test.setEdge(3, 6, 15);
        test.setEdge(4, 5, 3);
        test.setEdge(4, 8, 2);
        test.setEdge(4, 9, 6);
        test.setEdge(6, 7, 7);
        test.setEdge(7, 8, 4);
        test.setEdge(8, 9, 8);
        test.getVertex(3).setValue(9);
        test.getVertex(9).setValue(20);
        test.getVertex(4).setValue(11);
        test.getVertex(7).setValue(25);

        Queue Q = new Queue(10);
        test.BFT(0, Q);
        test.DFTsearch(9, 0);
        test.dijkstraSearch(0, 0);
*/

        //generate random graph
        /*
        Graph randTest = new Graph(100);
        randTest.createRandGraph();
        randTest.getVertex(50).setValue(408);
        Queue Q2 = new Queue(100);
        randTest.BFT(0, Q2);
        System.out.println();
        randTest.DFTsearch(408, 0);
        randTest.dijkstraSearch(408, 0);
        */

        //user enters number to search for using all three methods

        System.out.println();
        System.out.println("Enter an integer: ");
        int keyNum = Input.nextInt();
        //ran into a heap space error for over 30,000 nodes.  I think the array matrix for the edges is the problem.
        //Another storage method that takes up less memory would probably solve the problem.
        Graph graph = new Graph(30000);
        graph.createRandGraph();
        Queue Q3 = new Queue(30000);
        System.out.println();
        graph.DFTsearch(keyNum, 0);
        graph.dijkstraSearch(keyNum, 0);
        //I tried a recursion method for the breadth first search.  It works fine for small graphs but fails
        // with larger ones when the number is not present.
        graph.BFT(keyNum, Q3); //will only work if number can be found


    }
}
