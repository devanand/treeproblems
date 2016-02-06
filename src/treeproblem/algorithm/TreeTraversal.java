package treeproblem.algorithm;

import treeproblem.node.Node;

public class TreeTraversal {

	public void inOrder(Node node) {
		if(node == null) return;

		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}
	
	public void  preOrder(Node node) {
		if(node == null) return;

		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder(Node node) {
		if(node == null) return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");
	}
	
	public void inOrderIteration(Node root) {
		if(root == null ) {
			return;
		}

		Node current = root;
		Node pre = null;
		while(current!=null) {
			if(current.left == null) {
				System.out.println(current.data);
				current = current.right;
			} else {
				pre = current.left;

				while(pre.right !=null && pre.right != current) {
					pre = pre.right;
				}

				if(pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.println(current.data);
					current = current.right;
				}
			}
		}
	}
	
	public void preOrderIteration(Node root) {
		if(root == null ) {
			return;
		}

		Node current = root;
		Node pre = null;
		while(current!=null) {

			if(current.left == null) {
				System.out.println(current.data);
				current = current.right;
			} else {
				pre = current.left;
				while(pre.right !=null && pre.right != current) {
					pre = pre.right;
				}

				if(pre.right == null) {
					//System.out.println(current.data);
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					current = current.right;
				}
			}
		}
	}
}
