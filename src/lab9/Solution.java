package lab9;

import java.io.*;
import java.util.*;
 
public class Solution {

    public static int solution(int[] nums, int k){
        
        //******************** Write your code here ********************//
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
        //**************************************************************//

    }

}
