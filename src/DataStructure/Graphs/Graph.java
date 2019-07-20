package DataStructure.Graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class Graph {

    int V;
    ArrayList<LinkedList<Integer>> adjListArray;

    Graph(int V) {
        this.V = V;
        adjListArray = new ArrayList<LinkedList<Integer>>(V);

        for(int i = 0; i < V; i++) {
            adjListArray.add(new LinkedList<>());
        }
    }

    public void printGraph(Graph graph) {
        for (int v = 0; v < graph.V; v++) {
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for (Integer pCrawl : graph.adjListArray.get(v)) {
                System.out.print("-->" + pCrawl);
            }
            System.out.println("\n");
        }
    }
    
    public void addEdge(Graph graph, int src, int dest) {
        // Add an edge from src --> desc
        graph.adjListArray.get(src).add(dest);
        // Add an edge from desc --> src;
        graph.adjListArray.get(dest).add(src);
    }

    public void BFS(int vertex) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the vertex as visited and push it to the Queue
        visited[vertex]=true;
        queue.add(vertex);

        while(queue.size() != 0) {

            int v = queue.poll();
            System.out.print(v + " ");
            Iterator<Integer> itr = adjListArray.get(v).listIterator();

            while(itr.hasNext()) {
                int n = itr.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }    
        }
        
    }
}


