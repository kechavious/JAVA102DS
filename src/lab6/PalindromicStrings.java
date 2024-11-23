package lab6;

import java.io.*;
import java.util.*;
 
class PalindromicStrings {

      // Main Method
    public static void main(String[] args)
    {
        
        System.out.println("Palindrom Check!");
        String str = "lioninil";
        boolean t1 = Solution.solution(str);
        System.out.println(str + " is Palindrom?: " + t1);

        str = "abbcbba";
        boolean t2 = Solution.solution(str);
        System.out.println(str + " is Palindrom?: " + t2);

    }
}
