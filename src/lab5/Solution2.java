
package lab5;
import java.io.*;
import java.util.*;
 
public class Solution2 {

    public static ArrayList solution(int[] progresses, int[] speeds){

        ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        
        //******************** Write your code here ********************//

        //First, check the time that every task that should finish it.

        int length = progresses.length;
        for(int i = 0; i <length; i++ ){
            int remainWork = 100-progresses[i];//how mnay % left 
            int daysRemain = (remainWork+speeds[i]-1)/speeds[i];
            queue.add(daysRemain);
        }
        //second, cal the quantity of task should be released
        while(!queue.isEmpty()){
            int count =1;
            int current = queue.poll();

            //Third, check wether it could release together and return the day to the answer.
            while(!queue.isEmpty() && queue.peek()<=current){
                queue.poll();
                count++;
            }
            answer.add(count);
        }










        //**************************************************************//

        return answer;
    }

}
