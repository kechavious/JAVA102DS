package lab13;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
public class Network {

    // Main Method
    public static void main(String[] args){
        int input1 = 3;
        int[][] input2 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int answer1;

        Solution_Network s = new Solution_Network();

        answer1 = s.solution(input1, input2);

        System.out.println("answer1: " + answer1); // "answer1: 2"
    }
}
