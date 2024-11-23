package lab12;

import java.io.*;
import java.util.*;
import java.util.HashMap;

public class Solution_Copy {
    public static boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        // 将所有电话号码存入哈希表
        for (String phone : phone_book) {
            map.put(phone, 1);
        }

        // 检查每个电话号码的所有前缀是否存在于哈希表中
        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (map.containsKey(prefix)) {
                    return false; // 存在前缀，返回false
                }
            }
        }

        return true; // 不存在前缀，返回true
    }
}
