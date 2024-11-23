package lab6;

import java.io.*;
import java.util.*;
 
class NCards {

      // Main Method
    public static void main(String[] args)
    {
        int n1 = 4;
        int n2 = 5;
        int n3 = 6;

        Queue<Integer> answer1;
        
        answer1 = SolutionforNcards.solution(n1);

        // System.out.println(answer1.poll()); // expected output: '1 3 2 4'
        System.out.println(answer1); // expected output: '1 3 2 4'
    }
}
