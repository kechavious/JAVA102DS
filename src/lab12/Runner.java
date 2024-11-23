package lab12;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Runner {

    // Main Method
    public static void main(String[] args)
    {
        String[] input1_1 = {"leo", "kiki", "eden"};
        String[] input1_2 = {"eden", "kiki"};

        String[] input2_1 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] input2_2 = {"josipa", "filipa", "marina", "nikola"};

        String answer1;
        String answer2;

        Solution s = new Solution();

        answer1 = s.solution(input1_1, input1_2);
        answer2 = s.solution(input2_1, input2_2);

        System.out.println("answer1: " + answer1); // "answer1: leo"
        System.out.println("answer2: " + answer2); // "answer2: vinko"
    }
}
