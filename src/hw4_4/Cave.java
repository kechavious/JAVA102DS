package hw4_4;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Cave {

    // Main Method
    public static void main(String[] args)
    {

        int input1 = 9;
        int[][] input2 = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] input3 = {{8,5},{6,7},{4,1}};

        boolean answer1;

        Solution s = new Solution();

        answer1 = s.solution(input1, input2, input3);

        System.out.println("answer1: " + answer1); // "answer1: True"
    }
}
