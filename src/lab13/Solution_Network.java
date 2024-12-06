package lab13;

public class Solution_Network {
    public int solution(int n, int[][] computers) {
        // 用于记录每个节点是否访问过
        boolean[] visited = new boolean[n];
        int numNetworks = 0;

        // 遍历所有节点
        for (int i = 0; i < n; i++) {
            // 如果当前节点未访问，说明发现了一个新网络
            if (!visited[i]) {
                numNetworks++;
                dfs(computers, visited, i);
            }
        }

        return numNetworks;
    }

    // 深度优先搜索 (DFS)
    private void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;

        // 遍历与当前节点相连的所有节点
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i); // 递归访问相连节点
            }
        }
    }
}