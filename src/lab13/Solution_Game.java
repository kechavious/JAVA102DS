package lab13;

import java.util.*;

public class Solution_Game {
    public int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1; // 无效输入
        }
        
        int rows = grid.length;
        int cols = grid[0].length;

        // 如果起点或终点是障碍，直接返回 -1
        if (grid[0][0] == 0 || grid[rows - 1][cols - 1] == 0) {
            return -1;
        }

        // BFS 初始化
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右

        queue.add(new int[]{0, 0, 1}); // {当前行, 当前列, 当前路径长度}
        visited[0][0] = true;

        // BFS 开始
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int pathLength = current[2];

            // 如果到达终点
            if (x == rows - 1 && y == cols - 1) {
                return pathLength;
            }

            // 遍历四个方向
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // 检查是否在边界内、可通行且未访问
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                    grid[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.add(new int[]{newX, newY, pathLength + 1});
                    visited[newX][newY] = true; // 标记为已访问
                }
            }
        }

        return -1; // 如果无法到达终点
    }
}

