package lab11;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
class Balance {

    // Main Method
    public static void main(String[] args)
    {
        int input1 = 1;
        int input2 = 5;

        int answer1;
        int answer2;

        Solution_B s = new Solution_B();

        answer1 = s.solution(input1);
        answer2 = s.solution(input2);

        System.out.println("answer1: " + answer1); // Expected output: 1
        System.out.println("answer2: " + answer2); // Expected output: 3
    }
}
