package lab13;

import java.io.*;
import java.util.*;
 
public class Solution_Game {

    public int solution(int[][] maps) {

        //******************** Write your code here ********************//
        if (maps[0][0] == 0) {
            return -1;
        }
        // dimension(map: nxm matrix)
        int n = maps.length;
        int m = maps[0].length;

        if (n == 1 && m == 1) {
            return 1; // alr there
        }
       
        // directions for movement {up, down, left, right}
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // visited array to track if a cell has been visited
        boolean[][] visited = new boolean[n][m];
        // BFS queue stores {row, col, steps}
        Queue<int[]> queue = new LinkedList<>();

        // start from the top-left corner
        queue.add(new int[]{0, 0, 1}); // initial pos: step count 1
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
           
            // if we reach the bottom-right corner, return the steps
            if (x == n - 1 && y == m - 1) {
                return steps;
            }
           
            for (int[] dir : directions) { // explore all 4 possible directions
                int nx = x + dir[0];
                int ny = y + dir[1];
               
                // check if the new position is within bounds && not a wall && not visited
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, steps + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        // exit loop = no way to reach end
        return -1;
        //******************** Write your code here ********************//
       
    }

}
