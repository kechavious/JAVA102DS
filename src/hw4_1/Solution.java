package hw4_1;

import java.util.*;

public class Solution {

    public int solution(int n, int[][] costs) {
        // **Step 1**: Build the graph as an adjacency list
        // Use a HashMap to represent the graph, where each node maps to a list of edges
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>()); // Initialize adjacency list for each node
        }
        // Populate the adjacency list with edges
        for (int[] cost : costs) {
            graph.get(cost[0]).add(new int[]{cost[1], cost[2]}); // Add edge from cost[0] to cost[1] with weight cost[2]
            graph.get(cost[1]).add(new int[]{cost[0], cost[2]}); // Add edge from cost[1] to cost[0] with weight cost[2]
        }

        // **Step 2**: Initialize a priority queue to always select the smallest weight edge
        // Each entry in the priority queue is an edge represented as [destination, weight]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[1]));
        
        // Add all edges from the starting node (e.g., node 0) to the priority queue
        pq.addAll(graph.get(0));

        // **Step 3**: Create a visited array to track nodes already included in the MST
        boolean[] visited = new boolean[n];
        visited[0] = true; // Mark the starting node as visited

        // Variable to keep track of the total weight of the MST
        int mstWeight = 0;
        // Variable to count the number of edges included in the MST
        int edgesUsed = 0;

        // **Step 4**: Construct the MST
        while (!pq.isEmpty() && edgesUsed < n - 1) { // Continue until we've used n-1 edges
            // Remove the smallest weight edge from the priority queue
            int[] currentEdge = pq.poll();
            int dest = currentEdge[0]; // Destination node of the edge
            int weight = currentEdge[1]; // Weight of the edge

            // If the destination node is already visited, skip this edge to avoid cycles
            if (visited[dest]) {
                continue;
            }

            // Include this edge in the MST
            visited[dest] = true; // Mark the destination node as visited
            mstWeight += weight; // Add the edge weight to the total MST weight
            edgesUsed++; // Increment the count of edges used in the MST

            // Add all edges from the newly visited node to the priority queue
            for (int[] neighbor : graph.get(dest)) {
                if (!visited[neighbor[0]]) { // Only consider edges leading to unvisited nodes
                    pq.offer(neighbor);
                }
            }
        }

        // **Step 5**: Return the total weight of the MST
        return mstWeight;
    }
}

//prim implementation//


