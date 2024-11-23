package lab5;

import java.io.*;
import java.util.*;
 
public class Solution {

    public static int[] solution(int[] temperatures){

        
        //******************** Write your code here ********************//
            Stack<Integer> s=new Stack<>();
            int[] result = new int[temperatures.length];
    
            for(int i = 0; i < temperatures.length; i++){
                while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                    int index = s.pop();
                    result[index] = i - index;
                }
                s.push(i);
            }
            return result;
        }
        //******************** Write your code here ********************//
    }



