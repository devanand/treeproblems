package treeproblem.algorithm;

import java.util.Collections;

import treeproblem.node.Node;
import treeproblem.util.Util;

public class MaxPathSum {

	public static int maxPathSum(Node root) {
		int max[] = new int[1]; 
		max[0] = Integer.MIN_VALUE;
		calculateSum(root, max);
		return max[0];
	}

	public static int calculateSum(Node root, int[] max) {
		if (root == null) return 0;

		int left = calculateSum(root.left, max);
		int right = calculateSum(root.right, max);
		int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
		max[0]      = Math.max(max[0], Math.max(current, left + root.data + right));			

		return current;
	}
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.right = new Node(3);
		node.right.right = new Node(4);
		node.right.left = new Node(6);
		node.right.right.right = new Node(4);
		node.left = new Node(4);
		node.left.left = new Node(5);
		Util.printTree(Collections.singletonList(node), 1, 4);
		System.out.println(maxPathSum(node));
	}
}
