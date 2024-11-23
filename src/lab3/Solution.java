package lab3;

import java.io.*;
import java.util.*;
 
public class Solution {

    public static int solution(int num) {
        
        if (num < 0) {
            return -1; // Indicate an error
        }
        if (num > 10) {
            return -1; // Indicate an error
        }
        if (num == 0 || num == 1) {
            return 1; // Base case: 0! and 1! both equal 1
        }
        return num * solution(num - 1); // Recursive case
    }  
}               


