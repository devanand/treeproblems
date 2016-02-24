package treeproblem.algorithm;

import java.util.Collections;

import treeproblem.node.Node;
import treeproblem.util.Util;

public class IsBalanced {

	public static int maxLevel(Node node) {
		if(node == null) return 0;
		int left = maxLevel(node.left);
		int right = maxLevel(node.right);
		return Math.max(left, right)+1;
	}
	
	public static boolean isBalancedNaive(Node root) {
		if(root == null) return true;
		
		int left = maxLevel(root.left);
		int right = maxLevel(root.right);
		
		if(((left>right)?(left-right):(right-left)) <= 1) return isBalancedNaive(root.left) && isBalancedNaive(root.right);
		
		return false;
		
	}
	
	public static int isBalanced(Node root) {
		if(root == null ) return 0;
		int left = isBalanced(root.left);
		int right = isBalanced(root.right);
 
		if (left == -1 || right == -1)
			return -1;
 
		if (Math.abs(left - right) > 1) {
			return -1;
		}
 
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		Node node = new Node(1);
		node.right = new Node(3);
		node.right.right = new Node(4);
		node.right.left = new Node(6);
		node.right.right.right = new Node(4);
		node.left = new Node(4);
		node.left.left = new Node(5);
		Util.printTree(Collections.singletonList(node), 1, maxLevel(node));
		System.out.println(isBalanced(node) == -1?false:true);
	}
}
