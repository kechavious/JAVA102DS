package hw4_3;

import java.io.*;
import java.util.*;
 
public class Solution {
    public int solution(int[] input) {
        int maxCount = 0; // 最大连续出现次数
        int currentCount = 1; // 当前连续出现次数

        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                currentCount++; // 如果与前一个数字相同，计数加1
            } else {
                maxCount = Math.max(maxCount, currentCount); // 更新最大值
                currentCount = 1; // 重置当前计数
            }
        }

        // 检查最后一次连续计数
        maxCount = Math.max(maxCount, currentCount);

        return maxCount; // 返回最大连续出现次数
    }
}
    


