package treeproblem.algorithm;

import treeproblem.node.Node;

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
		System.out.println(root.data);
		int current = Math.max(root.data, Math.max(root.data + left, root.data + right));
		max[0]      = Math.max(max[0], Math.max(current, left + root.data + right));			

		return current;
	}
}
