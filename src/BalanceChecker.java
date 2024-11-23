import java.io.*;
import java.util.*;
 
class BalanceChecker {

    private static boolean balance_checker(String symbol_string){
        Stack<Character> stack= new Stack<>();
        for(int i = 0; i < symbol_string.length(); i++){
            char ch = symbol_string.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;

                }
                char top_char = stack.pop();
                if(ch == ')' && top_char != '('){
                    return false;
                }
                else if(ch == ']' && top_char != '['){
                    return false;
                }
                else if(ch == '}' && top_char != '{'){
                    return false;
                }
            }
        }
        
        return stack.isEmpty();

    }

      // Main Method
    public static void main(String[] args)
    {
        String input1 = "{{([][])}()}"; 
        String input2 = "[[{{(())}}]]"; 
        String input3 = "((()]))"; 

        boolean result1 = balance_checker(input1);
        boolean result2 = balance_checker(input2);
        boolean result3 = balance_checker(input3);

        System.out.println("Input string: " + input1);
        System.out.println("Output of Balance Checker: " + result1); // True

        System.out.println("Input string: " + input2);
        System.out.println("Output of Balance Checker: " + result2); // True

        System.out.println("Input string: " + input3);
        System.out.println("Output of Balance Checker: " + result3); // False
 
    }
}
