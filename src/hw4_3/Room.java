package hw4_3;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Room {

    // Main Method
    public static void main(String[] args)
    {

        int[] input1 = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};

        int answer1;

        Solution s = new Solution();

        answer1 = s.solution(input1);

        System.out.println("answer1: " + answer1); // "answer1: 3"
    }
}
