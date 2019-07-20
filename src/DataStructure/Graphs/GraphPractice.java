package DataStructure.Graphs;

import DataStructure.Graphs.Graph;

class GraphPractice {

    public static void main(String args[]) {
        // create the graph given in above figure
        int V = 5;
        Graph gp = new Graph(V);
        gp.addEdge(gp, 0, 1);
        gp.addEdge(gp, 1, 2);
        gp.addEdge(gp, 2, 3);
        gp.addEdge(gp, 3, 4);

        System.out.println("===>");
        // gp.printGraph(gp);
        gp.BFS(2);
    }
}
