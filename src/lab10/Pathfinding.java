package lab10;

import java.io.*;
import java.util.*;
import java.util.Arrays;

class Pathfinding {

    // Main Method
    public static void main(String[] args)
    {
        int[][] input1 = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        int[][] answer1;

        Solution_copy s = new Solution_copy();
        answer1 = s.solution(input1);

        System.out.println("answer1: " + Arrays.deepToString(answer1)); // Expected output: [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]
    }
}
