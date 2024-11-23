package lab4;
import java.util.Arrays;

public class Numbers{

    public static void main(String[] args){

        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};

        int[] answer1;
        int[] answer2;
        
        answer1 = Solution.solution(arr1);
        answer2 = Solution.solution(arr2);
        
        System.out.println("answer1: " + Arrays.toString(answer1)); // "answer1: [1,3,0,1]"
        System.out.println("answer2: " + Arrays.toString(answer2)); // "answer2: [4,3]"

    }
}





