package lab9;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class DoublePQ {

      // Main Method
    public static void main(String[] args)
    {
        String[] input1 = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] input2 = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] answer1;
        int[] answer2;

        answer1 = Solution.solution(input1);
        answer2 = Solution.solution(input2);

        System.out.println("answer1: " + Arrays.toString(answer1)); // Expected output: [0,0]
        System.out.println("answer2: " + Arrays.toString(answer2)); // Expected output: [333,-45]
    }
}
