package lab11;

import java.util.*;

public class Solution_B {

    // Precompute the minimum number of nodes for each height
    public static List<Long> minNodes;

    static {
        minNodes = new ArrayList<>();
        minNodes.add(1L); // N(0) = 1 node (for height 0)
        minNodes.add(2L); // N(1) = 2 nodes (for height 1)
        
        // Calculate the minimum nodes required for each height and stop if nodes exceed 1 billion
        while (true) {
            long next = 1 + minNodes.get(minNodes.size() - 1) + minNodes.get(minNodes.size() - 2);
            if (next > 1_000_000_000) break; // Stop when exceeding 1 billion
            minNodes.add(next);
        }
    }

    // Function to compute the maximum height of an AVL Tree with at most 'input1' vertices
    public static int solution(int input1) {
        int low = 0, high = minNodes.size() - 1;
        int result = 0;

        // Binary search for the maximum height where the minimum nodes required is <= input1
        while (low <= high) {
            int mid = (low + high) / 2;
            if (minNodes.get(mid) <= input1) {
                result = mid; // Valid height, move to a higher possible height
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result + 1; // Height is 1-based, so add 1
    }
}
