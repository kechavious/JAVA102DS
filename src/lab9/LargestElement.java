package lab9;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class LargestElement {

      // Main Method
    public static void main(String[] args)
    {
        int[] input1 = {3,2,1,5,6,4};
        int[] input2 = {3,2,3,1,2,4,5,5,6};

        int k1 = 2;
        int k2 = 4;

        int answer1;
        int answer2;

        answer1 = Solution.solution(input1,k1);
        answer2 = Solution.solution(input2,k2);

        System.out.println("answer1: " + answer1); // Expected output: 5
        System.out.println("answer2: " + answer2); // Expected output: 4
    }
}
