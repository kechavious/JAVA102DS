package lab11;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class CBT {

    // Main Method
    public static void main(String[] args)
    {
        int input1_1 = 2;
        int[] input1_2 = {2, 1, 3};

        int input2_1 = 4;
        int[] input2_2 = {8, 4, 9, 2, 5, 1, 6, 3, 7};

        StringBuffer[] answer1;
        StringBuffer[] answer2;

        Solution s = new Solution();

        answer1 = s.solution(input1_1, input1_2);
        answer2 = s.solution(input2_1, input2_2);

        System.out.println("answer1: " + Arrays.deepToString(answer1)); // [1 , 2 3 ]
        System.out.println("answer2: " + Arrays.deepToString(answer2)); // [3 , 6 2 , 1 4 5 7 ]
    }
}