
//leetcode 1008

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

class Solution {
	private static int pointer;

	private static TreeNode helper(int[] preorder, int limit) {
		if (pointer == preorder.length) {
			return null;
		}

		int curr = preorder[pointer];
		if (curr > limit) {
			return null;
		}

		TreeNode currentNode = new TreeNode(curr);

		pointer++;

		currentNode.left = helper(preorder, curr);
		currentNode.right = helper(preorder, limit);

		return currentNode;

	}

	public TreeNode bstFromPreorder(int[] preorder) {
		pointer = 0;

		return helper(preorder, Integer.MAX_VALUE);

	}
}