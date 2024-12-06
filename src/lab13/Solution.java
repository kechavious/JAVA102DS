package lab13;

import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        // 使用 Map 按类别统计衣物数量
        Map<String, Integer> categoryCount = new HashMap<>();

        for (String[] item : clothes) {
            String category = item[1];
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }

        // 计算所有组合
        int combinations = 1;
        for (int count : categoryCount.values()) {
            combinations *= (count + 1); // 每个类别可以选择穿或不穿
        }

        return combinations - 1; // 减去所有都不穿的情况
    }
}

