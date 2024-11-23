package lab5;

import java.io.*;
import java.util.*;
 
class FunctionDevelopment {

    public static void main(String[] args)
    {
        int[] progresses1 = {93, 30, 55};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] progresses3 = {95, 51, 88, 96, 52, 40, 2, 10};
        int[] progresses4 = {63, 32, 1, 86, 23, 12, 42, 2};

        int[] speeds1 = {1, 30, 5};
        int[] speeds2 = {1,1,1,1,1,1};
        int[] speeds3 = {50,30,20,1,40,50,98,90};
        int[] speeds4 = {12,32,11,45,12,1,32,42};

        ArrayList answer1;
        ArrayList answer2;
        ArrayList answer3;
        ArrayList answer4;

        answer1 = Solution2.solution(progresses1, speeds1);
        answer2 = Solution2.solution(progresses2, speeds2);
        answer3 = Solution2.solution(progresses3, speeds3);
        answer4 = Solution2.solution(progresses4, speeds4);

        System.out.println("answer1 " + answer1); // Expected output: [2,1]
        System.out.println("answer2 " + answer2); // Expected output: [1, 3, 2]
        System.out.println("answer3 " + answer3); // Expected output: [1, 2, 5]
        System.out.println("answer3 " + answer4); // Expected output: [2, 3, 3]
    }
}
