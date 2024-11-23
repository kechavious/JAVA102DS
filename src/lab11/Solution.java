package lab11;

import java.util.*;

public class Solution {

    static int K;
    static int[] arr;
    static StringBuffer[] ans;

    public static StringBuffer[] solution(int input1, int[] input2) {

        K = input1;
        arr = input2;
        ans = new StringBuffer[K];

        for (int i = 0; i < K; i++)
            ans[i] = new StringBuffer();

        // Call the recursive function to build the tree and populate levels
        buildTree(0, arr.length - 1, 0);

        // 去除每个层次字符串末尾的多余" ,"
        for (int i = 0; i < K; i++) {
            int len = ans[i].length();
            if (len >= 2 && ans[i].substring(len - 2).equals(" ,")) {
                ans[i].delete(len - 2, len); // 删除末尾的" ,"
            }
        }

        // Return the results
        return ans;
    }

    // Helper function to recursively build the tree
    private static void buildTree(int start, int end, int depth) {
        if (start > end) {
            return; // Base case
        }

        // Find the middle element (root of the current subtree)
        int mid = (start + end) / 2;

        // Append the middle element to the current depth's StringBuffer
        ans[depth].append(arr[mid]);
        // 在数字后添加空格和逗号
        ans[depth].append(" ");

        // Recursively process left and right subtrees
        buildTree(start, mid - 1, depth + 1); // Left subtree
        buildTree(mid + 1, end, depth + 1);   // Right subtree
    }
}

