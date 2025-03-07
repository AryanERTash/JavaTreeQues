// GFG postorder traversal

import java.util.*;

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}

class PreOrderIterator {
	public Node root;
	private Stack<Node> stack;

	public PreOrderIterator() {
		this.stack = new Stack<>();
	}

	public PreOrderIterator(Node root) {
		this();

		this.root = root;

		this.stack.push(root);
	}

	public Node getNext() {
		return stack.peek();
	}

	private boolean canPop(Node current, Node top) {
		return current == top.right || (current == top.left && top.right == null);
	}

	public void advanceNext() {

		Node current = stack.peek();

		if (current.left != null) {
			stack.push(current.left);
		} else if (current.right != null) {
			stack.push(current.right);
		} else {
			// both left and right are absent i.e leaf node
			
			current = stack.pop();

			while(!stack.empty() && canPop(current, stack.peek())) {
				current = stack.pop();
			}

			if(stack.empty()) return;

			Node top = stack.peek();

			if(current == top.left) {
				stack.push(top.right);
			}
			
		}
	}

	public boolean hasNext() {
		return stack.isEmpty() == false;
	}

}

class Tree {
	// Return a list containing the Preorder traversal of the given tree
	ArrayList<Integer> preOrder(Node root) {
		ArrayList<Integer> result = new ArrayList<>();

		PreOrderIterator itr = new PreOrderIterator(root);

		
		while(itr.hasNext()) {
			Node curr = itr.getNext();
			itr.advanceNext();

			result.add(curr.data);

		}

		return result;
	}

}