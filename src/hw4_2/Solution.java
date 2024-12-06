package hw4_2;
import java.io.*;
import java.util.*;

public class Solution {

    /*
    To solve the problem, we are going to use Dijkstra's algorithm to compute the shortest path from multiple start points.
    Specifically, we will compute the shortest distance from the starting point `s`, and from both destinations `a` and `b`.
    We will then combine these distances to find the minimum total fare.
    */

    // Dijkstra's algorithm to calculate shortest paths from a given start node
    private int[] dijkstra(int n, int start, int[][] fares) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Populate the graph with edges and their costs
        for (int[] fare : fares) {
            // Add bidirectional edges (fare[0] to fare[1] and fare[1] to fare[0])
            graph.get(fare[0]).add(new int[]{fare[1], fare[2]});
            graph.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }

        // Initialize the distance array where dist[i] is the shortest distance from 'start' to node i
        int[] dist = new int[n + 1];  // We have nodes from 1 to n, so array size is n+1
        Arrays.fill(dist, Integer.MAX_VALUE);  // Set all distances to infinity
        dist[start] = 0;  // Distance from the start node to itself is 0

        // Priority queue to store nodes and their current shortest distances, ordered by distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});  // Add the start node with distance 0

        // Dijkstra's algorithm to compute the shortest distances
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];  // Current node
            int cost = current[1];  // Cost to reach the current node

            if (cost > dist[node]) continue;  // Skip if the current path is not the shortest

            // Iterate over all neighboring nodes
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];  // Neighbor node
                int edgeCost = neighbor[1];  // Cost to reach the neighbor

                // Update the shortest distance to the neighbor node if a better path is found
                if (dist[node] + edgeCost < dist[nextNode]) {
                    dist[nextNode] = dist[node] + edgeCost;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }

        return dist;  // Return the shortest distances from 'start' to all other nodes
    }

    // Main function to calculate the minimum fare
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // Step 1: Get the shortest distances from the start point `s`
        int[] distFromS = dijkstra(n, s, fares);

        // Step 2: Get the shortest distances from destination `a`
        int[] distFromA = dijkstra(n, a, fares);

        // Step 3: Get the shortest distances from destination `b`
        int[] distFromB = dijkstra(n, b, fares);

        // Step 4: Compute the minimum fare by considering all possible shared paths through an intermediate station
        int minCost = Integer.MAX_VALUE;

        // Try all possible intermediate stations (1 to n)
        for (int i = 1; i <= n; i++) {
            // Calculate the fare if both passengers share the path through station `i`
            int cost = distFromS[i] + distFromA[i] + distFromB[i];
            // Update the minimum cost if a smaller cost is found
            minCost = Math.min(minCost, cost);
        }

        return minCost;  // Return the minimum fare
    }
}
// djkstra algorithm