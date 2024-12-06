package lab13;

import java.io.*;
import java.util.*;
import java.util.Arrays;
 
public class Clothes {

    // Main Method
    public static void main(String[] args)
    {
        String[][] input1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] input2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        int answer1;
        int answer2;

        Solution s = new Solution();

        answer1 = s.solution(input1);
        answer2 = s.solution(input2);

        System.out.println("answer1: " + answer1); // "answer1: 5"
        System.out.println("answer2: " + answer2); // "answer2: 3"
    }
}
