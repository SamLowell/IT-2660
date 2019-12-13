package Graph;
import java.util.*;

public class Graph {
    private int edge[][];
    private int numVert;
    private Node vertex[];
    int totalVisited = 0;
    int pathLength = 0;

    Random rand = new Random();

    /* new graph will have an array of x nodes (100,000, 10 for test)*/
    public Graph(int numNodes) {
        this.vertex = new Node[numNodes];
        this.fillNodes();
        this.edge = new int[numNodes][numNodes];
        numVert = numNodes;
        //createRandGraph();
    }

    //randomly generated vertex numbers between 1 and 300,000 with total of 100,000 nodes
    public void fillNodes() {
        for (int i = 0; i < vertex.length; i++) {
            vertex[i] = new Node();
        }
    }

    public void createRandEdge(int startV) {
        int destV = rand.nextInt(numVert);
        if (destV == startV) {
            destV = rand.nextInt(numVert);
        }
        randEdgeWeight(startV, destV);
    }

    public void randEdgeWeight(int sv, int dv) {
        edge[sv][dv] = rand.nextInt(50);
        edge[dv][sv] = edge[sv][dv];
    }

    public void createRandGraph() {
        for (int i = 0; i < numVert; i++) {
            createRandEdge(i);
        }
    }

    public void setEdge(int x, int y, int weight) {
        edge[x][y] = weight;
        edge[y][x] = weight;
    }

    public int getEdge(int x, int y) {
        return edge[x][y];
    }

    public Node getVertex(int x) {
        return vertex[x];
    }

    public void refreshGraph() {
        for (int i = 0; i < vertex.length; i++) {
            vertex[i].setVisited(false);
        }
        totalVisited = 0;
        pathLength = 0;
    }

    public void BFT(int KeyNum, Queue q) {
        refreshGraph();
        totalVisited = 1;
        System.out.println();
        System.out.println("Breadth First Search Results: ");

        if (breadthSearch(KeyNum, 0, q)) {
            printResults(KeyNum);
        } else {
            System.out.println("The number " + KeyNum + " could not be found.");
        }
    }

    public boolean breadthSearch(int keyNum, int startV, Queue Q) {
        int nextV;
        if (this.vertex[startV].getValue() == keyNum) {
            //this.vertex[startV].print(); //remove print
            totalVisited++;
            return true;
        }
        if (this.vertex[startV].getValue() != keyNum) {//start queue and find first edge
            this.vertex[startV].setVisited(true);
            //find connected vertex
            while (findAdjUnvisitedVertex(startV) != -1) {
                //visit and add to queue
                nextV = findAdjUnvisitedVertex(startV);
                vertex[nextV].setVisited(true);
                if (this.vertex[nextV].getValue() == keyNum) {
                    totalVisited++;
                    pathLength++;
                    return true;
                }
                Q.addEnd(nextV);
                //vertex[nextV].print();
                totalVisited++;
            }
            if (areAllVisited()) {
                return false;
            }
        }
        int index = Q.gethead();
        Q.deleteHead();
        pathLength++;
        return breadthSearch(keyNum, index, Q);
    }

    public boolean areAllVisited() {
        for (int i = 0; i < vertex.length; i++) {
            if (!vertex[i].getVisited()) {
                return false;
            }
        }
        return true;
    }

    public void printResults(int keyNum) {
        System.out.println("The number " + keyNum + " was found.");
        System.out.println("Total visited Nodes: " + totalVisited);
        System.out.println("Length of shortest path: " + pathLength);
    }

    public int findAdjUnvisitedVertex(int index) {
        //only works for undirected graph
        int i;
        for (i = 0; i < numVert; i++) {
            if ((edge[index][i] != 0) && !vertex[i].getVisited()) {
                return i;
            }
        }
        return -1; //no adjacent not visited vertices.
    }

    public int findAdjVisitedVertex(int index) {
        for (int i = 0; i < numVert; i++) {
            if (edge[index][i] == 1 && vertex[i].getVisited() == true) {
                return i;
            }

        }
        return -1;
    }

    public Node DFTsearch(int keyValue, int startV) {
        System.out.println("Depth First Search Results: ");
        try {
            Stack<Integer> stack = new Stack<>();
            refreshGraph();
            stack.push(startV);
            vertex[startV].setVisited(true);
            //vertex[startV].print();
            totalVisited = 1;
            int v = startV;
            if (this.vertex[startV].getValue() == keyValue) {
                pathLength = 0;
                printResults(keyValue);
                return vertex[startV];
            }
            //1. visit adjacent unvisited vertex, mark as visited, print, push to stack
            while (!stack.empty()) {
                v = stack.pop();
                pathLength++;
                for (int i = 0; i < numVert; i++) {
                    if (edge[v][i] != 0 && vertex[i].getVisited() == false) {
                        //vertex[i].print();
                        stack.push(i);
                        vertex[i].setVisited(true);
                        totalVisited++;
                        //pathLength++;
                        if (vertex[i].getValue() == keyValue) {
                            printResults(keyValue);
                            return vertex[i];
                        }
                    }
                }
            }
            for (int i = 0; i < numVert; i++) {
                if (vertex[i].getVisited()) {
                    throw new Exception("Number not found.");
                }
            }
            printResults(keyValue);
            return vertex[v];
        } catch (Exception e) {
            System.out.println(e);
        }
        return vertex[startV];
    }

    public void arrayMaxValue(int array[]) {
        for (int i = 0; i < vertex.length; i++) {
            array[i] = Integer.MAX_VALUE;
        }
    }

    public void dijkstraSearch(int KeyNum, int StartV) {
        refreshGraph();
        System.out.println();
        System.out.println("Dijkstra Search Results: ");
        boolean result = Dijkstra(KeyNum, StartV);
        if (result) {
            printResults(KeyNum);
            System.out.println("Paths are weighted.");
        } else {
            System.out.println("The number " + KeyNum + " could not be found.");
            System.out.println();
        }
    }

    public boolean Dijkstra(int keyNum, int startV) {
        Stack<Integer> shortest = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<>();

        list.add(startV);

        int[] dist = new int[vertex.length];
        arrayMaxValue(dist);
        int[] prev = new int[vertex.length];

        dist[startV] = 0;
        while (!list.isEmpty()) {
            //remove vertex with min dist from queue
            //int min = findMin(list, dist);
            removeDuplicates(list);
            int current = findMinIndex(list, dist); //list.indexOf(min);
            list.remove(list.indexOf(current));
            if (vertex[current].getValue() == keyNum) {
                if (Character.isDefined(prev[current]) || current == startV) {
                    while (Character.isDefined(current) && current != startV) {
                        shortest.push(current);
                        current = prev[current];
                    }
                    for (int x = 0; x < shortest.size(); x++) {
                        pathLength = pathLength + dist[shortest.get(x)];
                    }
                }
                return true;
            }
            vertex[current].setVisited(true);
            totalVisited++;
            int vNeighbor;
            ArrayList<Integer> currentNeighbors = new ArrayList();
            fillNeighborlist(currentNeighbors, current);

            for (int k = 0; k < currentNeighbors.size(); k++) {
                vNeighbor = currentNeighbors.get(k);
                list.add(vNeighbor);
                int distance = edge[current][vNeighbor];
                if (distance != 0) {
                    int altRoute = dist[current] + distance;
                    if (altRoute < dist[vNeighbor]) {
                        dist[vNeighbor] = altRoute;
                        prev[vNeighbor] = current;
                    } else {
                        dist[vNeighbor] = distance;
                        prev[vNeighbor] = current;
                    }
                }
            }
        }
        if (areAllVisited() == true) {
            return false;
        }
        return false;
    }

    public int findMinIndex(ArrayList<Integer> List, int[] Dist) {
        int[] num = new int[List.size()];
        for (int i = 0; i < List.size(); i++) {
            num[i] = Dist[List.get(i)];
        }
        int min = Arrays.stream(num).min().getAsInt();
        int listIndex = getArrayIndex(num, min);
        return List.get(listIndex);
    }

    public void fillNeighborlist(ArrayList list, int current) {
        for (int j = 0; j < numVert; j++) {
            if ((edge[current][j] != 0) && !vertex[j].getVisited()) {
                list.add(j);
            }
        }
    }

    public int getArrayIndex(int[] arr, int value) {

        int k = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                k = i;
                break;
            }
        }
        return k;
    }

    public void removeDuplicates(ArrayList<Integer> List) {
        Set<Integer> set = new HashSet<Integer>(List);
        List.clear();
        List.addAll(set);
    }

}
