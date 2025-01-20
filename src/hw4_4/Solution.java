package hw4_4;

import java.io.*;
import java.util.*;
 
public class Solution {
    
    /*
    To solve the problem, it is allowed to implement an additional class and variables here
    or to utilize JAVA's packges
    */

    List<Integer>[] tree;
    int[] parent;
    int[] pre, post;
    int time = 0;
    boolean[] visited;
    
    public boolean solution(int n, int[][] path, int[][] order) {
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] p : path) {
            tree[p[0]].add(p[1]);
            tree[p[1]].add(p[0]);
        }
        parent = new int[n];
        Arrays.fill(parent, -1);
        pre = new int[n];
        post = new int[n];
        visited = new boolean[n];
        parent[0] = 0;
        dfsBuild(0);
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            graph[parent[i]].add(i);
        }
        for (int[] o : order) {
            int A = o[0], B = o[1];
            if (isAncestor(B, A)) {
                return false;
            }
            graph[A].add(B);
        }
        return topologicalCheck(n, graph);
    }
    void dfsBuild(int u) {
        visited[u] = true;
        pre[u] = ++time;
        for (int nxt : tree[u]) {
            if (!visited[nxt]) {
                parent[nxt] = u;
                dfsBuild(nxt);
            }
        }
        post[u] = ++time;
    }
    boolean isAncestor(int a, int b) {
        return (pre[a] < pre[b]) && (post[a] > post[b]);
    }
    boolean topologicalCheck(int n, List<Integer>[] graph) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int nxt : graph[i]) {
                indegree[nxt]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for (int nxt : graph[cur]) {
                indegree[nxt]--;
                if (indegree[nxt] == 0) q.offer(nxt);
            }
        }

        return count == n;
    }
}






