package lab10;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class BST {

      // Main Method
    public static void main(String[] args)
    {
        int[] input1 = {50,30,24,5,28,45,98,52,60};

        List<Integer> answer1;

        answer1 = Solution.solution(input1);

        System.out.println("answer1: " + answer1.toString()); // Expected output: [5,28,24,45,30,60,52,98,50]
    }
}