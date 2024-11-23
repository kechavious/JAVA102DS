package lab6;

import java.io.*;
import java.util.*;
 
public class Solution {

    public static boolean solution(String A){
        //******************** Write your code here ********************//
    /* 

        StringBuilder sb= new StringBuilder(A);
        String reverseString = sb.reverse().toString();
        
        return A.equals(reverseString);
    }
} 
    */

        
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < A.length(); i++){
            stack.push(A.charAt(i));
            queue.add(A.charAt(i));

        }
        while(!stack.isEmpty()&&!queue.isEmpty()){
            if(stack.pop()!= queue.remove()){
                return false;
            }
            
        }
        return true;
    }
    
}



        //**************************************************************/

    



