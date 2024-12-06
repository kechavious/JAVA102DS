package hw4_4;

import java.io.*;
import java.util.*;
 
import java.util.*;

public class Solution {
    public boolean solution(int n, int[][] edges, int[][] constraints) {
        // Step 1: Build adjacency list for the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // Assuming undirected graph
        }

        // Step 2: Handle constraints
        for (int[] constraint : constraints) {
            int start = constraint[0];
            int end = constraint[1];
            if (!isPathExists(graph, start, end, n)) {
                return false; // If any constraint fails, return false
            }
        }

        return true; // All constraints satisfied
    }

    // Helper method: Check if a path exists using DFS
    private boolean isPathExists(Map<Integer, List<Integer>> graph, int start, int end, int n) {
        boolean[] visited = new boolean[n];
        return dfs(graph, start, end, visited);
    }

    // Depth-First Search to find a path
    private boolean dfs(Map<Integer, List<Integer>> graph, int current, int target, boolean[] visited) {
        if (current == target) {
            return true; // Found the target
        }

        visited[current] = true; // Mark current node as visited

        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, target, visited)) {
                    return true; // Found the target in the path
                }
            }
        }

        return false; // No path found
    }
}
