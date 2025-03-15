// GFG postorder traversal

import java.util.*;

class Node {
	/*
	 * Node structure
	 */
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class PreOrderIterator {
	/*
	 * Root holds the given tree and stack holds the traversal
	 */
	public Node root;
	private Stack<Node> stack;

	public PreOrderIterator() {
		this.stack = new Stack<>();
	}

	public PreOrderIterator(Node root) {
		this();

		this.root = root;

		this.stack.push(root);	// push root to top

	}

	public Node getNext() {
		return stack.peek();	// the element at top is our next element
	}

	private boolean canPop(Node current, Node top) {
		/*
		 * A node can be popped if it is either right of some node or left
		 * of some node and does not have a right child
		 */
		return current == top.right || (current == top.left && top.right == null);
	}

	public void advanceNext() {

		/*
		 * A method that updates the stack to contain netx traversal
		 */

		Node current = stack.peek();

		if (current.left != null) {
			// if stack has left push it (DLR traversal)
			stack.push(current.left);
		} else if (current.right != null) {
			stack.push(current.right);	// push right if present
		} else {
			// both left and right are absent i.e leaf node
			
			current = stack.pop();

			while(!stack.empty() && canPop(current, stack.peek())) {
				current = stack.pop();	// keep popping till stack has an elemnt which has unvisited subtree
			}

			if(stack.empty()) return;

			Node top = stack.peek();	// the top.right is the unvisited node

			if(current == top.left) {
				stack.push(top.right);	
			}
			
		}
	}

	public boolean hasNext() {
		return stack.isEmpty() == false; // self
	}

}

class Solution {
	// Return a list containing the Preorder traversal of the given tree
	static ArrayList<Integer> preorder(Node root) {
		/*
		 * Function from GFG prractice
		 * https://www.geeksforgeeks.org/problems/preorder-traversal-iterative/1
		 */
		ArrayList<Integer> result = new ArrayList<>();

		PreOrderIterator itr = new PreOrderIterator(root);

		//on average for each getnext the average time is O(1)
		// for n nodes time is proportional to O(n)
		// space := O(h) h = height of tree

		
		while(itr.hasNext()) {
			Node curr = itr.getNext();
			itr.advanceNext();

			result.add(curr.data);

		}

		return result;
	}

}