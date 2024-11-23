package lab10;

public class Node {
    int x;
    int y;
    int value;
    Node left;
    Node right;
    
    public Node(int x, int y, int value, Node left, Node right) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
