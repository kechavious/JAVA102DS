package lab10;

import java.io.*;
import java.util.*;
 
public class Solution {

    public static List<Integer> solution(int[] input){
        
        List<Integer> output = new ArrayList<>();

        //******************** Write your code here ********************//
        postOrderTraversal(input, 0, input.length - 1, output);
        //**************************************************************//

        return output;
    }

    private static void postOrderTraversal(int[] input, int start, int end, List<Integer> output) {
        if (start > end) {
            return;
        }
        int root = input[start];
        int i = start + 1;
        while (i <= end && input[i] < root) {
            i++;
        }
        postOrderTraversal(input, start + 1, i - 1, output);
        postOrderTraversal(input, i, end, output);
        output.add(root);
    }
}