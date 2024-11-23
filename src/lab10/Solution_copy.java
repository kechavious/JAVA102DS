package lab10;

import java.io.*;
import java.util.*;

public class Solution_copy {

    int[][] result;

    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        nodes.sort((a, b) -> b.y == a.y ? a.x - b.x : b.y - a.y);

        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i));
        }

        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        postorderTraversal(root, postorder);

        result = new int[2][nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            result[0][i] = preorder.get(i);
            result[1][i] = postorder.get(i);
        }

        return result;
    }

    private void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    private void preorderTraversal(Node node, List<Integer> traversal) {
        if (node != null) {
            traversal.add(node.id);
            preorderTraversal(node.left, traversal);
            preorderTraversal(node.right, traversal);
        }
    }

    private void postorderTraversal(Node node, List<Integer> traversal) {
        if (node != null) {
            postorderTraversal(node.left, traversal);
            postorderTraversal(node.right, traversal);
            traversal.add(node.id);
        }
    }

    class Node {
        int id, x, y;
        Node left, right;

        Node(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }
}
