package hw1;
import java.util.Scanner;

public class Climb {

    static int climbStairs(int n) {
        // ------------------- //
        // Implement this part //
        if (n <= 1) {
            return 1;
        }else if(n<=0){
            return 0;

        }
        else {
            return climbStairs(n-1)+climbStairs(n-2);
        }



        // ------------------- //
    }

    public static void main(String[] args) {
        // ----------------------------------- //
        // You don't need to correct this part //
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer between 0 and 45: ");

        int n = scanner.nextInt();

        int result = climbStairs(n);
        System.out.println();
        System.out.print(result);

        scanner.close();
        // ----------------------------------- //
    }
}



