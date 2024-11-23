package lab12;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class PhoneNumber {

    // Main Method
    public static void main(String[] args)
    {
        String[] input1 = {"119", "97674223", "1195524421"};
        String[] input2 = {"123","456","789"};

        boolean answer1;
        boolean answer2;

        Solution_Copy s = new Solution_Copy();

        answer1 = s.solution(input1);
        answer2 = s.solution(input2);

        System.out.println("answer1: " + answer1); // "answer1: false"
        System.out.println("answer2: " + answer2); // "answer2: true"
    }
}
