import java.util.*;

/*
 * Merge BST:
 * GFG: https://www.geeksforgeeks.org/problems/merge-two-bst-s/1
 */

class Node {
	int data;
	Node left, right;

	public Node(int d) {
		data = d;
		left = right = null;
	}
}

class BSTInOrderIterator {
	private Stack<Node> stack;

	public BSTInOrderIterator(Node root) {
		stack = new Stack<>();
		pushLeft(root);
	}

	private void pushLeft(Node node) {
		while (node != null) {
			stack.push(node);
			node = node.left; // Keep pushing left nodes
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public Node getNext() {
		return stack.peek();
	}

	public void advance() {
		Node top = stack.pop();

		pushLeft(top.right);
	}
}

class Solution {
	public ArrayList<Integer> merge(Node root1, Node root2) {
		ArrayList<Integer> result = new ArrayList<>();

		BSTInOrderIterator itr1 = new BSTInOrderIterator(root1);
		BSTInOrderIterator itr2 = new BSTInOrderIterator(root2);

		while (itr1.hasNext() && itr2.hasNext()) {
			int v1 = itr1.getNext().data;
			int v2 = itr2.getNext().data;

			if (v1 == v2) {
				result.add(v2);
				result.add(v1);
				itr1.advance();
				itr2.advance();
			} else if (v1 < v2) {
				result.add(v1);
				itr1.advance();
			} else {
				result.add(v2);
				itr2.advance();
			}
		}

		while (itr1.hasNext()) {
			result.add(itr1.getNext().data);
			itr1.advance();
		}

		while (itr2.hasNext()) {
			result.add(itr2.getNext().data);
			itr2.advance();
		}

		return result;
	}
}
