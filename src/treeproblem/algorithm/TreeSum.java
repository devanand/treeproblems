package treeproblem.algorithm;

import java.util.Collections;

import treeproblem.node.Node;
import treeproblem.util.Util;

public class TreeSum {
	
	public static int treeSum(Node node) {
		if(node == null) {
			return 0;
		}
		
		int old = node.data;
		node.data = treeSum(node.left)+treeSum(node.right);
		return node.data+old;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		treeSum(root);
		Util.printTree(Collections.singletonList(root), 1, 2);
	}
}
