import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        double num1 = scan.nextDouble();
        double num2 = scan.nextDouble();

        System.out.println("Input:");
        System.out.println(num1 + " " + num2);

        double[] swapped = swap(num1, num2); // Call swap method and capture returned array

        num1 = swapped[0]; // Update num1 with swapped value
        num2 = swapped[1]; // Update num2 with swapped value

        System.out.println("After Swap:");
        System.out.println(num1 + " " + num2);
    }

    public static double[] swap(double d1, double d2) {
        double tmp = d1;
        d1 = d2;
        d2 = tmp;
        return new double[]{d1, d2}; // Return swapped values in an array
    }
}
