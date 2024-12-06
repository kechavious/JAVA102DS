package hw4_2;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Taxi {

    // Main Method
    public static void main(String[] args)
    {

        int input1 = 6;
        int input2 = 4;
        int input3 = 6;
        int input4 = 2;
        int[][] input5 = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};

        int answer1;

        Solution s = new Solution();

        answer1 = s.solution(input1, input2, input3, input4, input5);

        System.out.println("answer1: " + answer1); // "answer1: 82"
    }
}
