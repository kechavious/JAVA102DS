package lab13;

public class Solution_Network {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n]; // 标记每个节点是否被访问
        int networkCount = 0;

        // 遍历每个节点
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                networkCount++; // 每次执行 DFS，表示发现一个新的网络
            }
        }

        return networkCount;
    }

    // 深度优先搜索递归方法
    private void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true; // 标记当前节点为已访问

        // 遍历与当前节点直接相连的其他节点
        for (int i = 0; i < computers.length; i++) {
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}
