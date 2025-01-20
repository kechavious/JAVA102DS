package hw4_3;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static final int[][] DIRECTIONS = {
        {0, 1},   // Right
        {1, 1},   // Down-Right
        {1, 0},   // Down
        {1, -1},  // Down-Left
        {0, -1},  // Left
        {-1, -1}, // Up-Left
        {-1, 0},  // Up
        {-1, 1}   // Up-Right
    };

    public int solution(int[] arrows) {
        Set<String> walls = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0; // Starting point
        int rooms = 0;

        // Mark the starting point as visited
        visited.add(x + "," + y);

        for (int arrow : arrows) {
            for (int step = 0; step < 2; step++) { // Split movement into smaller steps
                int dx = DIRECTIONS[arrow][0];
                int dy = DIRECTIONS[arrow][1];
                int nx = x + dx;
                int ny = y + dy;

                String wall = x + "," + y + "->" + nx + "," + ny;
                String reverseWall = nx + "," + ny + "->" + x + "," + y;

                // Check if the new wall creates a new room
                if (visited.contains(nx + "," + ny) && !walls.contains(wall)) {
                    rooms++; // A new room is formed
                }

                // Mark the wall and reverse wall as traversed
                walls.add(wall);
                walls.add(reverseWall);

                // Mark the new point as visited
                visited.add(nx + "," + ny);

                // Update current position
                x = nx;
                y = ny;
            }
        }

        return rooms;
    }
}




