/*
 * Merge 2 BST
 * Link top problem: https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
 */

import java.util.*;

class Node {
	int data;
	Node left, right;

	public Node(int d) {
		data = d;
		left = right = null;
	}
}

class BSTPreOrderIterator {
	/*
	 * A iterator implementation for pre order traversal of BST
	 * similar to PreOrderIterator
	 */

	private Stack<Node> stack;

	public BSTPreOrderIterator(Node root) {

		this.stack = new Stack<>();
		this.stack.push(root);
	}

	public boolean hasNexcdt() {
		return !stack.empty();
	}

	public Node getNext() {
		return stack.peek();
	}

	private boolean canPop(Node current, Node top) {
		return current == top.right ||
				(current == top.left && top.right == null);
	}

	public void advance() {
		Node current = stack.peek();

		if (current.left != null) {
			stack.push(current.left);
		} else if (current.right != null) {
			stack.push(current.right);
		} else {
			current = stack.pop();

			while (!stack.empty() && canPop(current, stack.peek())) {
				current = stack.pop();
			}

			if(stack.empty()) return;

			Node top = stack.peek();

			if (current == top.left) {
				stack.push(top.right);
			}

		}
	}

}

class Solution {
	
}
