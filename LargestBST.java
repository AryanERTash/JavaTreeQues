// gfg https://www.geeksforgeeks.org/problems/largest-bst/1
import java.util.*;

class Node {

    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Tuple {

    public int size;
    public int max;
    public int min;

    public Tuple(int size, int min, int max) {
        this.size = size;
        this.max = max;
        this.min = min;
    }

}

class Solution {

    // Return the size of the largest sub-tree which is also a BST
    static Tuple helper(Node root) {
        if (root == null) {
            return new Tuple(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Tuple left = helper(root.left);

        Tuple right = helper(root.right);

        if (left.max < root.data && right.min > root.data) {
            return new Tuple(left.size + 1 + right.size, Math.min(root.data, left.min), Math.max(root.data, right.max));	// to handle null we use min max

        }
        return new Tuple(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    static int largestBst(Node root) {

        return helper(root).size;
		

    }

}
