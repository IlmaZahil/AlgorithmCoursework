package cw.algorithms;
// Implementation of Ford Fulkerson using Java


import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.LinkedList;

class MaxFlow {
    /* Returns true if there is a path from source 's' to
    sink 't' in residual graph. Also fills parent[] to
    store the path */
    static boolean BFS(int[][] resGraph, int s, int t, int[] parent,int Vertices)
    {
        // Create a visited array and mark all vertices as
        // not visited
        boolean visited[] = new boolean[Vertices];
        for (int i = 0; i < Vertices; ++i)
            visited[i] = false;
        // Create a queue, enqueue source vertex and mark
        // source vertex as visited
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
        // Standard BFS Loop
        while (queue.size() != 0) {
            int u = queue.poll();
            for (int v = 0; v < Vertices; v++) {
                if (visited[v] == false && resGraph[u][v] > 0) {
                    // If we find a connection to the sink
                    // node, then there is no point in BFS
                    // anymore We just have to set its parent
                    // and can return true
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        // We didn't reach sink in BFS starting from source,
        // so return false
        return false;
    }
    // Returns tne maximum flow from s to t in the given
    // graph
    static int fordFulkerson(int graph[][], int s, int t)
    {
        int Vertices;
        Vertices = t + 1;
        int u, v;
        // Create a residual graph and fill the residual
        // graph with given capacities in the original graph
        // as residual capacities in residual graph
        // Residual graph where resGraph[i][j] indicates
        // residual capacity of edge from i to j (if there
        // is an edge. If resGraph[i][j] is 0, then there is
        // not)
        int resGraph[][] = new int[Vertices][Vertices];
        for (u = 0; u < Vertices; u++)
            for (v = 0; v < Vertices; v++)
                resGraph[u][v] = graph[u][v];
        // This array is filled by BFS and to store path
        int parent[] = new int[Vertices];
        int max_flow = 0; // There is no flow initially
        long start = System.currentTimeMillis();
        // Augment the flow while there is a path from source
        // to sink
        while (BFS(resGraph, s, t, parent,Vertices)) {
            // Find minimum residual capacity of the edges
            // along the path filled by BFS. Or we can say
            // find the maximum flow through the path found.

            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, resGraph[u][v]);
            }
            // update residual capacities of the edges and
            // reverse edges along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                resGraph[u][v] -= path_flow;
                resGraph[v][u] += path_flow;
            }
            // Add path flow to overall flow
            System.out.print("\nAugment path : " + s);
            for (int i=0; i < parent.length; i++){
                if (parent[i]!=-1 && parent[i]!=0){
                    System.out.print("-->"+parent[i]);

                }

            }
            System.out.print("-->"+t);

            System.out.println("\nFlow units that can be carried by this path : " + path_flow);
            System.out.println("Therefore, max flow is now : "+max_flow + " + " + path_flow + " = " + (max_flow+path_flow));
            max_flow += path_flow;
        }
        long now = System.currentTimeMillis();
        double elapsed = (now - start) / 1000.0;
        System.out.println("\nElapsed time : " + elapsed + " seconds");
        // Return the overall flow
        return max_flow;


    }


}