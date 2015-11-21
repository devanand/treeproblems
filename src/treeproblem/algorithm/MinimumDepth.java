package treeproblem.algorithm;

import java.util.Collections;

import treeproblem.node.Node;
import treeproblem.util.Util;

public class MinimumDepth {

	static public void minDepth(Node root, int depth, int min[]) {
		if(root == null) return;
		if(depth<min[0]) min[0] = depth;
		
		if(depth>min[0]) return;
		
		minDepth(root.left, depth+1, min);
		minDepth(root.right, depth+1, min);
	}
	
	static int minDepth(Node root) {
		if (root == null) return 1;
		
		int left =0, right =0;
		left = minDepth(root.left)+1;
		right = minDepth(root.right)+1;
		
		return left>right?right:left;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(5);
		root.right.right = new Node(6);
		root.right.right.right = new Node(7);
		Util.printTree(Collections.singletonList(root), 1, 4);
		System.out.println(minDepth(root));
	}
}
