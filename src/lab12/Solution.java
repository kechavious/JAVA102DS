package lab12;

import java.io.*;
import java.util.*;
import java.util.HashMap;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 记录每个参赛者的出现次数
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 减去每个完成者的次数
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        // 找到次数不为零的参赛者
        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                return name;
            }
        }

        return "";
    }
}
