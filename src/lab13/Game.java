package lab13;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
public class Game {

    // Main Method
    public static void main(String[] args)
    {
        int[][] input1 = {
        {1,0,1,1,1},
        {1,0,1,0,1},
        {1,0,1,1,1},
        {1,1,1,0,1},
        {0,0,0,0,1}};

        int answer1;

        Solution_Game s = new Solution_Game();

        answer1 = s.solution(input1);

        System.out.println("answer1: " + answer1); // "answer1: 11"
    }
}
