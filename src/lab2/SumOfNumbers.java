package lab2;
//do not change the name of the package
//the autograder will fail, if the package is not named properly
// add your own name below:
//
// author:Gordon Zou
//

public class SumOfNumbers {
    /*
        Implement this function. Do not change
        anything else in this file.
    */
    public static int sumOfNumbers(String str) {
        int sum = 0;
        String temp = "";

        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            // If the current character is a digit, add it to the temp string
            if (Character.isDigit(now)) {
                temp += now;
            } else {
                // If we encounter a non-ligit character, parse and add the number
                if (!temp.isEmpty()) {
                    sum += Integer.parseInt(temp);
                    temp = ""; // Reset the temp string
                }
            }
        }

        // After loop ends, check if there's any number left to add
        if (!temp.isEmpty()) {
            sum += Integer.parseInt(temp);
        }

        return sum;  // Return the total sum

    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(sumOfNumbers("abc123def456ghi789jkl0      1")); // 1368
        System.out.println(sumOfNumbers("00000000000     a     1")); // 0
        System.out.println(sumOfNumbers("")); // 0
        System.out.println(sumOfNumbers("hello "));
        System.out.println(sumOfNumbers(" 11 7"));
    }
}
