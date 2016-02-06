package treeproblem.algorithm;

import treeproblem.node.Node;
import treeproblem.util.Util;

public class IsBalanced {

	public static int maxLevel(Node node) {
		if(node == null) return 0;
		int left = maxLevel(node.left);
		int right = maxLevel(node.right);
		return Math.max(left, right)+1;
	}
	
	public static boolean isBalanced(Node root) {
		if(root == null) return true;
		
		int left = maxLevel(root.left);
		int right = maxLevel(root.right);
		
		if(((left>right)?(left-right):(right-left)) <= 1) return isBalanced(root.left) && isBalanced(root.right);
		
		return false;
		
	}
	
	public static boolean isBalancedOptimized(Node root, int height) {
		if(root == null) return true;
		
		int left=0, right=0;
		boolean l = isBalancedOptimized(root.left, left);
		boolean r = isBalancedOptimized(root.right, right);
		
		if(((left>right)?(left-right):(right-left)) <= 1) return true;
		
		else return l && r;
	}
	
	public static void main(String[] args) {
		Node node = new Node(1);
		//node.left = new Node(2);
		node.right = new Node(3);
		node.right.right = new Node(4);
		
		System.out.println(isBalancedOptimized(node, 0));
	}
}
