package lab5;

import java.io.*;
import java.util.*;
 
class DailyTemperatures {

      // Main Method
    public static void main(String[] args)
    {
        int[] input1 = {23, 24, 25, 21, 19, 22, 26, 23}; 
        int[] input2 = {12, 11, 14, 13, 10, 11, 13, 11}; 
        int[] input3 = {32, 31, 30, 28, 29, 30, 29, 27}; 

        int[] result1 = Solution.solution(input1);
        int[] result2 = Solution.solution(input2);
        int[] result3 = Solution.solution(input3);

        System.out.println("Input temp: " + Arrays.toString(input1));
        System.out.println("Output: " + Arrays.toString(result1)); // expected output: [1, 1, 4, 2, 1, 1, 0, 0]

        System.out.println("Input temp: " + Arrays.toString(input2));
        System.out.println("Output: " + Arrays.toString(result2)); // expected output: [2, 1, 0, 0, 1, 1, 0, 0]

        System.out.println("Input temp: " + Arrays.toString(input3));
        System.out.println("Output: " + Arrays.toString(result3)); // expected output: [0, 0, 0, 1, 1, 0, 0, 0]


    }
}
