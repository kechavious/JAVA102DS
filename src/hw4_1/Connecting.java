package hw4_1;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Connecting {

    // Main Method
    public static void main(String[] args)
    {

        int input1 = 4;
        int[][] input2 = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int answer1;

        Solution s = new Solution();

        answer1 = s.solution(input1, input2);

        System.out.println("answer1: " + answer1); // "answer1: 4"
    }
}

