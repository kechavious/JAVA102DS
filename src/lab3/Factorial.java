package lab3;
import java.util.Scanner;

public class Factorial{

    public static void main(String[] args){

        Scanner scan = new Scanner( System.in );
        int input_num = scan.nextInt();

        int answer1;

        answer1 = Solution.solution(input_num);
        
        System.out.println(input_num + "! = " + answer1);

    }
}





