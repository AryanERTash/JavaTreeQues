
//leetcode 1008 but recursive solution

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



class Pair {
	public TreeNode node;
	public int limit;

	public Pair() {
		node = null;
		limit = Integer.MAX_VALUE;
	}

	public Pair(TreeNode node, int limit) {
		this.node = node;
		this.limit = limit;
	}

}

class Solution {

	public TreeNode bstFromPreorder(int[] preorder) {

		if (preorder == null || preorder.length == 0)
			return null;

		Stack<Pair> stack = new Stack<>();

		int pointer = 0;

		TreeNode head = new TreeNode(preorder[pointer++]);
		Pair headPair = new Pair(head, Integer.MAX_VALUE);

		stack.push(headPair);

		while (pointer < preorder.length) {
			int key = preorder[pointer++];
			Pair currPair = stack.peek();

			while (!(key < currPair.node.val ||
					(key < currPair.limit))) {

				stack.pop();
				currPair = stack.peek();
			}

			TreeNode newNode = new TreeNode(key);

			if (key < currPair.node.val) {
				currPair.node.left = newNode;
				stack.push(new Pair(currPair.node.left, currPair.node.val));
			} else {
				currPair.node.right = newNode;
				stack.pop(); /*
								Since we are appending new node to right the node
								will have no use as its both left and right node are filled
							 */
				stack.push(new Pair(currPair.node.right, currPair.limit));
			}

		}

		return head;

	}
}