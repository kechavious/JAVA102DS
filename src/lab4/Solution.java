package lab4;

import java.util.List;
import java.util.ArrayList;
 
public class Solution {

    public static int[] solution(int[] arr) {

        
        //******************** Write your code here ********************//
        try{
            List<Integer> list = new ArrayList<Integer>();
            //check wether the array is 0 or not
            if(arr.length == 0){
                return new int[0];
            }
            if(arr.length >=0){
                list.add(arr[0]);
            }
            //find the non-duplicate elements in the array
            for(int i = 1; i < arr.length; i++){
                if(arr[i] != arr[i-1]){
                    list.add(arr[i]);
                }
            }

            //covert the arraylist to the array;
            int[] result = new int[list.size()];
            for(int j = 0; j < list.size(); j++){
                result[j] = list.get(j);
            }
            return result;

        }
        catch(Exception e){
            return new int[0];
        }

        //******************** Write your code here ********************//
    }
}


