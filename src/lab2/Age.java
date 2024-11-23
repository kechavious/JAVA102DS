package lab2;
import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your age (a positive integer): ");

        // Read the entire line of input
        String ageInput = in.nextLine().trim();
        int num = 0;

        try {
            // Check if the input is a valid integer and doesn't contain extra tokens
            num = Integer.parseInt(ageInput);
            if (num <= 0 || num >= 122) {
                System.out.println("Enter a valid age.");
                System.exit(0);
            }
            if(ageInput.contains(" ")){
                System.out.println("Enter a valid age");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid integer.");
            System.exit(0);
        }

        System.out.println("Enter your name: ");
        String name = in.nextLine().trim();

        // Check if the name contains any digits
        boolean hasNum = false;
        char[] arr = name.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                hasNum = true;
                break;
            }
        }

        if (hasNum) {
            System.out.println("Please enter a valid name.");
            System.exit(0);
        }

        System.out.println(name + " is " + num + " years old.");
        in.close();
    }
}

