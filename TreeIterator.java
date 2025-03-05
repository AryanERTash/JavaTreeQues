
/*
 * 	Leetcode #173
 *  Author: @AryanERTash
 */

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class BSTIterator {

	public TreeNode root;
	private TreeNode current;

	private final Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		this.root = root;
		this.current = root;
		this.stack = new Stack<>();
	}

	private void traverseLeft() {
		while (current != null) {
			stack.push(current);
			current = current.left;
		}
	}

	public int next() {

		traverseLeft();

		if (stack.isEmpty())
			return -1;

		TreeNode top = stack.pop();

		current = top.right;

		return top.val;

	}

	public boolean hasNext() {

		return this.current != null || !this.stack.isEmpty();

	}
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */