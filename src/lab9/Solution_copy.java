package lab9;

import java.io.*;
import java.util.*;
 
public class Solution_copy {

    public static int[] solution(String[] operations){
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer> removed = new HashSet<>();
        for(String operation : operations){
            String[] op = operation.split(" ");
            if(op[0].equals("I")){
                int num = Integer.parseInt(op[1]);
                minHeap.offer(num);
                maxHeap.offer(num);
            } else if(op[0].equals("D")){
                if(op[1].equals("1")){
                    // 删除最大值
                    while(!maxHeap.isEmpty() && removed.contains(maxHeap.peek())){
                        maxHeap.poll();
                    }
                    if(!maxHeap.isEmpty()){
                        int max = maxHeap.poll();
                        removed.add(max);
                    }
                } else if(op[1].equals("-1")){
                    // 删除最小值
                    while(!minHeap.isEmpty() && removed.contains(minHeap.peek())){
                        minHeap.poll();
                    }
                    if(!minHeap.isEmpty()){
                        int min = minHeap.poll();
                        removed.add(min);
                    }
                }
            }
        }
        // 清理堆中已删除的元素
        while(!maxHeap.isEmpty() && removed.contains(maxHeap.peek())){
            maxHeap.poll();
        }
        while(!minHeap.isEmpty() && removed.contains(minHeap.peek())){
            minHeap.poll();
        }
        if(minHeap.isEmpty() || maxHeap.isEmpty()){
            return new int[]{0, 0};
        } else {
            return new int[]{maxHeap.peek(), minHeap.peek()};
        }
    }

}

